import java.util.*;

public class Prime1 {
	public static void main(String args[]){
        /*      try(Scanner input=new Scanner(System.in)){
            System.out.print("Input an integer : ");
            int num=input.nextInt();
            boolean isPrime=true;
            for(int i=2; i<num; i++){
                if(num%i==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(num+" is a prime number...");
            }
            else{
                System.out.println(num+" is not a prime number...");
            }



           System.out.println("Q08 - Primes (1-1000):");
                for (int i = 2; i <= 1000; i++) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) { isPrime = false; 
                        break; 
                    }
                }
                if (isPrime) System.out.print(i + " ");
*/
             
		    L1:for(int j=2; j<=1000; j++){
                for(int i=2; i<j; i++){
				    if(j%i==0){
				    	continue L1;
				    }
			    }
			    System.out.println(j);

            }
        }
    }



