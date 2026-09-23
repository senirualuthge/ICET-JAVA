import java.util.*;

class Coursework6 {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        printBanner();

        while (true) {
            System.out.println("\n--- Home Page ---");
            System.out.println("[01] Decimal Converter");
            System.out.println("[02] Binary Converter");
            System.out.println("[03] Octal Converter");
            System.out.println("[04] Hexadecimal Converter");
            System.out.println("[05] Roman Number Converter");
            System.out.println("[00] Exit");
            System.out.print("Enter an option to continue: ");
            int option = input.nextInt();
            input.nextLine(); 

            switch (option) {
                case 1 -> {
                    boolean exitProgram = decimalConverter(input);
                    if (exitProgram) { input.close(); return; }
                }
                case 2 -> {
                    boolean exitProgram = binaryConverter(input);
                    if (exitProgram) { input.close(); return; }
                }
                case 3 -> {
                    boolean exitProgram = octalConverter(input);
                    if (exitProgram) { input.close(); return; }
                }
                case 4 -> {
                    boolean exitProgram = hexConverter(input);
                    if (exitProgram) { input.close(); return; }
                }
                case 5 -> {
                    boolean exitProgram = romanConverterMenu(input);
                    if (exitProgram) { input.close(); return; }
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    input.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    
    static void printBanner() {
        System.out.println("\t\t\t\t\t _    ____             __");
        System.out.println("\t\t\t\t\t|  \\ /      \\           |  \\");
        System.out.println("\t\t\t\t\t \\$$|  $$$$$$\\  ____  | $$  _____");
        System.out.println("\t\t\t\t\t|  \\| $$   \\$$ |      \\ | $$ /       \\");
        System.out.println("\t\t\t\t\t| $$| $$        \\$$$$$$\\| $$|  $$$$$$$");
        System.out.println("\t\t\t\t\t| $$| $$   __  /      $$| $$| $$");
        System.out.println("\t\t\t\t\t| $$| $$_/  \\|  $$$$$$$| $$| $$____");
        System.out.println("\t\t\t\t\t| $$ \\$$    $$ \\$$    $$| $$ \\$$     \\");
        System.out.println("\t\t\t\t\t \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$\n");

        System.out.println("  _   _                 _                  _____                          _            ");
        System.out.println(" | \\ | |               | |                / ____|                        | |           ");
        System.out.println(" |  \\| |_   _ _ __ ___ | |__   ___ _ __  | |     ___  _ ____   _____ _ __| |_ ___ _ __ ");
        System.out.println(
                " | . ` | | | | '_ ` _ \\| '_ \\ / _ \\ '__| | |    / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__|");
        System.out.println(" | |\\  | |_| | | | | | | |_) |  __/ |    | |___| (_) | | | \\ V /  __/ |  | ||  __/ |   ");
        System.out.println(
                " |_| \\_|\\__,_|_| |_| |_|_.__/ \\___|_|     \\_____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|   ");

        System.out.println(
                "======================================================================================================");
    }

    static boolean isValidNumberInBase(String s, int base) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.digit(s.charAt(i), base) == -1) {
                return false;
            }
        }
        return true;
    }

    
    static boolean isValidRoman(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D' && c != 'M') {
                return false;
            }
        }
        return true;
    }

    
    static boolean promptRetry(Scanner input, String message) {
        System.out.println(message);
        System.out.print("Input number again? (Y/N): ");
        String ag = input.nextLine().trim().toUpperCase();
        return ag.equals("Y");
    }

   
    static boolean promptGoHome(Scanner input) {
        System.out.print("Do you want to go to homepage? (Y/N): ");
        String goHome = input.nextLine().trim().toUpperCase();
        return !goHome.equals("Y"); 
    }

   
    static boolean decimalConverter(Scanner input) {
        while (true) {
            System.out.println("+----------------------------------------------------------------------------");
            System.out.println("|                         Decimal Converter                                  |");
            System.out.println("+----------------------------------------------------------------------------");

            System.out.print("\n\n\n ");
            System.out.print("Enter decimal number: ");
            String decIN = input.nextLine();

            if (decIN.isEmpty()) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            if (!isValidNumberInBase(decIN, 10)) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            int dec = Integer.parseInt(decIN);
            System.out.println("Decimal: " + dec);
            System.out.println("Binary: " + Integer.toBinaryString(dec));
            System.out.println("Octal: " + Integer.toOctalString(dec));
            System.out.println("Hexadecimal: " + Integer.toHexString(dec).toUpperCase());

            return promptGoHome(input);
        }
    }


    static boolean binaryConverter(Scanner input) {
        while (true) {
            System.out.println("+----------------------------------------------------------------------------");
            System.out.println("|                         Binary Converter                                   |");
            System.out.println("+----------------------------------------------------------------------------");

            System.out.print("\n\n\n ");
            System.out.print("Enter binary number: ");
            String biIN = input.nextLine();

            if (biIN.isEmpty()) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            if (!isValidNumberInBase(biIN, 2)) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            int bi = Integer.parseInt(biIN, 2); 
            System.out.println("Decimal: " + bi);
            System.out.println("Octal: " + Integer.toOctalString(bi));
            System.out.println("Hexadecimal: " + Integer.toHexString(bi).toUpperCase());

            return promptGoHome(input);
        }
    }

    
    static boolean octalConverter(Scanner input) {
        while (true) {
            System.out.println("+----------------------------------------------------------------------------");
            System.out.println("|                         Octal Converter                                   |");
            System.out.println("+----------------------------------------------------------------------------");

            System.out.print("\n\n\n ");
            System.out.print("Enter Octal number: ");
            String ocIN = input.nextLine();

            if (ocIN.isEmpty()) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            if (!isValidNumberInBase(ocIN, 8)) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            int oc = Integer.parseInt(ocIN, 8); 
            System.out.println("Decimal: " + oc);
            System.out.println("Binary: " + Integer.toBinaryString(oc));
            System.out.println("Hexadecimal: " + Integer.toHexString(oc).toUpperCase());

            return promptGoHome(input);
        }
    }

   
    static boolean hexConverter(Scanner input) {
        while (true) {
            System.out.println("+----------------------------------------------------------------------------");
            System.out.println("|                         HexaDecimal Converter                                   |");
            System.out.println("+----------------------------------------------------------------------------");

            System.out.print("\n\n\n ");
            System.out.print("Enter Hexadecimal number: ");
            String hxIN = input.nextLine();

            if (hxIN.isEmpty()) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            if (!isValidNumberInBase(hxIN, 16)) {
                if (promptRetry(input, "Invalid Number")) continue;
                else return false;
            }

            int hex = Integer.parseInt(hxIN, 16);
            System.out.println("Hexadecimal: " + hxIN.toUpperCase());
            System.out.println("Decimal: " + hex);
            System.out.println("Binary: " + Integer.toBinaryString(hex));
            System.out.println("Octal: " + Integer.toOctalString(hex));

            return promptGoHome(input);
        }
    }

   
    static boolean romanConverterMenu(Scanner input) {
        System.out.println("+----------------------------------------------------------------------------");
        System.out.println("|                         Roman Converter                                    |");
        System.out.println("+----------------------------------------------------------------------------");

        System.out.println("[01] Decimal Number to Roman number ");
        System.out.println("[02] Roman Number to Decimal");
        System.out.print("Enter an option: ");
        int rom = input.nextInt();
        input.nextLine(); 

        return switch (rom) {
            case 1 -> decimalToRomanConverter(input);
            case 2 -> romanToDecimalConverter(input);
            default -> {
                System.out.println("Invalid option. Please try again.");
                yield false;
            }
        };
    }

    static boolean decimalToRomanConverter(Scanner input) {
        while (true) {
            System.out.println("+----------------------------------------------------------------------------");
            System.out.println("|                         Decimal --->Roman Converter                        |");
            System.out.println("+----------------------------------------------------------------------------");

            System.out.print("Enter a decimal number: ");
            String decRomInput = input.nextLine();

            if (decRomInput.isEmpty()) {
                if (promptRetry(input, "invalid input...")) continue;
                else return false;
            }

            if (!isValidNumberInBase(decRomInput, 10)) {
                if (promptRetry(input,"invalid input...")) continue;
                else return false;
            }

            int num = Integer.parseInt(decRomInput);
            System.out.println("Decimal: " + num);
            System.out.println("Roman: " + decimalToRoman(num)); 

            return promptGoHome(input);
        }
    }

    static boolean romanToDecimalConverter(Scanner input) {
        while (true) {
            System.out.println("+----------------------------------------------------------------------------");
            System.out.println("|                         Roman -----> Decimal Converter                    |");
            System.out.println("+----------------------------------------------------------------------------");

            System.out.print("Enter a Roman number: ");
            String romanInput = input.nextLine().toUpperCase();

            if (romanInput.isEmpty()) {
                if (promptRetry(input, "invalid input...")) continue;
                else return false;
            }

            if (!isValidRoman(romanInput)) {
                if (promptRetry(input, "invalid input...")) continue;
                else return false;
            }

            System.out.println("Roman: " + romanInput);
            System.out.println("Decimal: " + romanToDecimalValue(romanInput)); 

            return promptGoHome(input);
        }
    }

  
    static String decimalToRoman(int num) {
        int temp = num;
        StringBuilder romanResult = new StringBuilder();

        
        while (temp >= 1000) { romanResult.append("M"); temp -= 1000; }

        
        while (temp >= 900) { romanResult.append("CM"); temp -= 900; }
        while (temp >= 500) { romanResult.append("D"); temp -= 500; }
        while (temp >= 400) { romanResult.append("CD"); temp -= 400; }
        while (temp >= 100) { romanResult.append("C"); temp -= 100; }

        
        while (temp >= 90) { romanResult.append("XC"); temp -= 90; }
        while (temp >= 50) { romanResult.append("L"); temp -= 50; }
        while (temp >= 40) { romanResult.append("XL"); temp -= 40; }
        while (temp >= 10) { romanResult.append("X"); temp -= 10; }

       
        while (temp >= 9) { romanResult.append("IX"); temp -= 9; }
        while (temp >= 5) { romanResult.append("V"); temp -= 5; }
        while (temp >= 4) { romanResult.append("IV"); temp -= 4; }
        while (temp >= 1) { romanResult.append("I"); temp -= 1; }

        return romanResult.toString();
    }

   
    static int romanToDecimalValue(String romanInput) {
        int result = 0;
        int prevValue = 0; 
        for (int i = romanInput.length() - 1; i >= 0; i--) {
            char c = romanInput.charAt(i);
            int curValue = switch (c) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (curValue < prevValue) {
                result -= curValue; 
            } else {
                result += curValue;
            }
            prevValue = curValue;
        }
        return result;
    }
}
