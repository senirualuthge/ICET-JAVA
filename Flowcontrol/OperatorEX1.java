import java.util.*;
public class OperatorEX1 {
    public static void main(String args[]){
		Scanner input=new Scanner(System.in);
        
		System.out.print("Enter Average : ");
		double avg=input.nextDouble();
		if(avg>=50){
			System.out.println("Pass");
		}
		else{
			System.out.println("Fail");
		}
        input.close();
	}
}

    

