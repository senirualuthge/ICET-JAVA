import java.util.Scanner;
import java.util.*;
// =======================================================================
// IMPORT STATEMENTS
// =======================================================================
// Imports all classes from java.util package (Scanner, String, Math, etc.)

// =======================================================================
// MAIN CLASS DEFINITION
// =======================================================================
// Defines the main class that contains all the program logic
// Class name matches the file name for compilation
class StudentManagementSystem_Commented {

    // ===================================================================
    // BATCH STATUS CONSTANTS
    // ===================================================================
    // Constant for open enrollment status (value = 1)
    public static final int ENROLLMENTOPEN = 1;
    // Constant for closed enrollment status (value = 0)
    public static final int ENROLLMENTCLOSED = 0;

    // ===================================================================
    // BATCH DATA ARRAYS
    // ===================================================================
    // Array storing batch numbers (105, 106, 107, 108, 109, 110)
    public static int[] batchNameArray = { 105, 106, 107, 108, 109, 110 };
    // Array storing enrollment status for each batch (0=closed, 1=open)
    public static int[] batchStatusArray = { 0, 0, 0, 0, 1, 1 };
    // Array storing student count per batch (computed in static block)
    public static int[] batchStudentCountArray;
    // Total number of batches (calculated from batchNameArray length)
    public static int batchCount = batchNameArray.length;

    // ===================================================================
    // STUDENT DATA ARRAYS (Parallel Arrays)
    // ===================================================================
    // Array storing registration numbers for all 150 students
    // Format: PR24105001 (PR=Physical, OR=Online, 24=Year, 105=Batch, 001=Student#)
    public static String[] regNoArray = {
            "PR24105001", "PR24105002", "PR24105003", "PR24105004", "PR24105005",
            "PR24105006", "PR24105007", "PR24105008", "PR24105009", "PR24105010",
            "OR24105011", "OR24105012", "OR24105013", "OR24105014", "OR24105015",
            "PR24105016", "PR24105017", "PR24105018", "OR24105019", "OR24105020",
            "PR24105021", "PR24105022", "OR24105023", "OR24105024", "PR24105025",
            "PR24106001", "PR24106002", "PR24106003", "PR24106004", "PR24106005",
            "PR24106006", "PR24106007", "PR24106008", "PR24106009", "PR24106010",
            "OR24106011", "OR24106012", "OR24106013", "OR24106014", "OR24106015",
            "PR24106016", "PR24106017", "PR24106018", "OR24106019", "OR24106020",
            "PR24106021", "PR24106022", "OR24106023", "OR24106024", "PR24106025",
            "PR24107001", "PR24107002", "PR24107003", "PR24107004", "PR24107005",
            "PR24107006", "PR24107007", "PR24107008", "PR24107009", "PR24107010",
            "OR24107011", "OR24107012", "OR24107013", "OR24107014", "OR24107015",
            "PR24107016", "PR24107017", "PR24107018", "OR24107019", "OR24107020",
            "PR24107021", "PR24107022", "OR24107023", "OR24107024", "PR24107025",
            "PR24108001", "PR24108002", "PR24108003", "PR24108004", "PR24108005",
            "PR24108006", "PR24108007", "PR24108008", "PR24108009", "PR24108010",
            "OR24108011", "OR24108012", "OR24108013", "OR24108014", "OR24108015",
            "PR24108016", "PR24108017", "PR24108018", "OR24108019", "OR24108020",
            "PR24108021", "PR24108022", "OR24108023", "OR24108024", "PR24108025",
            "PR24109001", "PR24109002", "PR24109003", "PR24109004", "PR24109005",
            "PR24109006", "PR24109007", "PR24109008", "PR24109009", "PR24109010",
            "OR24109011", "OR24109012", "OR24109013", "OR24109014", "OR24109015",
            "PR24109016", "PR24109017", "PR24109018", "OR24109019", "OR24109020",
            "PR24109021", "PR24109022", "OR24109023", "OR24109024", "PR24109025",
            "PR24110001", "PR24110002", "PR24110003", "PR24110004", "PR24110005",
            "PR24110006", "PR24110007", "PR24110008", "PR24110009", "PR24110010",
            "OR24110011", "OR24110012", "OR24110013", "OR24110014", "OR24110015",
            "PR24110016", "PR24110017", "PR24110018", "OR24110019", "OR24110020",
            "PR24110021", "PR24110022", "OR24110023", "OR24110024", "PR24110025"
    };

    // Array storing NIC (National Identity Card) numbers for all students
    public static String[] nicArray = {
            "199501012345", "199503153872", "199506202198", "199509102983", "199511258739",
            "199512303498", "199502183764", "199504223198", "199508153210", "199510293417",
            "199601102375", "199604182938", "199606243879", "199608142178", "199610312475",
            "199611173452", "199603293481", "199605083217", "199607232198", "199609192375",
            "199701212483", "199703132487", "199706253478", "199708083298", "199710243651",
            "199712152983", "199702182734", "199704293187", "199705142375", "199709083751",
            "199801032874", "199803232871", "199806193428", "199808013764", "199810242374",
            "199812302984", "199802152348", "199805213471", "199807172398", "199811283472",
            "199901122471", "199903052984", "199906213874", "199908093412", "199910273894",
            "199912153482", "199902202394", "199904163874", "199907293481", "199911083479",
            "200001112374", "200003143478", "200006293874", "200008103471", "200010252984",
            "200012043894", "200002193874", "200004212374", "200005183492", "200007153871",
            "200101232984", "200103083471", "200106273894", "200108123984", "200110043728",
            "200112213874", "200102253471", "200104103874", "200105293784", "200107202983",
            "200201013874", "200203253471", "200206143874", "200208083471", "200210293874",
            "200212183471", "200202103874", "200204123894", "200205283471", "200207153874",
            "200301093874", "200303283471", "200306153874", "200308123471", "200310083874",
            "200312243471", "200302273874", "200304203471", "200305123874", "200307213471",
            "200401153874", "200403123471", "200406293874", "200408083471", "200410213874",
            "200412153471", "200402203874", "200404273471", "200405143874", "200407183471",
            "200501023874", "200503193471", "200506153874", "200508213471", "200510083874",
            "200512293471", "200502123874", "200504153471", "200505283874", "200507173471"
            ,"200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678"
    };

