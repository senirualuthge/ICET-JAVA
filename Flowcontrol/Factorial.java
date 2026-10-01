import java.util.Scanner;
import java.util.*;
public class Factorial {
   

public class ex{
    public static void main(String[] args) {
        Scanner input =new Scanner (System.in);
        int sum = 0;
        int num1 ;
        int num2;
        System.out.print("Enter start: ");
        num1 = input.nextInt();
        System.out.print("Enter end: ");
        num2 = input.nextInt();
        for (int i = num1; i <= num2; i++) {
            sum += i;
            if (i > num1) System.out.print("+");
            System.out.print(i);
        }
        System.out.println(" =" + sum);
        input.close();
    }
}
}
