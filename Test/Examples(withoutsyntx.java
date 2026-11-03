class Example1 {
    public static void main(String args[]) {
        System.out.println("Institution of Computer Engineering Technology");
    }
}

class Example2 {
    public static void main(String args[]) {
        System.out.println("Institution of Computer Engineering Technology");
        System.out.println("223 A,");
        System.out.println("Galle Road,");
        System.out.println("Panadura");
    }
}

class Example3 {
    public static void main(String args[]) {
        System.out.print("J");
        System.out.print("A");
        System.out.print("v");
        System.out.print("A");
    }
}

class Example4 {
    public static void main(String args[]) {
        System.out.println("1");
        System.out.println("1000");
        System.out.println("1.23");
    }
}

class Example5 {
    public static void main(String args[]) {
        System.out.println("Hello");
        System.out.println("A");
        System.out.println(1234);
        System.out.println(-1234);
        System.out.println(1.2334);
        System.out.println(0.0032);
        System.out.println(-0.0023);
        System.out.println('A');
        System.out.println('6');
        System.out.println(true);
        System.out.println(false);
    }
}

class Example6 {
    public static void main(String args[]) {
        System.out.print("A");
        System.out.print("B");
        System.out.print("C");
        System.out.print("D");
    }
}

class Example7 {
    public static void main(String args[]) {
        System.out.println("1");
        System.out.print("2 ");
        System.out.println("3 ");
        System.out.print("4 ");
        System.out.print("5 ");
        System.out.println("6 ");
        System.out.print("7 ");
        System.out.print("8 ");
        System.out.print("9 ");
        System.out.println("10 ");
    }
}

class Example8 {
    public static void main(String args[]) {
        System.out.print("1");
        System.out.println();
        System.out.print("2 ");
        System.out.print("3 ");
        System.out.println();
        System.out.print("4 ");
        System.out.print("5 ");
        System.out.print("6 ");
        System.out.println();
        System.out.print("7 ");
        System.out.print("8 ");
        System.out.print("9 ");
        System.out.print("10 ");
    }
}

class Example9 {
    public static void main(String args[]) {
        System.out.println("A");
        System.out.println("B");
        System.out.println();
        System.out.println("C");
        System.out.println("D");
        System.out.print(" ");
    }
}

class Example10 {
    public static void main(String args[]) {
        System.out.println("A");
        System.out.println("B");
        System.out.print();
        System.out.println("C");
        System.out.println("D");
    }
}

class Example11 {
    public static void main(String args[]) {
        int a;
        a = 100;
        System.out.println("a");
        System.out.println(a);
    }
}

class Example12 {
    public static void main(String args[]) {
        int a;
        System.out.println("a");
        System.out.println(a); // ERROR: variable 'a' not initialized
    }
}

class Example13 {
    public static void main(String args[]) {
        int a = 100;
        System.out.println(a);
    }
}

class Example14 {
    public static void main(String args[]) {
        int a;
        System.out.println(a); // ERROR: variable 'a' used before assignment
        a = 100;
    }
}

class Example15 {
    public static void main(String args[]) {
        int x;
        x = 100;
        x = 200;
        System.out.println(x);
    }
}

class Example16 {
    public static void main(String args[]) {
        int x;
        x = 100;
        System.out.println(x);
        x = 200;
        System.out.println(x);
    }
}

class Example17 {
    public static void main(String args[]) {
        int x = 100;
        int y = 200;
        System.out.println(x);
        System.out.println(y);
    }
}

class Example18 {
    public static void main(String args[]) {
        int x;
        x = 1000;
        System.out.println(x);
        var y = 2000;
        System.out.println(y);
    }
}

class Example19 {
    public static void main(String args[]) {
        int x = 100;
        int y = 200;
        int z;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z); // ERROR: variable 'z' not initialized
    }
}

class Example20 {
    public static void main(String args[]) {
        int x = 100, y, z = 200;
        System.out.println("x");
        y = "java"; // ERROR: cannot assign String to int
        System.out.println(y);
        System.out.println(z);
    }
}

class Example21 {
    public static void main(String args[]) {
        System.out.println("A");
        //System.out.println("B");
        System.out.println("C");
        //System.out.println("D");
        System.out.println("E");
    }
}

class Example22 {
    public static void main(String args[]) {
        System.out.println("A");
        System.out.println("B");
        /*System.out.println("C");
        System.out.println("D");
        System.out.println("E");*/
        System.out.println("F");
    }
}

class Example23 {
    public static void main(String args[]) {
        int x = 100;
        int y = 200;
        System.out.println(x);
        System.out.println(y);
        x = y;
        System.out.println(x);
        System.out.println(y);
    }
}

class Example24 {
    public static void main(String args[]) {
        System.out.println(true);
        System.out.println("true");
    }
}

class Example25 {
    public static void main(String args[]) {
        System.out.println(Java); // ERROR: Java is not a variable
        System.out.println("Java");
    }
}

class Example26 {
    public static void main(String args[]) {
        System.out.println('A');
        System.out.println("A");
        System.out.println('2');
        System.out.println("2");
        System.out.println('JAVA'); // ERROR: char can only hold one character
        System.out.println("JAVA");
    }
}

class Example27 {
    public static void main(String args[]) {
        System.out.println("Hellooooo\tJAVA");
        System.out.println("Hellooooo\t\t\t\tJAVA");
    }
}

