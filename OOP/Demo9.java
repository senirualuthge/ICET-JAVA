// Demo 9 - fluent setters: the returned reference is the same object.
// Run: bash ../run.sh Demo9
public class Demo9 {
	public static void main(String[] args) {
		A a1=new A();
		System.out.println(a1); //0,0

		A a2=new A(10,20);
		System.out.println(a2); //10,20

		a2.setA(100);
		System.out.println(a2); //100,20

		a2.setB(200);
		System.out.println(a2); //100,200

		A a3=a2.setA(100);
		System.out.println("a3 : "+a3); //100,200 (same object as a2)

		a3=a2.setB(200);
		System.out.println("a3 : "+a3); //100,200
	}
}