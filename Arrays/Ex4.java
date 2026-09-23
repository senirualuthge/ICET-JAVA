import java.util.*;
class Ex4{

	public static int[] addLast(int[] ar, int value){
		int[] tempAr=new int[ar.length+1];	//Step 1
		for(int i=0; i<ar.length; i++){ 	//Step 2
			tempAr[i]=ar[i];
		}
		ar=tempAr; //Step 3
		ar[ar.length-1]=value; //Step 4
		return ar;
	}
	public static void main(String args[]){	
		int[] ar={10,20,30,40,50};
		System.out.println(Arrays.toString(ar));//[10,20,30,40,50]
		ar=addLast(ar,60);
		System.out.println(Arrays.toString(ar));//[10,20,30,40,50,60]


	}


}

