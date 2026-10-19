// Demo 8 - immutable methods: trim() returns a new String and leaves s1 alone.
// Run: bash ../run.sh Demo8
public class Demo8 {
	public static void main(String[] args) {
		String s1=new String(" Niroth ");
		System.out.println(s1);
		System.out.println("length of s1 : "+s1.length()); //8

		s1.trim();
		System.out.println("length of s1 : "+s1.length()); //8

		String s2=s1.trim();
		System.out.println("length of s2 : "+s2.length()); //6

		System.out.println(s1.trim()); //6
    }
}