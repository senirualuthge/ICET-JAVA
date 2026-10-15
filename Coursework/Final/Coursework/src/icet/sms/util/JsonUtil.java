package icet.sms.util;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class JsonUtil {

    private JsonUtil() {}

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parse(String json) {
        StringBuilder sb = new StringBuilder(json.trim());
        Object v = parseValue(sb);
        if (v instanceof Map) return (Map<String, Object>) v;
        throw new RuntimeException("Root must be a JSON object");
    }

    private static Object parseValue(StringBuilder sb) {
        skipWhitespace(sb);
        if (sb.length() == 0) throw new RuntimeException("Unexpected end of JSON");
        char c = sb.charAt(0);
        if (c == '{') return parseObject(sb);
        if (c == '[') return parseArray(sb);
        if (c == '"') return parseString(sb);
        return parseLiteral(sb);
    }

    private static void skipWhitespace(StringBuilder sb) {
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) sb.deleteCharAt(0);
    }

    private static Map<String, Object> parseObject(StringBuilder sb) {
        Map<String, Object> map = new LinkedHashMap<>();
        sb.deleteCharAt(0); // '{'
        skipWhitespace(sb);
        if (sb.length() > 0 && sb.charAt(0) == '}') { sb.deleteCharAt(0); return map; }
        while (true) {
            skipWhitespace(sb);
            String key = parseString(sb);
            skipWhitespace(sb);
            if (sb.charAt(0) != ':') throw new RuntimeException("Expected ':'");
            sb.deleteCharAt(0);
            Object val = parseValue(sb);
            map.put(key, val);
            skipWhitespace(sb);
            if (sb.length() == 0) throw new RuntimeException("Unterminated object");
            if (sb.charAt(0) == '}') { sb.deleteCharAt(0); return map; }
            if (sb.charAt(0) != ',') throw new RuntimeException("Expected ',' or '}'");
            sb.deleteCharAt(0);
        }
    }

    private static List<Object> parseArray(StringBuilder sb) {
        List<Object> list = new ArrayList<>();
        sb.deleteCharAt(0); // '['
        skipWhitespace(sb);
        if (sb.length() > 0 && sb.charAt(0) == ']') { sb.deleteCharAt(0); return list; }
        while (true) {
            list.add(parseValue(sb));
            skipWhitespace(sb);
            if (sb.length() == 0) throw new RuntimeException("Unterminated array");
            if (sb.charAt(0) == ']') { sb.deleteCharAt(0); return list; }
            if (sb.charAt(0) != ',') throw new RuntimeException("Expected ',' or ']'");
            sb.deleteCharAt(0);
        }
    }

    private static String parseString(StringBuilder sb) {
        if (sb.charAt(0) != '"') throw new RuntimeException("Expected '\"'");
        sb.deleteCharAt(0);
        StringBuilder out = new StringBuilder();
        while (sb.length() > 0) {
            char c = sb.charAt(0);
            if (c == '"') { sb.deleteCharAt(0); return out.toString(); }
            if (c == '\\') {
                sb.deleteCharAt(0);
                if (sb.length() == 0) throw new RuntimeException("Bad escape");
                char e = sb.charAt(0);
                sb.deleteCharAt(0);
                if (e == 'n') out.append('\n');
                else if (e == 't') out.append('\t');
                else if (e == 'r') out.append('\r');
                else out.append(e);
            } else {
                out.append(c);
                sb.deleteCharAt(0);
            }
        }
        throw new RuntimeException("Unterminated string");
    }

    private static Object parseLiteral(StringBuilder sb) {
        skipWhitespace(sb);
        if (sb.length() >= 4 && sb.substring(0, 4).equals("true")) {
            sb.delete(0, 4); return Boolean.TRUE;
        }
        if (sb.length() >= 5 && sb.substring(0, 5).equals("false")) {
            sb.delete(0, 5); return Boolean.FALSE;
        }
        if (sb.length() >= 4 && sb.substring(0, 4).equals("null")) {
            sb.delete(0, 4); return null;
        }
        // number
        int i = 0;
        while (i < sb.length() && "0123456789.-+eE".indexOf(sb.charAt(i)) >= 0) i++;
        String num = sb.substring(0, i);
        sb.delete(0, i);
        if (num.contains(".") || num.contains("e") || num.contains("E")) {
            return Double.parseDouble(num);
        }
        return Integer.parseInt(num);
    }

    public static String toJson(Object obj) {
        StringBuilder sb = new StringBuilder();
        writeValue(sb, obj);
        return sb.toString();
    }

    private static void writeValue(StringBuilder sb, Object obj) {
        if (obj == null) { sb.append("null"); return; }
        if (obj instanceof String) {
            sb.append('"');
            for (char c : ((String) obj).toCharArray()) {
                if (c == '"') sb.append("\\\"");
                else if (c == '\n') sb.append("\\n");
                else if (c == '\r') sb.append("\\r");
                else if (c == '\t') sb.append("\\t");
                else sb.append(c);
            }
            sb.append('"');
        } else if (obj instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) obj;
            sb.append('{');
            boolean first = true;
            for (Map.Entry<String, Object> e : map.entrySet()) {
                if (!first) sb.append(',');
                first = false;
                writeValue(sb, e.getKey());
                sb.append(':');
                writeValue(sb, e.getValue());
            }
            sb.append('}');
        } else if (obj instanceof List) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) obj;
            sb.append('[');
            boolean first = true;
            for (Object item : list) {
                if (!first) sb.append(',');
                first = false;
                writeValue(sb, item);
            }
            sb.append(']');
        } else if (obj instanceof Number) {
            sb.append(obj.toString());
        } else if (obj instanceof Boolean) {
            sb.append(obj.toString());
        } else {
            sb.append('"').append(obj.toString()).append('"');
        }
    }

    public static void writeFile(String path, String content) throws IOException {
        Files.writeString(Path.of(path), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static String readFile(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
