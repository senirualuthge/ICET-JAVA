// Demo 7 - a setter that returns `this` for method chaining.
// Run: bash ../run.sh Demo7
public class Demo7 {
	public static void main(String[] args) {
		Date7 d1=Date7.getDateInstance();
		System.out.println(d1); //e.g. 2026-10-15

		d1.setYear(1999);
		System.out.println(d1); //1999-10-15

		Date7 d2=d1.setYear(1999);
		System.out.println(d2); //1999-10-15
	}
}