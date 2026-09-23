import java.util.*;

public class FormatString1 {
    public static void main(String args[]){
        int age = 12;
        String fs = String.format("Your age is : %d", age);
        System.out.println(fs);
        System.out.printf("Your age is : %d", age);
    }
}


