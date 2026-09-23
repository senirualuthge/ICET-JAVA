import java.util.*;

public class TernaryOp1 {
        public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input a Salary : ");
		double salary=input.nextDouble();
		System.out.println("Basic Salary : "+salary);
		/*if(salary<50000){
			salary=salary*1.2; //salary=salary+salary*0.2;
		}else{
			salary=salary*1.1;//salary=salary+salary*0.1;
		}*/
		salary=salary<=50000 ? salary*1.2 : salary*1.1;
		System.out.println("Net Salary   : "+salary);
        input.close();
        
	}

    
}
