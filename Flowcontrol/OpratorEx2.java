import java.util.Scanner;
import java.util.*;
public class OpratorEx2 {
    
    public static void main(String args[]){ 
        
    Scanner input=new Scanner(System.in);
    double num;
    System.out.print("Monthly salary : ");
    num=input.nextDouble();
    if (num<=50000){
        num = num +(num * 20 / 100); 
       
        System.out.println("New Monthly Salary: " + num);
    }
    else{
        num = num + (num * 10 / 100); 
        
        System.out.println("New Monthly Salary: " + num);
    }
    double x = num * 12;
    System.out.println("Annual Salary: " + x);

    input.close();
    
    }
}

    

