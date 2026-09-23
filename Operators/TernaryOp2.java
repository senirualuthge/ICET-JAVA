import java.util.*;

public class TernaryOp2 {
    public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input average marks : ");
		double avg=input.nextDouble();
		String status;
		/*if(avg>=50){
			status="Pass";
		}else{
			status="Fail";
		}*/
		status=avg>=50 ? "Pass":"Fail";
		System.out.println(status);
        input.close();
	}

}
