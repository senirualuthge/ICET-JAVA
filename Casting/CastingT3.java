import java.util.*;
class CastingT3{
	public static void main(String args[]){
		char ch;
		double d=65.1234567;
		//ch=d;//Illegal, need to cast
		ch=(char)d;
		System.out.println(d+"-->"+ch); //65.0-->A
	}
}

