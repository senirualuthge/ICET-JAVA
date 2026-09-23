import java.util.*;
public class OpratorEX4 {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.print("Monthly Salary : ");
        double Sal=input.nextDouble();
        double totalTax = 0;
        double tax1=0;
        double tax2=0;
        double tax3=0;
        double tax4=0;
        double tax5=0;

        if(Sal<=150000){ 
            System.out.println("No tax applicable."+Sal);
            System.out.println("Salary after tax : "+(Sal));
        }
        else if (Sal>150000 && Sal<=200000){
            tax1 = (Sal-150000) * 6 / 100;
            totalTax = tax1;
            System.out.println("Tax applicable is 6% : "+tax1);
            System.out.println("Salary after tax : "+(Sal-totalTax));
        }
        else if (Sal > 200000 && Sal<=250000){
            tax1 = 50000 * 6 / 100;              // 150k-200k band fully taxed
            tax2 = (Sal-200000) * 12 / 100;
            totalTax = tax1 + tax2;
            System.out.println("Tax applicable is 12% : "+tax2);
            System.out.println("Tax applicable is  : "+tax1+" + "+tax2);
            System.out.println("Salary after tax : "+(Sal-totalTax));
        }
        else if (Sal > 250000 && Sal<=300000){
            tax1 = 50000 * 6 / 100;
            tax2 = 50000 * 12 / 100;              // 200k-250k band fully taxed
            tax3 = (Sal-250000) * 18 / 100;
            totalTax = tax1 + tax2 + tax3;
            System.out.println("Tax applicable is 18% : "+tax3);
            System.out.println("Tax applicable is  : "+tax1+" + "+tax2+" + "+tax3);
            System.out.println("Salary after tax : "+(Sal-totalTax));
        }
        else if (Sal > 300000 && Sal<=350000){
            tax1 = 50000 * 6 / 100;
            tax2 = 50000 * 12 / 100;
            tax3 = 50000 * 18 / 100;              // 250k-300k band fully taxed
            tax4 = (Sal-300000) * 20 / 100;
            totalTax = tax1 + tax2 + tax3 + tax4;
            System.out.println("Tax applicable is 20% : "+tax4);
            System.out.println("Tax applicable is  : "+tax1+" + "+tax2+" + "+tax3+" + "+tax4);
            System.out.println("Salary after tax : "+(Sal-totalTax));
        }
        else { // Sal > 350000
            tax1 = 50000 * 6 / 100;
            tax2 = 50000 * 12 / 100;
            tax3 = 50000 * 18 / 100;
            tax4 = 50000 * 20 / 100;              // 300k-350k band fully taxed
            tax5 = (Sal-350000) * 30 / 100;
            totalTax = tax1 + tax2 + tax3 + tax4 + tax5;
            System.out.println("Tax applicable is 30% : "+tax5);
            System.out.println("Tax applicable is  : "+tax1+" + "+tax2+" + "+tax3+" + "+tax4+" + "+tax5);
            System.out.println("Salary after tax : "+(Sal-totalTax));
        }

        input.close();
    }
}