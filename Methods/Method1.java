import java.util.*;

    class Method1{

	public static void printTotal(int num1,int num2){
		//----------Process-----------------
		int total=num1+num2;
		
		//---------output-------------------
		System.out.println(num1+" + "+num2+" = "+total);
	}
	public static void main(String args[]){
		try(Scanner input=new Scanner(System.in)){
		System.out.print("Input number 1 : ");
		int num1=input.nextInt();		
		System.out.print("Input number 1 : ");
		int num2=input.nextInt();
		printTotal(num1,num2);
    }
	}
}


