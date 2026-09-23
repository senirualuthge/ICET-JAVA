import java.util.*;

class Sorting1 {
   
    public static void sortArray(int[] ar) {
        for (int i = ar.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
    }
     public static void main(String args[]) {
        int[] ar = {100, 60, 10, 20, 70, 80, 40, 50, 30, 90};
        System.out.println(Arrays.toString(ar)); // [100,60,10,20,70,80,40,50,30,90]
        sortArray(ar);
        System.out.println(Arrays.toString(ar)); // [10,20,30,40,50,60,70,80,90,100]
    }

}
