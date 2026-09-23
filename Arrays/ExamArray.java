import java.util.*;

class ExamArray{

    // ---------- Exercise 1 ----------
    public static void printArray(int[] ar){
        for(int i=0; i<ar.length; i++){
            System.out.println(ar[i]);
        }
    }

    // ---------- Exercise 2 ----------
    public static void reversPrintArray(int[] ar){
        for(int i=ar.length-1; i>=0; i--){
            System.out.println(ar[i]);
        }
    }

    // ---------- Exercise 3 ----------
    public static void printArrayFromTo(int from, int to, int[] ar){
        if(from<=to){
            for(int i=from; i<=to; i++){
                System.out.println(ar[i]);
            }
        } else {
            for(int i=from; i>=to; i--){
                System.out.println(ar[i]);
            }
        }
    }

    // ---------- Exercise 5 ----------
    public static int indexOf(int value, int[] ar){
        for(int i=0; i<ar.length; i++){
            if(ar[i]==value){
                return i;
            }
        }
        return -1;
    }

    // ---------- Exercise 6 ----------
    public static boolean isAscending(int[] ar){
        for(int i=0; i<ar.length-1; i++){
            if(ar[i]>=ar[i+1]){
                return false;
            }
        }
        return true;
    }

    // ---------- Exercise 7 ----------
    public static void copyValuesFromTo(int[] source, int[] dest){
        int limit = Math.min(source.length, dest.length);
        for(int i=0; i<limit; i++){
            dest[i]=source[i];
        }
    }

    // ---------- Exercise 8 ----------
    public static int[] mergeTwoArrays(int[] ar, int[] br){
        int[] cr = new int[ar.length + br.length];
        int index = 0;
        for(int i=0; i<ar.length; i++){
            cr[index]=ar[i];
            index++;
        }
        for(int i=0; i<br.length; i++){
            cr[index]=br[i];
            index++;
        }
        return cr;
    }

    // ---------- Exercise 9 ----------
    public static boolean equals(int[] ar, int[] br){
        if(ar.length != br.length){
            return false;
        }
        for(int i=0; i<ar.length; i++){
            if(ar[i]!=br[i]){
                return false;
            }
        }
        return true;
    }

    // ---------- Exercise 10 ----------
    public static void reverseAnArray(int[] ar){
        for(int left=0, right=ar.length-1; left<right; left++, right--){
            int temp = ar[left];
            ar[left] = ar[right];
            ar[right] = temp;
        }
    }

    public static void main(String args[]){

        System.out.println("===== Exercise 1: printArray =====");
        int[] ar1={60,30,50,70,23,75,72,84,83,46};
        printArray(ar1);

        System.out.println("\n===== Exercise 2: reversPrintArray =====");
        int[] ar2={60,30,50,70,23,75,72,84,83,46};
        reversPrintArray(ar2);//[46,83,84,72,75,23,70,50,30,60]

        System.out.println("\n===== Exercise 3: printArrayFromTo =====");
        int[] ar3={60,30,50,70,23,75,72,84,83,46};
        printArrayFromTo(3,6,ar3); // 70,23,75,72
        System.out.println("--");
        printArrayFromTo(6,3,ar3); // 72,75,23,70
        System.out.println("--");
        printArrayFromTo(0,0,ar3); // 60
        System.out.println("--");
        printArrayFromTo(7,7,ar3); // 84

        System.out.println("\n===== Exercise 4: copy ar into br =====");
        int[] ar4={10,20,30,40,50};
        int[] br4=new int[ar4.length];
        System.out.println("ar : "+Arrays.toString(ar4));
        System.out.println("br : "+Arrays.toString(br4));
        System.out.println(ar4==br4); //false

        for(int i=0; i<ar4.length; i++){
            br4[i]=ar4[i];
        }

        System.out.println("ar : "+Arrays.toString(ar4));
        System.out.println("br : "+Arrays.toString(br4));
        System.out.println(ar4==br4); //false

        System.out.println("\n===== Exercise 5: indexOf =====");
        int[] ar5={60,20,50,100,90,70,30,100,80,10};
        int index;
        index=indexOf(100,ar5);
        System.out.println("Index of 100 : "+index); //7
        index=indexOf(99,ar5);
        System.out.println("Index of 99 : "+index); //-1

        System.out.println("\n===== Exercise 6: isAscending =====");
        int[] ar6={60,20,50,100,90,70,30,40,80,10};
        int[] br6={10,20,30,40,50,60,70,80,90,100};
        int[] cr6={10,20,30,40,50,50,70,80,90,100};
        System.out.println("ar : "+isAscending(ar6)); //false
        System.out.println("br : "+isAscending(br6)); //true
        System.out.println("cr : "+isAscending(cr6)); //false

        System.out.println("\n===== Exercise 7: copyValuesFromTo =====");
        int[] ar7={10,20,30,40,50,60};
        int[] br7=new int[ar7.length];
        int[] cr7=new int[ar7.length+3];
        int[] dr7=new int[ar7.length-3];
        copyValuesFromTo(ar7,br7);
        copyValuesFromTo(ar7,cr7);
        copyValuesFromTo(ar7,dr7);
        System.out.println("br : "+Arrays.toString(br7)); //[10,20,30,40,50,60]
        System.out.println("cr : "+Arrays.toString(cr7)); //[10,20,30,40,50,60,0,0,0]
        System.out.println("dr : "+Arrays.toString(dr7)); //[10,20,30]

        System.out.println("\n===== Exercise 8: mergeTwoArrays =====");
        int[] ar8={10,20,30,40,50,60};
        int[] br8={70,80,90,100};
        int[] cr8=mergeTwoArrays(ar8,br8);
        System.out.println("cr : "+Arrays.toString(cr8));
        //[10,20,30,40,50,60,70,80,90,100]

        System.out.println("\n===== Exercise 9: equals =====");
        int[] ar9={10,20,30,40,50,60};
        int[] br9={10,50,20,60,40,30};
        int[] cr9={10,20,30,40,50,60};
        int[] dr9={10,20,30,40,50,60,70};
        System.out.println("ar== br : "+equals(ar9,br9)); //false
        System.out.println("ar== cr : "+equals(ar9,cr9)); //true
        System.out.println("ar== dr : "+equals(ar9,dr9)); //false

        System.out.println("\n===== Exercise 10: reverseAnArray =====");
        int[] ar10={10,20,30,40,50,60,70,80,90};
        System.out.println(Arrays.toString(ar10));//[10,20,30,40,50,60,70,80,90]
        reverseAnArray(ar10);
        System.out.println(Arrays.toString(ar10));//[90,80,70,60,50,40,30,20,10]
    }
}