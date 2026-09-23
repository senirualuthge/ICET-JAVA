import java.util.*;

public class DoWileEx1 {
    public static void main (String arg []){

        Scanner input= new Scanner(System.in);
        int num =0;
        int count =0;

     do{
            num=num/10;
            count++;
		}
        
        while(num!=0) ;

            System.out.println("Total Marks : "+ count);

     input.close();
        
    }
}
