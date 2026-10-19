// Demo 1 - constructors, `this(...)` chaining and setters.
// Run: bash ../run.sh Demo1
public class Demo1 {
	public static void main(String[] args) {
		Date1 d1=new Date1();
		d1.printDate(); //1970-1-1 (Default date);

		d1.set(1999,12,31);
		d1.printDate(); //1999-12-31

		Date1 d2=new Date1(2020,3,14);
		d2.printDate(); //2020-3-14

		Date1 d3=new Date1();
		d3.setYear(2026);
		d3.setMonth(9);
		d3.setDay(17);
		System.out.println(d3);//2026-9-17
	}
}