import java.util.*;
public class FormatString5 {
    public static void main(String args[]){

     double avg=45.123;
	    	double salary=1234567.546;
	    	String fs;
	    	fs=String.format("%f,%f",avg,salary);
	    	System.out.println(fs);//45.123,1234567.546000
	    	fs=String.format("%2$f,%1$f",avg,salary);
	    	System.out.println(fs);//1234567.546000,45.123000
        
	    	fs=String.format("%2$20f,%1$15f",avg,salary);//no flags
	    	System.out.println(fs);//      1234567.546000,      45.123000

	    	fs=String.format("%2$20.4f,%1$15.2f",avg,salary);//no flags
	    	System.out.println(fs);//        1234567.5460,          45.12
        
	    	fs=String.format("%2$20.4f,%1$-15.2f",avg,salary);//flag->left alignment
	    	System.out.println(fs);//        1234567.5460,45.12
        
	    	fs=String.format("%2$0,20.4f,%1$-15.2f",avg,salary);//flag->left alignment
	    	System.out.println(fs);//0000001,234,567.5460,45.12
    }
}
//"%[argument index$][flags][width][.pression]conversion char"