    // Array storing student names (First Name + Last Name format)
    public static String[] nameArray = {
            "Gunawardena Weerasinghe", "Senanayake Silva", "Silva Kumara", "Kumara Herath", "Rathnayake Herath",
            "Wijesinghe Bandara", "Rajapaksha Herath", "Senanayake Karunaratne", "Karunaratne Jayasinghe",
            "Gunawardena Silva",
            "Weerasinghe Rajapaksha", "Silva Rathnayake", "Fernando Perera", "Kumara Abeysekera",
            "Ekanayake Rathnayake",
            "Herath Gunawardena", "Abeysekera Silva", "Weerasinghe Silva", "Jayasinghe Dias", "Bandara Rathnayake",
            "Silva Perera", "De Silva Dias", "Abeysekera Jayasinghe", "Rajapaksha Senanayake", "Kumara Karunaratne",
            "Silva Abeysekera", "Jayasinghe Bandara", "Rathnayake Kumara", "Weerasinghe Rajapaksha",
            "Senanayake Herath",
            "Perera Ekanayake", "Herath Jayasinghe", "Kumara Gunawardena", "Abeysekera Silva", "Dias Fernando",
            "Karunaratne Weerasinghe", "Ekanayake Bandara", "Rajapaksha Kumara", "Silva De Silva",
            "Gunawardena Rathnayake",
            "Bandara Karunaratne", "Fernando Perera", "De Silva Silva", "Rajapaksha Gunawardena", "Herath Weerasinghe",
            "Karunaratne Dias", "Jayasinghe Silva", "Senanayake Abeysekera", "Silva Jayasinghe", "Rathnayake Kumara",
            "Gunawardena Kumara", "Rajapaksha Silva", "Perera Jayasinghe", "Silva Ekanayake", "Dias Senanayake",
            "Herath Abeysekera", "Rathnayake Fernando", "Kumara Herath", "Weerasinghe Silva", "Senanayake Karunaratne",
            "Abeysekera Silva", "Bandara Gunawardena", "Karunaratne Weerasinghe", "Perera Herath", "Fernando Dias",
            "Weerasinghe Gunawardena", "Rathnayake Kumara", "Senanayake Fernando", "Silva Bandara", "Herath Rajapaksha",
            "Kumara Jayasinghe", "Abeysekera Perera", "Rathnayake Jayasinghe", "Kumara Weerasinghe",
            "Rajapaksha Ekanayake",
            "Fernando Rajapaksha", "Silva Gunawardena", "Perera Wijesinghe", "Herath Abeysekera",
            "Rajapaksha Ekanayake",
            "Karunaratne Silva", "Weerasinghe Fernando", "Silva Bandara", "Abeysekera Weerasinghe",
            "Kumara Karunaratne",
            "Dias Rajapaksha", "Herath Perera", "Rathnayake Gunawardena", "Ekanayake Jayasinghe", "Gunawardena Silva",
            "Rajapaksha Perera", "Karunaratne Jayasinghe", "Weerasinghe Abeysekera", "Rathnayake Fernando",
            "Kumara Herath",
            "Silva Weerasinghe", "Herath Karunaratne", "Abeysekera Silva", "Gunawardena Ekanayake",
            "Weerasinghe Kumara",
            "Weerasinghe Kumara", "Rajapaksha Abeysekera", "Gunawardena Perera", "Karunaratne Silva",
            "Herath Wijesinghe",
            "Rathnayake Ekanayake", "Silva Fernando", "Abeysekera Rajapaksha", "Fernando Bandara", "Perera Herath",
            "Weerasinghe Jayasinghe", "Silva Karunaratne", "Rathnayake Gunawardena", "Herath Kumara",
            "Abeysekera Silva",
            "Ekanayake Bandara", "Rajapaksha Fernando", "Gunawardena Weerasinghe", "Kumara Karunaratne", "Silva Dias",
            "Perera Weerasinghe", "Karunaratne Rajapaksha", "Jayasinghe Silva", "Rathnayake Perera", "Silva Ekanayake",
            "Silva Karunaratne", "Herath Fernando", "Kumara Jayasinghe", "Weerasinghe Perera", "Abeysekera Rajapaksha",
            "Rathnayake Karunaratne", "Ekanayake Bandara", "Gunawardena Perera", "Silva Wijesinghe",
            "Rajapaksha Jayasinghe",
            "Rathnayake Fernando", "Karunaratne Kumara", "Perera Silva", "Gunawardena Ekanayake", "Bandara Rajapaksha",
            "Silva Herath", "Rathnayake Weerasinghe", "Perera Gunawardena", "Herath Karunaratne", "Silva Rajapaksha",
            "Ekanayake Kumara", "Bandara Herath", "Weerasinghe Rajapaksha", "Karunaratne Abeysekera", "Perera Dias",
    };

    // Array storing PRF (Programming Fundamentals) marks for each student
    // Special values: -1 = Absent, -2 = Not conducted, 0-100 = actual marks
    public static int[] prfArray = {
            85, 39, -1, 72, 44,
            91, 60, 38, 95, 49,
            -1, 67, 23, 58, 88,
            81, 73, 29, 62, -1,
            79, 53, 94, 47, 35,
            93, 15, -1, 82, 45,
            88, 23, 79, 37, -1,
            68, 100, 59, 29, 92,
            12, 77, 38, 66, 9,
            84, 51, 32, -1, 97,
            95, -1, 63, 88, 32,
            76, 97, 54, -1, 23,
            90, 35, 81, 61, 44,
            67, 100, 17, 85, 29,
            70, 42, -1, 60, 86,
            86, 57, 91, 35, -1,
            76, 48, 94, 23, 69,
            -1, 80, 55, 88, 32,
            100, 67, 43, -1, 90,
            60, 77, 25, 71, 84,
            92, 68, 59, 85, 63,
            76, 91, 70, 84, 63,
            72, 89, 45, 81, 77,
            68, 63, 88, 75, 90,
            57, 79, 92, 62, 100,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2

    };

    // Array storing DBMS (Database Management System) marks for each student
    // Same special values as prfArray: -1, -2, 0-100
    public static int[] dbmsArray = {
            66, 45, 93, 58, -1,
            37, 88, 21, 79, 40,
            76, 54, -1, 69, 92,
            25, 84, 33, 60, 71,
            59, -1, 98, 27, 48,
            35, 91, 60, -1, 72,
            49, 26, 80, 14, 89,
            67, -1, 31, 94, 53,
            78, 5, 90, 24, 86,
            39, -1, 61, 73, 100,
            38, 91, -1, 74, 55,
            82, 66, 49, 99, 13,
            80, 70, 93, 36, 59,
            85, 47, 90, -1, 22,
            77, 34, 63, 100, 29,
            79, 62, 87, -1, 54,
            46, 99, 39, 70, -1,
            75, 83, 58, 92, 30,
            91, 40, 63, 95, 68,
            -1, 66, 21, 88, 37,
            67, 91, 85, 73, 70,
            63, 76, 88, 55, 64,
            79, 80, 59, 92, 68,
            100, 77, 83, 45, 62,
            66, 59, 78, 85, 56,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2
    };

