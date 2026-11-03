#!/usr/bin/env bash
#
# Compile & run a single Java source file from this workspace.
#
# Usage: bash run.sh <MainClassName> [more args passed to the program]
#
# Invoked by:
#   - .vscode/tasks.json          (Run Java File build task)
#   - Code Runner (settings.json) (code-runner.executorMap -> java)
#
# The script resolves the .java file for the given class, compiles it (pulling
# in any dependencies via -sourcepath), and runs its public static void main.

set -uo pipefail

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$WORKSPACE" || exit 1

MAIN_CLASS="${1:-}"
if [[ -z "$MAIN_CLASS" ]]; then
	echo "usage: bash run.sh <MainClassName | path/to/File.java>" >&2
	exit 1
fi
shift || true

# An explicit *.java path pins the exact file. Different folders can hold files
# with the same name (OOP/Demo3.java and "Event Handling/Demo3.java"), and the
# name search below would otherwise run whichever source path comes first.
# Code Runner and tasks.json pass ${file} for exactly this reason.
EXPLICIT_FILE=""
if [[ "$MAIN_CLASS" == *.java ]]; then
	if [[ -f "$MAIN_CLASS" ]]; then
		EXPLICIT_FILE="$(cd "$(dirname "$MAIN_CLASS")" && pwd)/$(basename "$MAIN_CLASS")"
	elif [[ -f "$WORKSPACE/$MAIN_CLASS" ]]; then
		EXPLICIT_FILE="$WORKSPACE/$MAIN_CLASS"
	fi
	MAIN_CLASS="$(basename "$MAIN_CLASS" .java)"
fi

# --- workspace layout (read from .vscode/settings.json) -----------------------
OUT_DIR="$WORKSPACE/.vscode/out"
SETTINGS="$WORKSPACE/.vscode/settings.json"

# --- toolchain ---------------------------------------------------------------
# The default JDK declared in .vscode/settings.json (java.configuration.runtimes)
# wins over the ambient JAVA_HOME/PATH: run.sh and VS Code's "Run Java File"
# share .vscode/out, so compiling with a different JDK than the one that runs
# leaves class files behind that fail with UnsupportedClassVersionError.
CFG_JAVA_HOME="$(python3 -c '
import json, os, sys
try:
    cfg = json.load(open(sys.argv[1]))
except Exception:
    sys.exit(0)
rts = [r for r in (cfg.get("java.configuration.runtimes") or []) if isinstance(r, dict)]
rts.sort(key=lambda r: not bool(r.get("default")))
for r in rts:
    p = r.get("path")
    if p and os.access(os.path.join(p, "bin", "javac"), os.X_OK):
        print(p)
        break
' "$SETTINGS" 2>/dev/null || true)"

if [[ -n "$CFG_JAVA_HOME" ]]; then
	JAVAC="$CFG_JAVA_HOME/bin/javac"
	JAVA="$CFG_JAVA_HOME/bin/java"
elif [[ -n "${JAVA_HOME:-}" && -x "$JAVA_HOME/bin/javac" ]]; then
	JAVAC="$JAVA_HOME/bin/javac"
	JAVA="$JAVA_HOME/bin/java"
else
	JAVAC="$(command -v javac || true)"
	JAVA="$(command -v java || true)"
fi

if [[ ! -x "$JAVAC" || ! -x "$JAVA" ]]; then
	echo "error: no JDK found. Set JAVA_HOME or put javac/java on PATH." >&2
	exit 1
fi

read_config() {
	# $1 = config key. Prints list items one per line, or a string value as-is.
	python3 - "$SETTINGS" "$1" <<-'PY' 2>/dev/null || true
		import json, sys
		try:
		    cfg = json.load(open(sys.argv[1]))
		except Exception:
		    sys.exit(0)
		val = cfg.get(sys.argv[2])
		if isinstance(val, str):
		    print(val)
		elif isinstance(val, list):
		    for item in val:
		        print(item)
	PY
}

# bash 3.2 (macOS default) has no mapfile; build the array with a read loop.
CFG_SOURCE_PATHS=()
while IFS= read -r line; do
	[[ -n "$line" ]] && CFG_SOURCE_PATHS+=("$line")
done < <(read_config "java.project.sourcePaths")

