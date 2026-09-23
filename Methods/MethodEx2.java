import java.util.*;

public class MethodEx2 {


    public static void printReverse(int num){
        do{
            System.out.print(num%10);
        }
        while((num/=10)!=0);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input number 1 : ");
        int num = input.nextInt(); //12345
        printReverse(num); //54321
        // optional: demonstrate findDigitsCount
        // findDigitsCount(num);
        input.close();
    }
}
 
    

