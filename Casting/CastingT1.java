import java.util.*;
class CastingT1{
	public static void main(String args[]){
		int x;
		byte b;
		
		x=127;
		b=(byte)x;
		System.out.println(x+" "+b); //
		
		x=128;
		b=(byte)x;
		System.out.println(x+" "+b); //
		
		x=Integer.MAX_VALUE;
		b=(byte)x;
		System.out.println(x+" "+b); //
		
		x=256;
		b=(byte)x;
		System.out.println(x+" "+b); //
	}
}

