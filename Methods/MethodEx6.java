import java.util.*;
public class MethodEx6 {
    
    public static int fact(int n) {
        if (n <= 1) {
        return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String args[]){
        for (int i = 0; i < 10; i++){
            System.out.println(i+"! : "+fact(i));
        }
    }
}
