import java.util.Scanner;
import java.util.*;
public class EX_1 {                                        // class name must match filename
    public static void main(String[] args) {               // entry point of the program
        try (Scanner input = new Scanner(System.in)) {     // try-with-resources: create Scanner to read keyboard input
            while (true) {                                 // loop forever until user says no
                System.out.print("Enter decimal number: ");    // prompt user
                String biIN = input.nextLine();                // read the input line as a String
                if (!biIN.matches("\\d+")) {                   // validate: only digits allowed
                    System.out.println("Invalid Number");      // print error for bad input
                    if (!input.nextLine().trim().equalsIgnoreCase("Y")) break; // if not "Y", exit loop
                    continue;                                  // if "Y", go back to the prompt
                }                                              // end of validation block
                int dec = Integer.parseInt(biIN);              // convert String to decimal int
                System.out.println("Binary: " + Integer.toBinaryString(dec));                     // print binary
                break; // exit loop if not "Y"
            }                                                  // end of while loop
        }                                                      // close Scanner automatically
    }                                                      // end of main method
}                                                          // end of class