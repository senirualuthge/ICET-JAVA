public class demo6 {
    public static void main(String[] args) {
        String s1 = new String("Niroth");
        System.out.println(s1); // s1.toString() -> Niroth

        s1 = s1.concat(" Samarawickrama"); // reassign, since concat() returns a new String
        System.out.println(s1); // s1.toString() -> Niroth Samarawickrama
    }
}