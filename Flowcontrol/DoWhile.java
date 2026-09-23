import java.util.*;
public class DoWhile {
    public static void main (String arg []){
        int num =0;
        int count =0;
        do{
            num=num/10;
            count++;
		}
        
        while(num!=0) ;

            System.out.println("Total Marks : "+ count);

    }

}
