import java.util.Scanner;
import java.util.*;

public class PRFAssignment3{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== PROGRAMMING FUNDAMENTALS - WEEK 03 ASSIGNMENT ==========\n");

        // ===== QUESTION 01 =====
        {
            int tot = 971;
            double avg;

        

            avg = (double) tot / 10;
            System.out.println("A. avg = (double) tot/10; -> " + avg);

            avg = tot / (double) 10;
            System.out.println("B. avg = tot/(double)10; -> " + avg);

            avg = (double) (tot / 10);
            System.out.println("C. avg = (double)(tot/10); -> " + avg);

            avg = tot / 10;
            System.out.println("D. avg = tot/10; -> " + avg);

            System.out.println("Correct answers: A and B\n");
        }

        // ===== QUESTION 02 =====
        {
        
            double d;

            d = 5 / 2 + 5 / 2;
            System.out.println("5 / 2 + 5 / 2 = " + d);

            d = 5 / 2.0 + 5 / 2;
            System.out.println("5 / 2.0 + 5 / 2 = " + d);

            d = 5 / 2 + 5.0 / 2;
            System.out.println("5 / 2 + 5.0 / 2 = " + d);

            d = 5 / 2.0 + 5 / 2.0;
            System.out.println("5 / 2.0 + 5 / 2.0 = " + d);

            System.out.println("Correct answer: B\n");
        }

        // ===== QUESTION 03 =====
        {
        
            int a = 10, b = 7, c = -10, d = -7;

            System.out.println("A. a%b = " + (a % b));
            System.out.println("B. -a%b = " + (-a % b));
            System.out.println("C. a%-b = " + (a % -b));
            System.out.println("D. -a%-b = " + (-a % -b));
            System.out.println("E. +a%+b = " + (+a % +b));
            System.out.println("F. c%d = " + (c % d));
            System.out.println("G. -c%d = " + (-c % d) + "\n");
        }

        // ===== QUESTION 04 =====
        {
        
            int x = 10, y = 7;

            System.out.println("A. x+y = " + (x + y));
            System.out.println("B. -x = " + (-x));
            System.out.println("C. -x-y = " + (-x - y));
            System.out.println("D. -(x-y) = " + (-(x - y)));
            System.out.println("E. +y = " + (+y));
            System.out.println("F. +y-x = " + (+y - x) + "\n");
        }

        // ===== QUESTION 05 =====
        {
            
            int x = -100;

            x = +x;
            System.out.println("x = +x; System.out.println(x); -> " + x);

            x = -x;
            System.out.println("x = -x; System.out.println(x); -> " + x);

            x = -x;
            System.out.println("x = -x; System.out.println(x); -> " + x);

            x = x + x;
            System.out.println("x = x+x; System.out.println(x); -> " + x);

            x = -x - x;
            System.out.println("x = -x-x; System.out.println(x); -> " + x);

            x = x - x;
            System.out.println("x = x-x; System.out.println(x); -> " + x + "\n");
        }

        // ===== QUESTION 06 =====
        {
            
            int x = 100;

            System.out.print("System.out.print(x++); -> ");
            System.out.print(x++);
            System.out.println(" (x becomes " + x + ")");

            System.out.print("System.out.println(x++); -> ");
            System.out.println(x++ + " (x becomes " + x + ")");

            x++;
            System.out.println("After x++; x = " + x);

            System.out.println("System.out.println(++x); -> " + (++x) + " (x becomes " + x + ")");
            System.out.println("System.out.println(x++); -> " + (x++) + " (x becomes " + x + ")\n");
        }

        // ===== QUESTION 07 =====
        {
            
            int x = 100, y;

            y = x++;
            System.out.println("y = x++; -> x=" + x + ", y=" + y);

            y = x++;
            System.out.println("y = x++; -> x=" + x + ", y=" + y);

            y = x++;
            System.out.println("y = x++; -> x=" + x + ", y=" + y + "\n");
        }

