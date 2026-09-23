import java.util.*;

class Coursework5 {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

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
            input.nextLine(); // consume leftover newline

            switch (option) {
                case 1: {

                    while (true) {

                        int dec = 0;

                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         Decimal Converter                                  |");
                        System.out.println("+----------------------------------------------------------------------------");

                        System.out.print("\n\n\n ");

                        System.out.print("Enter decimal number: ");
                        String decIN = input.nextLine(); // need a string, if not cannot use below condition

                        if (decIN.isEmpty()) {
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase(); // which type letter, use input goes a capital

                            if (ag.equals("Y"))
                                continue;
                            else
                                break;
                        }

                        boolean valid = true; // check number
                        for (int i = 0; i < decIN.length(); i++) { // loop runs through every letter
                            if (!Character.isDigit(decIN.charAt(i))) { // check ch is a digit using inverse logic
                                char c = decIN.charAt(i);
                                if (c < '0' || c > '9') {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        if (!valid) { // not a number
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase();
                            if (ag.equals("Y"))
                                continue; // if yes goes to top, not end it
                            else
                                break;
                        }

                        dec = Integer.parseInt(decIN); // read the string and return number
                        System.out.println("Decimal: " + dec);
                        System.out.println("Binary: " + Integer.toBinaryString(dec)); // convert number into binary
                        System.out.println("Octal: " + Integer.toOctalString(dec)); // convert number into octal
                        System.out.println("Hexadecimal: " + Integer.toHexString(dec).toUpperCase()); // convert number

                        System.out.print("Do you want to go to homepage? (Y/N): "); // redirecting to top
                        String goHome = input.nextLine().trim().toUpperCase();
                        if (goHome.equals("Y")) {
                            break; // go back to the homepage
                        } else {
                            input.close();
                            return;
                        }
                    }
                    break; // exits the switch case, prevents fall-through into case 2
                }
                case 2: {
                    while (true) {
                        int bi = 0;

                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         Binary Converter                                   |");
                        System.out.println("+----------------------------------------------------------------------------");

                        System.out.print("\n\n\n ");

                        System.out.print("Enter binary number: ");
                        String biIN = input.nextLine(); // need a string, if not cannot use below condition

                        if (biIN.isEmpty()) {
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase(); // which type letter, use input goes a capital

                            if (ag.equals("Y"))
                                continue;
                            else
                                break;
                        }

                        boolean valid = true; // check number
                        for (int i = 0; i < biIN.length(); i++) { // loop runs through every letter
                            if (!Character.isDigit(biIN.charAt(i))) { // check ch is a digit using inverse logic
                                char c = biIN.charAt(i);
                                if (c < '0' || c > '1') {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        if (!valid) { // not a number
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase();
                            if (ag.equals("Y"))
                                continue; // if yes goes to top, not end it
                            else
                                break;
                        }

                        bi = Integer.parseInt(biIN); // read the string and return numeric — assign, not redeclare
                        System.out.println("Decimal: " + bi);
                        System.out.println("Octal: " + Integer.toOctalString(bi)); // convert number into octal
                        System.out.println("Hexadecimal: " + Integer.toHexString(bi).toUpperCase()); // convert number
                                                                                                     // into hexa

                        System.out.print("Do you want to go to homepage? (Y/N): "); // redirecting to top
                        String goHome = input.nextLine().trim().toUpperCase();
                        if (goHome.equals("Y")) {
                            break; // go back to the homepage
                        } else {
                            input.close();
                            return;
                        }
                    }
                    break; // exits the switch case, prevents fall-through into case 2
                }
                case 3: {
                    while (true) {
                        int oc = 0;

                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         Octal Converter                                   |");
                        System.out.println("+----------------------------------------------------------------------------");

                        System.out.print("\n\n\n ");

                        System.out.print("Enter Octal number: ");
                        String ocIN = input.nextLine();

                        if (ocIN.isEmpty()) {
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase(); // which type letter, use input goes a capital

                            if (ag.equals("Y"))
                                continue;
                            else
                                break;
                        }

                        boolean valid = true; // check number
                        for (int i = 0; i < ocIN.length(); i++) { // loop runs through every letter
                            if (!Character.isDigit(ocIN.charAt(i))) { // check ch is a digit using inverse logic
                                char c = ocIN.charAt(i);
                                if (c < '0' || c > '7') {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        if (!valid) { // not a number
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase();
                            if (ag.equals("Y"))
                                continue; // if yes goes to top, not end it
                            else
                                break;
                        }

                        oc = Integer.parseInt(ocIN); // read the string and return number
                        System.out.println("Decimal: " + oc);
                        System.out.println("Binary: " + Integer.toBinaryString(oc)); // convert number into binary
                        System.out.println("Hexadecimal: " + Integer.toHexString(oc).toUpperCase()); // convert number

                        System.out.print("Do you want to go to homepage? (Y/N): "); // redirecting to top
                        String goHome = input.nextLine().trim().toUpperCase();
                        if (goHome.equals("Y")) {
                            break; // go back to the homepage
                        } else {
                            input.close();
                            return;
                        }
                    }
                    break; // exits the switch case, prevents fall-through into case 2
                }
                case 4: {
                    while (true) {
                        int hex = 0;

                       
                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         HexaDecimal Converter                                   |");
                        System.out.println("+----------------------------------------------------------------------------");


                        System.out.print("\n\n\n ");

                        System.out.print("Enter Hexadecimal number: ");
                        String hxIN = input.nextLine();

                        if (hxIN.isEmpty()) {
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase(); // which type letter, use input goes a capital

                            if (ag.equals("Y"))
                                continue;
                            else
                                break;
                        }

                        boolean valid = true; // check number
                        for (int i = 0; i < hxIN.length(); i++) { // loop runs through every letter
                            if (!Character.isDigit(hxIN.charAt(i))) { // check ch is a digit using inverse logic
                                char c = hxIN.charAt(i);
                                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        if (!valid) { // not a number
                            System.out.println("Invalid Number");
                            System.out.print("Input number again? (Y/N): ");
                            String ag = input.nextLine().toUpperCase();
                            if (ag.equals("Y"))
                                continue; // if yes goes to top, not end it
                            else
                                break;
                        }

                        hex = Integer.parseInt(hxIN, 16);
                        System.out.println("Hexadecimal: " + hxIN.toUpperCase());
                        System.out.println("Decimal: " + hex);
                        System.out.println("Binary: " + Integer.toBinaryString(hex));
                        System.out.println("Octal: " + Integer.toOctalString(hex));
                        System.out.print("Do you want to go to homepage? (Y/N): ");
                        String goHome = input.nextLine().trim().toUpperCase();
                        if (goHome.equals("Y")) {
                            break; // go back to the homepage
                        } else {
                            input.close();
                            return;
                        }
                    }
                    break; // exits the switch case, prevents fall-through into case 5
                }

                case 5: {
                    while (true) {

                        
                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         Roman Converter                                    |");
                        System.out.println("+----------------------------------------------------------------------------");


                        System.out.println("[01] Decimal Number to Roman number ");
                        System.out.println("[02] Roman Number to Decimal");
                        System.out.print("Enter an option: ");
                        int rom = input.nextInt();
                        input.nextLine(); // consume leftover newline left behind by nextInt()

                        switch (rom) {
                            case 1: {
                                while (true) {

                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         Decimal --->Roman Converter                        |");
                        System.out.println("+----------------------------------------------------------------------------");

                                    System.out.print("Enter a decimal number: ");
                                    String decRomInput = input.nextLine(); // need a string, if not cannot use

                                    if (decRomInput.isEmpty()) {
                                        System.out.println("invalid input...");
                                        System.out.print("Input number again? (Y/N): ");
                                        String retry = input.nextLine().toUpperCase(); // which type letter, use input
                                                                                       // goes a capital

                                        if (retry.equals("Y"))
                                            continue;
                                        else
                                            break;
                                    }

                                    boolean valid = true; // check number
                                    for (int i = 0; i < decRomInput.length(); i++) { // loop runs through every letter
                                        char c = decRomInput.charAt(i);
                                        if (c < '0' || c > '9') { // check ch is a digit
                                            valid = false;
                                            break;
                                        }
                                    }

                                    if (!valid) { // not a number
                                        System.out.println("invalid input...");
                                        System.out.print("Input number again? (Y/N): ");
                                        String retry = input.nextLine().toUpperCase();
                                        if (retry.equals("Y"))
                                            continue; // if yes goes to top, not end it
                                        else
                                            break;
                                    }

                                    int num = Integer.parseInt(decRomInput); // read the string and return number
                                    int temp = num; // working copy so num stays unchanged for printing later

                                    StringBuilder romanResult = new StringBuilder(); // builds the Roman numeral piece
                                                                                     // by piece

                                    // handle thousands
                                    while (temp >= 1000) {
                                        romanResult.append("M");
                                        temp -= 1000;
                                    }

                                    // handle hundreds (900, 500, 400, 100)
                                    while (temp >= 900) {
                                        romanResult.append("CM");
                                        temp -= 900;
                                    }
                                    while (temp >= 500) {
                                        romanResult.append("D");
                                        temp -= 500;
                                    }
                                    while (temp >= 400) {
                                        romanResult.append("CD");
                                        temp -= 400;
                                    }
                                    while (temp >= 100) {
                                        romanResult.append("C");
                                        temp -= 100;
                                    }

                                    // handle tens (90, 50, 40, 10)
                                    while (temp >= 90) {
                                        romanResult.append("XC");
                                        temp -= 90;
                                    }
                                    while (temp >= 50) {
                                        romanResult.append("L");
                                        temp -= 50;
                                    }
                                    while (temp >= 40) {
                                        romanResult.append("XL");
                                        temp -= 40;
                                    }
                                    while (temp >= 10) {
                                        romanResult.append("X");
                                        temp -= 10;
                                    }

                                    // handle units (9, 5, 4, 1)
                                    while (temp >= 9) {
                                        romanResult.append("IX");
                                        temp -= 9;
                                    }
                                    while (temp >= 5) {
                                        romanResult.append("V");
                                        temp -= 5;
                                    }
                                    while (temp >= 4) {
                                        romanResult.append("IV");
                                        temp -= 4;
                                    }
                                    while (temp >= 1) {
                                        romanResult.append("I");
                                        temp -= 1;
                                    }

                                    System.out.println("Decimal: " + num);
                                    System.out.println("Roman: " + romanResult.toString()); // convert number into Roman

                                    System.out.print("Do you want to go to homepage? (Y/N): "); // redirecting to top
                                    String goHome = input.nextLine().trim().toUpperCase();
                                    if (goHome.equals("Y")) {
                                        break; // go back to the homepage
                                    } else {
                                        input.close();
                                        return;
                                    }
                                }
                                break; // exits the switch(x) case, prevents fall-through into case 2
                            }
                            case 2: {
                                while (true) {

                                   
                        System.out.println("+----------------------------------------------------------------------------");
                        System.out.println("|                         Roman -----> Decimal Converter                    |");
                        System.out.println("+----------------------------------------------------------------------------");


                                    System.out.print("Enter a Roman number: ");
                                    String romanInput = input.nextLine().toUpperCase(); // need a string, if not cannot

                                    if (romanInput.isEmpty()) {
                                        System.out.println("invalid input...");
                                        System.out.print("Input number again? (Y/N): ");
                                        String retry = input.nextLine().toUpperCase();
                                        if (retry.equals("Y"))
                                            continue;
                                        else
                                            break;
                                    }

                                    boolean valid = true; // check number
                                    for (int i = 0; i < romanInput.length(); i++) { // loop runs through every letter
                                        char c = romanInput.charAt(i);
                                        // check ch is a valid Roman numeral letter
                                        if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D'
                                                && c != 'M') {
                                            valid = false;
                                            break;
                                        }
                                    }

                                    if (!valid) { // not a valid Roman numeral
                                        System.out.println("invalid input...");
                                        System.out.print("Input number again? (Y/N): ");
                                        String retry = input.nextLine().toUpperCase();
                                        if (retry.equals("Y"))
                                            continue; // if yes goes to top, not end it
                                        else
                                            break;
                                    }

                                    int result = 0;
                                    int prevValue = 0; // value of the symbol read just before this one (to the right)
                                    // read right to left: if current symbol is smaller than the one after it,
                                    // subtract; otherwise add
                                    for (int i = romanInput.length() - 1; i >= 0; i--) {
                                        char c = romanInput.charAt(i);
                                        int curValue = 0;
                                        switch (c) { // convert each Roman letter to its numeric value
                                            case 'I':
                                                curValue = 1;
                                                break;
                                            case 'V':
                                                curValue = 5;
                                                break;
                                            case 'X':
                                                curValue = 10;
                                                break;
                                            case 'L':
                                                curValue = 50;
                                                break;
                                            case 'C':
                                                curValue = 100;
                                                break;
                                            case 'D':
                                                curValue = 500;
                                                break;
                                            case 'M':
                                                curValue = 1000;
                                                break;
                                        }
                                        if (curValue < prevValue) {
                                            result -= curValue; // smaller value before a bigger one means subtract
                                                                // (e.g. IV = 4)
                                        } else {
                                            result += curValue; // otherwise just add it normally
                                        }
                                        prevValue = curValue; // remember this value for the next comparison
                                    }

                                    System.out.println("Roman: " + romanInput);
                                    System.out.println("Decimal: " + result); // convert Roman numeral into number

                                    System.out.print("Do you want to go to homepage? (Y/N): "); // redirecting to top
                                    String goHome = input.nextLine().trim().toUpperCase();
                                    if (goHome.equals("Y")) {
                                        break; // go back to the homepage
                                    } else {
                                        input.close();
                                        return;
                                    }
                                }
                                break; // exits the switch(x) case, prevents fall-through into default
                            }
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                        break; // exits the outer while(true) — currently runs once, no retry loop back to the
                               // Roman menu
                    }
                    break; // exits case 5, prevents fall-through into case 6
                }
                case 0:
                    System.out.println("Exiting...");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}




    
 
