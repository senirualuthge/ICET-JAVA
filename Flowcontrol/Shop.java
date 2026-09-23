import java.util.*;
public class Shop {
    public static void main(String args[]){ 
        
    Scanner input=new Scanner(System.in);
    int num;
    System.out.print("Monthly salary : ");
    num=input.nextInt();
    if (num<5000){
        num = num + 1000;
        System.out.println("New Monthly Salary: " + num);
    }
    int x = num * 12;
    System.out.println("Annual Salary: " + x);

    input.close();
    
    }
}
