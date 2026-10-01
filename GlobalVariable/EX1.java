import java.util.Scanner;
import java.util.*;
class EX1 {


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a number: ");
            int a = sc.nextInt();
            int arr[] = new int[0];
            while(a!=-1){
                

                //add to array
                arr = Arrays.copyOf(arr, arr.length + 1);
                arr[arr.length - 1] = a;
                System.out.println("Enter a number: ");
                a = sc.nextInt();
               

            
            }
            System.out.println("The array is:" + Arrays.toString(arr));

        }
    };    
    
}