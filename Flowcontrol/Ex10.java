import java.util.*;

public class Ex10 {

     public static void main (String arg []){

        int num =0;
        int count =0;
        
        Scanner input =new Scanner(System.in);
        System.out.print("Input marks for student(press -1 to terminate) :");
		num = input.nextInt();


       while(num!=0){

           
			num=num/10;
            count++;
		}
		System.out.println("Total Marks : "+ count);

        
        input.close();

    }
}
