import java.util.Scanner;
import java.util.*;

public class PRFAssignment2 {
    Scanner input = new Scanner(System.in);
    /* ================================================================
       SECTION 1: THEORY QUESTIONS & ANSWERS  (COMMENTED SECTION ONLY)
       ================================================================ */

    // 05. What are the output of following program?
    /*
    1. class Example{
            public static void main(String args[]){
            System.out.println("Institute of Computer Engineering Technology");
            System.out.println("223 A,");
            System.out.println("Galle Road,");
            System.out.println("Panadura.");
         }
    }

    Answer: Institute of Computer Engineering Technology
            223 A,
            Galle Road,
            Panadura.


    2.class Example{
        public static void main(String args[]){
        System.out.println("Institute of Computer Engineering Technology");
        System.out.print("223 A,");
        System.out.print("Galle Road,");
        System.out.print("Panadura.");
        }
    }        
    Answer: Institute of Computer Engineering Technology
            223 A,Galle Road,Panadura.
    


    6.What is the difference between print() and println()? Explain your answer
    with suitable examples.
    print()- when use print () cursor will not got the next line and the it will print the next output in the same line
}       println()-when use println() just after the executing the print statement cursor will go to the next line
    eg - System.out.print("223 A,");
         System.out.println("Galle Road,");


    7.What is the different between letter a of line 1 and line 2?
        class Example {
            public static void main(String args[]){
            System.out.println("a"); //line 1
            System.out.println('a'); //line 2
        }
    }
    Answer: line 1 is a string and 
            line 2 is a character and  only remain a single character.   

            
    8. What is the different between 7 of lines 1 , 2 , 3 and 4 ?
        lass Example {
            public static void main(String args[]){
            System.out.println(7); //line 1
            System.out.println(7.0); //line 2
            System.out.println("7"); //line 3
            System.out.println('7'); //line 4
        }
    }
    Answer: line 1 is an integer
            line 2 is a double
            line 3 is a string
            line 4 is a character 


    9.What are the type of java literals? Explain with a suitable example.
    Answer: There are 4 types of java literals
            1. Integer literals - 10, 20, 30
            2. Floating point literals - 10.5, 20.5, 30.5
            3. Character literals - 'a', 'b', 'c'
            4. String literals - "Hello", "World", "Java"
            5.Boolean Literals - true, false
            6. Null Literals - null


    10. What will be the output when you compile and run the following program? Explain your answer.
        class Example {
            public static void main(String args[]){
                System.out.println(1100100); //line 1
                System.out.println(0B1100100); //line 2
                System.out.println(01100100); //line 3
                System.out.println(0x1100100); //line 4
        }
    }
    Answer: line 1 - 1100100 is a decimal number
            line 2 - 0B1100100 is a binary number
            line 3 - 01100100 is an octal number
            line 4 - 0x1100100 is a hexadecimal number

    11.Which of the following lines are valid statements? Explain your answers.
            class Example{
                public static void main(String args[]){
                    System.out.println(0B11100100); //Line 1
                    System.out.println(0b11100100); //Line 2
                    System.out.println(0B11100200); //Line 3
                    System.out.println(0144); //Line 4
                    System.out.println(0148); //Line 5
                    System.out.println(0x64); //Line 6
                    System.out.println(0xabc); //Line 7
                    System.out.println(0xabcg); //Line 8
                    System.out.println(0X); //Line 9
                    System.out.println(0Xfffffff); //Line 10
             }
        }

         Answer: Line 1 - valid
            Line 2 - valid
            Line 3 - invalid (2 is not a valid binary digit)
            Line 4 - valid
            Line 5 - invalid (8 is not a valid octal digit)
            Line 6 - valid
            Line 7 - valid
            Line 8 - invalid (g is not a valid hexadecimal digit)
            Line 9 - invalid (0X is not a valid hexadecimal number)
            Line 10 - valid


    12. What is the result of attempting to compile and run the program?
            class Example{
                public static void main(String args[]){
                    System.out.print("A\nB");
                    System.out.println("CD");
                    System.out.print("\nEF\n");
                    System.out.print("G\nH")
            }
        }             
        Answer :Program will not compile because of the missing: in the last line.
    */

    /* 

                14. What is the output of following program.
                    class Example {
                        public static void main(String args[]){
                            System.out.println("Hello\nJAVA");
                            System.out.println("Hello\tJAVA");
                            System.out.println("Hello\bJAVA");
                            System.out.println("\\Hello JAVA\\");
                            System.out.println("\"Hello\nJAVA\"");
                            System.out.println("\'Hello\nJAVA\'");
                }
            }   
                
            Answer: Hello
                    JAVA
                    Hello    JAVA
                    HelloJAVA
                    \Hello JAVA\
                    "Hello
                    JAVA"
                    'Hello
                    JAVA'

                What are the Escape Sequences used in above program? Explain about them with suitable example.

            Answer :They are used to represent special characters in a string. 
                    \n - new line
                    \t - tab
                    \b - backspace  
     */

