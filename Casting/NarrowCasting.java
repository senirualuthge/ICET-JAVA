import java.util.*;

class NarrowCasting{
	public static void main(String args[]){
		short s=255;
		byte b;
		//b=s;
		b=(byte)s; //255->-"1 1 1 1 1 1 1 1"
		System.out.println(b); //-1
	}
}
