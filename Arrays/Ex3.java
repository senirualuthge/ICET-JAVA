import java.util.*;

class Ex3 {
    public static void main(String[] args) {
        int[] ar={10,20,30,40,50};
            System.out.println(Arrays.toString(ar)); //[10,20,30,40,50]
            //Insert code here to add 60
            int[] tempAr=new int[ar.length+1];	//Step 1
            for(int i=0; i<ar.length; i++){ 	//Step 2
                tempAr[i+1]=ar[i];
            }
            ar=tempAr; //Step 3
            ar[0]=60; //Step 4
            
            System.out.println(Arrays.toString(ar));//[60,10,20,30,40,50]
	}
}