    /* 18. 
                    Explain line 1 , 2 and 3 in following program.
                        class Example{
                            public static void main(String[] args){
                                int i; //line 1
                                i=103; //line 2
                            System.out.println(i); //line 3
                        }
                    }       
                Answer: line 1 - declare a variable i of type int
                        line 2 - assign the value 103 to the variable i
                        line 3 - print the value of variable i to the console
            


             
            */

    /*
            20. What is the result of attempting to compile and run the program?
                class Example{
                    public static void main(String args[]){
                        int x;
                        System.out.println(x);
                    }
            }
            Answer: Compile time error

            21.What is the result of attempting to compile and run the program?
                class Example{
                    public static void main(String args[]){
                        int x=10,y=20,z=30;
                        System.out.println(x);
                        System.out.println(y);
                        System.out.println(z);
                        int y=200;
                        System.out.println(y);
                    }
            }

            Answer: Compile time error
                    Because variable y is already declared in the same scope

            22. What will be the output when you compile and run the following program? Explain your answer.
                    class Example {
                            public static void main(String args[]){
                            int x,y;
                            x=100;
                            y=200;
                            System.out.println(x);
                            System.out.println(y);
                            y=300;
                            System.out.println(x);
                            System.out.println(y);
                        }
            }        

            Answer: 100
                    200
                    100
                    300

            23. Which of the following can be legally inserted at line 12? Explain your answer.

                    class Example {
                        public static void main(String args[]) {
                            int x;
                            // Line 12
                            System.out.println(x);
                        }
                    }
            Answer:           
                    A. x+1;
                    B. x=100;
                    C. int y=100;
                    D. int x=200;
                    E. Insert nothing.


            24. What is the result of attempting to compile and run the program?

                    class Example {
                        public static void main(String args[]) {
                            int x, y, z;        // line 1
                            x = y = z = 10;     // line 2
                            int a = 12, b, c = 4;  // line 3
                            int p = 10;         // line 4
                            int q = p;          // line 5
                            int i = j = k = 10; // line 6
                        }
                    }
            Answer: 
                    A. Compile error at line 2
                    B. Compile error at line 3
                    C. Compile error at line 5
                    D. Compile error at line 6
                    E. None of the above


            25. What are the output of following program and explain your answer.

                    class Example {
                        public static void main(String args[]) {
                            System.out.println("10" + "20"); // line 1
                            System.out.println(10 + 20);     // line 2
                        }
                    }

            Answer:Line 1: "10" and "20" are Strings, so + means concatenation → "1020"
                   Line 2: 10 and 20 are ints, so + means addition → 30
             
             

            26. What will be the output when you compile and run the following program?

                    class Example {
                        public static void main(String args[]) {
                            System.out.println(10 + 20 + 30);
                            System.out.println("10+20+30");
                            System.out.println("10+20" + 30);
                            System.out.println("10" + "20" + "30");
                            System.out.println("10" + 20 + 30);
                            System.out.println(10 + 20 + "30");
                            System.out.println(10 + "20" + 30);
                        }
                    }
            Answer: 60
                    10+20+30
                    10+2030
                    102030
                    102030
                    3030
                    102030



            27. What is the output for the following code fragments and explain your answer?

                    A. System.out.println(1 + 2 + 3);
                    B. System.out.println("1" + "2" + "3");
                    C. System.out.println('1' + '2' + '3');
                    D. System.out.println('1' + " " + '2' + " " + '3');
                    E. System.out.println('A' + 'B' + 'C');
                    F. System.out.println("A" + "B" + "C");
                    G. System.out.println('A' + 100 + 200);
                    H. System.out.println('A' + " " + 'B' + " " + 'C');

            Answer:A. 6          (all ints → arithmetic: 1+2+3 = 6)

                   B. 123        (all Strings → concatenation: "1"+"2"+"3")

                   C. 150        (all chars → chars first convert to ASCII values:
                                  '1'=49, '2'=50, '3'=51 → 49+50+51 = 150)

                   D. 1 2 3      (char + " " triggers string mode, so chars print as
                                  characters, not numbers: '1'+" " = "1 ", then +'2' = "1 2", etc.)

                   E. 198        ('A'=65, 'B'=66, 'C'=67 → 65+66+67 = 198)

                   F. ABC        (all Strings → concatenation)

                   G. 365        ('A' + 100 → numeric: 65+100=165, then +200 → 365,
                                  since no String is involved anywhere)

                   H. A B C      (same as D — once " " (a String) appears, everything
                                  switches to concatenating as text, so chars print as
                                  letters)



            28. What is the difference between the Question 20 program and the following program?


                    class Example {
                        public static void main(String[] args) {
                            int i;
                            i = input.nextInt();
                            System.out.println(i);
                        }
                    }

            Answer: In the Question 20 program, the variable 'x' is declared but not initialized before it is used in the System.out.println() statement, which leads to a compile-time error. In the second program, the variable 'i' is assigned a value from user input using Scanner's nextInt() method before it is printed, so it will compile and run successfully, displaying the user-provided integer value.

        
           


            */

