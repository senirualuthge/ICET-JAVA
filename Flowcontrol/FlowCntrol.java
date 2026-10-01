import java.util.Scanner;
import java.util.*;

public class FlowCntrol {
    	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input an integer : ");
		int num=input.nextInt();
		System.out.println("A");
		System.out.println("B");
		if (num> 100){
            System.out.println("C");
		    System.out.println("D");
        }
		System.out.println("E");

        input.close();
	}
}

