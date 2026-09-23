import java.util.*;
class Static1 {
    
    public static int x = 10; // static template variable

    public static void main(String[] args) {
        System.out.println(x);
        incrementX();
        System.out.println(x);
    }

    public static void incrementX() {
        x++;
    }
}