if [[ ${#CFG_SOURCE_PATHS[@]} -eq 0 ]]; then
	CFG_SOURCE_PATHS=(".")
fi

# With `set -u`, bash 3.2 errors on "${arr[@]}" for an empty array.
set_paths() {
	local first=1 out=""
	for p in "$@"; do
		[[ -d "$p" ]] || continue
		if [[ $first -eq 1 ]]; then out="$p"; first=0; else out="$out:$p"; fi
	done
	printf '%s' "$out"
}

CFG_OUT="$(read_config "java.project.outputPath" | head -n1)"
[[ -n "$CFG_OUT" ]] && OUT_DIR="$WORKSPACE/$CFG_OUT"

mkdir -p "$OUT_DIR"

# Build the -sourcepath / -cp argument lists (only paths that exist).
SOURCEPATH=""
for p in "${CFG_SOURCE_PATHS[@]}"; do
	[[ -d "$p" ]] || continue
	SOURCEPATH="${SOURCEPATH:+$SOURCEPATH:}$WORKSPACE/$p"
done
SOURCEPATH="${SOURCEPATH:-$WORKSPACE}"
CLASSPATH="$OUT_DIR"
for jar in "$WORKSPACE"/lib/*.jar; do
	[[ -f "$jar" ]] || continue
	CLASSPATH="$CLASSPATH:$jar"
done

# --- locate the source file --------------------------------------------------
SOURCE_FILE="$EXPLICIT_FILE"
for p in "${CFG_SOURCE_PATHS[@]}"; do
	[[ -n "$SOURCE_FILE" ]] && break
	[[ -d "$p" ]] || continue
	if [[ -f "$p/$MAIN_CLASS.java" ]]; then
		SOURCE_FILE="$p/$MAIN_CLASS.java"
		break
	fi
done

# Fallback: some files are named differently from their class (e.g. PolyEx-1.java).
if [[ -z "$SOURCE_FILE" ]]; then
	while IFS= read -r hit; do
		SOURCE_FILE="$hit"
		break
	done < <(grep -rlE "^[[:space:]]*(public[[:space:]]+)?(final[[:space:]]+|abstract[[:space:]]+)?class[[:space:]]+$MAIN_CLASS\b" \
		"${CFG_SOURCE_PATHS[@]}" --include='*.java' 2>/dev/null | sed "s|^|$WORKSPACE/|")
fi

# Fallback: the file name matches even though the type inside is named
# differently (PolyEx-3.java declares class Demo, CollectionEx-1.java declares
# class CollectionEx1). File names are unique across the source paths.
if [[ -z "$SOURCE_FILE" ]]; then
	while IFS= read -r hit; do
		SOURCE_FILE="$hit"
		break
	done < <(find "${CFG_SOURCE_PATHS[@]}" -type f -name "$MAIN_CLASS.java" 2>/dev/null | head -n 1)
fi

if [[ -z "$SOURCE_FILE" || ! -f "$SOURCE_FILE" ]]; then
	echo "error: could not find a .java file declaring class '$MAIN_CLASS'" >&2
	exit 1
fi

# --- derive the fully-qualified name from the package declaration -----------
FQN="$(python3 - "$SOURCE_FILE" <<-'PY'
	import os, re, sys

	path = sys.argv[1]
	src = open(path, encoding="utf-8", errors="replace").read()
	pkg_match = re.search(r"^\s*package\s+([\w.]+)\s*;", src, re.M)
	pkg = pkg_match.group(1) if pkg_match else ""
	base = os.path.splitext(os.path.basename(path))[0]

	def blank(m):
	    return " " * (m.end() - m.start())

	# Blank comments and string/char literals so braces and words inside them
	# cannot confuse the type-block scan below.
	code = re.sub(r"\"(?:\\.|[^\"\\])*\"|'(?:\\.|[^'\\])*'|//[^\n]*|/\*.*?\*/",
	              blank, src, flags=re.S)

	# The runnable name is the type that encloses main: file names such as
	# PolyEx-3.java do not match their class (Demo). Nested types join with `$`
	# so the launcher can load them.
	names = []
	main = re.search(r"\bvoid\s+main\s*\(\s*String", code)
	if main:
	    depth = 0
	    pending = None
	    stack = []
	    for t in re.finditer(r"\b(?:class|interface|enum|record)\s+(\w+)|([{}])", code):
	        if t.start() > main.start():
	            break
	        if t.group(1) is not None:
	            pending = t.group(1)
	            continue
	        if t.group(2) == "{":
	            stack.append((depth, pending))
	            pending = None
	            depth += 1
	        else:
	            depth = max(depth - 1, 0)
	            if stack and stack[-1][0] >= depth:
	                stack.pop()
	        names = [n for _, n in stack if n]

	cls = "$".join(names) if names else base
	print(f"{pkg}.{cls}" if pkg else cls)
PY
)"

echo "── compiling ${SOURCE_FILE#$WORKSPACE/}  →  ${FQN}"
if ! "$JAVAC" -encoding UTF-8 -nowarn -d "$OUT_DIR" -cp "$CLASSPATH" -sourcepath "$SOURCEPATH" "$SOURCE_FILE"; then
	echo "── compilation FAILED" >&2
	exit 1
fi

echo "── running $FQN"
exec "$JAVA" -cp "$CLASSPATH" "$FQN" "$@"
