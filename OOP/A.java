// Companion class for Demo9 - setters returning `this` for chaining and a package-private no-arg variant.
class A {

	private int a;
	private int b;

	A() {
	}

	A(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public A setA(int a) {
		this.a = a;
		return this;
	}

	public A setB(int b) {
		this.b = b;
		return this;
	}

	@Override
	public String toString() {
		return a + "," + b;
	}

}
