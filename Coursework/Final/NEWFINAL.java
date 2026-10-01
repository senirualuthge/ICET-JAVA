import java.util.Scanner;
import java.util.*;

class NEWFINAL {
    // Batch status
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

    // Batch data
    public static int[] batchNameArray = { 105, 106, 107, 108, 109, 110 };
    public static int[] batchStatusArray = { 0, 0, 0, 0, 1, 1 };
    public static int[] batchStudentCountArray; // computed at startup
    public static int batchCount = batchNameArray.length;

    // Student data
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

    public static int studentCount = regNoArray.length;

    static {
        // compute the initial per-batch student counts from the seed data
        batchStudentCountArray = new int[batchNameArray.length];
        for (int i = 0; i < studentCount; i++) {
            int batchNo = Integer.parseInt(regNoArray[i].substring(4, 7));
            for (int j = 0; j < batchNameArray.length; j++) {
                if (batchNameArray[j] == batchNo) {
                    batchStudentCountArray[j]++;
                    break;
                }
            }
        }
    }

    // shared console input
    public static Scanner input = new Scanner(System.in);

    // console clear
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

     // Exit
    public static void exit() {
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
    }


    public static int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()){
                int value =input.nextInt();
                input.nextLine();             //Consum Left overs
                return value;
            }
            System.out.println("Please enter a valid integer.");
            input.nextLine();                  //Discard
        }

    }

    public static int getValidInt(String prompt, int min, int max) {
        while (true) {
            int value = getValidInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    // reads a non-empty line of text
    public static String getValidString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    // reads Y or N (case-insensitive) and returns it upper-cased
    public static String getYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String ans = input.nextLine().trim().toUpperCase();
            if (ans.equals("Y") || ans.equals("N")) {
                return ans;
            }
            System.out.println("Please enter Y or N.");
        }
    }

    // reads marks: -1 (absent) or 0-100
    public static int getValidMarks(String prompt) {
        while (true) {
            int value = getValidInt(prompt);
            if (value == -1 || (value >= 0 && value <= 100)) {
                return value;
            }
            System.out.println("Marks must be -1 (absent) or between 0 and 100.");
        }
    }

    // =======================================================================
    // Array growth helpers (manual, arrays only - no ArrayList/LinkedList)
    // =======================================================================

    public static String[] growStringArray(String[] arr) {
        String[] bigger = new String[arr.length == 0 ? 1 : arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i];
        }
        return bigger;
    }

    public static int[] growIntArray(int[] arr) {
        int[] bigger = new int[arr.length == 0 ? 1 : arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i];
        }
        return bigger;
    }

    // =======================================================================
    // Lookup helpers
    // =======================================================================

    public static int findBatchIndex(int batchNo) {
        for (int i = 0; i < batchCount; i++) {
            if (batchNameArray[i] == batchNo) {
                return i;
            }
        }
        return -1;
    }

    public static int findStudentIndex(String regNo) {
        for (int i = 0; i < studentCount; i++) {
            if (regNoArray[i].equalsIgnoreCase(regNo)) {
                return i;
            }
        }
        return -1;
    }

    public static int findStudentIndexByNIC(String nic) {
        for (int i = 0; i < studentCount; i++) {
            if (nicArray[i].equals(nic)) {
                return i;
            }
        }
        return -1;
    }

    public static int getNextStudentNo(int batchNo) {
        int max = 0;
        for (int i = 0; i < studentCount; i++) {
            int b = Integer.parseInt(regNoArray[i].substring(4, 7));
            if (b == batchNo) {
                int studentNo = Integer.parseInt(regNoArray[i].substring(7, 10));
                if (studentNo > max) {
                    max = studentNo;
                }
            }
        }
        return max + 1;
    }

    // =======================================================================
    // Record add / remove
    // =======================================================================

    public static void addStudentRecord(String regNo, String nic, String name, int prf, int dbms) {
        if (studentCount == regNoArray.length) {
            regNoArray = growStringArray(regNoArray);
            nicArray = growStringArray(nicArray);
            nameArray = growStringArray(nameArray);
            prfArray = growIntArray(prfArray);
            dbmsArray = growIntArray(dbmsArray);
        }
        regNoArray[studentCount] = regNo;
        nicArray[studentCount] = nic;
        nameArray[studentCount] = name;
        prfArray[studentCount] = prf;
        dbmsArray[studentCount] = dbms;
        studentCount++;
    }

    public static void removeStudentAt(int idx) {
        for (int i = idx; i < studentCount - 1; i++) {
            regNoArray[i] = regNoArray[i + 1];
            nicArray[i] = nicArray[i + 1];
            nameArray[i] = nameArray[i + 1];
            prfArray[i] = prfArray[i + 1];
            dbmsArray[i] = dbmsArray[i + 1];
        }
        studentCount--;
    }

    public static void addBatchRecord(int batchNo) {
        if (batchCount == batchNameArray.length) {
            batchNameArray = growIntArray(batchNameArray);
            batchStatusArray = growIntArray(batchStatusArray);
            batchStudentCountArray = growIntArray(batchStudentCountArray);
        }
        batchNameArray[batchCount] = batchNo;
        batchStatusArray[batchCount] = ENROLLMENTOPEN;
        batchStudentCountArray[batchCount] = 0;
        batchCount++;
    }

    public static void removeBatchAt(int idx) {
        for (int i = idx; i < batchCount - 1; i++) {
            batchNameArray[i] = batchNameArray[i + 1];
            batchStatusArray[i] = batchStatusArray[i + 1];
            batchStudentCountArray[i] = batchStudentCountArray[i + 1];
        }
        batchCount--;
    }

    // =======================================================================
    // GPA
    // =======================================================================

    public static double marksToGPA(int marks) {
        if (marks == -1 || marks == -2) return 0.0;
        if (marks >= 90) return 4.25;
        if (marks >= 80) return 4.00;
        if (marks >= 75) return 3.70;
        if (marks >= 70) return 3.30;
        if (marks >= 65) return 3.00;
        if (marks >= 60) return 2.70;
        if (marks >= 55) return 2.30;
        if (marks >= 50) return 2.00;
        if (marks >= 45) return 1.70;
        if (marks >= 40) return 1.30;
        if (marks >= 30) return 1.00;
        if (marks >= 20) return 0.70;
        return 0.0;
    }

    public static double computeGPA(int prf, int dbms) {
        return (marksToGPA(prf) + marksToGPA(dbms)) / 2.0;
    }

    public static String marksDisplay(int marks) {
        if (marks == -1) return "Absent";
        if (marks == -2) return "Not conducted";
        return String.valueOf(marks);
    }

    public static void displayStudentProfile(int idx) {
        double gpa = computeGPA(prfArray[idx], dbmsArray[idx]);
        System.out.println("\n\tRegistration no\t\t: " + regNoArray[idx]);
        System.out.println("\tStudet Name\t\t: " + nameArray[idx]);
        System.out.println("\tStudet NIC\t\t: " + nicArray[idx]);
        System.out.println("\tStudet PRF Marks\t: " + marksDisplay(prfArray[idx]));
        System.out.println("\tStudet DBMS Marks\t: " + marksDisplay(dbmsArray[idx]));
        System.out.println("\tStudet GPA\t\t: " + gpa);
    }

    public static void printReportHeader() {
        System.out.printf("%-4s%-14s%-26s%-16s%-11s%-12s%-6s%n",
                "No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA");
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public static void printReportRow(int no, int idx) {
        double gpa = computeGPA(prfArray[idx], dbmsArray[idx]);
        System.out.printf("%-4d%-14s%-26s%-16s%-11s%-12s%.2f%n",
                no, regNoArray[idx], nameArray[idx], nicArray[idx],
                marksDisplay(prfArray[idx]), marksDisplay(dbmsArray[idx]), gpa);
    }

    // simple selection sort on an index array, ordered by student name
    public static int[] sortedIndicesByName() {
        int[] order = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            order[i] = i;
        }
        for (int i = 0; i < order.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < order.length; j++) {
                if (nameArray[order[j]].compareTo(nameArray[order[minPos]]) < 0) {
                    minPos = j;
                }
            }
            int temp = order[i];
            order[i] = order[minPos];
            order[minPos] = temp;
        }
        return order;
    }


    // home page
    public static void homePage() {

        do{    
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tiCET Student Management System\t\t|");
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("[1] Student Management");
            System.out.println("\n[2] Batch Management ");
            System.out.println("\n[3] Grade Management");
            System.out.println("\n[4] Report Generator");
            System.out.println("\n[5] Exit");

            

                int option = getValidInt("\n\nEnter an option to continue > ", 1, 5);


                    switch (option) {
                        case 1:
                            clearConsole();
                            studentManagement();
                            break;
                        case 2:
                            clearConsole();
                            batchManagement();
                            break;
                        case 3:
                            clearConsole();
                            gradeManagement();
                            break;
                        case 4:
                            clearConsole();
                            reportGenerator();
                            break;
                        case 5:
                            clearConsole();
                            exit();
                            break;
                    }
        } 
        while (true);
    }

    // Student Management
    public static void studentManagement() {

        boolean back = false;

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tStudent Management\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n\n\n");
            System.out.println("[1] Add Student");
            System.out.println("\n[2] Update Student ");
            System.out.println("\n[3] View Student Profile");
            System.out.println("\n[4] Delete Student Profile");
            System.out.println("\n[5] Exit");


            int Stmoption = getValidInt("\n\nEnter an option to continue > ", 1, 5);


            switch (Stmoption) {
                case 1:
                    clearConsole();
                    AddStudent();
                    break;
                case 2:
                    clearConsole();
                    UpdateStudent();
                    break;
                case 3:
                    clearConsole();
                    ViewStudentProfile();
                    break;
                case 4:
                    clearConsole();
                    DeleteStudentProfile();
                    break;
                case 5:
                    back = true;
                    clearConsole();
                    break;
            }

        } 
        while (!back);
    }

    public static void AddStudent() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tAdd Student\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Add Student Profile");
            System.out.println("\n[2] Exit");

            int Addoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (Addoption) {
                case 1:
                    clearConsole();
                    addStudentProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Add Student Profile logic (Figures 4-7)
    public static void addStudentProfileSession() {
        boolean back = false;

        do {
            int batchNo = getValidInt("Enter Batch Number (Students should be added): ");
            int bIdx = findBatchIndex(batchNo);

            if (bIdx == -1) {
                System.out.println("\n\tThis batch does not exist in the system.");
                String ans = getYesNo("Do you want to add student to another Batch (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            if (batchStatusArray[bIdx] == ENROLLMENTCLOSED) {
                System.out.println("\n\tStudents cannot be added to this batch because enrollment is closed.");
                String ans = getYesNo("Do you want to add student to another Batch (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            String nic = getValidString("\nEnter Student NIC: ");
            int sIdx = findStudentIndexByNIC(nic);

            if (sIdx != -1) {
                System.out.println("\n\tThis student is already added to the system.");
                displayStudentProfile(sIdx);
            } else {
                String name = getValidString("\nEnter Student Name: ");
                int mode = getValidInt("\nEnter Lecturer Mode (1-PHYSICAL 0-ONLINE): ", 0, 1);
                String prefix = (mode == 1) ? "PR" : "OR";
                int newStudentNo = getNextStudentNo(batchNo);
                String newRegNo = prefix + "24" + String.format("%03d", batchNo) + String.format("%03d", newStudentNo);

                addStudentRecord(newRegNo, nic, name, -2, -2);
                batchStudentCountArray[bIdx]++;

                System.out.println("\n\tStudent Registration No - " + newRegNo);
                System.out.println("Student was successfully added to the system.");
            }

            String again = getYesNo("\nDo you want to add another student (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void UpdateStudent() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tUpdate Student\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Update Student Profile");
            System.out.println("\n[2] Exit");

            int Updoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (Updoption) {
                case 1:
                    clearConsole();
                    updateStudentProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Update Student Profile logic (Figures 6-11)
    public static void updateStudentProfileSession() {
        boolean back = false;

        do {
            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student details (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            System.out.println("\n\tStudet Name\t: " + nameArray[idx]);
            System.out.println("\tStudet NIC\t: " + nicArray[idx]);
            System.out.println("\nWhat do you want to update ?");
            System.out.println("\t(01) Student Name");
            System.out.println("\t(02) Student NIC");
            int opt = getValidInt("\nEnter your option - ", 1, 2);

            if (opt == 1) {
                System.out.println("\nStudent Name Update");
                System.out.println("====================");
                System.out.println("Registration No\t\t: " + regNoArray[idx]);
                System.out.println("Student NIC\t\t: " + nicArray[idx]);
                System.out.println("Studet Current Name\t: " + nameArray[idx]);
                String newName = getValidString("\nEnter student name to update - ");
                nameArray[idx] = newName;
                System.out.println("\n\tStudent name updated successfully...");
            } else {
                System.out.println("\nStudent NIC Update");
                System.out.println("====================");
                System.out.println("Registration No\t\t: " + regNoArray[idx]);
                System.out.println("Student Name\t\t: " + nameArray[idx]);
                System.out.println("Student Current NIC\t: " + nicArray[idx]);
                String newNic = getValidString("\nEnter student NIC to update - ");
                int dupIdx = findStudentIndexByNIC(newNic);
                if (dupIdx != -1 && dupIdx != idx) {
                    System.out.println("\n\tThis student is already added to the system...");
                } else {
                    nicArray[idx] = newNic;
                    System.out.println("\n\tStudent NIC updated successfully...");
                }
            }

            String again = getYesNo("\nDo you want to update another student details (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void ViewStudentProfile() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tView Student Profile\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] View Student Profile");
            System.out.println("\n[2] Exit");

            int Viewoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (Viewoption) {
                case 1:
                    clearConsole();
                    viewStudentProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real View Student Profile logic (Figures 13-17)
    public static void viewStudentProfileSession() {
        boolean back = false;

        do {
            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system.");
            } else {
                displayStudentProfile(idx);
            }

            String again = getYesNo("\nDo you want to search another student details (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void DeleteStudentProfile() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tDelete Student Profile\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Delete Student Profile");
            System.out.println("\n[2] Exit");

            int Deloption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (Deloption) {
                case 1:
                    clearConsole();
                    deleteStudentProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Delete Student Profile logic (Figures 18-21)
    public static void deleteStudentProfileSession() {
        boolean back = false;

        do {
            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system.");
                String ans = getYesNo("Do you want to delete another student profile (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            displayStudentProfile(idx);
            String confirm = getYesNo("\nDo you want to delete this student profile (Y/N): ");

            if (confirm.equals("Y")) {
                int batchNo = Integer.parseInt(regNoArray[idx].substring(4, 7));
                int bIdx = findBatchIndex(batchNo);
                removeStudentAt(idx);
                if (bIdx != -1) batchStudentCountArray[bIdx]--;
                System.out.println("\n\tStudent was successfully deleted from the system.");
            }

            String again = getYesNo("\nDo you want to delete another student profile (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }



    // Batch Management
    public static void batchManagement() {
        boolean back = false;

        do {

            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tBatch Management\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n\n\n");
            System.out.println("[1] Add Batch");
            System.out.println("\n[2] Update Batch ");
            System.out.println("\n[3] View Batch Profile");
            System.out.println("\n[4] Delete Batch Profile");
            System.out.println("\n[5] Exit");


                int Btoption = getValidInt("\n\nEnter an option to continue > ", 1, 5);


                switch (Btoption) {
                    case 1:
                        clearConsole();
                        AddBatch();
                        break;
                    case 2:
                        clearConsole();
                        UpdateBatch();
                        break;
                    case 3:
                        clearConsole();
                        ViewBatch();
                        break;
                    case 4:
                        clearConsole();
                        DeleteBatch();
                        break;
                    case 5:
                        back = true;
                        clearConsole();
                        break;
                }
        }  
        while (!back);

    }

    public static void AddBatch() {
        boolean back = false;

        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tAdd Batch\t\t\t|");
            System.out.println("-----------------------------------------------------------------------------\n");
            System.out.println("[1] Add Batch Profile");
            System.out.println("\n[2] Exit");

            int AddBoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (AddBoption) {
                case 1:
                    clearConsole();
                    addBatchProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Add Batch Profile logic (Figures 23-25)
    public static void addBatchProfileSession() {
        boolean back = false;

        do {
            int batchNo = getValidInt("Enter Batch Number : ");
            int idx = findBatchIndex(batchNo);

            if (idx != -1) {
                System.out.println("\nBatch is already added to the system.");
            } else {
                addBatchRecord(batchNo);
                System.out.println("\nBatch was successfully added to the system.");
            }

            String again = getYesNo("Do you want to add another batch to the system (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void UpdateBatch() {
        boolean back = false;

        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tUpdate Batch\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Update Batch Profile");
            System.out.println("\n[2] Exit");

            int UpdBoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (UpdBoption) {
                case 1:
                    clearConsole();
                    updateBatchProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Update Batch Profile logic (Figures 26-28)
    public static void updateBatchProfileSession() {
        boolean back = false;

        do {
            int batchNo = getValidInt("Enter Batch Number : ");
            int idx = findBatchIndex(batchNo);

            if (idx == -1) {
                System.out.println("This batch does not exist in the system.");
                String ans = getYesNo("Do you want to update another batch details (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            String currentStatus = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
            String newStatusName = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN";
            System.out.println("Current Status : " + currentStatus);

            String confirm = getYesNo("\nDo you want to change the batch status to " + newStatusName + "(Y/N) ? ");
            if (confirm.equals("Y")) {
                batchStatusArray[idx] = (batchStatusArray[idx] == ENROLLMENTOPEN) ? ENROLLMENTCLOSED : ENROLLMENTOPEN;
                System.out.println("\n\tBatch Status updated successfully...");
            }

            String again = getYesNo("\nDo you want to update another batch details (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    
    public static void ViewBatch() {
        boolean back = false;

        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tView Batch Profile\t\t\t|");
            System.out.println("-----------------------------------------------------------------------------\n");
            System.out.println("[1] View Batch Profile");
            System.out.println("\n[2] Exit");

            int ViewBoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (ViewBoption) {
                case 1:
                    clearConsole();
                    viewBatchProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real View Batch Profile logic (Figure 29)
    public static void viewBatchProfileSession() {
        boolean back = false;

        do {
            System.out.printf("%-4s%-11s%-15s%-20s%n", "No", "Batch No", "Student Count", "Status");
            System.out.println("-------------------------------------------------------------");
            for (int i = 0; i < batchCount; i++) {
                String status = (batchStatusArray[i] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
                System.out.printf("%-4d%-11d%-15d%-20s%n", i + 1, batchNameArray[i], batchStudentCountArray[i], status);
            }

            String again = getYesNo("\nDo you want to go to the home page (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void DeleteBatch() {
        boolean back = false;

        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tDelete Batch Profile\t\t\t|");
            System.out.println("-----------------------------------------------------------------------------\n");
            System.out.println("[1] Delete Batch Profile");
            System.out.println("\n[2] Exit");

            int DelBoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (DelBoption) {
                case 1:
                    clearConsole();
                    deleteBatchProfileSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Delete Batch Profile logic. The spec doesn't detail this screen, so
    // it mirrors Delete Student Profile: show details, confirm, delete - and
    // refuses to delete a batch that still has students enrolled.
    public static void deleteBatchProfileSession() {
        boolean back = false;

        do {
            int batchNo = getValidInt("Enter Batch Number : ");
            int idx = findBatchIndex(batchNo);

            if (idx == -1) {
                System.out.println("\n\tThis batch does not exist in the system.");
                String ans = getYesNo("Do you want to delete another batch (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            String status = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
            System.out.println("\n\tBatch No\t: " + batchNameArray[idx]);
            System.out.println("\tStudent Count\t: " + batchStudentCountArray[idx]);
            System.out.println("\tStatus\t\t: " + status);

            if (batchStudentCountArray[idx] > 0) {
                System.out.println("\nThis batch cannot be deleted because it still has students enrolled.");
                String ans = getYesNo("\nDo you want to delete another batch (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            String confirm = getYesNo("\nDo you want to delete this batch profile (Y/N): ");
            if (confirm.equals("Y")) {
                removeBatchAt(idx);
                System.out.println("\n\tBatch was successfully deleted from the system.");
            }

            String again = getYesNo("\nDo you want to delete another batch (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    

        // Grade Management
    public static void gradeManagement() {

        do{
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tGrade Management\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] PRF Marks Update");
            System.out.println("\n[2] DBMS Marks Update ");
            System.out.println("\n[3] Exit");


            int GRoption = getValidInt("\n\nEnter an option to continue > ", 1, 3);
            

            switch (GRoption) {
                    case 1:
                        clearConsole();
                        PRFMarksUpdate();
                        break;
                    case 2:
                        clearConsole();
                        DBMSMarksUpdate();
                        break;
                    
                    case 3:
                        clearConsole();
                        return;
            }
        } 
        while (true);
    }

    public static void PRFMarksUpdate() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tPRF Marks Update \t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] PRF Marks");
            System.out.println("\n[2] Exit");

            int PRFoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (PRFoption) {
                case 1:
                    clearConsole();
                    prfMarksSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real PRF Marks Update logic (Figures 31-37)
    public static void prfMarksSession() {
        boolean back = false;

        do {
            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student PRF marks (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            System.out.println("\n\tRegistration no\t: " + regNoArray[idx]);
            System.out.println("\tStudet Name\t: " + nameArray[idx]);
            System.out.println("\tStudet NIC\t: " + nicArray[idx]);

            int current = prfArray[idx];
            boolean proceed = true;

            if (current >= 0) {
                System.out.println("\nThis student has already completed the PRF module.");
                System.out.println("\tPRF Marks : " + current);
                String upd = getYesNo("\nDo you want to update this student's PRF marks? ");
                proceed = upd.equals("Y");
            } else if (current == -1) {
                System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it..");
            }
            // current == -2 (not conducted) -> proceed silently

            if (proceed) {
                int marks = getValidMarks("\tEnter PRF Marks : ");
                prfArray[idx] = marks;
                System.out.println("\n\tThis student PRF Marks updated successfully...");
            }

            String again = getYesNo("\nDo you want to update another student PRF marks (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void DBMSMarksUpdate() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tDBMS Marks Update \t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] DBMS Marks");
            System.out.println("\n[2] Exit");

            int DBMSoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (DBMSoption) {
                case 1:
                    clearConsole();
                    dbmsMarksSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real DBMS Marks Update logic (Figures 38-44)
    public static void dbmsMarksSession() {
        boolean back = false;

        do {
            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student DBMS marks (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            System.out.println("\n\tRegistration no\t: " + regNoArray[idx]);
            System.out.println("\tStudet Name\t: " + nameArray[idx]);
            System.out.println("\tStudet NIC\t: " + nicArray[idx]);

            int current = dbmsArray[idx];
            boolean proceed = true;

            if (current >= 0) {
                System.out.println("\nThis student has already completed the DBMS module.");
                System.out.println("\tDBMS Marks : " + current);
                String upd = getYesNo("\nDo you want to update this student's DBMS marks? ");
                proceed = upd.equals("Y");
            } else if (current == -1) {
                System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it..");
            }

            if (proceed) {
                int marks = getValidMarks("\tEnter DBMS Marks : ");
                dbmsArray[idx] = marks;
                System.out.println("\n\tThis student DBMS Marks updated successfully...");
            }

            String again = getYesNo("\nDo you want to update another student DBMS marks (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    
    // Report Generator
    public static void reportGenerator() {
        
        do{
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tReport Generator\t\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Student Registartion Report\n");
            System.out.println("[2] Batch-wise Student Report\n");
            System.out.println("[3] Industry Training Eligability Report4\n");
                System.out.println("[4] Exit");


                int Report = getValidInt("\n\nEnter an option to continue > ", 1, 4);

                switch (Report) {
                        case 1:
                            clearConsole();
                            BatchSummary();
                            break;
                        case 2:
                            clearConsole();
                            ModuleReports ();
                            break;
                        case 3:
                            clearConsole();
                            BatchReport();
                            break;
                        
                        case 4:
                        clearConsole();
                        return;
                }
        }
        while (true);

    }

    public static void BatchSummary() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tStudent Registartion Report\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Student Registartion Report");
            System.out.println("\n[2] Exit");

            int Reportoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (Reportoption) {
                case 1:
                    clearConsole();
                    studentRegistrationReportSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Student Registration Report logic - all students, alphabetical by name
    public static void studentRegistrationReportSession() {
        boolean back = false;

        do {
            int[] order = sortedIndicesByName();
            printReportHeader();
            for (int i = 0; i < order.length; i++) {
                printReportRow(i + 1, order[i]);
            }

            String again = getYesNo("\nDo you want to go back to the menu (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void ModuleReports() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tBatch-wise Student Report\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Add Batch Profile");
            System.out.println("\n[2] Exit");

            int Moduleoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (Moduleoption) {
                case 1:
                    clearConsole();
                    batchWiseStudentReportSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Batch-wise Student Report logic (Figure batch selection + report)
    public static void batchWiseStudentReportSession() {
        boolean back = false;

        do {
            for (int i = 0; i < batchCount; i++) {
                System.out.println("[" + (i + 1) + "] " + batchNameArray[i] + " Batch");
            }
            System.out.println("\n[" + (batchCount + 1) + "] Exit");

            int opt = getValidInt("\nEnter an option to continue > ", 1, batchCount + 1);

            if (opt == batchCount + 1) {
                back = true;
                clearConsole();
                continue;
            }

            int batchNo = batchNameArray[opt - 1];
            clearConsole();
            System.out.println(batchNo + " Batch Student Report");
            System.out.println("-------------------------------------------------------------------------\n");
            printReportHeader();
            int no = 1;
            for (int i = 0; i < studentCount; i++) {
                int b = Integer.parseInt(regNoArray[i].substring(4, 7));
                if (b == batchNo) {
                    printReportRow(no, i);
                    no++;
                }
            }

            String again = getYesNo("\nDo you want another batch report (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void BatchReport() {
        boolean back = false;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tIndustry Training Eligability Report\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("[1] Add Batch Profile");
            System.out.println("\n[2] Exit");

            int BatchRoption = getValidInt("\n\nEnter an option to continue > ", 1, 2);

            switch (BatchRoption) {
                case 1:
                    clearConsole();
                    industryTrainingEligibilityReportSession();
                    break;
                case 2:
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    // real Industry Training Eligibility Report logic (GPA > 3.25 and both marks > 50)
    public static void industryTrainingEligibilityReportSession() {
        boolean back = false;

        do {
            printReportHeader();
            int no = 1;
            for (int i = 0; i < studentCount; i++) {
                double gpa = computeGPA(prfArray[i], dbmsArray[i]);
                if (gpa > 3.25 && prfArray[i] > 50 && dbmsArray[i] > 50) {
                    printReportRow(no, i);
                    no++;
                }
            }

            String again = getYesNo("\nDo you want to go to homepage (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }


        
    // main method
    public static void main(String args[]) {
        homePage();
            
    }

}