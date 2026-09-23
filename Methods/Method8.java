import java.util.*;
public class Method8 {

    public static int pow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println("2^7 : "+pow(2,7));
    }
}
