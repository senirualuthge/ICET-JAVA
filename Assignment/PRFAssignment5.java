import java.util.Scanner;
import java.util.*;

public class PRFAssignment5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//1
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        if (num1 > num2) {
            double sum = num1 + num2;
            System.out.println("Sum of the two numbers: " + sum);
        } else {
            System.out.println("First number: " + num1);
            System.out.println("Second number: " + num2);
        }
//2
        System.out.print("Enter an integer number: ");
        int num = sc.nextInt();

        int absValue;
        if (num < 0) {
            absValue = -num;
        } else {
            absValue = num;
        }

        System.out.println("Absolute value: " + absValue);

//3
        System.out.print("Enter marks for Chemistry: ");
        double chemistry = sc.nextDouble();

        System.out.print("Enter marks for Physics: ");
        double physics = sc.nextDouble();

        System.out.print("Enter marks for Combined Maths: ");
        double combinedMaths = sc.nextDouble();

        double total = chemistry + physics + combinedMaths;
        double average = total / 3;

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);

        if (average > 75) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
//4
        System.out.print("Enter unit price: ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter amount bought: ");
        int amount = sc.nextInt();

        double total1 = unitPrice * amount;

        System.out.println("Total: Rs." + total1);

        if (total1 > 1500) {
            System.out.println("You are entitled to the super draw.");
        } else {
            System.out.println("Try again");
        }
//6
        System.out.print("Enter unit price: ");
        double unitPrice1 = sc.nextDouble();

        System.out.print("Enter amount bought: ");
        int amount1 = sc.nextInt();

        double total2 = unitPrice1 * amount1;

        System.out.println("Total: Rs." + total2);

        if (total2 > 500) {
            double discount = total2 * 0.05;
            double newTotal = total2 - discount;

            System.out.println("Discount: Rs." + discount);
            System.out.println("New Total: Rs." + newTotal);
        } else {
            System.out.println("No discount given");
        }
//6
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        boolean isLeap;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }

        if (isLeap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
//7
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter third number: ");
        int c = sc.nextInt();

        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        System.out.println("Maximum number is: " + max);
//10.    
         System.out.print("Enter an integer number: ");
        int number = sc.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }

//20

        
       
        System.out.print("Enter an integer: ");
        int num3 = sc.nextInt();

        if (num3 > 0) {
            System.out.println(num3 + " is positive.");
        } else if (num3 < 0) {
            System.out.println(num3 + " is negative.");
        } else {
            System.out.println("The number is zero.");
        }

//21   
        System.out.print("Enter first number: ");
        int d = sc.nextInt();
        System.out.print("Enter second number: ");
        int e = sc.nextInt();

        int diff = Math.abs(d - e);
        System.out.println("Absolute difference: " + diff);
//23
        System.out.print("Enter first number: ");
        int g = sc.nextInt();
        System.out.print("Enter second number: ");
        int h = sc.nextInt();

        if (g > h) {
            System.out.println("The first number is greater than the second number");
        } else if (g < h) {
            System.out.println("The first number is less than the second number");
        } else {
            System.out.println("Both are equal");
        }

//24   
         System.out.print("Enter first number: ");
        int x = sc.nextInt();
        System.out.print("Enter second number: ");
        int  y= sc.nextInt();
        System.out.print("Enter third number: ");
        int  z= sc.nextInt();

        int da = x % 10, db = y % 10, dc = z % 10;

        if (da == db || db == dc || da == dc) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

