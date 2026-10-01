import java.util.*;
class NarrowConversion{
	public static void main(String args[]){
		int age=12;
		age+=10; //age=age+10;
		System.out.println(age); //22
		
		long y=1000;
		age+=(int)y; //Legal->Wider conversion, explicit narrowing back to int
	}
}



