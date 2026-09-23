import java.util.*;
    public class Coursework4 {
        
    
    public static void main(String args[]){

        System.out.println("-------------------------------");
        System.out.println("||SALARY INFORMATION SYSTEM||");
        System.out.println("-------------------------------");
                System.out.println("\t[1] Calculate Income Tax");
                System.out.println("\t[2] Calculate Annual Bonus");
                System.out.println("\t[3] Calculate Loan Amount ");

                System.out.println("\n\n" );




            Scanner input = new Scanner(System.in);   // ONE Scanner for the whole program

                System.out.print("Enter and option to continue :");
                int x = input.nextInt();

             switch(x){


                    
                    case 1	:System.out.println(" 1");

                        System.out.println("-------------------------------");
                        System.out.println("||CALCULATE INCOME TAX||");
                        System.out.println("-------------------------------");




                 
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
                         tax1 = 50000 * 6 / 100;           
                         tax2 = (Sal-200000) * 12 / 100;
                         totalTax = tax1 + tax2;
                         System.out.println("Tax applicable is 12% : "+tax2);
                         System.out.println("Tax applicable is  : "+tax1+" + "+tax2);
                         System.out.println("Salary after tax : "+(Sal-totalTax));
                     }
                     else if (Sal > 250000 && Sal<=300000){
                         tax1 = 50000 * 6 / 100;
                         tax2 = 50000 * 12 / 100;             
                         tax3 = (Sal-250000) * 18 / 100;
                         totalTax = tax1 + tax2 + tax3;
                         System.out.println("Tax applicable is 18% : "+tax3);
                         System.out.println("Tax applicable is  : "+tax1+" + "+tax2+" + "+tax3);
                         System.out.println("Salary after tax : "+(Sal-totalTax));
                     }
                     else if (Sal > 300000 && Sal<=350000){
                         tax1 = 50000 * 6 / 100;
                         tax2 = 50000 * 12 / 100;
                         tax3 = 50000 * 18 / 100;             
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
                         tax4 = 50000 * 20 / 100;              
                         tax5 = (Sal-350000) * 30 / 100;
                         totalTax = tax1 + tax2 + tax3 + tax4 + tax5;
                         System.out.println("Tax applicable is 30% : "+tax5);
                         System.out.println("Tax applicable is  : "+tax1+" + "+tax2+" + "+tax3+" + "+tax4+" + "+tax5);
                         System.out.println("Salary after tax : "+(Sal-totalTax));
                        }

                        break;

			        case 2:


                        System.out.println("2");
                        System.out.println("-------------------------------");
                        System.out.println("||CALCULATE ANNUAL BONUS ||");
                        System.out.println("-------------------------------");

                        double salary;
                        String name;

                        System.out.print("Employee name : ");
                        input.nextLine();
                        name = input.nextLine();

                        System.out.print("Employee Salary : ");
                        salary = input.nextDouble();

                        if (salary <= 100000) {
                            System.out.println("Bonus: " + (salary + 5000.00));
                        } 
                        else if (salary > 100000 && salary < 150000) {
                            double salary1 = salary + (salary * 10 / 100);
                            System.out.println("Bonus: " + salary1);
                        } 
                        else if (salary >= 150000 && salary < 200000) {
                            double salary2 = salary + (salary * 10 / 100);
                            System.out.println("Bonus: " + salary2);
                        } 
                        else if (salary >= 200000 && salary < 300000) {
                            double salary3 = salary + (salary * 15 / 100);
                            System.out.println("Bonus: " + salary3);
                        } 
                        else if (salary >= 300000 && salary < 400000) {
                            double salary4 = salary + (salary * 20 / 100);
                            System.out.println("Bonus: " + salary4);
                        } 
                        else if (salary >= 400000) {
                            double salary5 = salary + (salary * 25 / 100);
                            System.out.println("Bonus: " + salary5);
                        }

                        System.out.println("Employee: " + name);

                        break;   
                        
                        

                        
			        case 3	:System.out.println(" 3");
                        
                        System.out.println("-------------------------------");
                        System.out.println("||CALCULATE LOAN AMOUNT||");
                        System.out.println("-------------------------------");
                        
                        System.out.print("Employee name : ");
                        name = input.nextLine();

                        System.out.print("Employee Salary : ");
                        salary = input.nextDouble();
                        input.nextLine(); 

                        System.out.print("Enter number of years (max 5) : ");
                        int years = input.nextInt();
                        input.nextLine(); 

                        if (salary <= 50000) {                      
                        System.out.println("Employee salary must exceed Rs.50000 to get a loan.");

                        } else if (years <= 0 || years > 5) {

                            System.out.println("Sorry, number of years must be between 1 and 5.");
                        } 
                        else {
                            double ar = 0.15;
                            double mi = salary * 0.60;
                            int n = years * 12;
                            double monthlyRate = ar / 12;

                            double loanAmount = mi * (1 - Math.pow(1 + monthlyRate, -n)) / monthlyRate;
                            loanAmount = Math.round(loanAmount / 1000.0) * 1000;

                            System.out.println("-------------------------------");
                            System.out.println("Employee Name        : " + name);
                            System.out.printf("Monthly Salary       : %.2f%n", salary);
                            System.out.printf("Monthly Installment  : %.2f%n", mi);
                            System.out.println("Annual Interest Rate : 15%");
                            System.out.println("Loan Period          : " + years + " year(s)");
                            System.out.printf("Maximum Loan Amount  : Rs. %.2f%n", loanAmount);
                            System.out.println("-------------------------------");
                        }

                        break;
                       
                    default: 
                     System.out.println("Wrong Number");
                    break;
                }


            
        input.close();   
                
        }
}