        // ===== QUESTION 08 =====
        {
            
            int x = 100, y;

            y = ++x;
            System.out.println("y = ++x; -> x=" + x + ", y=" + y);

            y = ++x;
            System.out.println("y = ++x; -> x=" + x + ", y=" + y);

            y = ++x;
            System.out.println("y = ++x; -> x=" + x + ", y=" + y + "\n");
        }

        // ===== QUESTION 09 =====
        {
            
            int x = 100;

            x = x++;
            System.out.println("x = x++; -> " + x);

            x = x++;
            System.out.println("x = x++; -> " + x);

            x = x++;
            System.out.println("x = x++; -> " + x);

            x = ++x;
            System.out.println("x = ++x; -> " + x);

            x = ++x;
            System.out.println("x = ++x; -> " + x);

            x = ++x;
            System.out.println("x = ++x; -> " + x + "\n");
        }

        // ===== QUESTION 10 =====
        {
            
            int a = 10, b = 20, x;

            a = 10; b = 20;
            x = a + b;
            System.out.println("A. x = a + b; -> " + x);

            a = 10; b = 20;
            x = a + -b;
            System.out.println("B. x = a + -b; -> " + x);

            a = 10; b = 20;
            x = ++a + b;
            System.out.println("C. x = ++a + b; -> " + x + " (a=" + a + ", b=" + b + ")");

            a = 10; b = 20;
            x = a + b++;
            System.out.println("D. x = a + b++; -> " + x + " (a=" + a + ", b=" + b + ")");

            a = 10; b = 20;
            x = ++a + b++;
            System.out.println("E. x = ++a + b++; -> " + x + " (a=" + a + ", b=" + b + ")");

            a = 10; b = 20;
            x = a + ++b;
            System.out.println("F. x = a + ++b; -> " + x + " (a=" + a + ", b=" + b + ")");

            a = 10; b = 20;
            x = ++a + ++b;
            System.out.println("G. x = ++a + ++b; -> " + x + " (a=" + a + ", b=" + b + ")");

            a = 10; b = 20;
            x = a++ + ++b;
            System.out.println("H. x = a++ + ++b; -> " + x + " (a=" + a + ", b=" + b + ")\n");
        }

        // ===== QUESTION 11 =====
        {
        
            int x;

            x = 12 - 4 * 2;
            System.out.println("12 - 4*2 : " + x);

            x = (12 - 4) * 2;
            System.out.println("(12 - 4)*2: " + x);

            x = 12 - (4 * 2);
            System.out.println("12 - (4*2): " + x + "\n");
        }

        // ===== QUESTION 12 =====
        {
        
            int x;

            x = 7 % 10 / 2 * 2;
            System.out.println("A. 7 % 10 / 2 * 2 = " + x);

            x = 7 % (10 / 2) * 2;
            System.out.println("B. 7 % (10 / 2) * 2 = " + x);

            x = 7 % 10 / (2 * 2);
            System.out.println("C. 7 % 10 / (2 * 2) = " + x);

            x = 7 % (10 / (2 * 2));
            System.out.println("D. 7 % (10 / (2 * 2)) = " + x);

            x = 7 % ((10 / 2) * 2);
            System.out.println("E. 7 % ((10 / 2) * 2) = " + x + "\n");
        }

        // ===== QUESTION 13 =====
        {
        
            System.out.print("Enter dividend: ");
            int dividend = sc.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            int quotient = dividend / divisor;
            int remainder = dividend % divisor;

            System.out.println("Quotient: " + quotient);
            System.out.println("Remainder: " + remainder + "\n");
        }

        // ===== QUESTION 14 =====
        {
        
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.println("Addition: " + (num1 + num2));
            System.out.println("Subtraction: " + (num1 - num2));
            System.out.println("Multiplication: " + (num1 * num2));
            System.out.println("Division: " + (num1 / num2));
            System.out.println("Remainder: " + (num1 % num2) + "\n");
        }

