import java.util.Scanner;
import java.util.*;
class PrePostIncrement{
	public static void main(String args[]){
		
	Scanner input=new Scanner(System.in);
	int x=100;
	System.out.println(x); //prints 100
		
	x++;
	System.out.println(x); //prints 101
		
	++x;
	System.out.println(x); //prints 102
		
	x--;		
	System.out.println(x); //prints 101
		
	--x;
	System.out.println(x); //prints 100
	}
}

