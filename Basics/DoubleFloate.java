import java.util.*;
class DoubleFloate{
	public static void main(String args[]){
		
		System.out.println(9223372036854775807L); //Legal, max of long
		//System.out.println(9223372036854775808L); //Illegal
		System.out.println(9223372036854775808f); //legal->float(32bits)
		System.out.println(9223372036854775808d); //legal->double(64bits)
	}
}


