import java.util.Scanner;
import java.util.*;
class KbiT4{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		int x,y;
		System.out.print("Input First number  : ");
		x=input.nextInt(); //->12
		System.out.print("Input Second number : ");
		y=input.nextInt(); //->13

		System.out.println(x+" "+y); //12 13
		//Insert code here to swap x,y
		x=y;
		y=x;
		System.out.println(x+" "+y); //13 12
	}
}

