import java.util.Scanner;
import java.util.*;
class KbiT1{
	public static void main(String args[]){
		int y, m, d;	
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Year:");
		y=input.nextInt();
		System.out.println("Enter month:");
		m=input.nextInt();
		System.out.println("Enter day:");
		d=input.nextInt();
		input.close();
		System.out.println(y+"-"+m+"-"+d);
	}
}

