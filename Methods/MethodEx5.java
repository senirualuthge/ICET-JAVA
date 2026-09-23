import java.util.*;

public class MethodEx5 {
    public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input student average marks : ");
		double avg=input.nextDouble();
		if(isPass(avg)){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
	}

	// determine if student passed; pass threshold 50.0
	public static boolean isPass(double avg){
		return avg>=50.0;
	}

}