    // Total number of students (calculated from regNoArray length = 150)
    public static int studentCount = regNoArray.length;

    // ===================================================================
    // STATIC INITIALIZER BLOCK
    // ===================================================================
    // This block runs ONCE when the class is first loaded
    // It computes how many students belong to each batch
    static {
        // Create array to hold student count for each batch
        batchStudentCountArray = new int[batchNameArray.length];
        // Loop through all students
        for (int i = 0; i < studentCount; i++) {
            // Extract batch number from registration number (positions 4-6, e.g., "105")
            int batchNo = Integer.parseInt(regNoArray[i].substring(4, 7));
            // Find which batch index this batch number corresponds to
            for (int j = 0; j < batchNameArray.length; j++) {
                // If batch number matches, increment that batch's student count
                if (batchNameArray[j] == batchNo) {
                    batchStudentCountArray[j]++;
                    break; // Stop searching once found
                }
            }
        }
    }

    // ===================================================================
    // SCANNER OBJECT FOR USER INPUT
    // ===================================================================
    // Shared Scanner object to read user input from console (System.in)
    public static Scanner input = new Scanner(System.in);

    // ===================================================================
    // CLEAR CONSOLE METHOD
    // ===================================================================
    // Clears the terminal screen for a cleaner UI experience
    public final static void clearConsole() {
        try {
            // Get the operating system name
            final String os = System.getProperty("os.name");
            // If Windows, use 'cls' command to clear screen
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Mac/Linux, use ANSI escape codes to clear screen
                // \033[H = move cursor to top-left, \033[2J = clear entire screen
                System.out.print("\033[H\033[2J");
                System.out.flush(); // Force the output to display immediately
            }
        } catch (final Exception e) {
            // Print stack trace if clearing fails (non-critical error)
            e.printStackTrace();
        }
    }

    // ===================================================================
    // EXIT METHOD
    // ===================================================================
    // Gracefully exits the program with a farewell message
    public static void exit() {
        clearConsole(); // Clear screen first
        System.out.println("\n\t\tYou left the program...\n"); // Display exit message
        System.exit(0); // Terminate the program with success status (0)
    }

    // ===================================================================
    // INPUT VALIDATION HELPERS
    // ===================================================================

    // Reads and validates an integer from user input
    // Keeps asking until user enters a valid integer
    public static int getValidInt(String prompt) {
        while (true) { // Infinite loop until valid input received
            System.out.print(prompt); // Display the prompt message
            if (input.hasNextInt()) { // Check if next input is a valid integer
                int value = input.nextInt(); // Read the integer
                input.nextLine(); // Consume the remaining newline character
                return value; // Return the valid integer
            }
            System.out.println("Please enter a valid integer."); // Error message for non-integer
            input.nextLine(); // Discard the invalid input
        }
    }

    // Reads and validates an integer within a specific range (min to max)
    // Uses getValidInt() first, then checks range
    public static int getValidInt(String prompt, int min, int max) {
        while (true) { // Keep asking until valid input in range
            int value = getValidInt(prompt); // Get valid integer first
            if (value >= min && value <= max) { // Check if within allowed range
                return value; // Return if valid
            }
            System.out.println("Please enter a number between " + min + " and " + max + "."); // Range error
        }
    }

    // Reads a non-empty string from user input
    // Trims whitespace and rejects empty strings
    public static String getValidString(String prompt) {
        while (true) { // Keep asking until non-empty input
            System.out.print(prompt); // Display prompt
            String s = input.nextLine().trim(); // Read line and remove leading/trailing spaces
            if (!s.isEmpty()) { // Check if string is not empty
                return s; // Return the valid non-empty string
            }
            System.out.println("Input cannot be empty."); // Error for empty input
        }
    }

    // Reads Y or N (Yes/No) from user, case-insensitive
    // Converts input to uppercase and validates
    public static String getYesNo(String prompt) {
        while (true) { // Keep asking until Y or N entered
            System.out.print(prompt); // Display prompt
            String ans = input.nextLine().trim().toUpperCase(); // Read, trim, convert to uppercase
            if (ans.equals("Y") || ans.equals("N")) { // Check for valid Y or N
                return ans; // Return the uppercase answer
            }
            System.out.println("Please enter Y or N."); // Error for invalid input
        }
    }

    // Reads marks from user: must be -1 (absent) or 0-100 (valid marks)
    public static int getValidMarks(String prompt) {
        while (true) { // Keep asking until valid marks entered
            int value = getValidInt(prompt); // Get valid integer first
            if (value == -1 || (value >= 0 && value <= 100)) { // Check valid marks range
                return value; // Return valid marks
            }
            System.out.println("Marks must be -1 (absent) or between 0 and 100."); // Marks error
        }
    }

    // ===================================================================
    // UI DISPLAY HELPERS
    // ===================================================================

    // Prints a formatted header with title centered between two lines
    public static void printHeader(String title) {
        // Print top border line (79 dashes)
        System.out.println("-----------------------------------------------------------------------------");
        // Calculate padding to center the title (total width 79 minus title length)
        int pad = (79 - title.length()) / 2;
        // Build a string of spaces for centering
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pad; i++) sb.append(" "); // Append pad number of spaces
        // Print the title centered with a leading pipe character
        System.out.println("|" + sb.toString() + title);
        // Print bottom border line with two newlines
        System.out.println("-----------------------------------------------------------------------------\n");
    }

    // ===================================================================
    // ARRAY GROWTH HELPERS
    // ===================================================================
    // These methods double the size of arrays when capacity is reached
    // (Java arrays are fixed-size, so we must create larger ones and copy)

    // Doubles the size of a String array (or creates size 1 if empty)
    public static String[] growStringArray(String[] arr) {
        // Create new array: double size, or 1 if original was empty
        String[] bigger = new String[arr.length == 0 ? 1 : arr.length * 2];
        // Copy all elements from old array to new array
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i]; // Copy element at index i
        }
        return bigger; // Return the larger array
    }

    // Doubles the size of an int array (or creates size 1 if empty)
    public static int[] growIntArray(int[] arr) {
        // Create new array: double size, or 1 if original was empty
        int[] bigger = new int[arr.length == 0 ? 1 : arr.length * 2];
        // Copy all elements from old array to new array
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i]; // Copy element at index i
        }
        return bigger; // Return the larger array
    }

    // ===================================================================
    // LOOKUP / SEARCH HELPERS
    // ===================================================================

    // Searches for a batch by its batch number and returns its index
    // Returns -1 if not found
    public static int findBatchIndex(int batchNo) {
        for (int i = 0; i < batchCount; i++) { // Loop through all batches
            if (batchNameArray[i] == batchNo) { // Check if batch number matches
                return i; // Return the index where found
            }
        }
        return -1; // Return -1 if batch not found
    }

    // Searches for a student by registration number (case-insensitive)
    // Returns the index of the student, or -1 if not found
    public static int findStudentIndex(String regNo) {
        for (int i = 0; i < studentCount; i++) { // Loop through all students
            if (regNoArray[i].equalsIgnoreCase(regNo)) { // Compare ignoring case
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if student not found
    }

    // Searches for a student by NIC number (case-sensitive)
    // Returns the index of the student, or -1 if not found
    public static int findStudentIndexByNIC(String nic) {
        for (int i = 0; i < studentCount; i++) { // Loop through all students
            if (nicArray[i].equals(nic)) { // Compare NIC exactly
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Finds the next available student number for a given batch
    // Looks at all existing students in the batch and finds the highest number + 1
    public static int getNextStudentNo(int batchNo) {
        int max = 0; // Track the highest student number found
        for (int i = 0; i < studentCount; i++) { // Loop through all students
            // Extract batch number from registration number (positions 4-6)
            int b = Integer.parseInt(regNoArray[i].substring(4, 7));
            if (b == batchNo) { // If student belongs to this batch
                // Extract student number from registration number (positions 7-9)
                int studentNo = Integer.parseInt(regNoArray[i].substring(7, 10));
                if (studentNo > max) { // If this is the highest number so far
                    max = studentNo; // Update max
                }
            }
        }
        return max + 1; // Return next available number (max + 1)
    }

    // ===================================================================
    // RECORD ADD / REMOVE OPERATIONS
    // ===================================================================

    // Adds a new student record to all parallel arrays
    // Grows arrays if needed (when full)
    public static void addStudentRecord(String regNo, String nic, String name, int prf, int dbms) {
        // Check if arrays are full - if so, double their size
        if (studentCount == regNoArray.length) {
            regNoArray = growStringArray(regNoArray);     // Grow regNo array
            nicArray = growStringArray(nicArray);          // Grow NIC array
            nameArray = growStringArray(nameArray);        // Grow name array
            prfArray = growIntArray(prfArray);             // Grow PRF marks array
            dbmsArray = growIntArray(dbmsArray);           // Grow DBMS marks array
        }
        // Add the new student data at the next available position
        regNoArray[studentCount] = regNo;   // Set registration number
        nicArray[studentCount] = nic;        // Set NIC
        nameArray[studentCount] = name;      // Set name
        prfArray[studentCount] = prf;        // Set PRF marks
        dbmsArray[studentCount] = dbms;      // Set DBMS marks
        studentCount++;                      // Increment total student count
    }

    // Removes a student record at the specified index
    // Shifts all subsequent elements left by one position
    public static void removeStudentAt(int idx) {
        // Shift elements left to fill the gap
        for (int i = idx; i < studentCount - 1; i++) {
            regNoArray[i] = regNoArray[i + 1];   // Shift regNo left
            nicArray[i] = nicArray[i + 1];        // Shift NIC left
            nameArray[i] = nameArray[i + 1];      // Shift name left
            prfArray[i] = prfArray[i + 1];        // Shift PRF marks left
            dbmsArray[i] = dbmsArray[i + 1];      // Shift DBMS marks left
        }
        studentCount--; // Decrease total student count
    }

    // Adds a new batch record to batch arrays
    // Sets enrollment to OPEN by default and student count to 0
    public static void addBatchRecord(int batchNo) {
        // Grow batch arrays if needed
        if (batchCount == batchNameArray.length) {
            batchNameArray = growIntArray(batchNameArray);           // Grow batch name array
            batchStatusArray = growIntArray(batchStatusArray);      // Grow batch status array
            batchStudentCountArray = growIntArray(batchStudentCountArray); // Grow student count array
        }
        batchNameArray[batchCount] = batchNo;                      // Set batch number
        batchStatusArray[batchCount] = ENROLLMENTOPEN;             // Default to OPEN
        batchStudentCountArray[batchCount] = 0;                    // Start with 0 students
        batchCount++;                                               // Increment batch count
    }

    // ===================================================================
    // GPA CALCULATION
    // ===================================================================

    // Converts marks (0-100) to GPA on a 4.25 scale
    // Uses a grade boundary system
    public static double marksToGPA(int marks) {
        if (marks == -1 || marks == -2) return 0.0;  // Absent or Not conducted = 0.0 GPA
        if (marks >= 90) return 4.25;  // 90-100 = 4.25 GPA
        if (marks >= 80) return 4.00;  // 80-89  = 4.00 GPA
        if (marks >= 75) return 3.70;  // 75-79  = 3.70 GPA
        if (marks >= 70) return 3.30;  // 70-74  = 3.30 GPA
        if (marks >= 65) return 3.00;  // 65-69  = 3.00 GPA
        if (marks >= 60) return 2.70;  // 60-64  = 2.70 GPA
        if (marks >= 55) return 2.30;  // 55-59  = 2.30 GPA
        if (marks >= 50) return 2.00;  // 50-54  = 2.00 GPA
        if (marks >= 45) return 1.70;  // 45-49  = 1.70 GPA
        if (marks >= 40) return 1.30;  // 40-44  = 1.30 GPA
        if (marks >= 30) return 1.00;  // 30-39  = 1.00 GPA
        if (marks >= 20) return 0.70;  // 20-29  = 0.70 GPA
        return 0.0;                     // Below 20 = 0.0 GPA
    }

    // Computes overall GPA by averaging PRF and DBMS GPAs
    public static double computeGPA(int prf, int dbms) {
        // Average of both module GPAs
        return (marksToGPA(prf) + marksToGPA(dbms)) / 2.0;
    }

    // Converts marks integer to display string
    // Shows "Absent", "Not conducted", or the actual number
    public static String marksDisplay(int marks) {
        if (marks == -1) return "Absent";        // -1 = Absent from exam
        if (marks == -2) return "Not conducted"; // -2 = Exam not conducted
        return String.valueOf(marks);             // Otherwise return the marks as string
    }

    // Displays a student's full profile to the console
    public static void displayStudentProfile(int idx) {
        double gpa = computeGPA(prfArray[idx], dbmsArray[idx]); // Calculate GPA first
        System.out.println("\n\tRegistration no\t\t: " + regNoArray[idx]); // Print reg no
        System.out.println("\tStudet Name\t\t: " + nameArray[idx]);        // Print name
        System.out.println("\tStudet NIC\t\t: " + nicArray[idx]);          // Print NIC
        System.out.println("\tStudet PRF Marks\t: " + marksDisplay(prfArray[idx]));  // Print PRF
        System.out.println("\tStudet DBMS Marks\t: " + marksDisplay(dbmsArray[idx])); // Print DBMS
        System.out.println("\tStudet GPA\t\t: " + gpa);                    // Print GPA
    }

    // ===================================================================
    // HOME PAGE (Main Menu)
    // ===================================================================
    // Displays the main menu and handles navigation to sub-menus
    public static void homePage() {
        do { // Infinite loop - keeps showing menu until Exit (5) is selected
            printHeader("iCET Student Management System"); // Display header
            System.out.println("[1] Student Management");  // Option 1
            System.out.println("\n[2] Batch Management ");  // Option 2
            System.out.println("\n[3] Grade Management");   // Option 3
            System.out.println("\n[4] Report Generator");   // Option 4
            System.out.println("\n[5] Exit");               // Option 5

            // Read user choice (validated between 1-5)
            int option = getValidInt("\n\nEnter an option to continue > ", 1, 5);

            // Handle menu selection with switch statement
            switch (option) {
                case 1: // Student Management selected
                    clearConsole();          // Clear screen first
                    studentManagement();     // Go to Student Management menu
                    break;                   // Exit this case
                case 2: // Batch Management selected
                    clearConsole();
                    batchManagement();       // Go to Batch Management menu
                    break;
                case 3: // Grade Management selected
                    clearConsole();
                    gradeManagement();       // Go to Grade Management menu
                    break;
                case 4: // Report Generator selected
                    clearConsole();
                    reportGenerator();       // Go to Report Generator menu
                    break;
                case 5: // Exit selected
                    clearConsole();
                    exit();                  // Exit the program
                    break;
            }
        } while (true); // Loop forever (exit() terminates program)
    }

    // ===================================================================
    // STUDENT MANAGEMENT MENU
    // ===================================================================
    // Handles student CRUD operations (Create, Read, Update, Delete)
    public static void studentManagement() {
        boolean back = false; // Flag to control when to return to home page

        do { // Loop until user selects Exit (5)
            printHeader("Student Management");    // Display header
            System.out.println("[1] Add Student");            // Option 1
            System.out.println("\n[2] Update Student ");      // Option 2
            System.out.println("\n[3] View Student Profile"); // Option 3
            System.out.println("\n[4] Delete Student Profile");// Option 4
            System.out.println("\n[5] Exit");                 // Option 5

            // Read user choice (validated between 1-5)
            int Stmoption = getValidInt("\n\nEnter an option to continue > ", 1, 5);

            // Handle student management options
            switch (Stmoption) {
                case 1: // Add Student
                    clearConsole();
                    AddStudent();         // Go to Add Student function
                    break;
                case 2: // Update Student
                    clearConsole();
                    UpdateStudent();      // Go to Update Student function
                    break;
                case 3: // View Student Profile
                    clearConsole();
                    ViewStudentProfile(); // Go to View Student Profile function
                    break;
                case 4: // Delete Student Profile
                    clearConsole();
                    DeleteStudentProfile(); // Go to Delete Student Profile function
                    break;
                case 5: // Exit (back to home)
                    back = true;          // Set flag to exit loop
                    clearConsole();
                    break;
            }

        } while (!back); // Continue loop until back = true
    }

    // ===================================================================
    // ADD STUDENT FUNCTION
    // ===================================================================
    // Allows adding a new student to the system
    public static void AddStudent() {
        boolean back = false; // Flag to control loop

        do { // Loop to allow adding multiple students
            printHeader("Add Student"); // Display header

            // Ask for batch number
            int batchNo = getValidInt("Enter Batch Number (Students should be added): ");
            // Find the batch in the system
            int bIdx = findBatchIndex(batchNo);

            // CHECK 1: Does this batch exist?
            if (bIdx == -1) {
                System.out.println("\n\tThis batch does not exist in the system.");
                // Ask if user wants to try another batch
                String ans = getYesNo("Do you want to add student to another Batch (Y/N): ");
                if (ans.equals("N")) back = true; // Exit if user says No
                clearConsole();
                continue; // Skip to next iteration (restart loop)
            }

            // CHECK 2: Is enrollment open for this batch?
            if (batchStatusArray[bIdx] == ENROLLMENTCLOSED) {
                System.out.println("\n\tStudents cannot be added to this batch because enrollment is closed.");
                String ans = getYesNo("Do you want to add student to another Batch (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            // Get student NIC
            String nic = getValidString("\nEnter Student NIC: ");
            // Check if student with this NIC already exists
            int sIdx = findStudentIndexByNIC(nic);

            // CHECK 3: Does student with this NIC already exist?
            if (sIdx != -1) {
                // Student already in system - show their profile
                System.out.println("\n\tThis student is already added to the system.");
                displayStudentProfile(sIdx);
            } else {
                // New student - collect remaining details
                String name = getValidString("\nEnter Student Name: "); // Get name
                // Get mode: 1=Physical, 0=Online
                int mode = getValidInt("\nEnter Lecturer Mode (1-PHYSICAL 0-ONLINE): ", 0, 1);
                // Set prefix based on mode (PR=Physical, OR=Online)
                String prefix = (mode == 1) ? "PR" : "OR";
                // Get next available student number for this batch
                int newStudentNo = getNextStudentNo(batchNo);
                // Build registration number: prefix + "24" + batch(3digits) + student#(3digits)
                String newRegNo = prefix + "24" + String.format("%03d", batchNo) + String.format("%03d", newStudentNo);

                // Add student to system with -2 marks (Not conducted)
                addStudentRecord(newRegNo, nic, name, -2, -2);
                // Increment batch student count
                batchStudentCountArray[bIdx]++;

                // Display success message with generated reg no
                System.out.println("\n\tStudent Registration No - " + newRegNo);
                System.out.println("Student was successfully added to the system.");
            }

            // Ask if user wants to add another student
            String again = getYesNo("\nDo you want to add another student (Y/N): ");
            if (again.equals("N")) back = true; // Exit if No
            clearConsole();
        } while (!back); // Loop until user chooses to stop
    }

    // ===================================================================
    // UPDATE STUDENT FUNCTION
    // ===================================================================
    // Allows updating student name or NIC
    public static void UpdateStudent() {
        boolean back = false;

        do {
            printHeader("Update Student"); // Display header

            // Get registration number from user
            String regNo = getValidString("Enter Student Registration No: ");
            // Find student in system
            int idx = findStudentIndex(regNo);

            // CHECK: Does student exist?
            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student details (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            // Display current student details
            System.out.println("\n\tStudet Name\t: " + nameArray[idx]);
            System.out.println("\tStudet NIC\t: " + nicArray[idx]);
            System.out.println("\nWhat do you want to update ?");
            System.out.println("\t(01) Student Name"); // Option 1
            System.out.println("\t(02) Student NIC");  // Option 2

            // Read update choice (1 or 2)
            int opt = getValidInt("\nEnter your option - ", 1, 2);

            if (opt == 1) { // UPDATE NAME
                System.out.println("\nStudent Name Update");
                System.out.println("====================");
                // Show current details
                System.out.println("Registration No\t\t: " + regNoArray[idx]);
                System.out.println("Student NIC\t\t: " + nicArray[idx]);
                System.out.println("Studet Current Name\t: " + nameArray[idx]);
                // Get new name
                String newName = getValidString("\nEnter student name to update - ");
                // Update the name in array
                nameArray[idx] = newName;
                System.out.println("\n\tStudent name updated successfully...");
            } else { // UPDATE NIC
                System.out.println("\nStudent NIC Update");
                System.out.println("====================");
                // Show current details
                System.out.println("Registration No\t\t: " + regNoArray[idx]);
                System.out.println("Student Name\t\t: " + nameArray[idx]);
                System.out.println("Student Current NIC\t: " + nicArray[idx]);
                // Get new NIC
                String newNic = getValidString("\nEnter student NIC to update - ");
                // Check if this NIC is already used by another student
                int dupIdx = findStudentIndexByNIC(newNic);
                if (dupIdx != -1 && dupIdx != idx) {
                    // Duplicate NIC found - reject update
                    System.out.println("\n\tThis student is already added to the system...");
                } else {
                    // No duplicate - update the NIC
                    nicArray[idx] = newNic;
                    System.out.println("\n\tStudent NIC updated successfully...");
                }
            }

            // Ask if user wants to update another student
            String again = getYesNo("\nDo you want to update another student details (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // VIEW STUDENT PROFILE FUNCTION
    // ===================================================================
    // Displays a student's complete profile
    public static void ViewStudentProfile() {
        boolean back = false;

        do {
            printHeader("View Student's Profile"); // Display header

            // Get registration number from user
            String regNo = getValidString("Enter Student Registration No: ");
            // Find student in system
            int idx = findStudentIndex(regNo);

            // CHECK: Does student exist?
            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system.");
            } else {
                // Display the student's full profile
                displayStudentProfile(idx);
            }

            // Ask if user wants to search another student
            String again = getYesNo("\nDo you want to search another student details (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // DELETE STUDENT PROFILE FUNCTION
    // ===================================================================
    // Deletes a student from the system with confirmation
    public static void DeleteStudentProfile() {
        boolean back = false;

        do {
            printHeader("Delete Student Profile"); // Display header

            // Get registration number from user
            String regNo = getValidString("Enter Student Registration No: ");
            // Find student in system
            int idx = findStudentIndex(regNo);

            // CHECK: Does student exist?
            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system.");
                String ans = getYesNo("Do you want to delete another student profile (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            // Show student profile before deletion
            displayStudentProfile(idx);
            // Ask for confirmation
            String confirm = getYesNo("\nDo you want to delete this student profile (Y/N): ");

            if (confirm.equals("Y")) {
                // Extract batch number from registration number
                int batchNo = Integer.parseInt(regNoArray[idx].substring(4, 7));
                // Find batch index
                int bIdx = findBatchIndex(batchNo);
                // Remove student from arrays
                removeStudentAt(idx);
                // Decrease batch student count if batch exists
                if (bIdx != -1) batchStudentCountArray[bIdx]--;
                System.out.println("\n\tStudent was successfully deleted from the system.");
            }

            // Ask if user wants to delete another student
            String again = getYesNo("\nDo you want to delete another student profile (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // BATCH MANAGEMENT MENU
    // ===================================================================
    // Handles batch CRUD operations
    public static void batchManagement() {
        boolean back = false;

        do {
            printHeader("Batch Management"); // Display header
            System.out.println("[1] Add Batch");       // Option 1
            System.out.println("\n[2] Update Batch "); // Option 2
            System.out.println("\n[3] View Batches");  // Option 3
            System.out.println("\n[4] Exit");          // Option 4

            // Read choice (validated 1-4)
            int Btoption = getValidInt("\n\nEnter an option to continue > ", 1, 4);

            // Handle batch management options
            switch (Btoption) {
                case 1: // Add Batch
                    clearConsole();
                    AddBatch();      // Go to Add Batch function
                    break;
                case 2: // Update Batch
                    clearConsole();
                    UpdateBatch();   // Go to Update Batch function
                    break;
                case 3: // View Batches
                    clearConsole();
                    ViewBatch();     // Go to View Batch function
                    break;
                case 4: // Exit (back to home)
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // ===================================================================
    // ADD BATCH FUNCTION
    // ===================================================================
    // Adds a new batch to the system
    public static void AddBatch() {
        boolean back = false;

        do {
            printHeader("Add Batch"); // Display header

            // Get batch number from user
            int batchNo = getValidInt("Enter Batch Number : ");
            // Check if batch already exists
            int idx = findBatchIndex(batchNo);

            if (idx != -1) {
                // Batch already exists
                System.out.println("\nBatch is already added to the system.");
            } else {
                // Add the new batch
                addBatchRecord(batchNo);
                System.out.println("\nBatch was successfully added to the system.");
            }

            // Ask if user wants to add another batch
            String again = getYesNo("Do you want to add another batch to the system (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // UPDATE BATCH FUNCTION
    // ===================================================================
    // Toggles batch enrollment status (OPEN <-> CLOSED)
    public static void UpdateBatch() {
        boolean back = false;

        do {
            printHeader("Update Batch"); // Display header

            // Get batch number from user
            int batchNo = getValidInt("Enter Batch Number : ");
            // Find batch in system
            int idx = findBatchIndex(batchNo);

            // CHECK: Does batch exist?
            if (idx == -1) {
                System.out.println("This batch does not exist in the system.");
                String ans = getYesNo("Do you want to update another batch details (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            // Get current status display string
            String currentStatus = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
            // Get opposite status name for confirmation message
            String newStatusName = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN";
            System.out.println("Current Status : " + currentStatus);

            // Ask user to confirm status change
            String confirm = getYesNo("\nDo you want to change the batch status to " + newStatusName + "(Y/N) ? ");
            if (confirm.equals("Y")) {
                // Toggle the status (0 becomes 1, 1 becomes 0)
                batchStatusArray[idx] = (batchStatusArray[idx] == ENROLLMENTOPEN) ? ENROLLMENTCLOSED : ENROLLMENTOPEN;
                System.out.println("\n\tBatch Status updated successfully...");
            }

            // Ask if user wants to update another batch
            String again = getYesNo("\nDo you want to update another batch details (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // VIEW BATCHES FUNCTION
    // ===================================================================
    // Displays all batches in a formatted table
    public static void ViewBatch() {
        boolean back = false;

        do {
            printHeader("View Batch"); // Display header
            // Print table header with column names
            System.out.printf("%-4s%-11s%-15s%-20s%n", "No", "Batch No", "Student Count", "Status");
            System.out.println("-------------------------------------------------------------");
            // Loop through all batches and print each row
            for (int i = 0; i < batchCount; i++) {
                // Get status string based on status value
                String status = (batchStatusArray[i] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
                // Print formatted row: number, batch no, student count, status
                System.out.printf("%-4d%-11d%-15d%-20s%n", i + 1, batchNameArray[i], batchStudentCountArray[i], status);
            }

            // Ask if user wants to go back to home page
            String again = getYesNo("\nDo you want to go to the home page (Y/N): ");
            if (again.equals("Y")) back = true; // Return to home page
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // GRADE MANAGEMENT MENU
    // ===================================================================
    // Handles PRF and DBMS marks updates
    public static void gradeManagement() {
        do { // Infinite loop until Exit (3) selected
            printHeader("Grade Management"); // Display header
            System.out.println("[1] PRF Marks Update");     // Option 1
            System.out.println("\n[2] DBMS Marks Update "); // Option 2
            System.out.println("\n[3] Exit");               // Option 3

            // Read choice (validated 1-3)
            int GRoption = getValidInt("\n\nEnter an option to continue > ", 1, 3);

            // Handle grade management options
            switch (GRoption) {
                case 1: // PRF Marks Update
                    clearConsole();
                    PRFMarksUpdate();    // Go to PRF update function
                    break;
                case 2: // DBMS Marks Update
                    clearConsole();
                    DBMSMarksUpdate();   // Go to DBMS update function
                    break;
                case 3: // Exit (back to home)
                    clearConsole();
                    return; // Return to home page
            }
        } while (true); // Loop forever (return exits the method)
    }

    // ===================================================================
    // PRF MARKS UPDATE FUNCTION
    // ===================================================================
    // Updates PRF marks for a student
    public static void PRFMarksUpdate() {
        boolean back = false;

        do {
            printHeader("PRF Marks Update"); // Display header

            // Get registration number from user
            String regNo = getValidString("Enter Student Registration No: ");
            // Find student in system
            int idx = findStudentIndex(regNo);

            // CHECK: Does student exist?
            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student PRF marks (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            // Display student details
            System.out.println("\n\tRegistration no\t: " + regNoArray[idx]);
            System.out.println("\tStudet Name\t: " + nameArray[idx]);
            System.out.println("\tStudet NIC\t: " + nicArray[idx]);

            int current = prfArray[idx]; // Get current PRF marks
            boolean proceed = true;       // Flag: should we proceed to update?

            // CHECK: What is the current marks status?
            if (current >= 0) {
                // Student already has marks - ask for confirmation
                System.out.println("\nThis student has already completed the PRF module.");
                System.out.println("\tPRF Marks : " + current);
                String upd = getYesNo("\nDo you want to update this student's PRF marks? ");
                proceed = upd.equals("Y"); // Only proceed if user confirms
            } else if (current == -1) {
                // Student was absent - inform user they can update
                System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it..");
            }
            // If current == -2 (not conducted), proceed silently without any message

            if (proceed) {
                // Get new marks from user
                int marks = getValidMarks("\tEnter PRF Marks : ");
                // Update the marks in array
                prfArray[idx] = marks;
                System.out.println("\n\tThis student PRF Marks updated successfully...");
            }

            // Ask if user wants to update another student's PRF marks
            String again = getYesNo("\nDo you want to update another student PRF marks (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // DBMS MARKS UPDATE FUNCTION
    // ===================================================================
    // Updates DBMS marks for a student (same logic as PRF)
    public static void DBMSMarksUpdate() {
        boolean back = false;

        do {
            printHeader("DBMS Marks Update"); // Display header

            // Get registration number from user
            String regNo = getValidString("Enter Student Registration No: ");
            // Find student in system
            int idx = findStudentIndex(regNo);

            // CHECK: Does student exist?
            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student DBMS marks (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            // Display student details
            System.out.println("\n\tRegistration no\t: " + regNoArray[idx]);
            System.out.println("\tStudet Name\t: " + nameArray[idx]);
            System.out.println("\tStudet NIC\t: " + nicArray[idx]);

            int current = dbmsArray[idx]; // Get current DBMS marks
            boolean proceed = true;

            // CHECK: What is the current marks status?
            if (current >= 0) {
                // Student already has marks - ask for confirmation
                System.out.println("\nThis student has already completed the DBMS module.");
                System.out.println("\tDBMS Marks : " + current);
                String upd = getYesNo("\nDo you want to update this student's DBMS marks? ");
                proceed = upd.equals("Y");
            } else if (current == -1) {
                // Student was absent - inform user
                System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it..");
            }

            if (proceed) {
                // Get new marks and update
                int marks = getValidMarks("\tEnter DBMS Marks : ");
                dbmsArray[idx] = marks;
                System.out.println("\n\tThis student DBMS Marks updated successfully...");
            }

            // Ask if user wants to update another student's DBMS marks
            String again = getYesNo("\nDo you want to update another student DBMS marks (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // REPORT GENERATOR MENU
    // ===================================================================
    // Generates various reports about students and batches
    public static void reportGenerator() {
        do { // Infinite loop until Exit (4) selected
            printHeader("Report Generator"); // Display header
            System.out.println("[1] Student Registration Report\n");        // Option 1
            System.out.println("[2] Batch-wise Student Report\n");          // Option 2
            System.out.println("[3] Industry Training Eligibility Report\n");// Option 3
            System.out.println("[4] Exit");                                 // Option 4

            // Read choice (validated 1-4)
            int Report = getValidInt("\n\nEnter an option to continue > ", 1, 4);

            // Handle report options
            switch (Report) {
                case 1: // Student Registration Report
                    clearConsole();
                    studentRegistrationReport(); // Generate registration report
                    break;
                case 2: // Batch-wise Student Report
                    clearConsole();
                    batchWiseStudentReport();    // Generate batch report
                    break;
                case 3: // Industry Training Eligibility Report
                    clearConsole();
                    industryTrainingEligibilityReport(); // Generate eligibility report
                    break;
                case 4: // Exit (back to home)
                    clearConsole();
                    return; // Return to home page
            }
        } while (true); // Loop forever (return exits the method)
    }

    // ===================================================================
    // REPORT DISPLAY HELPERS
    // ===================================================================

    // Prints the table header row for all reports
    public static void printReportHeader() {
        // Print column headers with specific widths using printf formatting
        System.out.printf("%-4s%-14s%-26s%-16s%-11s%-12s%-6s%n",
                "No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA");
        // Print separator line
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    // Prints a single row of student data in the report table
    public static void printReportRow(int no, int idx) {
        double gpa = computeGPA(prfArray[idx], dbmsArray[idx]); // Calculate GPA
        // Print formatted row with student data
        System.out.printf("%-4d%-14s%-26s%-16s%-11s%-12s%.2f%n",
                no, regNoArray[idx], nameArray[idx], nicArray[idx],
                marksDisplay(prfArray[idx]), marksDisplay(dbmsArray[idx]), gpa);
    }

    // ===================================================================
    // SORTING ALGORITHM
    // ===================================================================
    // Selection sort that creates an index array sorted by student name
    // This sorts indices without modifying the original arrays
    public static int[] sortedIndicesByName() {
        // Create an array of indices [0, 1, 2, ..., studentCount-1]
        int[] order = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            order[i] = i; // Initialize with sequential indices
        }
        // Selection sort algorithm
        for (int i = 0; i < order.length - 1; i++) {
            int minPos = i; // Assume current position has the minimum
            // Find the minimum element in remaining unsorted portion
            for (int j = i + 1; j < order.length; j++) {
                // Compare names alphabetically
                if (nameArray[order[j]].compareTo(nameArray[order[minPos]]) < 0) {
                    minPos = j; // Found a smaller name
                }
            }
            // Swap the minimum element with the current position
            int temp = order[i];       // Store current element
            order[i] = order[minPos];  // Put minimum at current position
            order[minPos] = temp;      // Put current at minimum's old position
        }
        return order; // Return the sorted index array
    }

    // ===================================================================
    // STUDENT REGISTRATION REPORT
    // ===================================================================
    // Shows all students sorted alphabetically by name
    public static void studentRegistrationReport() {
        boolean back = false;

        do {
            printHeader("Student Registration Report"); // Display header
            int[] order = sortedIndicesByName();         // Get sorted indices
            printReportHeader();                         // Print table header
            // Loop through sorted indices and print each student
            for (int i = 0; i < order.length; i++) {
                printReportRow(i + 1, order[i]); // Print row with sequential number
            }

            // Ask if user wants to go back to menu
            String again = getYesNo("\nDo you want to go back to the menu (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // BATCH-WISE STUDENT REPORT
    // ===================================================================
    // Shows students filtered by a specific batch
    public static void batchWiseStudentReport() {
        boolean back = false;

        do {
            printHeader("Batch-wise Student Report"); // Display header
            // List all available batches as menu options
            for (int i = 0; i < batchCount; i++) {
                System.out.println("[" + (i + 1) + "] " + batchNameArray[i] + " Batch");
            }
            System.out.println("\n[" + (batchCount + 1) + "] Exit"); // Exit option

            // Read user's batch selection
            int opt = getValidInt("\nEnter an option to continue > ", 1, batchCount + 1);

            // CHECK: Did user select Exit?
            if (opt == batchCount + 1) {
                back = true; // Return to previous menu
                clearConsole();
                continue;
            }

            // Get the batch number for selected option
            int batchNo = batchNameArray[opt - 1]; // -1 because array is 0-indexed
            clearConsole();
            // Display batch-specific header
            printHeader(batchNo + " Batch Student Report");
            printReportHeader(); // Print table header

            int no = 1; // Row counter
            // Loop through all students and show only those in selected batch
            for (int i = 0; i < studentCount; i++) {
                // Extract batch number from registration number
                int b = Integer.parseInt(regNoArray[i].substring(4, 7));
                if (b == batchNo) { // If student belongs to this batch
                    printReportRow(no, i); // Print the row
                    no++; // Increment row counter
                }
            }

            // Ask if user wants another batch report
            String again = getYesNo("\nDo you want another batch report (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // INDUSTRY TRAINING ELIGIBILITY REPORT
    // ===================================================================
    // Shows students eligible for industry training
    // Criteria: GPA > 3.25 AND PRF > 50 AND DBMS > 50
    public static void industryTrainingEligibilityReport() {
        boolean back = false;

        do {
            printHeader("Industry Training Eligibility Student Report"); // Display header
            printReportHeader(); // Print table header

            int no = 1; // Row counter
            // Loop through all students and check eligibility
            for (int i = 0; i < studentCount; i++) {
                double gpa = computeGPA(prfArray[i], dbmsArray[i]); // Calculate GPA
                // CHECK: Student must meet ALL three criteria
                if (gpa > 3.25 && prfArray[i] > 50 && dbmsArray[i] > 50) {
                    printReportRow(no, i); // Print eligible student
                    no++; // Increment row counter
                }
            }

            // Ask if user wants to go to homepage
            String again = getYesNo("\nDo you want to go to homepage (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }

    // ===================================================================
    // MAIN METHOD (Program Entry Point)
    // ===================================================================
    // This is where the program starts executing
    public static void main(String args[]) {
        homePage(); // Call the home page method to start the application
    }
}
