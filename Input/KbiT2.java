import java.util.*;
class KbiT2{
	public static void main(String args[]){
		int x, y;	
		Scanner input=new Scanner(System.in);
		System.out.println("Number:");
		y=input.nextInt();
		System.out.println("Number:");
		x=input.nextInt();
		input.close();
		System.out.println(x+ "+" + y+"=" +( x+y));
		System.out.println(x+ "-" + y+"=" +( x-y));
		System.out.println(x+ "*" + y+"=" +( x*y));
		System.out.println(x+ "/" + y+"=" +( x/y));
	}
}


