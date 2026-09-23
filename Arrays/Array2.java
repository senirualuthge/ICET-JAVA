import java.util.*;
class Array2 {
 
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\n");
    }

    public static void printArray1(int[] a) {
        for (int b : a) {
             System.out.print(b + " ");
        }
        System.out.println("\n");
    }
    
    public static void printArrayReverse(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

    public static void printArrayFrom2To5(int[] a) {
        for (int i = 2; i <= 5; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }
    public static void printArrayFromAtoB(int[] a, int b, int c) {
        for (int i = b; i <= c; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }
    public static void searchfromindex(int[]a, int n){
        for(int i=0;i<a.length;i++){
            if(a[i]==n){
                System.out.println("Found " + n + " at index: "+i);
                break;
            }
        }

    }
    
    public static void indexof(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                System.out.println("Found " + n + " at index: " + i);
                return;
            }
        }
        System.out.println(n + " not found in the array.");
    }
    public static void mergeArrays(int[]c,int[]d){
        int[] mergedArray = new int[c.length + d.length];
        for (int i = 0; i < c.length; i++) {
            mergedArray[i] = c[i];
        }
        for (int i = 0; i < d.length; i++) {
            mergedArray[c.length + i] = d[i];
        }
        printArray(mergedArray);
    }

    public static void main(String[] args) {
    
     int[] a = {10, 20, 30, 40, 50, 60, 70};
     int[] b = new int[a.length];
     int[] c = {10,20,30};
     int[] d = {40,50,60};

     printArray(a);
     printArray1(a);
     printArrayReverse(a);
     printArrayFrom2To5(a);

     searchfromindex(a,30); 
     indexof(a, 50);
     mergeArrays(c,d);
       
    
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        // Print the full array
        printArrayFromAtoB(b, 0, b.length - 1);




    }
}
