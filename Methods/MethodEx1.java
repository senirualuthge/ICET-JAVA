import java.util.*;

public class MethodEx1 {
    public static void printPrimeNumbers(int a){
		//----------Process-----------------
		boolean isPrime=true;
		for(int i=2; i<a; i++){
			if(a%i==0){
				isPrime=false;
				break;
			}
		}
		//---------output-------------------
		if(isPrime){
			System.out.println(a+" is a prime number....");
		}
	}
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input an integer : ");
		int num=input.nextInt();		
		printPrimeNumbers(num);
        input.close();
	}
}


