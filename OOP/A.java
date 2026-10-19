// Companion class for Demo9 - setters returning `this` for chaining.
class A {
	private int a;
	private int b;

	public A(){}
	public A(int a, int b){
		this.a=a;
		this.b=b;
	}

	public A setA(int a){
		this.a=a;
		return this;
	}
	public A setB(int b){
		this.b=b;
		return this;
	}

	public String toString(){
		return a+","+b;
	}
}