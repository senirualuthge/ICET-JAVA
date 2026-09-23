import java.util.*;
class Ex2{
	public static int[] ar={10,20,30,40,50};
	
	public static void main(String args[]){	
		System.out.println(Arrays.toString(ar));//[10,20,30,40,50]
		addLast(60);
		System.out.println(Arrays.toString(ar));//[10,20,30,40,50,60]
	}
	public static void addLast(int data){
		int[] tempAr=new int[ar.length+1];
		for (int i = 0; i < ar.length; i++){
			tempAr[i]=ar[i];
		}
		tempAr[tempAr.length-1]=data;
		ar=tempAr;
	}
}
