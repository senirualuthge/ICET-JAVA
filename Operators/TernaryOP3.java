import java.util.Scanner;
import java.util.*;

public class TernaryOP3 {
    public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input average marks : ");
		double avg=input.nextDouble();
		String grade;
        grade=avg>75 ? "Grade A" :avg>65 ? "GradeB"	:avg>45 ? "GradeC" :avg>25 ? "GradeD" : "GradeE";
        System.out.println(grade);
        input.close();
    }
}


