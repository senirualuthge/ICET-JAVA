import java.util.Scanner;
import java.util.*;

class NextLineT1{
public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Input your age  : ");
		int age=input.nextInt();
		
		System.out.print("Input your name : ");
		String name=input.next();

		System.out.println("Name : "+name);
		System.out.println("Age  : "+age);
		input.close();

	

	}
}
