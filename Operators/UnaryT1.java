import java.util.Scanner;
import java.util.*;
class UnaryT1{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input number 1 : ");
		int num1=input.nextInt();
		System.out.print("Input number 2 : ");
		int num2=input.nextInt();
		int result;
		
		result=num1+num2;
		System.out.println(num1+" + "+num2+" = "+result);
		
		result=num1-num2;
		System.out.println(num1+" - "+num2+" = "+result);
		
		result=num1*num2;
		System.out.println(num1+" * "+num2+" = "+result);
		
		result=num1/num2;
		System.out.println(num1+" / "+num2+" = "+result);
		
		System.out.println(-100); //negative
		System.out.println(+100); //positive
		
		int x;
		x=-100; //
		System.out.println(x);
		x=+100; //
		System.out.println(x);

		input.close();
	}
}

