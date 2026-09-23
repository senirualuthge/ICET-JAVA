import java.util.*;
public class Method9 {

    public static void printFibonacci(int limit) {
        int a = 0, b = 1;
        while (a <= limit) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        printFibonacci(100);
    }
}