        // ===== QUESTION 15 =====
        {
        
            System.out.print("Enter radius of the circle: ");
            double radius = sc.nextDouble();

            double area = Math.PI * radius * radius;
            double perimeter = 2 * Math.PI * radius;

            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter + "\n");
        }

        // ===== QUESTION 16 =====
        {
        
            System.out.print("Enter price of the product: ");
            double price = sc.nextDouble();
            System.out.print("Enter discount rate (%): ");
            double discountRate = sc.nextDouble();

            double discount = price * (discountRate / 100);
            double finalPrice = price - discount;

            System.out.println("Discount amount: " + discount);
            System.out.println("Final price: " + finalPrice + "\n");
        }

        // ===== QUESTION 17 =====
        {
        
            System.out.print("Enter total amount of purchase: ");
            double amount = sc.nextDouble();

            double tax = amount * 0.15;
            double total = amount + tax;

            System.out.println("Import tax (15%): " + tax);
            System.out.println("Total amount: " + total + "\n");
        }

        // ===== QUESTION 18 =====
        {
        
            System.out.print("Enter bytes: ");
            long bytes = sc.nextLong();

            double kb = bytes / 1024.0;
            double mb = kb / 1024.0;
            double gb = mb / 1024.0;

            System.out.println(bytes + " Bytes = " + kb + " KB");
            System.out.println(bytes + " Bytes = " + mb + " MB");
            System.out.println(bytes + " Bytes = " + gb + " GB\n");
        }

        // ===== QUESTION 19 =====
        {
        
            System.out.print("Number of days: ");
            int days = sc.nextInt();

            int months = days / 30;
            int remainingDays = days % 30;

            System.out.println(days + " days = " + months + " Months and " + remainingDays + " days\n");
        }

        // ===== QUESTION 20 =====
        {
        
            System.out.print("Input seconds: ");
            int totalSeconds = sc.nextInt();

            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            System.out.printf("%02d:%02d:%02d\n\n", hours, minutes, seconds);
        }

        // ===== QUESTION 21 =====
        {
        
            System.out.print("How many eggs do you have: ");
            int totalEggs = sc.nextInt();

            int gross = totalEggs / 144;
            int remaining = totalEggs % 144;
            int dozen = remaining / 12;
            int extra = remaining % 12;

            System.out.println("Your number of eggs is " + gross + " gross, " +
                              dozen + " dozen, and " + extra + "\n");
        }

        // ===== QUESTION 22 =====
        {
           
            System.out.print("Enter dividend: ");
            int dividend = sc.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            int quotient = dividend / divisor;
            int remainder = dividend - (quotient * divisor);

            System.out.println("Remainder (without using % operator): " + remainder + "\n");
        }

        // ===== QUESTION 23 =====
        {
            
            System.out.print("Enter body mass (kg): ");
            double mass = sc.nextDouble();
            System.out.print("Enter height (m): ");
            double height = sc.nextDouble();

            double bmi = mass / (height * height);

            System.out.printf("Body Mass Index is %.2f\n\n", bmi);
        }

        // ===== QUESTION 24 =====
        {
           
            System.out.print("Enter basic salary: ");
            double salary = sc.nextDouble();

            double employeeFund = salary * 0.12;
            double employerFund = salary * 0.035;
            double pensionFund = salary * 0.083;
            double totalContribution = employeeFund + employerFund + pensionFund;

            System.out.println("Employee Fund (12.0%): " + employeeFund);
            System.out.println("Employer Fund (3.5%): " + employerFund);
            System.out.println("Pension Fund (8.3%): " + pensionFund);
            System.out.println("Total Contribution: " + totalContribution + "\n");
        }

        // ===== QUESTION 25 =====
        {
            
            System.out.print("Enter the tax-inclusive price in dollars: ");
            double taxInclusivePrice = sc.nextDouble();

            double actualPrice = taxInclusivePrice / 1.10;
            double salesTax = taxInclusivePrice - actualPrice;

            System.out.printf("Actual Price is: %.2f\n", actualPrice);
            System.out.printf("Sales Tax is: %.2f\n", salesTax);
        }

        sc.close();
    }
}