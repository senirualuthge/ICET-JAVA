import java.util.*;

class Student {
    private String regNo;
    private String nic;
    private String name;
    private int prfMarks;
    private int dbmsMarks;

    Student(String regNo, String nic, String name, int prfMarks, int dbmsMarks) {
        this.regNo = regNo;
        this.nic = nic;
        this.name = name;
        this.prfMarks = prfMarks;
        this.dbmsMarks = dbmsMarks;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getNic() {
        return nic;
    }

    public String getName() {
        return name;
    }

    public int getPrfMarks() {
        return prfMarks;
    }

    public int getDbmsMarks() {
        return dbmsMarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setPrfMarks(int prfMarks) {
        this.prfMarks = prfMarks;
    }

    public void setDbmsMarks(int dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

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

    public double computeGPA() {
        return (marksToGPA(prfMarks) + marksToGPA(dbmsMarks)) / 2.0;
    }

    public static String marksDisplay(int marks) {
        if (marks == -1) return "Absent";
        if (marks == -2) return "Not conducted";
        return String.valueOf(marks);
    }
}

class Batch {
    private int batchNo;
    private boolean enrollmentOpen;
    private int studentCount;

    Batch(int batchNo, boolean enrollmentOpen, int studentCount) {
        this.batchNo = batchNo;
        this.enrollmentOpen = enrollmentOpen;
        this.studentCount = studentCount;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public boolean isEnrollmentOpen() {
        return enrollmentOpen;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setEnrollmentOpen(boolean enrollmentOpen) {
        this.enrollmentOpen = enrollmentOpen;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void incrementStudentCount() {
        studentCount++;
    }

    public void decrementStudentCount() {
        studentCount--;
    }
}

class StudentManagementSystem_ObjectArray {

    public static Student[] students = new Student[150];
    public static int studentCount = students.length;

    public static Batch[] batches = new Batch[6];
    public static int batchCount = batches.length;

    public static Scanner input = new Scanner(System.in);

    static {

        students[0] = new Student("PR24105001", "199501012345", "Gunawardena Weerasinghe", 85, 66);
        students[1] = new Student("PR24105002", "199503153872", "Senanayake Silva", 39, 45);
        students[2] = new Student("PR24105003", "199506202198", "Silva Kumara", -1, 93);
        students[3] = new Student("PR24105004", "199509102983", "Kumara Herath", 72, 58);
        students[4] = new Student("PR24105005", "199511258739", "Rathnayake Herath", 44, -1);
        students[5] = new Student("PR24105006", "199512303498", "Wijesinghe Bandara", 91, 37);
        students[6] = new Student("PR24105007", "199502183764", "Rajapaksha Herath", 60, 88);
        students[7] = new Student("PR24105008", "199504223198", "Senanayake Karunaratne", 38, 21);
        students[8] = new Student("PR24105009", "199508153210", "Karunaratne Jayasinghe", 95, 79);
        students[9] = new Student("PR24105010", "199510293417", "Gunawardena Silva", 49, 40);
        students[10] = new Student("OR24105011", "199601102375", "Weerasinghe Rajapaksha", -1, 76);
        students[11] = new Student("OR24105012", "199604182938", "Silva Rathnayake", 67, 54);
        students[12] = new Student("OR24105013", "199606243879", "Fernando Perera", 23, -1);
        students[13] = new Student("OR24105014", "199608142178", "Kumara Abeysekera", 58, 69);
        students[14] = new Student("OR24105015", "199610312475", "Ekanayake Rathnayake", 88, 92);
        students[15] = new Student("PR24105016", "199611173452", "Herath Gunawardena", 81, 25);
        students[16] = new Student("PR24105017", "199603293481", "Abeysekera Silva", 73, 84);
        students[17] = new Student("PR24105018", "199605083217", "Weerasinghe Silva", 29, 33);
        students[18] = new Student("OR24105019", "199607232198", "Jayasinghe Dias", 62, 60);
        students[19] = new Student("OR24105020", "199609192375", "Bandara Rathnayake", -1, 71);
        students[20] = new Student("PR24105021", "199701212483", "Silva Perera", 79, 59);
        students[21] = new Student("PR24105022", "199703132487", "De Silva Dias", 53, -1);
        students[22] = new Student("OR24105023", "199706253478", "Abeysekera Jayasinghe", 94, 98);
        students[23] = new Student("OR24105024", "199708083298", "Rajapaksha Senanayake", 47, 27);
        students[24] = new Student("PR24105025", "199710243651", "Kumara Karunaratne", 35, 48);
        students[25] = new Student("PR24106001", "199712152983", "Silva Abeysekera", 93, 35);
        students[26] = new Student("PR24106002", "199702182734", "Jayasinghe Bandara", 15, 91);
        students[27] = new Student("PR24106003", "199704293187", "Rathnayake Kumara", -1, 60);
        students[28] = new Student("PR24106004", "199705142375", "Weerasinghe Rajapaksha", 82, -1);
        students[29] = new Student("PR24106005", "199709083751", "Senanayake Herath", 45, 72);
        students[30] = new Student("PR24106006", "199801032874", "Perera Ekanayake", 88, 49);
        students[31] = new Student("PR24106007", "199803232871", "Herath Jayasinghe", 23, 26);
        students[32] = new Student("PR24106008", "199806193428", "Kumara Gunawardena", 79, 80);
        students[33] = new Student("PR24106009", "199808013764", "Abeysekera Silva", 37, 14);
        students[34] = new Student("PR24106010", "199810242374", "Dias Fernando", -1, 89);
        students[35] = new Student("OR24106011", "199812302984", "Karunaratne Weerasinghe", 68, 67);
        students[36] = new Student("OR24106012", "199802152348", "Ekanayake Bandara", 100, -1);
        students[37] = new Student("OR24106013", "199805213471", "Rajapaksha Kumara", 59, 31);
        students[38] = new Student("OR24106014", "199807172398", "Silva De Silva", 29, 94);
        students[39] = new Student("OR24106015", "199811283472", "Gunawardena Rathnayake", 92, 53);
        students[40] = new Student("PR24106016", "199901122471", "Bandara Karunaratne", 12, 78);
        students[41] = new Student("PR24106017", "199903052984", "Fernando Perera", 77, 5);
        students[42] = new Student("PR24106018", "199906213874", "De Silva Silva", 38, 90);
        students[43] = new Student("OR24106019", "199908093412", "Rajapaksha Gunawardena", 66, 24);
        students[44] = new Student("OR24106020", "199910273894", "Herath Weerasinghe", 9, 86);
        students[45] = new Student("PR24106021", "199912153482", "Karunaratne Dias", 84, 39);
        students[46] = new Student("PR24106022", "199902202394", "Jayasinghe Silva", 51, -1);
        students[47] = new Student("OR24106023", "199904163874", "Senanayake Abeysekera", 32, 61);
        students[48] = new Student("OR24106024", "199907293481", "Silva Jayasinghe", -1, 73);
        students[49] = new Student("PR24106025", "199911083479", "Rathnayake Kumara", 97, 100);
        students[50] = new Student("PR24107001", "200001112374", "Gunawardena Kumara", 95, 38);
        students[51] = new Student("PR24107002", "200003143478", "Rajapaksha Silva", -1, 91);
        students[52] = new Student("PR24107003", "200006293874", "Perera Jayasinghe", 63, -1);
        students[53] = new Student("PR24107004", "200008103471", "Silva Ekanayake", 88, 74);
        students[54] = new Student("PR24107005", "200010252984", "Dias Senanayake", 32, 55);
        students[55] = new Student("PR24107006", "200012043894", "Herath Abeysekera", 76, 82);
        students[56] = new Student("PR24107007", "200002193874", "Rathnayake Fernando", 97, 66);
        students[57] = new Student("PR24107008", "200004212374", "Kumara Herath", 54, 49);
        students[58] = new Student("PR24107009", "200005183492", "Weerasinghe Silva", -1, 99);
        students[59] = new Student("PR24107010", "200007153871", "Senanayake Karunaratne", 23, 13);
        students[60] = new Student("OR24107011", "200101232984", "Abeysekera Silva", 90, 80);
        students[61] = new Student("OR24107012", "200103083471", "Bandara Gunawardena", 35, 70);
        students[62] = new Student("OR24107013", "200106273894", "Karunaratne Weerasinghe", 81, 93);
        students[63] = new Student("OR24107014", "200108123984", "Perera Herath", 61, 36);
        students[64] = new Student("OR24107015", "200110043728", "Fernando Dias", 44, 59);
        students[65] = new Student("PR24107016", "200112213874", "Weerasinghe Gunawardena", 67, 85);
        students[66] = new Student("PR24107017", "200102253471", "Rathnayake Kumara", 100, 47);
        students[67] = new Student("PR24107018", "200104103874", "Senanayake Fernando", 17, 90);
        students[68] = new Student("OR24107019", "200105293784", "Silva Bandara", 85, -1);
        students[69] = new Student("OR24107020", "200107202983", "Herath Rajapaksha", 29, 22);
        students[70] = new Student("PR24107021", "200201013874", "Kumara Jayasinghe", 70, 77);
        students[71] = new Student("PR24107022", "200203253471", "Abeysekera Perera", 42, 34);
        students[72] = new Student("OR24107023", "200206143874", "Rathnayake Jayasinghe", -1, 63);
        students[73] = new Student("OR24107024", "200208083471", "Kumara Weerasinghe", 60, 100);
        students[74] = new Student("PR24107025", "200210293874", "Rajapaksha Ekanayake", 86, 29);
        students[75] = new Student("PR24108001", "200212183471", "Fernando Rajapaksha", 86, 79);
        students[76] = new Student("PR24108002", "200202103874", "Silva Gunawardena", 57, 62);
        students[77] = new Student("PR24108003", "200204123894", "Perera Wijesinghe", 91, 87);
        students[78] = new Student("PR24108004", "200205283471", "Herath Abeysekera", 35, -1);
        students[79] = new Student("PR24108005", "200207153874", "Rajapaksha Ekanayake", -1, 54);
        students[80] = new Student("PR24108006", "200301093874", "Karunaratne Silva", 76, 46);
        students[81] = new Student("PR24108007", "200303283471", "Weerasinghe Fernando", 48, 99);
        students[82] = new Student("PR24108008", "200306153874", "Silva Bandara", 94, 39);
        students[83] = new Student("PR24108009", "200308123471", "Abeysekera Weerasinghe", 23, 70);
        students[84] = new Student("PR24108010", "200310083874", "Kumara Karunaratne", 69, -1);
        students[85] = new Student("OR24108011", "200312243471", "Dias Rajapaksha", -1, 75);
        students[86] = new Student("OR24108012", "200302273874", "Herath Perera", 80, 83);
        students[87] = new Student("OR24108013", "200304203471", "Rathnayake Gunawardena", 55, 58);
        students[88] = new Student("OR24108014", "200305123874", "Ekanayake Jayasinghe", 88, 92);
        students[89] = new Student("OR24108015", "200307213471", "Gunawardena Silva", 32, 30);
        students[90] = new Student("PR24108016", "200401153874", "Rajapaksha Perera", 100, 91);
        students[91] = new Student("PR24108017", "200403123471", "Karunaratne Jayasinghe", 67, 40);
        students[92] = new Student("PR24108018", "200406293874", "Weerasinghe Abeysekera", 43, 63);
        students[93] = new Student("OR24108019", "200408083471", "Rathnayake Fernando", -1, 95);
        students[94] = new Student("OR24108020", "200410213874", "Kumara Herath", 90, 68);
        students[95] = new Student("PR24108021", "200412153471", "Silva Weerasinghe", 60, -1);
        students[96] = new Student("PR24108022", "200402203874", "Herath Karunaratne", 77, 66);
        students[97] = new Student("OR24108023", "200404273471", "Abeysekera Silva", 25, 21);
        students[98] = new Student("OR24108024", "200405143874", "Gunawardena Ekanayake", 71, 88);
        students[99] = new Student("PR24108025", "200407183471", "Weerasinghe Kumara", 84, 37);
        students[100] = new Student("PR24109001", "200501023874", "Weerasinghe Kumara", 92, 67);
        students[101] = new Student("PR24109002", "200503193471", "Rajapaksha Abeysekera", 68, 91);
        students[102] = new Student("PR24109003", "200506153874", "Gunawardena Perera", 59, 85);
        students[103] = new Student("PR24109004", "200508213471", "Karunaratne Silva", 85, 73);
        students[104] = new Student("PR24109005", "200510083874", "Herath Wijesinghe", 63, 70);
        students[105] = new Student("PR24109006", "200512293471", "Rathnayake Ekanayake", 76, 63);
        students[106] = new Student("PR24109007", "200502123874", "Silva Fernando", 91, 76);
        students[107] = new Student("PR24109008", "200504153471", "Abeysekera Rajapaksha", 70, 88);
        students[108] = new Student("PR24109009", "200505283874", "Fernando Bandara", 84, 55);
        students[109] = new Student("PR24109010", "200507173471", "Perera Herath", 63, 64);
        students[110] = new Student("OR24109011", "200203456782", "Weerasinghe Jayasinghe", 72, 79);
        students[111] = new Student("OR24109012", "200305678901", "Silva Karunaratne", 89, 80);
        students[112] = new Student("OR24109013", "199601234567", "Rathnayake Gunawardena", 45, 59);
        students[113] = new Student("OR24109014", "199511223344", "Herath Kumara", 81, 92);
        students[114] = new Student("OR24109015", "200412345678", "Abeysekera Silva", 77, 68);
        students[115] = new Student("PR24109016", "200512345678", "Ekanayake Bandara", 68, 100);
        students[116] = new Student("PR24109017", "199909876543", "Rajapaksha Fernando", 63, 77);
        students[117] = new Student("PR24109018", "199812346789", "Gunawardena Weerasinghe", 88, 83);
        students[118] = new Student("OR24109019", "200010203040", "Kumara Karunaratne", 75, 45);
        students[119] = new Student("OR24109020", "200608789012", "Silva Dias", 90, 62);
        students[120] = new Student("PR24109021", "200012345678", "Perera Weerasinghe", 57, 66);
        students[121] = new Student("PR24109022", "199812345679", "Karunaratne Rajapaksha", 79, 59);
        students[122] = new Student("OR24109023", "199902345678", "Jayasinghe Silva", 92, 78);
        students[123] = new Student("OR24109024", "199712345670", "Rathnayake Perera", 62, 85);
        students[124] = new Student("PR24109025", "200102345671", "Silva Ekanayake", 100, 56);
        students[125] = new Student("PR24110001", "200203456782", "Silva Karunaratne", -2, -2);
        students[126] = new Student("PR24110002", "200305678901", "Herath Fernando", -2, -2);
        students[127] = new Student("PR24110003", "199601234567", "Kumara Jayasinghe", -2, -2);
        students[128] = new Student("PR24110004", "199511223344", "Weerasinghe Perera", -2, -2);
        students[129] = new Student("PR24110005", "200412345678", "Abeysekera Rajapaksha", -2, -2);
        students[130] = new Student("PR24110006", "200512345678", "Rathnayake Karunaratne", -2, -2);
        students[131] = new Student("PR24110007", "199909876543", "Ekanayake Bandara", -2, -2);
        students[132] = new Student("PR24110008", "199812346789", "Gunawardena Perera", -2, -2);
        students[133] = new Student("PR24110009", "200010203040", "Silva Wijesinghe", -2, -2);
        students[134] = new Student("PR24110010", "200608789012", "Rajapaksha Jayasinghe", -2, -2);
        students[135] = new Student("OR24110011", "200012345678", "Rathnayake Fernando", -2, -2);
        students[136] = new Student("OR24110012", "199812345679", "Karunaratne Kumara", -2, -2);
        students[137] = new Student("OR24110013", "199902345678", "Perera Silva", -2, -2);
        students[138] = new Student("OR24110014", "199712345670", "Gunawardena Ekanayake", -2, -2);
        students[139] = new Student("OR24110015", "200102345671", "Bandara Rajapaksha", -2, -2);
        students[140] = new Student("PR24110016", "200203456782", "Silva Herath", -2, -2);
        students[141] = new Student("PR24110017", "200305678901", "Rathnayake Weerasinghe", -2, -2);
        students[142] = new Student("PR24110018", "199601234567", "Perera Gunawardena", -2, -2);
        students[143] = new Student("OR24110019", "199511223344", "Herath Karunaratne", -2, -2);
        students[144] = new Student("OR24110020", "200412345678", "Silva Rajapaksha", -2, -2);
        students[145] = new Student("PR24110021", "200203456782", "Ekanayake Kumara", -2, -2);
        students[146] = new Student("PR24110022", "200305678901", "Bandara Herath", -2, -2);
        students[147] = new Student("OR24110023", "199601234567", "Weerasinghe Rajapaksha", -2, -2);
        students[148] = new Student("OR24110024", "199511223344", "Karunaratne Abeysekera", -2, -2);
        students[149] = new Student("PR24110025", "200412345678", "Perera Dias", -2, -2);

        batches[0] = new Batch(105, false, 0);
        batches[1] = new Batch(106, false, 0);
        batches[2] = new Batch(107, false, 0);
        batches[3] = new Batch(108, false, 0);
        batches[4] = new Batch(109, true, 0);
        batches[5] = new Batch(110, true, 0);

        for (int i = 0; i < studentCount; i++) {
            int batchNo = Integer.parseInt(students[i].getRegNo().substring(4, 7));
            int bIdx = findBatchIndex(batchNo);
            if (bIdx != -1) {
                batches[bIdx].incrementStudentCount();
            }
        }
    }

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
        }
    }

    public static void exit() {
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
    }

    public static int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine();
                return value;
            }
            System.out.println("Please enter a valid integer.");
            input.nextLine();
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

    public static int getValidMarks(String prompt) {
        while (true) {
            int value = getValidInt(prompt);
            if (value == -1 || (value >= 0 && value <= 100)) {
                return value;
            }
            System.out.println("Marks must be -1 (absent) or between 0 and 100.");
        }
    }

    public static void printHeader(String title) {
        System.out.println("-----------------------------------------------------------------------------");
        int pad = (79 - title.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pad; i++) sb.append(" ");
        System.out.println("|" + sb.toString() + title);
        System.out.println("-----------------------------------------------------------------------------\n");
    }

    public static Student[] growStudentArray(Student[] arr) {
        Student[] bigger = new Student[arr.length == 0 ? 1 : arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i];
        }
        return bigger;
    }

    public static Batch[] growBatchArray(Batch[] arr) {
        Batch[] bigger = new Batch[arr.length == 0 ? 1 : arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i];
        }
        return bigger;
    }

    public static int findBatchIndex(int batchNo) {
        for (int i = 0; i < batchCount; i++) {
            if (batches[i].getBatchNo() == batchNo) {
                return i;
            }
        }
        return -1;
    }

    public static int findStudentIndex(String regNo) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRegNo().equalsIgnoreCase(regNo)) {
                return i;
            }
        }
        return -1;
    }

    public static int findStudentIndexByNIC(String nic) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getNic().equals(nic)) {
                return i;
            }
        }
        return -1;
    }

    public static int getNextStudentNo(int batchNo) {
        int max = 0;
        for (int i = 0; i < studentCount; i++) {
            int b = Integer.parseInt(students[i].getRegNo().substring(4, 7));
            if (b == batchNo) {
                int studentNo = Integer.parseInt(students[i].getRegNo().substring(7, 10));
                if (studentNo > max) {
                    max = studentNo;
                }
            }
        }
        return max + 1;
    }

    public static void addStudentRecord(Student s) {
        if (studentCount == students.length) {
            students = growStudentArray(students);
        }
        students[studentCount] = s;
        studentCount++;
    }

    public static void removeStudentAt(int idx) {
        for (int i = idx; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        students[studentCount - 1] = null;
        studentCount--;
    }

    public static void addBatchRecord(int batchNo) {
        if (batchCount == batches.length) {
            batches = growBatchArray(batches);
        }
        batches[batchCount] = new Batch(batchNo, true, 0);
        batchCount++;
    }

    public static void displayStudentProfile(int idx) {
        Student s = students[idx];
        System.out.println("\n\tRegistration no\t\t: " + s.getRegNo());
        System.out.println("\tStudet Name\t\t: " + s.getName());
        System.out.println("\tStudet NIC\t\t: " + s.getNic());
        System.out.println("\tStudet PRF Marks\t: " + Student.marksDisplay(s.getPrfMarks()));
        System.out.println("\tStudet DBMS Marks\t: " + Student.marksDisplay(s.getDbmsMarks()));
        System.out.println("\tStudet GPA\t\t: " + s.computeGPA());
    }

    public static void homePage() {
        do {
            printHeader("iCET Student Management System");
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
        } while (true);
    }

    public static void studentManagement() {
        boolean back = false;

        do {
            printHeader("Student Management");
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

        } while (!back);
    }

    public static void AddStudent() {
        boolean back = false;

        do {
            printHeader("Add Student");

            int batchNo = getValidInt("Enter Batch Number (Students should be added): ");
            int bIdx = findBatchIndex(batchNo);

            if (bIdx == -1) {
                System.out.println("\n\tThis batch does not exist in the system.");
                String ans = getYesNo("Do you want to add student to another Batch (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            if (!batches[bIdx].isEnrollmentOpen()) {
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

                addStudentRecord(new Student(newRegNo, nic, name, -2, -2));
                batches[bIdx].incrementStudentCount();

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
            printHeader("Update Student");

            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student details (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            Student s = students[idx];
            System.out.println("\n\tStudet Name\t: " + s.getName());
            System.out.println("\tStudet NIC\t: " + s.getNic());
            System.out.println("\nWhat do you want to update ?");
            System.out.println("\t(01) Student Name");
            System.out.println("\t(02) Student NIC");

            int opt = getValidInt("\nEnter your option - ", 1, 2);

            if (opt == 1) {
                System.out.println("\nStudent Name Update");
                System.out.println("====================");
                System.out.println("Registration No\t\t: " + s.getRegNo());
                System.out.println("Student NIC\t\t: " + s.getNic());
                System.out.println("Studet Current Name\t: " + s.getName());
                String newName = getValidString("\nEnter student name to update - ");
                s.setName(newName);
                System.out.println("\n\tStudent name updated successfully...");
            } else {
                System.out.println("\nStudent NIC Update");
                System.out.println("====================");
                System.out.println("Registration No\t\t: " + s.getRegNo());
                System.out.println("Student Name\t\t: " + s.getName());
                System.out.println("Student Current NIC\t: " + s.getNic());
                String newNic = getValidString("\nEnter student NIC to update - ");
                int dupIdx = findStudentIndexByNIC(newNic);
                if (dupIdx != -1 && dupIdx != idx) {
                    System.out.println("\n\tThis student is already added to the system...");
                } else {
                    s.setNic(newNic);
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
            printHeader("View Student's Profile");

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
            printHeader("Delete Student Profile");

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
                int batchNo = Integer.parseInt(students[idx].getRegNo().substring(4, 7));
                int bIdx = findBatchIndex(batchNo);
                removeStudentAt(idx);
                if (bIdx != -1) batches[bIdx].decrementStudentCount();
                System.out.println("\n\tStudent was successfully deleted from the system.");
            }

            String again = getYesNo("\nDo you want to delete another student profile (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void batchManagement() {
        boolean back = false;

        do {
            printHeader("Batch Management");
            System.out.println("[1] Add Batch");
            System.out.println("\n[2] Update Batch ");
            System.out.println("\n[3] View Batches");
            System.out.println("\n[4] Exit");

            int Btoption = getValidInt("\n\nEnter an option to continue > ", 1, 4);

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
                    back = true;
                    clearConsole();
                    break;
            }
        } while (!back);
    }

    public static void AddBatch() {
        boolean back = false;

        do {
            printHeader("Add Batch");

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
            printHeader("Update Batch");

            int batchNo = getValidInt("Enter Batch Number : ");
            int idx = findBatchIndex(batchNo);

            if (idx == -1) {
                System.out.println("This batch does not exist in the system.");
                String ans = getYesNo("Do you want to update another batch details (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            String currentStatus = batches[idx].isEnrollmentOpen() ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
            String newStatusName = batches[idx].isEnrollmentOpen() ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN";
            System.out.println("Current Status : " + currentStatus);

            String confirm = getYesNo("\nDo you want to change the batch status to " + newStatusName + "(Y/N) ? ");
            if (confirm.equals("Y")) {
                batches[idx].setEnrollmentOpen(!batches[idx].isEnrollmentOpen());
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
            printHeader("View Batch");
            System.out.printf("%-4s%-11s%-15s%-20s%n", "No", "Batch No", "Student Count", "Status");
            System.out.println("-------------------------------------------------------------");
            for (int i = 0; i < batchCount; i++) {
                String status = batches[i].isEnrollmentOpen() ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
                System.out.printf("%-4d%-11d%-15d%-20s%n", i + 1, batches[i].getBatchNo(),
                        batches[i].getStudentCount(), status);
            }

            String again = getYesNo("\nDo you want to go to the home page (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void gradeManagement() {
        do {
            printHeader("Grade Management");
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
        } while (true);
    }

    public static void PRFMarksUpdate() {
        boolean back = false;

        do {
            printHeader("PRF Marks Update");

            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student PRF marks (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            Student s = students[idx];
            System.out.println("\n\tRegistration no\t: " + s.getRegNo());
            System.out.println("\tStudet Name\t: " + s.getName());
            System.out.println("\tStudet NIC\t: " + s.getNic());

            int current = s.getPrfMarks();
            boolean proceed = true;

            if (current >= 0) {
                System.out.println("\nThis student has already completed the PRF module.");
                System.out.println("\tPRF Marks : " + current);
                String upd = getYesNo("\nDo you want to update this student's PRF marks? ");
                proceed = upd.equals("Y");
            } else if (current == -1) {
                System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it..");
            }

            if (proceed) {
                int marks = getValidMarks("\tEnter PRF Marks : ");
                s.setPrfMarks(marks);
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
            printHeader("DBMS Marks Update");

            String regNo = getValidString("Enter Student Registration No: ");
            int idx = findStudentIndex(regNo);

            if (idx == -1) {
                System.out.println("\n\tThis student not exist in the system.");
                String ans = getYesNo("Do you want to update another student DBMS marks (Y/N): ");
                if (ans.equals("N")) back = true;
                clearConsole();
                continue;
            }

            Student s = students[idx];
            System.out.println("\n\tRegistration no\t: " + s.getRegNo());
            System.out.println("\tStudet Name\t: " + s.getName());
            System.out.println("\tStudet NIC\t: " + s.getNic());

            int current = s.getDbmsMarks();
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
                s.setDbmsMarks(marks);
                System.out.println("\n\tThis student DBMS Marks updated successfully...");
            }

            String again = getYesNo("\nDo you want to update another student DBMS marks (Y/N): ");
            if (again.equals("N")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void reportGenerator() {
        do {
            printHeader("Report Generator");
            System.out.println("[1] Student Registration Report\n");
            System.out.println("[2] Batch-wise Student Report\n");
            System.out.println("[3] Industry Training Eligibility Report\n");
            System.out.println("[4] Exit");

            int Report = getValidInt("\n\nEnter an option to continue > ", 1, 4);

            switch (Report) {
                case 1:
                    clearConsole();
                    studentRegistrationReport();
                    break;
                case 2:
                    clearConsole();
                    batchWiseStudentReport();
                    break;
                case 3:
                    clearConsole();
                    industryTrainingEligibilityReport();
                    break;
                case 4:
                    clearConsole();
                    return;
            }
        } while (true);
    }

    public static void printReportHeader() {
        System.out.printf("%-4s%-14s%-26s%-16s%-11s%-12s%-6s%n",
                "No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA");
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public static void printReportRow(int no, int idx) {
        Student s = students[idx];
        System.out.printf("%-4d%-14s%-26s%-16s%-11s%-12s%.2f%n",
                no, s.getRegNo(), s.getName(), s.getNic(),
                Student.marksDisplay(s.getPrfMarks()), Student.marksDisplay(s.getDbmsMarks()), s.computeGPA());
    }

    public static int[] sortedIndicesByName() {
        int[] order = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            order[i] = i;
        }
        for (int i = 0; i < order.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < order.length; j++) {
                if (students[order[j]].getName().compareTo(students[order[minPos]].getName()) < 0) {
                    minPos = j;
                }
            }
            int temp = order[i];
            order[i] = order[minPos];
            order[minPos] = temp;
        }
        return order;
    }

    public static void studentRegistrationReport() {
        boolean back = false;

        do {
            printHeader("Student Registration Report");
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

    public static void batchWiseStudentReport() {
        boolean back = false;

        do {
            printHeader("Batch-wise Student Report");
            for (int i = 0; i < batchCount; i++) {
                System.out.println("[" + (i + 1) + "] " + batches[i].getBatchNo() + " Batch");
            }
            System.out.println("\n[" + (batchCount + 1) + "] Exit");

            int opt = getValidInt("\nEnter an option to continue > ", 1, batchCount + 1);

            if (opt == batchCount + 1) {
                back = true;
                clearConsole();
                continue;
            }

            int batchNo = batches[opt - 1].getBatchNo();
            clearConsole();
            printHeader(batchNo + " Batch Student Report");
            printReportHeader();

            int no = 1;
            for (int i = 0; i < studentCount; i++) {
                int b = Integer.parseInt(students[i].getRegNo().substring(4, 7));
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

    public static void industryTrainingEligibilityReport() {
        boolean back = false;

        do {
            printHeader("Industry Training Eligibility Student Report");
            printReportHeader();

            int no = 1;
            for (int i = 0; i < studentCount; i++) {
                Student s = students[i];
                double gpa = s.computeGPA();
                if (gpa > 3.25 && s.getPrfMarks() > 50 && s.getDbmsMarks() > 50) {
                    printReportRow(no, i);
                    no++;
                }
            }

            String again = getYesNo("\nDo you want to go to homepage (Y/N): ");
            if (again.equals("Y")) back = true;
            clearConsole();
        } while (!back);
    }

    public static void main(String args[]) {
        homePage();
    }
}