//25
        
        System.out.print("Enter first number: ");
        int qa = sc.nextInt();
        System.out.print("Enter second number: ");
        int qb = sc.nextInt();
        System.out.print("Enter third number: ");
        int qc = sc.nextInt();

        if (qa > (qb - qc) || qb > (qa - qc) || qc > (qa - qb)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
//26
        System.out.print("Enter selling price: ");
        double qsp = sc.nextDouble();
        System.out.print("Enter cost of product: ");
        double cost = sc.nextDouble();

        if (qsp > cost) {
            System.out.println("Profit: " + (qsp - cost));
        } else if (cost > qsp) {
            System.out.println("Loss: " + (cost - qsp));
        } else {
            System.out.println("No Profit No Loss");
        }
//27
        System.out.print("Enter first number: ");
        int zz = sc.nextInt();
        System.out.print("Enter second number: ");
        int nnn = sc.nextInt();
        System.out.print("Enter third number: ");
        int jj = sc.nextInt();

        if (zz < nnn && nnn < jj) {
            System.out.println("Increasing");
        } else if (zz > nnn && nnn > jj) {
            System.out.println("Decreasing");
        } else {
            System.out.println("Neither increasing nor decreasing order");
        }
//28
        System.out.print("Enter age: ");
        int cc = sc.nextInt();
        System.out.print("Enter weight (kg): ");
        double dd = sc.nextDouble();

        if (cc > 18 && dd >= 50) {
            System.out.println("Eligible to donate blood");
        } else {
            System.out.println("Not eligible to donate blood");
        }
//29
        
        System.out.print("Enter first number: ");
        int aa = sc.nextInt();
        System.out.print("Enter second number: ");
        int bb = sc.nextInt();

        if ((aa < 0 && bb < 0) || (aa > 0 && bb > 0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

//30
        System.out.print("Enter a character: ");
        char x3 = sc.next().charAt(0);

        if (x3 >= 'a' && x3 <= 'z') {
            System.out.println(x3 + " is lowercase");
        } else if (x3 >= 'A' && x3 <= 'Z') {
            System.out.println(x3 + " is uppercase");
        } else {
            System.out.println(x3 + " is not an alphabet");
        }
//31
        System.out.print("Enter a number: ");
        int xy = sc.nextInt();

        if (xy % 10 == 7 || xy % 7 == 0) {
            System.out.println(xy + " is a Buzz Number");
        } else {
            System.out.println(xy + " is not a Buzz Number");
        }

//32
        System.out.print("Enter number of classes held: ");
        int hh= sc.nextInt();
        System.out.print("Enter number of classes attended: ");
        int att = sc.nextInt();

        double per = (att * 100.0) / hh;
        System.out.println("Attendance: " + per + "%");

        if (per >= 70) {
            System.out.println("Eligible to sit for the PRF exam");
        } else {
            System.out.print("Attendance is below 70%. Do you have a medical cause? (Y/N): ");
            char med = sc.next().charAt(0);

            if (med == 'Y' || med == 'y') {
                System.out.println("Eligible to sit for the PRF exam (medical cause)");
            } else {
                System.out.println("Not eligible to sit for the PRF exam");
            }
        }

//33
        System.out.print("Enter salary: ");
        double sal= sc.nextDouble();
        System.out.print("Enter year of service: ");
        int yer = sc.nextInt();

        double br;
        if (yer < 5) {
            br = 0.10;
        } else if (yer < 10) {
            br = 0.15;
        } else {
            br = 0.25;
        }

        double bonus = sal * br;
        double total11 = sal + bonus;
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + total11);

//34
        

        System.out.print("Enter number of books: ");
        int numBooks = sc.nextInt();

        double ppb = 100.00;
        double subtotal = numBooks * ppb;
        double discount = 0.0;

        if (subtotal > 5000) {
            discount = subtotal * 0.10;
        }

        double q34total = subtotal - discount;

        System.out.printf("Subtotal : %.2f%n", subtotal);
        if (discount > 0) {
            System.out.printf("Discount : %.2f%n", discount);
        } else {
            System.out.println("Discount : -");
        }
        System.out.printf("TOTAL    : %.2f%n", q34total);

//35
        
        System.out.print("Enter temperature: ");
        int q35temp = sc.nextInt();

        if (q35temp >= 80) {
            System.out.println("Activity: Swimming");
        } else if (q35temp >= 60) {
            System.out.println("Activity: Tennis");
        } else if (q35temp >= 40) {
            System.out.println("Activity: Golf");
        } else {
            System.out.println("Activity: Skiing");

        }
//36
        System.out.print("Enter a letter: ");
        char ach = sc.next().charAt(0);

        if (ach == 'a' || ach == 'e' || ach == 'i' || ach == 'o' || ach == 'u' ||
            ach == 'A' || ach == 'E' || ach == 'I' || ach == 'O' || ach == 'U') {
            System.out.println(ach + " is a vowel");
        } else {
            System.out.println(ach + " is a consonant");
        }

//37
        System.out.print("Enter current annual salary: ");
        double sal1 = sc.nextDouble();
        System.out.print("Enter performance rating (1=excellent, 2=good, 3=poor): ");
        int rate = sc.nextInt();

        double rr;
        if (rate == 1) {
            rr = 0.06;
        } else if (rate == 2) {
            rr = 0.04;
        } else {
            rr = 0.015;
        }

        double raise = sal1 * rr;
        double newSalary = sal1 + raise;
        System.out.println("Raise: " + raise);
        System.out.println("New Salary: " + newSalary);

//38
        System.out.print("Enter attendance percentage: ");
        double atten = sc.nextDouble();
        System.out.print("Enter average marks: ");
        double avgM = sc.nextDouble();

        if (atten > 80 && avgM > 50) {
            System.out.println("Eligible to sit for the O/L examination");
        } else {
            System.out.println("Not eligible to sit for the O/L examination");
        }
//39
        System.out.print("Enter time (0-24): ");
        int time = sc.nextInt();

        if (time >= 0 && time < 12) {
            System.out.println("Good morning");
        } else if (time >= 12 && time < 16) {
            System.out.println("Good afternoon");
        } else if (time >= 16 && time < 19) {
            System.out.println("Good evening");
        } else if (time >= 19 && time <= 24) {
            System.out.println("Good night");
        } else {
            System.out.println("Invalid time");
        }
//40
        
        System.out.print("Enter year: ");
        int q40year = sc.nextInt();
        System.out.print("Enter month (as text, e.g. January): ");
        String q40month = sc.next();


        boolean q40isLeap = (q40year % 4 == 0 && q40year % 100 != 0) || (q40year % 400 == 0);

        int q40days;
        switch (q40month.toLowerCase()) {
            case "january":
            case "march":
            case "may":
            case "july":
            case "august":
            case "october":
            case "december":
                q40days = 31;
                break;
            case "april":
            case "june":
            case "september":
            case "november":
                q40days = 30;
                break;
            case "february":
                q40days = q40isLeap ? 29 : 28;
                break;
            default:
                q40days = -1;
        }

        if (q40days == -1) {
            System.out.println("Invalid month");
        } else {
            System.out.println(q40month + " " + q40year + " has " + q40days + " days");
        }
        System.out.println(q40year + " is " + (q40isLeap ? "a leap year" : "not a leap year"));

//41      
        System.out.println("\nQ41 - Print Shop Pricing");
        System.out.print("Enter number of copies: ");
        int copies = sc.nextInt();

        double ppc;
        if (copies <= 99) {
            ppc = 30.00;
        } else if (copies <= 499) {
            ppc = 28.00;
        } else if (copies <= 799) {
            ppc = 27.00;
        } else if (copies <= 1000) {
            ppc = 26.00;
        } else {
            ppc = 25.00;
        }

        double total111 = copies * ppc;
        System.out.printf("Price per copy: Rs.%.2f%n", ppc);
        System.out.printf("Total price: Rs.%.2f%n", total111);
//42
        
        System.out.print("Enter waist size in inches: ");
        int waist = sc.nextInt();

        if (waist >= 28 && waist <= 29) {
            System.out.println("Size: X-Small");
        } else if (waist >= 30 && waist <= 31) {
            System.out.println("Size: Small");
        } else if (waist >= 32 && waist <= 34) {
            System.out.println("Size: Medium");
        } else if (waist >= 36 && waist <= 38) {
            System.out.println("Size: Large");
        } else if (waist >= 40 && waist <= 42) {
            System.out.println("Size: X-Large");
        } else {
            System.out.println("No matching size");
        }

//43
        System.out.print("Enter the first number: ");
        double first = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double sec = sc.nextDouble();
        System.out.print("Enter the operator (+,-,*,/,%,^): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println(first + " + " + sec + " = " + (first + sec));
                break;
            case '-':
                System.out.println(first + " - " + sec + " = " + (first - sec));
                break;
            case '*':
                System.out.println(first + " * " + sec + " = " + (first * sec));
                break;
            case '/':
                if (sec != 0) {
                    System.out.println(first + " / " + sec + " = " + (first / sec));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            case '%':
                System.out.println(first + " % " + sec + " = " + (first % sec));
                break;
            case '^':
                System.out.println(first + " ^ " + sec + " = " + Math.pow(first, sec));
                break;
            default:
                System.out.println("Invalid operator");
        }

//44
        System.out.println("Q44 - Day of Week (Feb 2022)");
        System.out.print("Enter a day number (1-28): ");
        int day = sc.nextInt();

        
        int x5 = 2; 
        int ind = (day - 1 + x5) % 7;

        String dName;
        switch (ind) {
            case 0:
                dName = "Sunday";
                break;
            case 1:
                dName = "Monday";
                break;
            case 2:
                dName = "Tuesday";
                break;
            case 3:
                dName = "Wednesday";
                break;
            case 4:
                dName = "Thursday";
                break;
            case 5:
                dName = "Friday";
                break;
            case 6:
                dName = "Saturday";
                break;
            default:
                dName = "Invalid";
        }

        System.out.println("February " + day + ", 2022 is a " + dName);
       
//45
        System.out.print("Enter row number (1-8): ");
        int row = sc.nextInt();
        System.out.print("Enter column number (1-8): ");
        int col = sc.nextInt();

        if ((row % 2 == 0 && col % 2 == 0) || (row % 2 != 0 && col % 2 != 0)) {
            System.out.println("White");
        } else {
            System.out.println("Black");

        }

//46
        System.out.print("Enter first integer: ");
        int a1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b2 = sc.nextInt();
        System.out.print("Enter third integer: ");
        int c3 = sc.nextInt();

        if ((a1 * a1 + b2 * b2 == c3 * c3) ||
            (a1 * a1 + c3 * c3 == b2 * b2) ||
            (b2 * b2 + c3 * c3 == a1 * a1)) {
            System.out.println("These numbers form a Pythagorean triple");
        } else {
            System.out.println("These numbers do NOT form a Pythagorean triple");
        }
//47
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter day: ");
        int q47day = sc.nextInt();

        String season;
        if ((month == 12 && q47day >= 21) || month == 1 || month == 2 || (month == 3 && q47day < 20)) {
            season = "Winter";
        } else if ((month == 3 && q47day >= 20) || month == 4 || month == 5 || (month == 6 && q47day < 21)) {
            season = "Spring";
        } else if ((month == 6 && q47day >= 21) || month == 7 || month == 8 || (month == 9 && q47day < 22)) {
            season = "Summer";
        } else if ((month == 9 && q47day >= 22) || month == 10 || month == 11 || (month == 12 && q47day < 21)) {
            season = "Autumn";
        } else {
            season = "Invalid date";
        }

        System.out.println("Season: " + season);
//48
        System.out.print("Enter month (1-12): ");
        int month1 = sc.nextInt();
        System.out.print("Enter day: ");
        int dayyy = sc.nextInt();

        String sign;
        if ((month1 == 12 && dayyy >= 22) || (month1 == 1 && dayyy <= 19)) {
            sign = "Capricornus";
        } else if ((month1 == 1 && dayyy >= 20) || (month1 == 2 && dayyy <= 18)) {
            sign = "Aquarius";
        } else if ((month1 == 2 && dayyy >= 19) || (month1 == 3 && dayyy <= 20)) {
            sign = "Pisces";
        } else if ((month1 == 3 && dayyy >= 21) || (month1 == 4 && dayyy <= 19)) {
            sign = "Aries";
        } else if ((month1 == 4 && dayyy >= 20) || (month1 == 5 && dayyy <= 20)) {
            sign = "Taurus";
        } else if ((month1 == 5 && dayyy >= 21) || (month1 == 6 && dayyy <= 21)) {
            sign = "Gemini";
        } else if ((month1 == 6 && dayyy >= 22) || (month1 == 7 && dayyy <= 22)) {
            sign = "Cancer";
        } else if ((month1 == 7 && dayyy >= 23) || (month1 == 8 && dayyy <= 22)) {
            sign = "Leo";
        } else if ((month1 == 8 && dayyy >= 23) || (month1 == 9 && dayyy <= 22)) {
            sign = "Virgo";
        } else if ((month1 == 9 && dayyy >= 23) || (month1 == 10 && dayyy <= 23)) {
            sign = "Libra";
        } else if ((month1 == 10 && dayyy >= 24) || (month1 == 11 && dayyy <= 21)) {
            sign = "Scorpius";
        } else if ((month1 == 11 && dayyy >= 22) || (month1 == 12 && dayyy <= 21)) {
            sign = "Sagittarius";
        } else {
            sign = "Invalid date";
        }

        System.out.println("Astrological Sign: " + sign);

//49
        System.out.print("Enter basic salary: ");
        double basic = sc.nextDouble();

        double ha, ta;
        if (basic <= 10000) {
            ha = 0.20;
            ta = 0.60;
        } else if (basic <= 20000) {
            ha = 0.25;
            ta = 0.70;
        } else {
            ha = 0.30;
            ta = 0.75;
        }

        double q49gross = basic + (basic * ha) + (basic * ta);
        System.out.println("Gross Salary: " + q49gross);

//50
        System.out.print("Enter angle a: ");
        double a4 = sc.nextDouble();
        System.out.print("Enter angle b: ");
        double b5 = sc.nextDouble();
        System.out.print("Enter angle c: ");
        double c5 = sc.nextDouble();

        if (a4 > 0 && b5 > 0 && c5 > 0 && (a4 + b5 + c5 == 180)) {
            System.out.println("A valid triangle can be formed");
        } else {
            System.out.println("A valid triangle CANNOT be formed");
        }

//51
        System.out.println("Q51 - Age Classification");
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (age > 65) {
            System.out.println("Senior");
        } else if (age > 20) {
            System.out.println("Adult");
        } else if (age > 13) {
            System.out.println("Teenager");
        } else if (age > 1) {
            System.out.println("Child");
        } else {
            System.out.println("Infant");
        }
//52
        System.out.print("Enter X coordinate: ");
        double xx = sc.nextDouble();
        System.out.print("Enter Y coordinate: ");
        double yy = sc.nextDouble();

        if (xx == 0 && yy == 0) {
            System.out.println("Origin");
        } else if (xx > 0 && yy > 0) {
            System.out.println("Quadrant I");
        } else if (xx < 0 && yy > 0) {
            System.out.println("Quadrant II");
        } else if (xx < 0 && yy < 0) {
            System.out.println("Quadrant III");
        } else if (xx > 0 && yy < 0) {
            System.out.println("Quadrant IV");
        } else {
            System.out.println("On an axis");
        }

//53
        System.out.print("Enter systolic (SBP): ");
        int sbp = sc.nextInt();
        System.out.print("Enter diastolic (DBP): ");
        int dbp = sc.nextInt();

        if (sbp >= 130 && dbp >= 90) {
            System.out.println("High Pressure");
        } else if (sbp <= 100 && dbp <= 70) {
            System.out.println("Low Pressure");
        } else if (sbp >= 100 && dbp <= 130 && dbp >= 70 && dbp <= 90) {
            System.out.println("Normal");
        } else {
            System.out.println("Undetermined");
        }
//54
        
        System.out.print("Enter a URL: ");
        String url = sc.next();

        if (url.endsWith(".com")) {
            System.out.println("Commercial website");
        } else if (url.endsWith(".org")) {
            System.out.println("Organization website");
        } else if (url.endsWith(".lk")) {
            System.out.println("Sri Lankan website");
        } else {
            System.out.println("Unknown website type");
        }
//55
        System.out.print("Enter the number: ");
        int num4 = sc.nextInt();
        System.out.print("Enter upper bound: ");
        int upper = sc.nextInt();
        System.out.print("Enter lower bound: ");
        int q55lower = sc.nextInt();

        if (num4 >= q55lower && num4 <= upper) {
            System.out.println(num4+ " is within the range");
        } else {
            System.out.println(num4 + " is NOT within the range");
        }
//56
        System.out.print("Enter a: ");
        int qaa = sc.nextInt();
        System.out.print("Enter b: ");
        int qbb = sc.nextInt();

        boolean item = (qaa >= 10) && (qbb < 50);
        System.out.println("item = " + item);

//57
        System.out.print("Enter first date month: ");
        int m1 = sc.nextInt();
        System.out.print("Enter first date day: ");
        int d1 = sc.nextInt();
        System.out.print("Enter first date year: ");
        int y1 = sc.nextInt();

        System.out.print("Enter second date month: ");
        int m2 = sc.nextInt();
        System.out.print("Enter second date day: ");
        int d2 = sc.nextInt();
        System.out.print("Enter second date year: ");
        int y2 = sc.nextInt();

        if (y1 != y2) {
            System.out.println(y1 < y2 ? "First date comes first" : "Second date comes first");
        } else if (m1 != m2) {
            System.out.println(m1 < m2 ? "First date comes first" : "Second date comes first");
        } else if (d1 != d2) {
            System.out.println(d1 < d2 ? "First date comes first" : "Second date comes first");
        } else {
            System.out.println("Both dates are the same");
        }
//58
        System.out.print("Enter year: ");
        int yyy = sc.nextInt();
        System.out.print("Enter month: ");
        int m = sc.nextInt();
        System.out.print("Enter day: ");
        int ddd = sc.nextInt();

        int yo = yyy - ((14 - m) / 12);
        int xxx = yyy + (yyy / 4) - (yyy / 100) + (yyy / 400);
        int mn = m + 12 * ((14 - m) / 12) - 2;
        int q58do = (ddd + xxx + (31 * m) / 12) % 7;

        String ddName;
        switch (q58do) {
            case 0:
                ddName = "Sunday";
                break;
            case 1:
                ddName = "Monday";
                break;
            case 2:
                ddName = "Tuesday";
                break;
            case 3:
                ddName = "Wednesday";
                break;
            case 4:
                ddName = "Thursday";
                break;
            case 5:
                ddName = "Friday";
                break;
            case 6:
                ddName = "Saturday";
                break;
            default:
                ddName = "Invalid";
        }

        System.out.println("Day of the week: " + ddName);

//59
        System.out.print("Enter R (0-255): ");
        int qr = sc.nextInt();
        System.out.print("Enter G (0-255): ");
        int qg = sc.nextInt();
        System.out.print("Enter B (0-255): ");
        int qbbb = sc.nextInt();

        double qqc, qm, qy, qk;

        if (qr == 0 && qg == 0 && qbbb == 0) {
            qqc = 0;
            qm = 0;
            qy = 0;
            qk = 1;
        } else {
            double qw = Math.max(qr / 255.0, Math.max(qg / 255.0, qbbb / 255.0));
            qqc = (qw - (qr / 255.0)) / qw;
            qm = (qw - (qg / 255.0)) / qw;
            qy = (qw - (qbbb / 255.0)) / qw;
            qk = 1 - qw;
        }

        System.out.println("C = " + qqc);
        System.out.println("M = " + qm);
        System.out.println("Y = " + qy);
        System.out.println("K = " + qk);

//60
        System.out.print("Enter parcel weight (kg): ");
        double weight = sc.nextDouble();

        double charge;
        if (weight <= 5) {
            charge = 500;
        } else {
            double extraKg = weight - 5;
            charge = 500 + (extraKg * 100);
        }

        System.out.println("Courier charge: Rs." + charge);







        
/*8
 Which of the following lines can be legally inserted at line 10?
class Example{
public static void main(String[] args) {
int x = 10;
//Insert code here//Line 10
}
}

Answers:
C. if(x==10){}
E. if((x=100)!=10){}
F. if((x=100)>0==true){}


9.
class Example{
public static void main(String[] args) {
int x = 10;
boolean b=true;
//Insert code here//Line 10
}
}
Answer:all


11. Write the outputs for the following code lines.
boolean b=true;
A. System.out.println(b);
B. System.out.println(b=true);
C. System.out.println(b==true);
D. System.out.println(b!=true);
E. System.out.println(b=true==true);
F. System.out.println((b=true)==false);
G. System.out.println(b=(true!=false));

Answer:a - true
b - true
c - true
d - false
e - true
f - false
g - true



12. Write the outputs for the following code lines.
int x = 10;
A. System.out.println(x=9);
B. System.out.println(x==9);
C. System.out.println(x=9!=10);
D. System.out.println((x=9)==10);
E. System.out.println((x=9)<=10);
Answer:a - 9
b - false
c - Compile error
d - false
e - true


13. What are the outputs of the following commands?
int x=20,y=60;
boolean bool;
System.out.println(x=10); //Line 1
System.out.println(bool=true); //Line 2
System.out.println(x=10>0); //Line 3
System.out.println((x=10)>0); //Line 4
System.out.println(bool=(x=10)>0); //Line 5
System.out.println(bool=x+y>100); //Line 6

Answer:
Line 1 = 10
Line 2 = true
Line 3 = Compile Error (
Line 4 = true
Line 5 = true
Line 6 = false





14. What are the outputs of the following commands?
byte b = 10;
short s = 100;
int x = 125;
long l = 15000;
float f = 1.5f;
double d = 21.231;
char c = 'c';
boolean bool = 10>9;
System.out.println(b+s+x+""+f+d+c+bool); //Line 1
System.out.println(""+b+s+x+f+d+c+bool); //Line 2
System.out.println(b+s+x+f+d+c+""+bool); //Line 3
System.out.println(b+s+x+f+d+c+bool+""); //Line 4
System.out.println(bool+b+f+d+c+""+x+l); //Line 5

Answer:
Line 1 = 2351.521.231ctrue
Line 2 = 101001251.521.231ctrue
Line 3 = 356.731true
Line 4 = Compile Error 
Line 5 = Compile Error 






15. Assume that i = 1, j = 2, k = 3 and m = 2. What does each of the following
statements print?
System.out.println( i ==1); //Line 1
System.out.println( j ==3); //Line 2
System.out.println( ( i >=1) && ( j <4) ); //Line 3
System.out.println( ( m <=99) & ( k < m ) ); //Line 4
System.out.println( ( j >= i ) || ( k == m ) ); //Line 5
System.out.println( ( k + m < j )|(3- j>= k)); //Line 6
System.out.println( !( k > m ) ); //Line 7

Answer:
Line 1 = true
Line 2 = false
Line 3 = true
Line 4 = false
Line 5 = true
Line 6 = false
Line 7 = false




16. Given:
class Example{
public static void main(String args[]){
//line 5
switch(x){
default: System.out.print("4 ");
case 1 : System.out.print("1 ");
case 2 : System.out.print("2 ");
case 3 : System.out.print("3 ");
}
}
}

What will be the outputs when you insert the following codes at line 5?
A. int x=1; B. int x=2; C. int x=3;
D. int x=4; E. int x=0; F. int x=5;

Answer :
A. x=1 → 1 2 3 
B. x=2 → 2 3 
C. x=3 → 3 
D. x=4 → 4 1 2 3 
E. x=0 → 4 1 2 3 
F. x=5 → 4 1 2 3


Answer:
A. x=1 → 1 2 3 
B. x=2 → 2 3 
C. x=3 → 3 
D. x=4 → 4 1 2 3 
E. x=0 → 4 1 2 3 
F. x=5 → 4 1 2 3




17. Given Code:
class Example{
public static void main(String args[]){
int a=-5;
int b=-2;
a%=b;
a/=b;
b=a>0?0:a;
System.out.println(a+" "+b);
}
}

Answer:
Answer D


class Example{
public static void main(String args[]){
int x=100;
System.out.println(x); //Line 1
{
int y=200;
{
int z=300;
System.out.println(x); //Line 2
System.out.println(y); //Line 3
System.out.println(z); //Line 4
}
System.out.println(x); //Line 5
System.out.println(y); //Line 6
System.out.println(z); //Line 7
}
System.out.println(x); //Line 8
System.out.println(y); //Line 9
System.out.println(z); //Line 10
}
}


Answer:
Line 1 (x) → Legal
Line 2 (x) → Legal
Line 3 (y) → Legal
Line 4 (z) → Legal
Line 5 (x) → Legal
Line 6 (y) → Legal
Line 7 (z) → Illegal 
Line 8 (x) → Legal
Line 9 (y) → Illegal 
Line 10 (z) → Illegal


class Example{
public static void main(String args[]){
//Line 5
switch(x){
default : System.out.print("Wrong ");break;
case 2 : System.out.print("2 ");
case 3 : System.out.print("3 ");
case 1 : System.out.print("1 ");break;
}
}
}


Answer:
A. matches case 1 directly → 1 
B. case 2 →  case 3 →  case 1 break→ 2 3 1 
C. case 3 →  case 1 → break  → 3 1 
D. no match → default → Wrong 
E.  no match → default → Wrong 
F. no match → default → Wrong 

22. Given:
//Insert code here //line 4
switch(x){
case 'A' : System.out.println("65 ");break;
case 'B' : System.out.println("66 ");break;
case 'C' : System.out.println("67 ");break;
default : System.out.println("wrong ");
}

Answer:
Legal: A, B, C, D, E
Illegal: F, G, H




*/





        
        sc.close();
    }
}
    
    

