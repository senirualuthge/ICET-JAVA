import java.util.Scanner;
import java.util.*;
class Ex8 {
      
        public static void main (String arg []){

       
        int tot =0;
        int mark;
        Scanner input =new Scanner(System.in);

/* 
        int a,b,c,d,e,f,g;
        System.out.println("Input marks for Numbers");
        a = input.nextInt();
        System.out.println("Input marks for Numbers");
        b = input.nextInt();
        System.out.println("Input marks for Numbers");
        c = input.nextInt();
        System.out.println("Input marks for Numbers");
        d = input.nextInt();
        System.out.println("Input marks for Numbers");
        e = input.nextInt();
        System.out.println("Input marks for Numbers");
        f = input.nextInt();
        System.out.println("Input marks for Numbers");
        g = input.nextInt();

        tot = a+b+c+d+e+f+g;
        System.out.println("Total of marks: " + tot);
 */
        System.out.println("Input no of students " );
        final int N=input.nextInt();

        for (int i = 1; i <= 7; i++) {
            System.out.println("Input marks for Number " + i);
            mark = input.nextInt();
            tot += mark;
            System.out.println("Full marks " + tot);




        }

        double avg = (double)tot/N;
        System.out.println("Total marks   : "+tot);
		System.out.println("Average marks : "+avg);


        input.close();
    }
}
