import java.util.*;
class CastingT2{
	public static void main(String args[]){
		char ch='A';
		double d;
		d=ch; //Legal, wider conversion
		System.out.println(d); //65.0
	}
}

