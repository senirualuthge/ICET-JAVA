import java.util.*;
public class Array1 {
    public static void main(String[] args) {
        int a [] = new int[10]; // declare and initialize an array of 10 integers
        printArray(a);
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
