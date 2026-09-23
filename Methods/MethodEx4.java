import java.util.*;

public class MethodEx4 {
            public static int findDigitsCount(int num){
            int count=0;
            do{
                count++;
                num/=10;
            }
            while(num!=0);
            return count;
        }
        public static void main(String args[]){
            try(Scanner input=new Scanner(System.in)){
            System.out.print("Input number 1 : ");
            int num=input.nextInt();		
            int count;
            count=findDigitsCount(num);
            System.out.println("No of digits for "+num+" : "+count);
        }
    }

	
}



