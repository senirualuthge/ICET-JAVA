import java.util.Scanner;
import java.util.*;

public class Method2 {

    public static char findGrade(double avg) {
        if (avg >= 90) {
            return 'A';
        } else if (avg >= 80) {
            return 'B';
        } else if (avg >= 70) {
            return 'C';
        } else if (avg >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input student average marks : ");
        double avg = input.nextDouble();
        char grade = findGrade(avg);
        System.out.println(avg + " : " + grade);
    }
}
