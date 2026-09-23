import java.util.*;
class RemainderT1{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input millimetres : ");
		int mm=input.nextInt();
		int km=0,m=0,cm=0;
		
		km=mm/1000000;
		mm=mm%1000000;
		
		m =mm/1000;
		mm=mm%1000;
		
		cm =mm/10;
		mm=mm%10;
		
		System.out.println(km+"km, "+m+"m, "+cm+"cm, "+mm);
		
	}
}

