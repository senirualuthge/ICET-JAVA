import java.util.*;
class  WiderCasting1{
	public static void main(String args[]){
		int total=765;
		int n=10; //no of subjects
		double avg;
		
		avg=total/n; //->Integer division
		System.out.println(avg); //76.0
		
		avg=(double)total/n;
		System.out.println(avg); //76.5
		
		avg=total/(double)n;
		System.out.println(avg); //76.5
	}
}


