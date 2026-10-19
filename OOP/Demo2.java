// Demo 2 - dispatching through constants (YEAR/MONTH/DAY).
// The main method used to call `new date()`, a class that lived in demo1.java;
// it now uses DateValue, the class this demo actually defines.
// Run: bash ../run.sh Demo2
public class Demo2 {
	public static void main(String[] args) {
		DateValue d1=new DateValue();
		System.out.println(d1);//1970-1-1

		d1.set(DateValue.YEAR,2026);
		d1.set(DateValue.MONTH,9);
		d1.set(DateValue.DAY,17);
		System.out.println(d1);//2026-9-17
	}
}