    /* 33
            Data Type       Size                                 Description  
            
            byte           1 byte                                 -128 to 127

            short          2 bytes                               -32 768 to 32 767

            int            4 bytes                                -2147483648 to 2147483647

            long            8 bytes                                -9223372036854775808 to 9223372036854775807

            float           4 bytes                                ±3.4 x 10^38 (single precision, ~7 decimal digits)

            double           8 bytes                                  ±1.8 x 10^308 (double precision, ~15 decimal digits)

            boolean          1 bit(JVM dependent,                     true or false
                            often 1 byte in practice)

            char              2bytes                                   0 to 65 535 (single 16-bit Unicode character)  
            
            

        34.   Not valid: @name, new, user-input, My Variable, 123num, java.org
              valid: $percent, _piece, Boolean, main, Customer, getFirstName, longVariable, myVariable, user_input, MyClass


        35. class Example{
                    public static void main(String[] args) {
                        System.out.println("iCET"); //line 1
                        String s="connect intelligents…";
                        System.out.println(s); //line 2
                }
            }                       
        
        
        line1: System.out.println("iCET"); prints a string literal
        line2: System.out.println(s); prints the value of a variable   
        
        36.

            public class Greeting {
                public static void main(String[] args) {
                 Scanner input = new Scanner(System.in);

                 System.out.print("Enter your name: ");
                 String name = input.nextLine();

                 System.out.println("Hello " + name + ", nice to meet you!");

                input.close();
            }
        }   






*/

    /*-----------Do not modify before this line--------
    int temp = num1;
    num1 = num2;
    num2 = temp
    */

    /* ================================================================
       SECTION 2: EXECUTABLE CODE  (NOT COMMENTED)
       ================================================================ */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter your Address: ");
        String address = input.nextLine();
        System.out.println("Enter your Phone number: ");
        String phone = input.nextLine();
        System.out.println("Enter your email: ");
        String email = input.nextLine();

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println();
        System.out.println("Output:");

        int rows = 7;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("                 " + "229");
        System.out.println("+                " + "800");
        System.out.println("---------------------");
        System.out.println("                " + "1029");
        System.out.println("=====================");

        System.out.println("\n\n\n");

        System.out.println("* * * * * * ================================================================");
        System.out.println(" * * * * *  ================================================================");
        System.out.println("* * * * * * ================================================================");
        System.out.println(" * * * * *  ================================================================");
        System.out.println("* * * * * * ================================================================");
        System.out.println(" * * * * *  ================================================================");
        System.out.println("* * * * * * ================================================================");
        System.out.println(" * * * * *  ================================================================");
        System.out.println("* * * * * * ================================================================");
        System.out.println(" * * * * *  ================================================================");
        System.out.println("============================================================================");
        System.out.println("============================================================================");
        System.out.println("============================================================================");
        System.out.println("============================================================================");
        System.out.println("============================================================================");
        System.out.println("============================================================================");
        System.out.println("============================================================================\n\n\n");

        System.out.println("ICM - iCET CERTIFIED MASTER\n");
        System.out.println("iCM\n");
        System.out.println("iCET");
        System.out.println("CERTIFIED");
        System.out.println("MASTER");
        System.out.println("iCM\n\n");
        System.out.println("iCET\tCERTIFIED\tMASTER");

        //15.
        System.out.println("JAVA is a typed language");
        System.out.println("AB\"CB");
        System.out.println("AB\\CD");
        System.out.println("C:\\Wondows\\Program");
        System.out.println("AB \\\"CD");
        System.out.println("AB \\\\\"\"CD");
        System.out.println("AB\\nCD");
        System.out.println("AB\\tCD");
        System.out.println("AB\\bCD");

        System.out.println("\n\n\n\n\n\n");

