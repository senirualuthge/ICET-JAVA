import java.util.*;
class Prime{
public static void main(String[] args){
System.out.println("\nQ48: Prime numbers 1-100 using while");
int x = 2;

while (x <= 100) {
    int dc = 0;
    int i = 2;

    while (i < x) {
        if (x % i == 0) {
            dc = dc + 1;
        }
        i++;
    }

    if (dc == 0) {
        System.out.print(x + " ");
    }

    x++;
}
    }
}   
