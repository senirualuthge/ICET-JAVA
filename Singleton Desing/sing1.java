// Singleton demo. The singleton types are named SingletonA/SingletonB rather
// than plain A/B so they do not collide with A.java in OOP/ - both live in the
// default package, and two top-level classes called A cannot coexist.

class SingletonA {
	private static SingletonA ob;

	private SingletonA() {
	}

	public static SingletonA getInstance() {
		if (ob == null) {
			ob = new SingletonA();
		}
		return ob;
	}
}

class SingletonB {
	private static SingletonB oa;

	private SingletonB() {
	}

	public static SingletonB getInstance() {
		if (oa == null) {
			oa = new SingletonB();
		}
		return oa;
	}
}

class sing1 {
	public static void main(String[] args) {
		// SingletonA a1 = new SingletonA(); // Illegal: constructor is private
		SingletonA a1 = SingletonA.getInstance();
		SingletonA a2 = SingletonA.getInstance();
		System.out.println(a1 == a2); // true

		SingletonB b1 = SingletonB.getInstance();
		SingletonB b2 = SingletonB.getInstance();
		System.out.println(b1 == b2); // true
	}
}
