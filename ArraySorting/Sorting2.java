import java.util.*;

public class Sorting2 {

    // Array to store student IDs
    public static String[] id = {"S001", "S002", "S003", "S004", "S005", "S006", "S007"};

    // Array to store marks of each student (corresponding to the ID array)
    public static int[] marks = {50, 20, 90, 100, 30, 80, 45};


    // This method sorts students by marks in descending order (highest first)
    // and prints the result as a table
    public static void bestInMarks() {

        // Get the total number of students (length of the marks array)
        int length = marks.length;

        // Create temporary arrays to hold copies of the data
        // We use copies so the original arrays are not changed
        int[] tempMark = new int[length];
        String[] tempId = new String[length];

        // Copy marks and IDs from the original arrays into the temporary arrays
        for (int i = 0; i < length; i++) {
            tempMark[i] = marks[i];   // copy each mark
            tempId[i] = id[i];         // copy each student ID
        }

        // Bubble Sort algorithm to sort marks from highest to lowest
        // The outer loop goes from the last index down to 1
        for (int i = tempMark.length - 1; i > 0; i--) {

            // The inner loop compares each pair of neighboring marks
            // If the current mark is smaller than the next, swap them
            for (int j = 0; j < i; j++) {

                // If current mark is less than next mark, swap them (descending order)
                if (tempMark[j] < tempMark[j + 1]) {

                    // Swap marks: move the bigger mark to the left
                    int temp = tempMark[j];
                    tempMark[j] = tempMark[j + 1];
                    tempMark[j + 1] = temp;

                    // Swap student IDs along with the marks to keep them matched
                    String tempStId = tempId[j];
                    tempId[j] = tempId[j + 1];
                    tempId[j + 1] = tempStId;
                }
            }
        }

        // Print the table header
        System.out.println("StID\tMarks");
        System.out.println("==============");

        // Print each student ID and their sorted mark
        for (int i = 0; i < tempMark.length; i++) {
            System.out.println(tempId[i] + "\t" + tempMark[i]);
        }
    }

    // The main method - program starts here
    public static void main(String args[]) {
        // Call the bestInMarks method to sort and display results
        bestInMarks();
    }
}
