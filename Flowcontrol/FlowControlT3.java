import java.util.*;
public class FlowControlT3 {
    public static void main(String arg[]){
        int i=0;
        
        for (System.out.println("A");i<10; System.out.println("C")){
            System.out.println("B");
            i++;
        }
    }
}