class Example28 {
    public static void main(String args[]) {
        System.out.println("Hi\tJAVA");
        System.out.println("Hello\tWorld");
    }
}

class Example29 {
    public static void main(String args[]) {
        System.out.println("AB\nCD");
        System.out.println("");
        System.out.println("EF\tGH\n\niJ\tKL");
    }
}

class Example30 {
    public static void main(String args[]) {
        System.out.println("time - \"17:56:02\"");
    }
}

class Example31 {
    public static void main(String args[]) {
        System.out.println("\"iCET\"");
        System.out.println("\"Institute of Computer Engineering Technology\"");
    }
}

class Example32 {
    public static void main(String args[]) {
        System.out.println("First Line\nSecond Line");
        System.out.println("A\tB\tC");
        System.out.println("D\tE\tF");
    }
}

class Example33 {
    public static void main(String args[]) {
        System.out.println("AB\nCD");
        System.out.println("AB\tCD");
        System.out.println("AB\fCD");
        System.out.println("AB\bCD");
        System.out.println("AB\rCD");
        System.out.println("AB\\CD");
    }
}

class Example34 {
    public static void main(String args[]) {
        System.out.println(10 + 20);
        System.out.println("10" + "20");
        System.out.println("10" + 20);
        System.out.println(10 + "20");
    }
}

class Example35 {
    public static void main(String args[]) {
        System.out.println("20230326");
        System.out.println("2023-03-26");
    }
}

class Example36 {
    public static void main(String args[]) {
        int x, y, z;
        x = 10;
        y = 20;
        z = x + y;
        System.out.println(x + "+" + y + "=" + z);
    }
}

class Example37 {
    public static void main(String args[]) {
        int x = 10, y = 20;
        System.out.println(x + y);
        System.out.println("x" + "y");
        System.out.println("x+y");
        System.out.println("x" + y);
        System.out.println(x + "y");
    }
}

class Example38 {
    public static void main(String args[]) {
        System.out.println(10 + 20 + 30);
        System.out.println("10+20+30");
        System.out.println(10 + 20 + 30);
        System.out.println("10+20" + 30);
        System.out.println("10" + "20" + "30");
        System.out.println("10" + 20 + 30);
        System.out.println(10 + 20 + "30");
        System.out.println(10 + "20" + 30);
    }
}

class Example39 {
    public static void main(String args[]) {
        String s1 = "Hello";
        System.out.println(s1);
        System.out.println(s1.concat(" JAVA"));
    }
}

class Example40 {
    public static void main(String args[]) {
        int x, y, z;
        x = 10;
        y = 20;
        z = x + y;
        System.out.println(x + " + " + y + " = " + z);
        z = x - y;
        System.out.println(x + " - " + y + " = " + z);
        z = x * y;
        System.out.println(x + " * " + y + " = " + z);
    }
}

class Example41 {
    public static void main(String args[]) {
        int x, y;
        x = 10;
        y = 20;
        System.out.println(x + " + " + y + " = " + (x + y));
        System.out.println(x + " - " + y + " = " + (x - y));
        System.out.println(x + " * " + y + " = " + (x * y));
    }
}

class Example42 {
    public static void main(String args[]) {
        int x, y;
        x = 100;
        y = 200;
        System.out.println(x);
        System.out.println(y);
        y = x;
        System.out.println(x);
        System.out.println(y);
    }
}

class Example43 {
    public static void main(String args[]) {
        int num = 103;
        if (num > 0) {
            System.out.println(num + " is positive number");
        } else if (num < 0) {
            System.out.println(num + " is negative number");
        } else {
            System.out.println(num + " is 0");
        }
    }
}

import java.util.*;
class Example44 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input number - ");
        int num = input.nextInt();
        if (num > 0) {
            System.out.println(num + " is positive number");
        } else if (num < 0) {
            System.out.println(num + " is negative number");
        } else {
            System.out.println(num + " is 0");
        }
    }
}

import java.util.*;
class Example45 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your marks - ");
        int mark = input.nextInt();
        if (mark >= 75) {
            System.out.println("your grade is A");
        } else if (mark >= 65) {
            System.out.println("your grade is B");
        } else if (mark >= 50) {
            System.out.println("your grade is C");
        } else {
            System.out.println("your grade is F");
        }
    }
}

import java.util.*;
class Example46 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age - ");
        int age = input.nextInt();
        if (age < 18) {
            System.out.println("age is not valid to vote");
        } else {
            System.out.println("welcome to vote");
        }
    }
}

class Example47 {
    public static void main(String args[]) {
        double x, y, z;
        x = 3;
        y = 4;
        z = Math.sqrt(x * x + y * y);
        System.out.println("Hypotenuse is " + z);
    }
}

import java.util.*;
class Example48 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any number - ");
        int num = input.nextInt();
        int fact = 1;
        for (int i = 1; i < num; i++) {
            fact = fact * i;
        }
        System.out.println("The factorial of " + num + " is " + fact);
    }
}

import java.util.*;
class Example49 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input your age - ");
        int age = input.nextInt();
        if (age < 18) {
            System.out.println("age is not valid to vote");
        } else {
            System.out.println("welcome to vote");
        }
    }
}

public class Example50 {
    public static void main(String args[]) {
        for (int i = -5; i < 6; i++) {
            int result = i != 0 ? 100 / i : 0;
            if (i != 0) {
                System.out.println("100/" + i + " is " + result);
            }
        }
    }
}
