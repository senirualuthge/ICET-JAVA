// Demo 3 - copying one object into another with set(DemoDate).
// Run: bash ../run.sh Demo3
public class Demo3 {
	public static void main(String[] args) {
		DemoDate d1=new DemoDate(2026,9,17);
		System.out.println(d1);//2026-9-17

		DemoDate d2=new DemoDate();
		System.out.println(d2);//1970-1-1

		d2.set(d1);
		System.out.println(d2);//2026-9-17
	}
}