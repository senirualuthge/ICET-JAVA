// Demo 5 - constructor overloading, a static factory method and copy-set.
// Run: bash ../run.sh Demo5
public class Demo5 {
	public static void main(String[] args) {
		Box5 b1=new Box5();
		b1.set(12,5,3);
		b1.printVolume(); //180
		System.out.println();

		Box5 b2=new Box5(10);
		b2.printVolume(); //1000
		System.out.println();

		Box5 b3=new Box5(120,50,30);
		b3.printVolume(); //180000
		System.out.println();

		Box5 b4=Box5.getInstance();
		b4.printVolume(); //1
		System.out.println();

		b4.set(b3);
		b4.printVolume(); //180000
		System.out.println();
    }
}