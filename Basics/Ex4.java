import java.util.*;
public class Ex4 {
    public static void main(String args[]){
        int x=100;
        System.out.println(x);
        {
            int y=200;
            System.out.println(x);
            System.out.println(y);
            {
                int z=300;
                System.out.println(x);
                System.out.println(y);
                System.out.println(z);
            }
            System.out.println(x);
            System.out.println(y);
            // z is out of scope here -> System.out.println(z); would be an error
        }
        System.out.println(x);
        // y and z are out of scope here -> System.out.println(y/z); would be errors
    }
}
