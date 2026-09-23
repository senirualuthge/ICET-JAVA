import java.util.*;
public class Ex5 {

    public static void main(String args[]){
        {
            int y;
            final int x=101;

            if(x>=100){ //true
                y=200;
            }
            System.out.println(y);  //Legal
        }

        {
            int y;
            int x=101;

            if(102>=100){ //true
                y=200;
            }
            System.out.println(y);
        }

        {
            int y;
            int x=101;

            if(x>=100){
                y=200;
            }else{
                y=300;
            }
            System.out.println(y);  //
        }

        {
            int y;
            int x=101;

            if(x>=100){
                y=200;
            }
            // System.out.println(y);  //Initialization error - y might not have been initialized
        }

        // int y;
        // System.out.println(y);  //Error - y might not have been initialized
    }
}
