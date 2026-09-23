import java.util.*;
class Kbi1{
	public static void main(String args[]){
		int x;
		int y;
		int z;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter x:");
		x=input.nextInt();
		System.out.println("Enter y:");
		y=input.nextInt();
		z=x+y;
		input.close();
		System.out.print("Sub Total is :");	
		System.out.println(x + " + " + y + " = " + z);
	}
}

