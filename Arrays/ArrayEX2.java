import java.util.*;

class ArrayEX2 {
    //   ---------- Exercise 1 ----------
    public static void isEqual(int[] a, int[] b){
        if (a.length != b.length){
            System.out.println("False");

        }
        else{
            for (int i=0; i<a.length;i++){
                if(a[i]!=b[i]){
                    System.out.println("Not Equal");
                    return;
                }


            }
            System.out.println("Equal");
        }

    }
    //  ---------- Exercise 2 ----------
    public static void reverseArray (int[]a){
        /*for(int i=a.length-1;i>=0;i--){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        */
        for (int left = 0, right = a.length - 1; right > left; left++, right--) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                
            }
        }
     
    
    public static void main(String args[]){
        System.out.println("===== Exercise 1: printArray =====");
            int [] a={10,20,30,40};
            int [] b={10,20,30,40};
            int [] c={10,20,30,50};
            
        isEqual(a,b);
        isEqual(a,c);


        System.out.println("\n===== Exercise 2: reversPrintArray =====");

        reverseArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(",");
        }
        
    }    
}
