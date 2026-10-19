// Demo 4 - building today's date from the system clock.
// Run: bash ../run.sh Demo4
public class Demo4 {
	public static void main(String[] args) {
		Date4 d1=Date4.getDateInstance();
		System.out.println(d1);//e.g. 2026-10-15
	}
}