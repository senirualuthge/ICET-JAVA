import java.util.*;

public class EX2 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] brr = new int[6]; 
        for(int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        brr[5] = 60;
        arr = brr;
        System.out.println("Array after inserting 60: " + Arrays.toString(arr));
    }
    
}
