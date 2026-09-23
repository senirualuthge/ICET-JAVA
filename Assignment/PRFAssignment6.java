import java.util.*;

public class PRFAssignment6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1.
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World");
        }

        // 2.
        System.out.println("\nQ2: Numbers 1 to 100");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 3.
        System.out.println("\nQ3: Numbers 100 to 1");
        for (int i = 100; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 4.
        System.out.println("\nQ4: Even numbers between 1 and 100");
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 5.
        System.out.println("\nQ5: 10 random numbers between 0 and 100");
        for (int i = 0; i < 10; i++) {
            System.out.print((int) (Math.random() * 101) + " ");
        }
        System.out.println();

        // 6.
        System.out.println("\nQ6: 50 random numbers - print only odd");
        for (int i = 0; i < 50; i++) {
            int r = (int) (Math.random() * 101);
            if (r % 2 != 0) {
                System.out.print(r + " ");
            }
        }
        System.out.println();

        // 7.
        System.out.println("\nQ7: Characters A to Z");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(ch);
        }

        // 8.
        System.out.println("\nQ8: Factorial");
        System.out.print("Enter an integer: ");
        int factNum = sc.nextInt();
        long fact = 1;
        for (int i = 1; i <= factNum; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + factNum + "! = " + fact);

        // 9.
        int countGT100 = 0;
        System.out.println("Enter 50 integers:");
        for (int i = 0; i < 50; i++) {
            int n = sc.nextInt();
            if (n > 100)
                countGT100++;
        }
        System.out.println("Numbers greater than 100: " + countGT100);

        // 10.
        System.out.println("\nQ10: Marks - Total, Average, Max, Min");
        int[] marks = new int[10];
        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.println("Enter 10 marks:");
        for (int i = 0; i < 10; i++) {
            marks[i] = sc.nextInt();
            total += marks[i];
            if (marks[i] > max)
                max = marks[i];
            if (marks[i] < min)
                min = marks[i];
        }
        double avg = total / 10.0;
        System.out.println("Total   : " + total);
        System.out.println("Max     : " + max);
        System.out.println("Min     : " + min);
        System.out.println("Average : " + avg);

        // 11.
        System.out.println("\nQ11: Height and Weight of 100 students");
        double totalHeight = 0, totalWeight = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.print("Student " + i + " height (cm): ");
            totalHeight += sc.nextDouble();
            System.out.print("Student " + i + " weight (kg): ");
            totalWeight += sc.nextDouble();
        }
        System.out.println("Average height: " + (totalHeight / 100) + " cm");
        System.out.println("Average weight: " + (totalWeight / 100) + " kg");

        // 12.
        System.out.println("\nQ12: Hello World 10 times (for and while)");
        for (int i = 0; i < 10; i++)
            System.out.println("Hello World (for)");
        int w = 0;
        while (w < 10) {
            System.out.println("Hello World (while)");
            w++;
        }

        // 13.

        System.out.println("\nQ13: 1 to 100 using while");
        int c13 = 1;
        while (c13 <= 100) {
            System.out.print(c13 + " ");
            c13++;
        }
        System.out.println();

        // 14. Write a Java program to print even numbers between 1 and 100 using a
        // while loop.
        System.out.println("\nQ14: Even numbers 1-100 using while");
        int c14 = 2;
        while (c14 <= 100) {
            System.out.print(c14 + " ");
            c14 += 2;
        }
        System.out.println();

        // 15.

        System.out.println("\nQ15: Sum of digits");
        System.out.print("Enter a number: ");
        int num15 = sc.nextInt();
        int sum15 = 0;
        for (int t = num15; t > 0; t /= 10) {
            sum15 += t % 10;
        }
        System.out.println("Sum of digits: " + sum15);

        // 16.

        System.out.println("\nQ16: See comment below for trace output");
        /*
         * class Example{
         * public static void main(String[] args) {
         * for (int i = 0; i < 10; i++){ System.out.println(i); }
         * for (int i = 0; i < 10; i++){ System.out.println(i++); }
         * for (int i = 0; i < 10; i++){ System.out.println(++i); }
         * int j=0; while(j<10){ System.out.println(j); j++; }
         * int k=0; while(k<10){ System.out.println(k++); }
         * int m=0; while(m<10){ System.out.println(++m); }
         * int n=0; while(n++<10){ System.out.println(n); }
         * int p=0; while(++p<10){ System.out.println(p); }
         * int q=0; do{ System.out.println(q++); }while(q<10);
         * int s=0; do{ System.out.println(++s); }while(s<10);
         * int t=0; do{ System.out.println(t); }while(t++<10);
         * int u=0; do{ System.out.println(u); }while(++u<10);
         * }
         * }
         * Output:
         * for i++: 0 1 2 3 4 5 6 7 8 9
         * for i++ (body): 0 2 4 6 8
         * for ++i (body): 1 3 5 7 9
         * while j: 0 1 2 3 4 5 6 7 8 9
         * while k++: 0 1 2 3 4 5 6 7 8 9
         * while ++m: 1 2 3 4 5 6 7 8 9 10
         * while n++<10: 1 2 3 4 5 6 7 8 9 10
         * while ++p<10: 1 2 3 4 5 6 7 8 9
         * do-while q++: 0 1 2 3 4 5 6 7 8 9
         * do-while ++s: 1 2 3 4 5 6 7 8 9 10
         * do-while t: 0 1 2 3 4 5 6 7 8 9
         * do-while ++u: 0 1 2 3 4 5 6 7 8 9
         */

        // 17.
        System.out.println("\nQ17: Salary - Least number of notes/coins");
        int[] denoms = { 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
        String[] denomNames = {
                "R5000 notes", "R2000 notes", "R1000 notes",
                "R500 notes", "R200 notes", "R100 notes",
                "R50 notes", "R20 notes", "R10 coins",
                "R5 coins", "R2 coins", "R1 Coins"
        };
        System.out.print("Input number of Employees: ");
        int emp = sc.nextInt();
        int[] totalNotes = new int[denoms.length];
        for (int i = 0; i < emp; i++) {
            System.out.print("Input salary " + (i + 1) + " : ");
            int salary = sc.nextInt();
            for (int j = 0; j < denoms.length; j++) {
                totalNotes[j] += salary / denoms[j];
                salary %= denoms[j];
            }
        }
        for (int j = 0; j < denoms.length; j++) {
            System.out.println(denomNames[j] + " : " + totalNotes[j]);
        }

        // 18. Given code: What is the result? (++x > 2) || (++y > 2) trace
        /*
         * class Test{
         * public static void main(String args[]){
         * int x = 0; int y = 0;
         * for(int i = 0; i<5; i++){
         * if((++x > 2) || (++y > 2)){ x++; }
         * }
         * System.out.println(x+" "+y);
         * }
         * }
         * Answer: C. Prints: 8 2
         * Explanation:
         * i=0: ++x=1 (>2? no), ++y=1 (>2? no) -> x=1,y=1
         * i=1: ++x=2 (>2? no), ++y=2 (>2? no) -> x=2,y=2
         * i=2: ++x=3 (>2? yes, short-circuit, ++y skipped) -> x++ -> x=4,y=2
         * i=3: ++x=5 (>2? yes) -> x++ -> x=6,y=2
         * i=4: ++x=7 (>2? yes) -> x++ -> x=8,y=2
         */

        // 19. Which of the following code fragments are legal?
        /*
         * A. int i=0; for(int i=0;i<10;i++){} B. for(int i=0;i<10;i++){} for(int
         * i=0;i<10;i++){}
         * C. for(int i=0;i<10;i++){ int i=3; } D. {int i=0;} for(int i=0;i<10;i++){}
         * Answer: B and D (A and C have duplicate variable declarations)
         */

        // 20. Which of the following code fragment can be used to print integer numbers
        // 100 to 109.
        /*
         * A. for(int i=100;i<110;i++){ System.out.println(i); }
         * B. for(int i=100;i<110;i++){ System.out.println(i++); }
         * C. for(int i=0;i<10;i++){ int k=100; System.out.println(i+k); }
         * D. for(int i=0;i<10;i++){ int k=100; System.out.println(k); k++; }
         * E. int k=100; for(int i=0;i<10;i++){ System.out.println(k); k++; }
         * Answer: A, C, E
         */

        // 21. What is the output of the following code fragments?
        /*
         * A. for(int i=0;;i++){ System.out.println("i : "+i); } -> infinite: 0,1,2,...
         * B. int i=0; for(;i<10;){ System.out.println("i : "+i++); } -> 0 through 9
         * C. for(int i=0;i<10;i++){ System.out.println("i : "+i++); } -> 0,2,4,6,8
         * D. for(char ch='A';ch<91;ch++){ System.out.println("ch : "+ch); } -> A
         * through Z
         * E. for(int i=0,j=10;i<=j;i++,j--){ System.out.println(i+" "+j); } -> 0 10, 1
         * 9, 2 8, 3 7, 4 6, 5 5
         * F. for(int i=0;i<128;i++){ System.out.println((char)i+" "+i); } -> 0 0 ...
         * 127 127
         * G. int x=1; for(int i=0;i<10;i++){ int k=100; System.out.println(x+k); k++; }
         * -> 101 ten times
         */

        // 22. Which of the following loop declarations are legal?
        /*
         * A. for(int i=0;i<10;i++){} B. for(i=0;i<10;i++){} C. for(int i=0;;i++){} D.
         * for(int i=0;i<10;){}
         * E. for(double d=0;d<10;d++){} F. for(;;){} G. for(byte b=0;b<10;b++){} H.
         * for(;int i=0;){}
         * I. for(int i=0,j=10;i++;j++){} J. for(int i=0;;){} K. for(char ch='A';
         * ch>92;ch++){}
         * Answer: Legal: A, C, D, E, F, G, J, K Illegal: B, H, I
         */

        // 23.
        System.out.println("\nQ23: Series of positive integers");
        int less1000 = 0, greater1000 = 0;
        System.out.println("Enter positive integers (-1 to stop):");
        while (true) {
            int n = sc.nextInt();
            if (n == -1)
                break;
            if (n < 1000)
                less1000++;
            else if (n > 1000)
                greater1000++;
        }
        System.out.println("Numbers less than 1000: " + less1000);
        System.out.println("Numbers greater than 1000: " + greater1000);

        // 24.
        System.out.println("\nQ24: Coin toss simulation");
        int heads = 0, tails = 0;
        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.5) {
                System.out.println("HEAD");
                heads++;
            } else {
                System.out.println("TAIL");
                tails++;
            }
        }
        System.out.println("Statistics: " + heads + " Heads and " + tails + " Tails");

        // 25.
        System.out.println("\nQ25: Dice rolling 5 times");
        String diceOut = "";
        for (int i = 0; i < 5; i++) {
            diceOut += (int) (Math.random() * 6 + 1);
        }
        System.out.println(diceOut);

        // 26.
        System.out.println("\nQ26: Dice roll until desired number");
        System.out.print("What number do you want to roll (1-6)? ");
        int target = sc.nextInt();
        int roll;
        do {
            roll = (int) (Math.random() * 6 + 1);
            System.out.println("Rolled: " + roll);
        } while (roll != target);

        // 27.
        System.out.println("\nQ27: Sum of digits");
        System.out.print("Enter a number: ");
        int num27 = sc.nextInt();
        int sum27 = 0;
        int temp27 = num27;
        while (temp27 > 0) {
            sum27 += temp27 % 10;
            temp27 /= 10;
        }
        System.out.println("Sum of digits: " + sum27);

        // 28.
        System.out.println("\nQ28: Reverse a number");
        System.out.print("Enter a number: ");
        int num28 = sc.nextInt();
        int rev28 = 0;
        for (int t = num28; t > 0; t /= 10) {
            rev28 = rev28 * 10 + t % 10;
        }
        System.out.println("Reversed: " + rev28);

        // 29.
        System.out.println("\nQ29: 99 Bottles of Beer");
        System.out.print("How many bottles of beer are on the wall: ");
        int bottles = sc.nextInt();
        for (int i = bottles; i > 0; i--) {
            String current = i == 1 ? "bottle" : "bottles";
            String next = (i - 1) == 1 ? "bottle" : "bottles";
            System.out.println(i + " " + current + " of beer on the wall, " + i + " " + current + " of beer.");
            if (i - 1 > 0) {
                System.out.println("Take one down, pass it around, " + (i - 1) + " " + next + " of beer on the wall.");
            } else {
                System.out.println("Take one down, pass it around, no more bottles of beer on the wall.");
            }
        }

        // 30.
        System.out.println("\nQ30: Palindrome number");
        System.out.print("Enter a number: ");
        int num30 = sc.nextInt();
        int rev30 = 0;
        for (int t = num30; t > 0; t /= 10) {
            rev30 = rev30 * 10 + t % 10;
        }
        if (num30 == rev30) {
            System.out.println(num30 + " is a palindrome");
        } else {
            System.out.println(num30 + " is not a palindrome");
        }

        // 31.
        System.out.println("\nQ31: Teacher evaluation");
        int studentCount = 0;
        int totalMarks = 0;
        int maxMark = Integer.MIN_VALUE;
        int minMark = Integer.MAX_VALUE;
        System.out.println("Enter student marks (-1 to stop):");
        while (true) {
            int m = sc.nextInt();
            if (m == -1)
                break;
            studentCount++;
            totalMarks += m;
            if (m > maxMark)
                maxMark = m;
            if (m < minMark)
                minMark = m;
        }
        double avgMarks = (double) totalMarks / studentCount;
        System.out.println("No of Students : " + studentCount);
        System.out.println("Total marks    : " + totalMarks);
        System.out.println("Maximum        : " + maxMark);
        System.out.println("Minimum        : " + minMark);
        System.out.println("Average        : " + avgMarks);

        // 32.
        System.out.println("\nQ32: Reverse a word");
        System.out.print("Enter a word or phrase: ");
        sc.nextLine();
        String str32 = sc.nextLine();
        String rev32 = "";
        for (int i = str32.length() - 1; i >= 0; i--) {
            rev32 += str32.charAt(i);
        }
        System.out.println("Reverse word: " + rev32);

        // 33.
        System.out.println("\nQ33: String palindrome");
        System.out.print("Enter a string: ");
        String str33 = sc.nextLine();
        String rev33 = "";
        for (int i = str33.length() - 1; i >= 0; i--) {
            rev33 += str33.charAt(i);
        }
        if (str33.equalsIgnoreCase(rev33)) {
            System.out.println(str33 + " is a palindrome");
        } else {
            System.out.println(str33 + " is not a palindrome");
        }

        // 34.
        System.out.println("\nQ34: Character occurrences");
        System.out.print("Enter a string: ");
        String str34 = sc.nextLine();
        System.out.print("Enter a character: ");
        char ch34 = sc.nextLine().charAt(0);
        int count34 = 0;
        for (int i = 0; i < str34.length(); i++) {
            if (str34.charAt(i) == ch34)
                count34++;
        }
        System.out.println("Occurrences of '" + ch34 + "': " + count34);

        // 35.
        System.out.println("\nQ35: Power of a number (without built-in)");
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exp = sc.nextInt();
        long power = 1;
        for (int i = 0; i < exp; i++) {
            power *= base;
        }
        System.out.println(base + "^" + exp + " = " + power);

        // 36.
        System.out.println("\nQ36: Count vowels and consonants");
        System.out.print("Enter a string: ");
        sc.nextLine();
        String str36 = sc.nextLine().toLowerCase();
        int vowels = 0, consonants = 0;
        for (int i = 0; i < str36.length(); i++) {
            char c = str36.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);

        // 37.
        System.out.println("\nQ37: Greatest Common Divisor");
        System.out.print("Enter first positive integer: ");
        int a37 = sc.nextInt();
        System.out.print("Enter second positive integer: ");
        int b37 = sc.nextInt();
        int x37 = a37, y37 = b37;
        while (y37 != 0) {
            int t = y37;
            y37 = x37 % y37;
            x37 = t;
        }
        System.out.println("GCD of " + a37 + " and " + b37 + " = " + x37);

        // 38. Given: class Example{ public static void main(String[] args) { int j = 0;
        // do System.out.print(j); while (j++ < 2); } } What is the result?
        /*
         * class Example{
         * public static void main(String[] args) {
         * int j = 0;
         * do
         * System.out.print(j);
         * while (j++ < 2);
         * }
         * }
         * Output: 012
         * Answer: B. 012
         * Explanation: do executes body first: print 0, j++ -> j=1, 1<2 true
         * print 1, j++ -> j=2, 2<2 false -> stops
         */

        // 39. Given: class Example { public static void main(String[] args) { int j =
        // 0; while (j++ < 2) { System.out.print(j+" "); } } } What is the result?
        /*
         * class Example {
         * public static void main(String[] args) {
         * int j = 0;
         * while (j++ < 2) { System.out.print(j+" "); }
         * }
         * }
         * Output: 1 2
         * Explanation: j++ < 2: check 0<2 true, j=1 -> print 1; check 1<2 true, j=2 ->
         * print 2; check 2<2 false
         */

        // 40. Given: class Example { public static void main(String [] args) { int x =
        // 0; // Line 4 --insert code here- do { } while (x++ < y);
        // System.out.println(x); } } Which inserted at line 4 produces output 12?
        /*
         * class Example {
         * public static void main(String [] args) {
         * int x = 0;
         * // Line 4 --insert code here-
         * do { } while (x++ < y);
         * System.out.println(x);
         * }
         * }
         * Which inserted at line 4, produces the output 12?
         * A. int y = x; B. int y = 11; C. int y = 13; D. int y = 10; E. int y = 12; F.
         * None
         * Answer: B. int y = 11;
         * Explanation: x starts 0, loop runs while x++ < y. For y=11:
         * x++ < 11: 0<11 T(x=1), 1<11 T(x=2), ..., 10<11 T(x=11), 11<11 F(x=12) ->
         * print 12
         */

        // 41.
        System.out.println("\nQ41: Patterns with two for-loops");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 42.
        System.out.println("\nQ42: 10x10 grid with single print");
        for (int i = 0; i < 10; i++) {
            System.out.println("* * * * * * * * * *");
        }

        // 43.
        int rows43 = 8;
        for (int i = 1; i <= rows43; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 44.
        System.out.println("\nQ44: Patterns with println");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 45.
        System.out.println("\nQ45: Multiplication table");
        System.out.print("Enter size of multiplication table: ");
        int size = sc.nextInt();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // 46.
        System.out.println("\nQ46: Guess the number");
        int secret = (int) (Math.random() * 100) + 1;
        int guess;
        do {
            System.out.print("Enter your guess (1-100): ");
            guess = sc.nextInt();
            if (guess > secret) {
                System.out.println("Too high, try again.");
            } else if (guess < secret) {
                System.out.println("Too low, try again.");
            } else {
                System.out.println("Correct!");
            }
        } while (guess != secret);

        // 47.
        System.out.println("\nQ47: Right angle triangle with numbers");
        System.out.print("Input number of rows: ");
        int rows47 = sc.nextInt();
        for (int i = 1; i <= rows47; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 48.
        System.out.println("\nQ48: Prime numbers 1-100 using while");
        int num48 = 2;
        while (num48 <= 100) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num48); i++) {
                if (num48 % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(num48 + " ");
            num48++;
        }
        System.out.println();

        // 49.
        System.out.println("\nQ49: Armstrong number");
        System.out.print("Enter a number: ");
        int num49 = sc.nextInt();
        int sum49 = 0;
        int temp49 = num49;
        int digits49 = String.valueOf(num49).length();
        while (temp49 > 0) {
            int d = temp49 % 10;
            int pow = 1;
            for (int i = 0; i < digits49; i++)
                pow *= d;
            sum49 += pow;
            temp49 /= 10;
        }
        if (sum49 == num49) {
            System.out.println(num49 + " is an Armstrong number");
        } else {
            System.out.println(num49 + " is not an Armstrong number");
        }

        // 50.
        System.out.println("\nQ50: Sum of multiples of 3 or 5 below 1000");
        int sum50 = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum50 += i;
        }
        System.out.println("Sum: " + sum50);

        // 51.
        System.out.println("\nQ51: Smallest number evenly divisible by 1-20");
        long num51 = 2520;
        while (true) {
            boolean divisible = true;
            for (int i = 1; i <= 20; i++) {
                if (num51 % i != 0) {
                    divisible = false;
                    break;
                }
            }
            if (divisible)
                break;
            num51++;
        }
        System.out.println("Smallest number: " + num51);

        // 52.
        System.out.println("\nQ52: Vowels in a set of words");
        System.out.print("Enter a set of words: ");
        sc.nextLine();
        String words52 = sc.nextLine().toLowerCase();
        int vowels52 = 0;
        for (int i = 0; i < words52.length(); i++) {
            char c = words52.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels52++;
            }
        }
        System.out.println("Number of vowels: " + vowels52);

        // 53.
        System.out.println("\nQ53: Power of a number");
        System.out.print("Enter base: ");
        int base53 = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exp53 = sc.nextInt();
        long power53 = 1;
        for (int i = 0; i < exp53; i++)
            power53 *= base53;
        System.out.println(base53 + "^" + exp53 + " = " + power53);

        // 54.
        System.out.println("\nQ54: Prime numbers 1-100 using for");
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(i + " ");
        }
        System.out.println();

        // 55.
        System.out.println("\nQ55: Random points in unit circle");
        int count55 = 0;
        while (true) {
            double x55 = Math.random() * 2 - 1;
            double y55 = Math.random() * 2 - 1;
            System.out.println("(" + x55 + ", " + y55 + ")");
            if (Math.sqrt(x55 * x55 + y55 * y55) > 1) {
                System.out.println("Point outside circle - stopping");
                break;
            }
            count55++;
        }
        System.out.println("Points inside circle: " + count55);

        // 56. What will be the output when you compile and run the following program?
        // Explain your answer. (variable scope in loops/switch)
        /*
         * class Example{
         * public static void main(String[] args) {
         * int a,b,c,d,e;
         * for (int i = 0; i < 10; i++){ a=i; }
         * int j=0; while(j++<10){ b=j; }
         * int k=0; do{ c=j; }while(j++<10);
         * int m=0; switch(m){ case 0 : d=0; }
         * int n=0; switch(n){ default : e=0; }
         * System.out.println(a); //Line 24: 9
         * System.out.println(b); //Line 25: 10
         * System.out.println(c); //Line 26: 11
         * System.out.println(d); //Line 27: 0
         * System.out.println(e); //Line 28: 0
         * }
         * }
         * Explanation:
         * - a=9 (last i in for loop)
         * - b=10 (while j++<10: j goes 0..9<10, b assigned j each time, last b=10, exit
         * j=11)
         * - c=11 (j=11, do running once sets c=11, then j++<10 -> 11<10 false, j=12)
         * - d=0 (case 0 matches)
         * - e=0 (default sets e=0)
         */

        // 57.
        System.out.println("\nQ57: Factors of a number");
        System.out.print("Enter a number: ");
        int num57 = sc.nextInt();
        System.out.print("Factors: ");
        for (int i = 1; i <= num57; i++) {
            if (num57 % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 58. What will be the result of attempting to compile and run the following
        // code? (boolean do-while)
        /*
         * class Example {
         * public static void main(String[] args) {
         * boolean b = false;
         * int i = 1;
         * do {
         * i++;
         * b = !b;
         * } while (b);
         * System.out.println(i);
         * }
         * }
         * Output: 3
         * Answer: E. The code will compile without error and will print 3 when run.
         * Explanation: i=1,b=false -> 1st: i=2,b=true -> while(b) true
         * 2nd: i=3,b=false -> while(b) false -> stop, print 3
         */

        // 59. Given: class Example { ... for loop with break } What is the result?
        /*
         * class Example{
         * public static void main(String[] args) {
         * int k=0; int l=0;
         * for (int i=0; i <= 3; i++) {
         * k++;
         * if (i == 2) break;
         * l++;
         * }
         * System.out.println(k + ", " + l);
         * }
         * }
         * Options: A. compile error B. 3, 3 C. 4, 3 if break replaced by continue
         * D. compile error if break replaced by return E. compile error if break
         * removed
         * Answer: C is correct (break gives 3,2; continue gives 4,3)
         */

        // 60. Which statements are true? Select the two correct answers.
        /*
         * A. {{}} is a valid statement block.
         * B. { continue; } is a valid statement block.
         * C. block: { break block; } is a valid statement block.
         * D. block: { continue block; } is a valid statement block.
         * E. The break statement can only be used in a loop or a switch statement.
         * Answer: A and C
         */

        // 61. Given: class Example with switch inside for loop. What is the result?
        /*
         * class Example{
         * public static void main(String args[]){
         * for(int i=0; i<10; i++){
         * int j=i%3;
         * switch(j){
         * case 0: System.out.print("A "); break;
         * case 1: System.out.print("B "); break;
         * default: System.out.print(j+" ");
         * }
         * }
         * }
         * }
         * Output: A B 2 A B 2 A B 2 A
         * Answer: D. A B 2 A B 2 A B 2 A
         */

        // 62. Given the following code fragment, which of the following lines will be a
        // part of the output? (labeled continue)
        /*
         * class Example {
         * public static void main(String[] args) {
         * outer:for (int i = 0; i < 3; i++) {
         * for (int j = 0; j < 2; j++) {
         * if (i == j) continue outer;
         * System.out.println("i=" + i + ", j=" + j);
         * }
         * }
         * }
         * }
         * Output: i=1,j=0 and i=2,j=0 and i=2,j=1
         * Answer: A. i=1, j=0 D. i=2, j=1
         */

        // 63. Given: class Example with labeled break in if. What is the result?
        /*
         * class Example {
         * public static void main(String args[]) {
         * int x=1;
         * L1:if(x>0){
         * System.out.print("A ");
         * L2:if(x==1){break L1;}
         * System.out.print("B ");
         * }
         * }
         * }
         * Answer: E. Prints A
         * Explanation: x=1, enters L1, prints "A ", L2: x==1 true, break L1 exits
         * labeled block, "B " skipped.
         */

        // 64. Predict the output for the following piece of code. (continue)
        /*
         * class Example{
         * public static void main(String args[]){
         * for (int i = 1 ; i <= 5 ; i++ ){
         * if (i < 5 ) continue;
         * else System.out.println( i );
         * }
         * }
         * }
         * Answer: C. Only 5 is printed
         * Explanation: i=1,2,3,4 all continue (skip to next iteration). i=5: else
         * prints 5.
         */

        // 65. What will be the output when you compile and run the following program?
        // (complex labeled loops)
        /*
         * class Example {
         * public static void main(String args[]) {
         * int i = 0; int j = 0;
         * label1: while (i++<5) {
         * label2: for (;;) {
         * label3: do {
         * System.out.print(i+" "+j+" ");
         * switch (i+j++) {
         * case 0: continue label3;
         * case 1: continue label2;
         * case 2: continue label1;
         * case 3: break; case 4: break label3;
         * case 5: break label2; case 6: break label1;
         * default: break label1;
         * }
         * } while (++j<5);
         * }
         * }
         * }
         * }
         * Answer: A. 1 0 1 1 2 2 2 3 3 4
         */

        sc.close();
    }
}
