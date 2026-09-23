import java.util.*;


class Mymethod3
{
	public static void increment(){
		int x=100;
		System.out.println("myMethod : "+x);
		x++;
		System.out.println("myMethod : "+x);
	}
	public static void main(String args[]){
		int x;
		x=100;
		System.out.println("main : "+x);
		increment();
		System.out.println("main : "+x);
	}
}