        //16. 
        System.out.println("  _  ______  ______ _________ ");
        System.out.println(" (_)/ _____|  ______|___   __|");
        System.out.println("  _|  |    |  |__       | |   ");
        System.out.println(" | |  |    |   __|      | |   ");
        System.out.println(" | |  |____|  |____     | |   ");
        System.out.println(" |_|\\______|_______|    |_|");
        System.out.println("\n\n\n\n\n\n");

        //17.
        System.out.println("           +\"\"\"\"\"+");
        System.out.println("         [ | o o | ]");
        System.out.println("           |  ^  |");
        System.out.println("           | '_' |");
        System.out.println("           +'''''+");
        System.out.println("          ||||||||||");
        System.out.println("      /\\/\\||||||||||||/\\/\\");
        System.out.println("        ||||||||||||||");
        System.out.println("       |||||||||||||||||");
        System.out.println("        |||||||||||||||");
        System.out.println("         |||||||||||||");
        System.out.println("           ||||||||||");
        System.out.println("            /\\    /\\");

        System.out.println("\n\n\n\n\n\n");

        
       

        System.out.println("\n\n\n\n\n\n");

    //30.
        System.out.print("Input number: ");
        int n = input.nextInt();
        System.out.println("" + n + n + n);
        System.out.println(n + n + n);

        System.out.print("Enter Combined Maths marks: ");
        int cm = input.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chem = input.nextInt();
        System.out.print("Enter Physics marks: ");
        int phy = input.nextInt();
        System.out.print("Enter English marks: ");
        int eng = input.nextInt();
        int total = cm + chem + phy + eng;
        System.out.println("Combined Maths - " + cm);
        System.out.println("Chemistry - " + chem);
        System.out.println("Physics - " + phy);
        System.out.println("English - " + eng);
        System.out.println("Total - " + total);

        System.out.print("Enter Red value : ");
        int r = input.nextInt();
        System.out.print("Enter Green value : ");
        int g = input.nextInt();
        System.out.print("Enter Blue value : ");
        int bl = input.nextInt();   // renamed from 'b' to avoid clash
        int invR = 255 - r;
        int invG = 255 - g;
        int invB = 255 - bl;
        System.out.println("Inversion of given color - [" + invR + ", " + invG + ", " + invB + "]");

        //37.

        int xx = 10;
        int yy = 5;
        String z = xx + 'y' + "y" + xx + yy + 'z';
        System.out.println("z is: " + z);

        ///38.,39.
        input.nextLine();   // Clear the Enter key left by nextInt()

        // Subject 1
        System.out.print("Subject 1 name: ");
        String sub1 = input.nextLine();
        System.out.print(sub1 + " marks: ");
        int mark1 = input.nextInt();
        input.nextLine();

        // Subject 2
        System.out.print("Subject 2 name: ");
        String sub2 = input.nextLine();
        System.out.print(sub2 + " marks: ");
        int mark2 = input.nextInt();
        input.nextLine();

        // Subject 3
        System.out.print("Subject 3 name: ");
        String sub3 = input.nextLine();
        System.out.print(sub3 + " marks: ");
        int mark3 = input.nextInt();

        // Calculate total
        int tot = mark1 + mark2 + mark3;

        // Display results
        System.out.println();
        System.out.println(sub1 + "\t\t" + mark1);
        System.out.println(sub2 + "\t\t" + mark2);
        System.out.println(sub3 + "\t\t" + mark3);
        System.out.println("----------------------");
        System.out.println("Total\t\t" + tot);

        System.out.print("Input number 1 : ");
        int num1=input.nextInt();
        System.out.print("Input number 2 : ");
        int num2=input.nextInt();
        System.out.println(num1+" "+num2);
        //-----------Do not modify before this line--------
        //Insert java code(s) here to swap the two
        //variables "num1" and "num2"
        //as an example when you input 10 for
        //num1 and 20 for num2, then
        //the first output should be "10 20" and the
        //second output "20 10"
        int temp = num1;
        num1 = num2;
        num2 = temp;
        //-------Do not modify after this line---------------
        System.out.println(num1 + " " + num2);

        System.out.println(num1 + " " + num2);
        System.out.println(num1+" "+num2);

    

        //19.
            int x; int y;
            x = 102;
            y = 103;
            System.out.print(x + " " + y);          

       
       //29..
            Scanner sc = new Scanner(System.in);   // create Scanner in this scope

            System.out.print("Enter 1st input: ");
            int num11 = sc.nextInt();   // ← this

            System.out.print("Enter 2nd input: ");
            int num22 = sc.nextInt();

            System.out.println("1st input " + num11);
            System.out.println("2nd input " + num22);

           int sum = num11 + num22;
           System.out.println(num11 + " + " + num22 + " = " + sum);

        sc.close();  
     input.close();   



    }
}