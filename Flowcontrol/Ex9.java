import java.util.Scanner;
import java.util.*;
class Ex9 {
      
        public static void main (String arg []){

       
        int tot =0;
        int mark =0;
        int i =1;
        Scanner input =new Scanner(System.in);

        while(i>=1){
            System.out.println("Input marks for Number " + i);
            mark = input.nextInt();
            if(mark<0){
                break;
            }

            tot += mark;
            System.out.print("Full Marks :"+tot);
            i++;
        }
int total =0;
        
        while(mark!=1){
            
			total+=mark;
			System.out.print("Input marks for student(press -1 to terminate) :");
			mark=input.nextInt();
		}
		System.out.println("Total Marks : "+total);

        
        input.close();

    }
}