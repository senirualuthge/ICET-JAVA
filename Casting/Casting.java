import java.util.*;
class Casting{
	public static void main(String args[]){
		int x=100;
		byte b;
		//b=x;
		b=(byte)x; //assign last 8 bits of x  to b
		System.out.println(x+" "+b); //100 100
	}
}


