import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/* =========================================================================
   iCET Student Management System
   OOP - Day 02 / Milestone 01

   A Java Swing GUI application covering the required options of the
   coursework document:

       1.  Student Management
               1.1  Add Student
               1.2  Update Student          (name and NIC only)
               1.3  View Student Profile    (6 details + GPA)
               1.4  Delete Student Profile

       2.  Batch Management
               2.1  Add Batch
               2.2  Update Batch            (enrollment status only)
               2.3  View Batches

       3.  Grade Management
               3.1  PRF Marks Update
               3.2  DBMS Marks Update

   Structure of this file
   ----------------------
       1. CoreStudent        - encapsulated student record + GPA calculation
       2. CoreBatch          - encapsulated batch record + enrollment status
       3. CoreStore          - every record and all the searching / inserting /
                              deleting logic (this is the "database")
       4. CoreGui            - helper class for fonts, buttons and messages
       5. CoreScreen         - base class used by every screen
       6. The screens        - one class per screen
       7. CoreManagementSystem - the main window (main method)

   Every screen is a JPanel kept inside a CardLayout of one single JFrame,
   so the user moves between the screens of the application without opening
   any extra window.

   (The class names carry a "Core" prefix so that this file can be placed
   next to the other coursework files without clashing with their classes.)
   ========================================================================= */

class CoreStudent {
    private String regNo;
    private String nic;
    private String name;
    private int prfMarks;
    private int dbmsMarks;

    CoreStudent(String regNo, String nic, String name, int prfMarks, int dbmsMarks) {
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

    // The batch number is hidden inside the 10 character registration number.
    // PR24105001 -> characters 4, 5 and 6 -> 105
    public int getBatchNo() {
        return Integer.parseInt(regNo.substring(4, 7));
    }

    // GPA of a single mark
    // -1 (absent) and -2 (exam not conducted) give a GPA of 0.00
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

    // (PRF Marks GPA + DBMS Marks GPA) / 2
    public double computeGPA() {
        return (marksToGPA(prfMarks) + marksToGPA(dbmsMarks)) / 2.0;
    }

    public static String marksDisplay(int marks) {
        if (marks == -1) return "Absent";
        if (marks == -2) return "Not Conducted";
        return String.valueOf(marks);
    }
}

class CoreBatch {
    private int batchNo;
    private boolean enrollmentOpen;
    private int studentCount;

    CoreBatch(int batchNo, boolean enrollmentOpen, int studentCount) {
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

    // ENROLLMENTOPEN = 1 , ENROLLMENTCLOSED = 0
    public String getStatus() {
        return enrollmentOpen ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
    }
}

/* Holds every student and batch record together with all the searching,
   inserting and deleting logic used by the screens. */
class CoreStore {

    public static CoreStudent[] students = new CoreStudent[150];
    public static int studentCount = students.length;

    public static CoreBatch[] batches = new CoreBatch[6];
    public static int batchCount = batches.length;

    static {
        students[0] = new CoreStudent("PR24105001", "199501012345", "Gunawardena Weerasinghe", 85, 66);
        students[1] = new CoreStudent("PR24105002", "199503153872", "Senanayake Silva", 39, 45);
        students[2] = new CoreStudent("PR24105003", "199506202198", "Silva Kumara", -1, 93);
        students[3] = new CoreStudent("PR24105004", "199509102983", "Kumara Herath", 72, 58);
        students[4] = new CoreStudent("PR24105005", "199511258739", "Rathnayake Herath", 44, -1);
        students[5] = new CoreStudent("PR24105006", "199512303498", "Wijesinghe Bandara", 91, 37);
        students[6] = new CoreStudent("PR24105007", "199502183764", "Rajapaksha Herath", 60, 88);
        students[7] = new CoreStudent("PR24105008", "199504223198", "Senanayake Karunaratne", 38, 21);
        students[8] = new CoreStudent("PR24105009", "199508153210", "Karunaratne Jayasinghe", 95, 79);
        students[9] = new CoreStudent("PR24105010", "199510293417", "Gunawardena Silva", 49, 40);
        students[10] = new CoreStudent("OR24105011", "199601102375", "Weerasinghe Rajapaksha", -1, 76);
        students[11] = new CoreStudent("OR24105012", "199604182938", "Silva Rathnayake", 67, 54);
        students[12] = new CoreStudent("OR24105013", "199606243879", "Fernando Perera", 23, -1);
        students[13] = new CoreStudent("OR24105014", "199608142178", "Kumara Abeysekera", 58, 69);
        students[14] = new CoreStudent("OR24105015", "199610312475", "Ekanayake Rathnayake", 88, 92);
        students[15] = new CoreStudent("PR24105016", "199611173452", "Herath Gunawardena", 81, 25);
        students[16] = new CoreStudent("PR24105017", "199603293481", "Abeysekera Silva", 73, 84);
        students[17] = new CoreStudent("PR24105018", "199605083217", "Weerasinghe Silva", 29, 33);
        students[18] = new CoreStudent("OR24105019", "199607232198", "Jayasinghe Dias", 62, 60);
        students[19] = new CoreStudent("OR24105020", "199609192375", "Bandara Rathnayake", -1, 71);
        students[20] = new CoreStudent("PR24105021", "199701212483", "Silva Perera", 79, 59);
        students[21] = new CoreStudent("PR24105022", "199703132487", "De Silva Dias", 53, -1);
        students[22] = new CoreStudent("OR24105023", "199706253478", "Abeysekera Jayasinghe", 94, 98);
        students[23] = new CoreStudent("OR24105024", "199708083298", "Rajapaksha Senanayake", 47, 27);
        students[24] = new CoreStudent("PR24105025", "199710243651", "Kumara Karunaratne", 35, 48);
        students[25] = new CoreStudent("PR24106001", "199712152983", "Silva Abeysekera", 93, 35);
        students[26] = new CoreStudent("PR24106002", "199702182734", "Jayasinghe Bandara", 15, 91);
        students[27] = new CoreStudent("PR24106003", "199704293187", "Rathnayake Kumara", -1, 60);
        students[28] = new CoreStudent("PR24106004", "199705142375", "Weerasinghe Rajapaksha", 82, -1);
        students[29] = new CoreStudent("PR24106005", "199709083751", "Senanayake Herath", 45, 72);
        students[30] = new CoreStudent("PR24106006", "199801032874", "Perera Ekanayake", 88, 49);
        students[31] = new CoreStudent("PR24106007", "199803232871", "Herath Jayasinghe", 23, 26);
        students[32] = new CoreStudent("PR24106008", "199806193428", "Kumara Gunawardena", 79, 80);
        students[33] = new CoreStudent("PR24106009", "199808013764", "Abeysekera Silva", 37, 14);
        students[34] = new CoreStudent("PR24106010", "199810242374", "Dias Fernando", -1, 89);
        students[35] = new CoreStudent("OR24106011", "199812302984", "Karunaratne Weerasinghe", 68, 67);
        students[36] = new CoreStudent("OR24106012", "199802152348", "Ekanayake Bandara", 100, -1);
        students[37] = new CoreStudent("OR24106013", "199805213471", "Rajapaksha Kumara", 59, 31);
        students[38] = new CoreStudent("OR24106014", "199807172398", "Silva De Silva", 29, 94);
        students[39] = new CoreStudent("OR24106015", "199811283472", "Gunawardena Rathnayake", 92, 53);
        students[40] = new CoreStudent("PR24106016", "199901122471", "Bandara Karunaratne", 12, 78);
        students[41] = new CoreStudent("PR24106017", "199903052984", "Fernando Perera", 77, 5);
        students[42] = new CoreStudent("PR24106018", "199906213874", "De Silva Silva", 38, 90);
        students[43] = new CoreStudent("OR24106019", "199908093412", "Rajapaksha Gunawardena", 66, 24);
        students[44] = new CoreStudent("OR24106020", "199910273894", "Herath Weerasinghe", 9, 86);
        students[45] = new CoreStudent("PR24106021", "199912153482", "Karunaratne Dias", 84, 39);
        students[46] = new CoreStudent("PR24106022", "199902202394", "Jayasinghe Silva", 51, -1);
        students[47] = new CoreStudent("OR24106023", "199904163874", "Senanayake Abeysekera", 32, 61);
        students[48] = new CoreStudent("OR24106024", "199907293481", "Silva Jayasinghe", -1, 73);
        students[49] = new CoreStudent("PR24106025", "199911083479", "Rathnayake Kumara", 97, 100);
        students[50] = new CoreStudent("PR24107001", "200001112374", "Gunawardena Kumara", 95, 38);
        students[51] = new CoreStudent("PR24107002", "200003143478", "Rajapaksha Silva", -1, 91);
        students[52] = new CoreStudent("PR24107003", "200006293874", "Perera Jayasinghe", 63, -1);
        students[53] = new CoreStudent("PR24107004", "200008103471", "Silva Ekanayake", 88, 74);
        students[54] = new CoreStudent("PR24107005", "200010252984", "Dias Senanayake", 32, 55);
        students[55] = new CoreStudent("PR24107006", "200012043894", "Herath Abeysekera", 76, 82);
        students[56] = new CoreStudent("PR24107007", "200002193874", "Rathnayake Fernando", 97, 66);
        students[57] = new CoreStudent("PR24107008", "200004212374", "Kumara Herath", 54, 49);
        students[58] = new CoreStudent("PR24107009", "200005183492", "Weerasinghe Silva", -1, 99);
        students[59] = new CoreStudent("PR24107010", "200007153871", "Senanayake Karunaratne", 23, 13);
        students[60] = new CoreStudent("OR24107011", "200101232984", "Abeysekera Silva", 90, 80);
        students[61] = new CoreStudent("OR24107012", "200103083471", "Bandara Gunawardena", 35, 70);
        students[62] = new CoreStudent("OR24107013", "200106273894", "Karunaratne Weerasinghe", 81, 93);
        students[63] = new CoreStudent("OR24107014", "200108123984", "Perera Herath", 61, 36);
        students[64] = new CoreStudent("OR24107015", "200110043728", "Fernando Dias", 44, 59);
        students[65] = new CoreStudent("PR24107016", "200112213874", "Weerasinghe Gunawardena", 67, 85);
        students[66] = new CoreStudent("PR24107017", "200102253471", "Rathnayake Kumara", 100, 47);
        students[67] = new CoreStudent("PR24107018", "200104103874", "Senanayake Fernando", 17, 90);
        students[68] = new CoreStudent("OR24107019", "200105293784", "Silva Bandara", 85, -1);
        students[69] = new CoreStudent("OR24107020", "200107202983", "Herath Rajapaksha", 29, 22);
        students[70] = new CoreStudent("PR24107021", "200201013874", "Kumara Jayasinghe", 70, 77);
        students[71] = new CoreStudent("PR24107022", "200203253471", "Abeysekera Perera", 42, 34);
        students[72] = new CoreStudent("OR24107023", "200206143874", "Rathnayake Jayasinghe", -1, 63);
        students[73] = new CoreStudent("OR24107024", "200208083471", "Kumara Weerasinghe", 60, 100);
        students[74] = new CoreStudent("PR24107025", "200210293874", "Rajapaksha Ekanayake", 86, 29);
        students[75] = new CoreStudent("PR24108001", "200212183471", "Fernando Rajapaksha", 86, 79);
        students[76] = new CoreStudent("PR24108002", "200202103874", "Silva Gunawardena", 57, 62);
        students[77] = new CoreStudent("PR24108003", "200204123894", "Perera Wijesinghe", 91, 87);
        students[78] = new CoreStudent("PR24108004", "200205283471", "Herath Abeysekera", 35, -1);
        students[79] = new CoreStudent("PR24108005", "200207153874", "Rajapaksha Ekanayake", -1, 54);
        students[80] = new CoreStudent("PR24108006", "200301093874", "Karunaratne Silva", 76, 46);
        students[81] = new CoreStudent("PR24108007", "200303283471", "Weerasinghe Fernando", 48, 99);
        students[82] = new CoreStudent("PR24108008", "200306153874", "Silva Bandara", 94, 39);
        students[83] = new CoreStudent("PR24108009", "200308123471", "Abeysekera Weerasinghe", 23, 70);
        students[84] = new CoreStudent("PR24108010", "200310083874", "Kumara Karunaratne", 69, -1);
        students[85] = new CoreStudent("OR24108011", "200312243471", "Dias Rajapaksha", -1, 75);
        students[86] = new CoreStudent("OR24108012", "200302273874", "Herath Perera", 80, 83);
        students[87] = new CoreStudent("OR24108013", "200304203471", "Rathnayake Gunawardena", 55, 58);
        students[88] = new CoreStudent("OR24108014", "200305123874", "Ekanayake Jayasinghe", 88, 92);
        students[89] = new CoreStudent("OR24108015", "200307213471", "Gunawardena Silva", 32, 30);
        students[90] = new CoreStudent("PR24108016", "200401153874", "Rajapaksha Perera", 100, 91);
        students[91] = new CoreStudent("PR24108017", "200403123471", "Karunaratne Jayasinghe", 67, 40);
        students[92] = new CoreStudent("PR24108018", "200406293874", "Weerasinghe Abeysekera", 43, 63);
        students[93] = new CoreStudent("OR24108019", "200408083471", "Rathnayake Fernando", -1, 95);
        students[94] = new CoreStudent("OR24108020", "200410213874", "Kumara Herath", 90, 68);
        students[95] = new CoreStudent("PR24108021", "200412153471", "Silva Weerasinghe", 60, -1);
        students[96] = new CoreStudent("PR24108022", "200402203874", "Herath Karunaratne", 77, 66);
        students[97] = new CoreStudent("OR24108023", "200404273471", "Abeysekera Silva", 25, 21);
        students[98] = new CoreStudent("OR24108024", "200405143874", "Gunawardena Ekanayake", 71, 88);
        students[99] = new CoreStudent("PR24108025", "200407183471", "Weerasinghe Kumara", 84, 37);
        students[100] = new CoreStudent("PR24109001", "200501023874", "Weerasinghe Kumara", 92, 67);
        students[101] = new CoreStudent("PR24109002", "200503193471", "Rajapaksha Abeysekera", 68, 91);
        students[102] = new CoreStudent("PR24109003", "200506153874", "Gunawardena Perera", 59, 85);
        students[103] = new CoreStudent("PR24109004", "200508213471", "Karunaratne Silva", 85, 73);
        students[104] = new CoreStudent("PR24109005", "200510083874", "Herath Wijesinghe", 63, 70);
        students[105] = new CoreStudent("PR24109006", "200512293471", "Rathnayake Ekanayake", 76, 63);
        students[106] = new CoreStudent("PR24109007", "200502123874", "Silva Fernando", 91, 76);
        students[107] = new CoreStudent("PR24109008", "200504153471", "Abeysekera Rajapaksha", 70, 88);
        students[108] = new CoreStudent("PR24109009", "200505283874", "Fernando Bandara", 84, 55);
        students[109] = new CoreStudent("PR24109010", "200507173471", "Perera Herath", 63, 64);
        students[110] = new CoreStudent("OR24109011", "200203456782", "Weerasinghe Jayasinghe", 72, 79);
        students[111] = new CoreStudent("OR24109012", "200305678901", "Silva Karunaratne", 89, 80);
        students[112] = new CoreStudent("OR24109013", "199601234567", "Rathnayake Gunawardena", 45, 59);
        students[113] = new CoreStudent("OR24109014", "199511223344", "Herath Kumara", 81, 92);
        students[114] = new CoreStudent("OR24109015", "200412345678", "Abeysekera Silva", 77, 68);
        students[115] = new CoreStudent("PR24109016", "200512345678", "Ekanayake Bandara", 68, 100);
        students[116] = new CoreStudent("PR24109017", "199909876543", "Rajapaksha Fernando", 63, 77);
        students[117] = new CoreStudent("PR24109018", "199812346789", "Gunawardena Weerasinghe", 88, 83);
        students[118] = new CoreStudent("OR24109019", "200010203040", "Kumara Karunaratne", 75, 45);
        students[119] = new CoreStudent("OR24109020", "200608789012", "Silva Dias", 90, 62);
        students[120] = new CoreStudent("PR24109021", "200012345678", "Perera Weerasinghe", 57, 66);
        students[121] = new CoreStudent("PR24109022", "199812345679", "Karunaratne Rajapaksha", 79, 59);
        students[122] = new CoreStudent("OR24109023", "199902345678", "Jayasinghe Silva", 92, 78);
        students[123] = new CoreStudent("OR24109024", "199712345670", "Rathnayake Perera", 62, 85);
        students[124] = new CoreStudent("PR24109025", "200102345671", "Silva Ekanayake", 100, 56);
        students[125] = new CoreStudent("PR24110001", "200203456782", "Silva Karunaratne", -2, -2);
        students[126] = new CoreStudent("PR24110002", "200305678901", "Herath Fernando", -2, -2);
        students[127] = new CoreStudent("PR24110003", "199601234567", "Kumara Jayasinghe", -2, -2);
        students[128] = new CoreStudent("PR24110004", "199511223344", "Weerasinghe Perera", -2, -2);
        students[129] = new CoreStudent("PR24110005", "200412345678", "Abeysekera Rajapaksha", -2, -2);
        students[130] = new CoreStudent("PR24110006", "200512345678", "Rathnayake Karunaratne", -2, -2);
        students[131] = new CoreStudent("PR24110007", "199909876543", "Ekanayake Bandara", -2, -2);
        students[132] = new CoreStudent("PR24110008", "199812346789", "Gunawardena Perera", -2, -2);
        students[133] = new CoreStudent("PR24110009", "200010203040", "Silva Wijesinghe", -2, -2);
        students[134] = new CoreStudent("PR24110010", "200608789012", "Rajapaksha Jayasinghe", -2, -2);
        students[135] = new CoreStudent("OR24110011", "200012345678", "Rathnayake Fernando", -2, -2);
        students[136] = new CoreStudent("OR24110012", "199812345679", "Karunaratne Kumara", -2, -2);
        students[137] = new CoreStudent("OR24110013", "199902345678", "Perera Silva", -2, -2);
        students[138] = new CoreStudent("OR24110014", "199712345670", "Gunawardena Ekanayake", -2, -2);
        students[139] = new CoreStudent("OR24110015", "200102345671", "Bandara Rajapaksha", -2, -2);
        students[140] = new CoreStudent("PR24110016", "200203456782", "Silva Herath", -2, -2);
        students[141] = new CoreStudent("PR24110017", "200305678901", "Rathnayake Weerasinghe", -2, -2);
        students[142] = new CoreStudent("PR24110018", "199601234567", "Perera Gunawardena", -2, -2);
        students[143] = new CoreStudent("OR24110019", "199511223344", "Herath Karunaratne", -2, -2);
        students[144] = new CoreStudent("OR24110020", "200412345678", "Silva Rajapaksha", -2, -2);
        students[145] = new CoreStudent("PR24110021", "200203456782", "Ekanayake Kumara", -2, -2);
        students[146] = new CoreStudent("PR24110022", "200305678901", "Bandara Herath", -2, -2);
        students[147] = new CoreStudent("OR24110023", "199601234567", "Weerasinghe Rajapaksha", -2, -2);
        students[148] = new CoreStudent("OR24110024", "199511223344", "Karunaratne Abeysekera", -2, -2);
        students[149] = new CoreStudent("PR24110025", "200412345678", "Perera Dias", -2, -2);

        batches[0] = new CoreBatch(105, false, 0);
        batches[1] = new CoreBatch(106, false, 0);
        batches[2] = new CoreBatch(107, false, 0);
        batches[3] = new CoreBatch(108, false, 0);
        batches[4] = new CoreBatch(109, true, 0);
        batches[5] = new CoreBatch(110, true, 0);

        for (int i = 0; i < studentCount; i++) {
            int batchNo = Integer.parseInt(students[i].getRegNo().substring(4, 7));
            int bIdx = findBatchIndex(batchNo);
            if (bIdx != -1) {
                batches[bIdx].incrementStudentCount();
            }
        }
    }

    // ---------- array handling ----------

    public static CoreStudent[] growStudentArray(CoreStudent[] arr) {
        CoreStudent[] newArr = new CoreStudent[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static CoreBatch[] growBatchArray(CoreBatch[] arr) {
        CoreBatch[] newArr = new CoreBatch[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // ---------- searching ----------

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

    public static CoreStudent getStudent(String regNo) {
        int idx = findStudentIndex(regNo);
        return (idx == -1) ? null : students[idx];
    }

    public static CoreBatch getBatch(int batchNo) {
        int idx = findBatchIndex(batchNo);
        return (idx == -1) ? null : batches[idx];
    }

    // Next sequential number of the batch - the numbers are never random
    public static int getNextStudentNo(int batchNo) {
        int max = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getBatchNo() == batchNo) {
                int studentNo = Integer.parseInt(students[i].getRegNo().substring(7, 10));
                if (studentNo > max) {
                    max = studentNo;
                }
            }
        }
        return max + 1;
    }

    // Builds the new 10 character registration number
    // physical -> PR , online -> OR
    public static String generateRegNo(int batchNo, String mode) {
        String prefix = mode.startsWith("P") ? "PR" : "OR";
        return prefix + "24" + String.format("%03d", batchNo) + String.format("%03d", getNextStudentNo(batchNo));
    }

    // ---------- inserting / removing ----------

    public static void addStudentRecord(CoreStudent s) {
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
        // a new batch always starts with ENROLLMENTOPEN
        batches[batchCount] = new CoreBatch(batchNo, true, 0);
        batchCount++;
    }

    public static void removeBatchAt(int idx) {
        for (int i = idx; i < batchCount - 1; i++) {
            batches[i] = batches[i + 1];
        }
        batches[batchCount - 1] = null;
        batchCount--;
    }
}

/* Small helper class so that every screen of the application looks the same.
   It only builds fonts, labels, buttons and the message boxes. */
class CoreGui {

    public static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 22);
    public static final Font HEAD_FONT = new Font("Arial", Font.BOLD, 15);
    public static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font VALUE_FONT = new Font("Arial", Font.BOLD, 14);

    public static JLabel title(String text) {
        JLabel l = new JLabel(text, JLabel.CENTER);
        l.setFont(TITLE_FONT);
        l.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));
        return l;
    }

    public static JButton menuButton(String text) {
        JButton b = new JButton(text);
        b.setFont(HEAD_FONT);
        b.setPreferredSize(new Dimension(260, 65));
        return b;
    }

    public static JButton actionButton(String text) {
        JButton b = new JButton(text);
        b.setFont(LABEL_FONT);
        b.setPreferredSize(new Dimension(170, 34));
        return b;
    }

    public static JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(LABEL_FONT);
        return l;
    }

    public static JLabel value(String text) {
        JLabel l = new JLabel(text);
        l.setFont(VALUE_FONT);
        return l;
    }

    public static JTextField textField(int columns) {
        JTextField t = new JTextField(columns);
        t.setFont(LABEL_FONT);
        return t;
    }

    public static void info(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "iCET Student Management System",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warn(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    // returns the marks entered by the user, -99 when the entry is not valid
    public static int readMarks(Component parent, String text) {
        try {
            int marks = Integer.parseInt(text.trim());
            if (marks == -1 || (marks >= 0 && marks <= 100)) {
                return marks;
            }
            warn(parent, "Marks must be -1 (Absent) or a number between 0 and 100.");
        } catch (NumberFormatException e) {
            warn(parent, "Marks must be a whole number : -1, 0 - 100");
        }
        return -99;
    }
}

/* Implemented by the screens that must reload their data each time the user
   opens them (the batch drop down and the batch list). */
interface CoreRefreshable {
    void refresh();
}

/* Base class of every screen. All of them use BorderLayout :
        North  -> the title
        Center -> the content of the screen
        South  -> the buttons                                 */
class CoreScreen extends JPanel implements CoreRefreshable {
    private static final long serialVersionUID = 1L;


    protected final CoreManagementSystem app;

    CoreScreen(CoreManagementSystem app) {
        this.app = app;
        setLayout(new BorderLayout());
    }

    public void refresh() {
    }

    protected void addTitle(String text) {
        add(CoreGui.title(text), BorderLayout.NORTH);
    }

    // the "Back to Home Page" button required by the coursework
    protected void addBackToHome() {
        JButton back = CoreGui.actionButton("Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panel.add(back);
        add(panel, BorderLayout.SOUTH);
    }

    protected JButton menuButton(String text, String pageKey) {
        JButton b = CoreGui.menuButton(text);
        b.addActionListener(e -> app.go(pageKey));
        return b;
    }

    protected JPanel newForm(String borderTitle) {
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder(borderTitle));
        return form;
    }

    // label + field row used by the forms
    protected void addFormRow(JPanel form, int row, String text, Component field) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 6, 6, 6);
        form.add(CoreGui.label(text), gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(6, 6, 6, 6);
        form.add(field, gbc);
    }

    // a read only row of a student or batch profile
    protected void addDetailRow(JPanel panel, int row, String text, JLabel valueLabel) {
        addFormRow(panel, row, text, valueLabel);
    }

    // the 6 details of a student as one block of text
    protected String profileText(CoreStudent s) {
        return "Registration No : " + s.getRegNo() + "\n"
                + "Student Name    : " + s.getName() + "\n"
                + "Student NIC     : " + s.getNic() + "\n"
                + "PRF Marks       : " + CoreStudent.marksDisplay(s.getPrfMarks()) + "\n"
                + "DBMS Marks      : " + CoreStudent.marksDisplay(s.getDbmsMarks()) + "\n"
                + "Student GPA     : " + String.format("%.2f", s.computeGPA());
    }

    protected void showProfileMessage(Component parent, CoreStudent s) {
        JOptionPane.showMessageDialog(parent, profileText(s), "Student Profile",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

/* ================= 1. HOME PAGE ================= */
class CoreHomePage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    CoreHomePage(CoreManagementSystem app) {
        super(app);
        addTitle("iCET Student Management System");

        JPanel center = new JPanel(new GridLayout(1, 3, 30, 30));
        center.setBorder(BorderFactory.createEmptyBorder(50, 70, 50, 70));
        center.add(menuButton("[1]  Student Management", "student"));
        center.add(menuButton("[2]  Batch Management", "batch"));
        center.add(menuButton("[3]  Grade Management", "grade"));
        add(center, BorderLayout.CENTER);

        JButton exit = CoreGui.actionButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        south.add(exit);
        add(south, BorderLayout.SOUTH);
    }
}

/* ================= 2. STUDENT MANAGEMENT ================= */
class StudentManagementPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    StudentManagementPage(CoreManagementSystem app) {
        super(app);
        addTitle("Student Management");

        JPanel center = new JPanel(new GridLayout(2, 2, 30, 30));
        center.setBorder(BorderFactory.createEmptyBorder(50, 90, 50, 90));
        center.add(menuButton("[1]  Add Student", "addStudent"));
        center.add(menuButton("[2]  Update Student", "updateStudent"));
        center.add(menuButton("[3]  View Student Profile", "viewStudent"));
        center.add(menuButton("[4]  Delete Student Profile", "deleteStudent"));
        add(center, BorderLayout.CENTER);

        addBackToHome();
    }
}

/* ---------------- 2.1 Add Student ---------------- */
class AddStudentPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private JComboBox<Integer> cmbBatch;
    private JTextField txtNic;
    private JTextField txtName;
    private JComboBox<String> cmbMode;

    AddStudentPage(CoreManagementSystem app) {
        super(app);
        addTitle("Add New Student");

        cmbBatch = new JComboBox<Integer>();
        cmbBatch.setFont(CoreGui.LABEL_FONT);
        cmbBatch.setPreferredSize(new Dimension(230, 26));

        txtNic = CoreGui.textField(20);
        txtName = CoreGui.textField(20);

        cmbMode = new JComboBox<String>(new String[]{"PHYSICAL (PR)", "ONLINE (OR)"});
        cmbMode.setFont(CoreGui.LABEL_FONT);
        cmbMode.setPreferredSize(new Dimension(230, 26));

        JPanel form = newForm("Student Details");
        addFormRow(form, 0, "Batch          :", cmbBatch);
        addFormRow(form, 1, "Student NIC    :", txtNic);
        addFormRow(form, 2, "Student Name   :", txtName);
        addFormRow(form, 3, "Lecture Mode   :", cmbMode);

        JLabel note = CoreGui.label("PRF Marks = -2   |   DBMS Marks = -2   (exams are not conducted yet)");
        note.setFont(new Font("Arial", Font.ITALIC, 12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(12, 6, 6, 6);
        form.add(note, gbc);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
        center.add(form);
        add(center, BorderLayout.CENTER);

        JButton addBtn = CoreGui.actionButton("Add Student");
        addBtn.addActionListener(e -> addStudent());

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        south.add(addBtn);
        JButton back = CoreGui.actionButton("Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        south.add(back);
        add(south, BorderLayout.SOUTH);

        refresh();
    }

    // the drop down always shows the batches that are currently in the system
    public void refresh() {
        cmbBatch.removeAllItems();
        for (int i = 0; i < CoreStore.batchCount; i++) {
            cmbBatch.addItem(CoreStore.batches[i].getBatchNo());
        }
    }

    private void addStudent() {
        if (cmbBatch.getSelectedIndex() == -1) {
            CoreGui.warn(this, "There are no batches in the system.");
            return;
        }

        int batchNo = (Integer) cmbBatch.getSelectedItem();
        CoreBatch batch = CoreStore.getBatch(batchNo);

        // students can only be added when the enrollment is open
        if (!batch.isEnrollmentOpen()) {
            CoreGui.warn(this, "Students cannot be added to batch " + batchNo
                    + " because the ENROLLMENT is CLOSED.");
            return;
        }

        String nic = txtNic.getText().trim();
        if (nic.isEmpty()) {
            CoreGui.warn(this, "Please enter the student NIC.");
            return;
        }

        // the NIC must not already exist in the system
        int existingIndex = CoreStore.findStudentIndexByNIC(nic);
        if (existingIndex != -1) {
            CoreGui.warn(this, "This student is already added to the system.\n\n"
                    + profileText(CoreStore.students[existingIndex]));
            return;
        }

        String name = txtName.getText().trim();
        if (name.isEmpty()) {
            CoreGui.warn(this, "Please enter the student name.");
            return;
        }

        String mode = (String) cmbMode.getSelectedItem();
        String regNo = CoreStore.generateRegNo(batchNo, mode);

        // default marks are -2 because the exams are not conducted yet
        CoreStore.addStudentRecord(new CoreStudent(regNo, nic, name, -2, -2));
        batch.incrementStudentCount();

        txtNic.setText("");
        txtName.setText("");

        CoreGui.info(this, "Student Registration No : " + regNo + "\n\n"
                + "Student added successfully.");
    }
}

/* ---------------- 2.2 Update Student ---------------- */
class UpdateStudentPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private JTextField txtSearchId;
    private JLabel lblRegNo;
    private JLabel lblName;
    private JLabel lblNic;
    private JComboBox<String> cmbField;
    private JTextField txtNewValue;
    private JButton btnUpdate;
    private JLabel lblNewPrompt;
    private int currentIndex = -1;

    UpdateStudentPage(CoreManagementSystem app) {
        super(app);
        addTitle("Update Student Details");

        JPanel form = newForm("Find the Student");
        txtSearchId = CoreGui.textField(20);
        JButton btnSearch = CoreGui.actionButton("Search");
        btnSearch.addActionListener(e -> searchStudent());
        addFormRow(form, 0, "Student Registration No :", txtSearchId);
        addFormRow(form, 1, "", btnSearch);

        JPanel details = newForm("Current Student Details");
        lblRegNo = CoreGui.value("-");
        lblName = CoreGui.value("-");
        lblNic = CoreGui.value("-");
        addDetailRow(details, 0, "Registration No :", lblRegNo);
        addDetailRow(details, 1, "Student Name    :", lblName);
        addDetailRow(details, 2, "Student NIC     :", lblNic);

        JPanel updatePanel = newForm("Update");
        cmbField = new JComboBox<String>(new String[]{"Student Name", "Student NIC"});
        cmbField.setFont(CoreGui.LABEL_FONT);
        cmbField.setPreferredSize(new Dimension(230, 26));
        txtNewValue = CoreGui.textField(20);
        btnUpdate = CoreGui.actionButton("Update");
        btnUpdate.addActionListener(e -> updateStudent());
        lblNewPrompt = CoreGui.label("Enter the new student name :");

        addFormRow(updatePanel, 0, "Update          :", cmbField);
        addFormRow(updatePanel, 1, "", lblNewPrompt);
        addFormRow(updatePanel, 2, "", txtNewValue);
        addFormRow(updatePanel, 3, "", btnUpdate);
        setUpdateEnabled(false);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(15, 90, 15, 90));
        center.add(form);
        center.add(Box.createVerticalStrut(12));
        center.add(details);
        center.add(Box.createVerticalStrut(12));
        center.add(updatePanel);
        add(center, BorderLayout.CENTER);

        addBackToHome();
    }

    public void refresh() {
        currentIndex = -1;
        txtSearchId.setText("");
        txtNewValue.setText("");
        lblRegNo.setText("-");
        lblName.setText("-");
        lblNic.setText("-");
        setUpdateEnabled(false);
    }

    private void setUpdateEnabled(boolean enabled) {
        cmbField.setEnabled(enabled);
        txtNewValue.setEnabled(enabled);
        btnUpdate.setEnabled(enabled);
        lblNewPrompt.setEnabled(enabled);
    }

    private void searchStudent() {
        String regNo = txtSearchId.getText().trim();
        if (regNo.isEmpty()) {
            CoreGui.warn(this, "Please enter the student registration no.");
            return;
        }

        int idx = CoreStore.findStudentIndex(regNo);
        if (idx == -1) {
            currentIndex = -1;
            setUpdateEnabled(false);
            lblRegNo.setText("-");
            lblName.setText("-");
            lblNic.setText("-");
            CoreGui.warn(this, "This student not exist in the system.");
            return;
        }

        currentIndex = idx;
        CoreStudent s = CoreStore.students[idx];
        lblRegNo.setText(s.getRegNo());
        lblName.setText(s.getName());
        lblNic.setText(s.getNic());
        setUpdateEnabled(true);
    }

    private void updateStudent() {
        if (currentIndex == -1) {
            CoreGui.warn(this, "Please search a valid student first.");
            return;
        }

        String newValue = txtNewValue.getText().trim();
        if (newValue.isEmpty()) {
            CoreGui.warn(this, "Please enter the new value.");
            return;
        }

        CoreStudent s = CoreStore.students[currentIndex];

        if (cmbField.getSelectedIndex() == 0) {
            // student names are allowed to be duplicated
            s.setName(newValue);
        } else {
            int dup = CoreStore.findStudentIndexByNIC(newValue);
            if (dup != -1 && dup != currentIndex) {
                CoreGui.warn(this, "This NIC is already added to the system.");
                return;
            }
            s.setNic(newValue);
        }

        lblName.setText(s.getName());
        lblNic.setText(s.getNic());
        txtNewValue.setText("");
        CoreGui.info(this, "Student updated successfully.");
    }
}

/* ---------------- 2.3 View Student Profile ---------------- */
class ViewStudentPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private JTextField txtSearchId;
    private JLabel lblRegNo;
    private JLabel lblName;
    private JLabel lblNic;
    private JLabel lblPrf;
    private JLabel lblDbms;
    private JLabel lblGpa;

    ViewStudentPage(CoreManagementSystem app) {
        super(app);
        addTitle("View Student Profile");

        JPanel form = newForm("Find the Student");
        txtSearchId = CoreGui.textField(20);
        JButton btnSearch = CoreGui.actionButton("Search");
        btnSearch.addActionListener(e -> searchStudent());
        addFormRow(form, 0, "Student Registration No :", txtSearchId);
        addFormRow(form, 1, "", btnSearch);

        JPanel details = newForm("Student Profile");
        lblRegNo = CoreGui.value("-");
        lblName = CoreGui.value("-");
        lblNic = CoreGui.value("-");
        lblPrf = CoreGui.value("-");
        lblDbms = CoreGui.value("-");
        lblGpa = CoreGui.value("-");
        addDetailRow(details, 0, "Registration No :", lblRegNo);
        addDetailRow(details, 1, "Student Name    :", lblName);
        addDetailRow(details, 2, "Student NIC     :", lblNic);
        addDetailRow(details, 3, "PRF Marks       :", lblPrf);
        addDetailRow(details, 4, "DBMS Marks      :", lblDbms);
        addDetailRow(details, 5, "Student GPA     :", lblGpa);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(15, 110, 15, 110));
        center.add(form);
        center.add(Box.createVerticalStrut(12));
        center.add(details);
        add(center, BorderLayout.CENTER);

        addBackToHome();
    }

    public void refresh() {
        clearDetails();
    }

    private void clearDetails() {
        lblRegNo.setText("-");
        lblName.setText("-");
        lblNic.setText("-");
        lblPrf.setText("-");
        lblDbms.setText("-");
        lblGpa.setText("-");
    }

    private void searchStudent() {
        String regNo = txtSearchId.getText().trim();
        if (regNo.isEmpty()) {
            CoreGui.warn(this, "Please enter the student registration no.");
            return;
        }

        int idx = CoreStore.findStudentIndex(regNo);
        if (idx == -1) {
            clearDetails();
            CoreGui.warn(this, "This student does not exist in the system.");
            return;
        }

        CoreStudent s = CoreStore.students[idx];
        lblRegNo.setText(s.getRegNo());
        lblName.setText(s.getName());
        lblNic.setText(s.getNic());
        lblPrf.setText(CoreStudent.marksDisplay(s.getPrfMarks()));
        lblDbms.setText(CoreStudent.marksDisplay(s.getDbmsMarks()));
        lblGpa.setText(String.format("%.2f", s.computeGPA()));
    }
}

/* ---------------- 2.4 Delete Student Profile ---------------- */
class DeleteStudentPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private JTextField txtSearchId;
    private JLabel lblRegNo;
    private JLabel lblName;
    private JLabel lblNic;
    private JLabel lblPrf;
    private JLabel lblDbms;
    private JLabel lblGpa;
    private JButton btnDelete;
    private int currentIndex = -1;

    DeleteStudentPage(CoreManagementSystem app) {
        super(app);
        addTitle("Delete Student Profile");

        JPanel form = newForm("Find the Student");
        txtSearchId = CoreGui.textField(20);
        JButton btnSearch = CoreGui.actionButton("Search");
        btnSearch.addActionListener(e -> searchStudent());
        addFormRow(form, 0, "Student Registration No :", txtSearchId);
        addFormRow(form, 1, "", btnSearch);

        JPanel details = newForm("Student Profile");
        lblRegNo = CoreGui.value("-");
        lblName = CoreGui.value("-");
        lblNic = CoreGui.value("-");
        lblPrf = CoreGui.value("-");
        lblDbms = CoreGui.value("-");
        lblGpa = CoreGui.value("-");
        addDetailRow(details, 0, "Registration No :", lblRegNo);
        addDetailRow(details, 1, "Student Name    :", lblName);
        addDetailRow(details, 2, "Student NIC     :", lblNic);
        addDetailRow(details, 3, "PRF Marks       :", lblPrf);
        addDetailRow(details, 4, "DBMS Marks      :", lblDbms);
        addDetailRow(details, 5, "Student GPA     :", lblGpa);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(15, 110, 15, 110));
        center.add(form);
        center.add(Box.createVerticalStrut(12));
        center.add(details);
        add(center, BorderLayout.CENTER);

        btnDelete = CoreGui.actionButton("Delete Student Profile");
        btnDelete.addActionListener(e -> deleteStudent());
        btnDelete.setEnabled(false);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        south.add(btnDelete);
        JButton back = CoreGui.actionButton("Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        south.add(back);
        add(south, BorderLayout.SOUTH);
    }

    public void refresh() {
        currentIndex = -1;
        btnDelete.setEnabled(false);
        clearDetails();
    }

    private void clearDetails() {
        lblRegNo.setText("-");
        lblName.setText("-");
        lblNic.setText("-");
        lblPrf.setText("-");
        lblDbms.setText("-");
        lblGpa.setText("-");
    }

    private void searchStudent() {
        String regNo = txtSearchId.getText().trim();
        if (regNo.isEmpty()) {
            CoreGui.warn(this, "Please enter the student registration no.");
            return;
        }

        int idx = CoreStore.findStudentIndex(regNo);
        if (idx == -1) {
            currentIndex = -1;
            btnDelete.setEnabled(false);
            clearDetails();
            CoreGui.warn(this, "This student does not exist in the system.");
            return;
        }

        currentIndex = idx;
        CoreStudent s = CoreStore.students[idx];
        lblRegNo.setText(s.getRegNo());
        lblName.setText(s.getName());
        lblNic.setText(s.getNic());
        lblPrf.setText(CoreStudent.marksDisplay(s.getPrfMarks()));
        lblDbms.setText(CoreStudent.marksDisplay(s.getDbmsMarks()));
        lblGpa.setText(String.format("%.2f", s.computeGPA()));
        btnDelete.setEnabled(true);
    }

    private void deleteStudent() {
        if (currentIndex == -1) {
            CoreGui.warn(this, "Please search a valid student first.");
            return;
        }

        CoreStudent s = CoreStore.students[currentIndex];
        int answer = JOptionPane.showConfirmDialog(this,
                "Do you want to delete the profile of " + s.getName() + " ?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            CoreBatch batch = CoreStore.getBatch(s.getBatchNo());
            CoreStore.removeStudentAt(currentIndex);
            if (batch != null) {
                batch.decrementStudentCount();
            }
            refresh();
            CoreGui.info(this, "Student was successfully deleted from the system.");
        }
    }
}

/* ================= 3. BATCH MANAGEMENT ================= */
class BatchManagementPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    BatchManagementPage(CoreManagementSystem app) {
        super(app);
        addTitle("Batch Management");

        JPanel center = new JPanel(new GridLayout(2, 2, 30, 30));
        center.setBorder(BorderFactory.createEmptyBorder(50, 90, 50, 90));
        center.add(menuButton("[1]  Add Batch", "addBatch"));
        center.add(menuButton("[2]  Update Batch", "updateBatch"));
        center.add(menuButton("[3]  View Batches", "viewBatch"));

        JButton back = CoreGui.menuButton("[4]  Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        center.add(back);
        add(center, BorderLayout.CENTER);
    }
}

/* ---------------- 3.1 Add Batch ---------------- */
class AddBatchPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private JTextField txtBatchNo;

    AddBatchPage(CoreManagementSystem app) {
        super(app);
        addTitle("Add Batch");

        JPanel form = newForm("Batch Details");
        txtBatchNo = CoreGui.textField(20);
        addFormRow(form, 0, "Batch No :", txtBatchNo);

        JLabel note = CoreGui.label("The batch number is unique and starts from 100.");
        note.setFont(new Font("Arial", Font.ITALIC, 12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(12, 6, 6, 6);
        form.add(note, gbc);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
        center.add(form);
        add(center, BorderLayout.CENTER);

        JButton addBtn = CoreGui.actionButton("Add Batch");
        addBtn.addActionListener(e -> addBatch());
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        south.add(addBtn);
        JButton back = CoreGui.actionButton("Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        south.add(back);
        add(south, BorderLayout.SOUTH);
    }

    private void addBatch() {
        String text = txtBatchNo.getText().trim();
        if (text.isEmpty()) {
            CoreGui.warn(this, "Please enter the batch number.");
            return;
        }

        int batchNo;
        try {
            batchNo = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            CoreGui.warn(this, "The batch number must be a whole number.");
            return;
        }

        if (batchNo < 100 || batchNo > 999) {
            CoreGui.warn(this, "The batch number must be a 3 digit number starting from 100.");
            return;
        }

        if (CoreStore.findBatchIndex(batchNo) != -1) {
            CoreGui.warn(this, "Batch " + batchNo + " is already added to the system.");
            return;
        }

        CoreStore.addBatchRecord(batchNo);
        txtBatchNo.setText("");
        CoreGui.info(this, "Batch " + batchNo + " was successfully added to the system.");
    }
}

/* ---------------- 3.2 Update Batch ---------------- */
class UpdateBatchPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private JTextField txtBatchNo;
    private JLabel lblBatchNo;
    private JLabel lblStudentCount;
    private JLabel lblStatus;
    private JButton btnChange;
    private int currentIndex = -1;

    UpdateBatchPage(CoreManagementSystem app) {
        super(app);
        addTitle("Update Batch");

        JPanel form = newForm("Find the Batch");
        txtBatchNo = CoreGui.textField(20);
        JButton btnSearch = CoreGui.actionButton("Search");
        btnSearch.addActionListener(e -> searchBatch());
        addFormRow(form, 0, "Batch No :", txtBatchNo);
        addFormRow(form, 1, "", btnSearch);

        JPanel details = newForm("Current Batch Details");
        lblBatchNo = CoreGui.value("-");
        lblStudentCount = CoreGui.value("-");
        lblStatus = CoreGui.value("-");
        addDetailRow(details, 0, "Batch No      :", lblBatchNo);
        addDetailRow(details, 1, "Student Count :", lblStudentCount);
        addDetailRow(details, 2, "Status        :", lblStatus);
        btnChange = CoreGui.actionButton("Change Batch Status");
        btnChange.addActionListener(e -> changeStatus());
        btnChange.setEnabled(false);
        addFormRow(details, 3, "", btnChange);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(15, 110, 15, 110));
        center.add(form);
        center.add(Box.createVerticalStrut(12));
        center.add(details);
        add(center, BorderLayout.CENTER);

        addBackToHome();
    }

    public void refresh() {
        currentIndex = -1;
        btnChange.setEnabled(false);
        clearDetails();
    }

    private void clearDetails() {
        lblBatchNo.setText("-");
        lblStudentCount.setText("-");
        lblStatus.setText("-");
    }

    private void searchBatch() {
        String text = txtBatchNo.getText().trim();
        if (text.isEmpty()) {
            CoreGui.warn(this, "Please enter the batch number.");
            return;
        }

        int batchNo;
        try {
            batchNo = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            CoreGui.warn(this, "The batch number must be a whole number.");
            return;
        }

        int idx = CoreStore.findBatchIndex(batchNo);
        if (idx == -1) {
            currentIndex = -1;
            btnChange.setEnabled(false);
            clearDetails();
            CoreGui.warn(this, "This batch does not exist in the system.");
            return;
        }

        currentIndex = idx;
        CoreBatch b = CoreStore.batches[idx];
        lblBatchNo.setText(String.valueOf(b.getBatchNo()));
        lblStudentCount.setText(String.valueOf(b.getStudentCount()));
        lblStatus.setText(b.getStatus());
        btnChange.setEnabled(true);
    }

    private void changeStatus() {
        if (currentIndex == -1) {
            CoreGui.warn(this, "Please search a valid batch first.");
            return;
        }

        CoreBatch b = CoreStore.batches[currentIndex];
        String newStatus = b.isEnrollmentOpen() ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN";

        int answer = JOptionPane.showConfirmDialog(this,
                "Do you want to change the status of batch " + b.getBatchNo()
                        + " to " + newStatus + " ?",
                "Confirm Update", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            b.setEnrollmentOpen(!b.isEnrollmentOpen());
            lblStatus.setText(b.getStatus());
            CoreGui.info(this, "Batch status updated successfully.");
        }
    }
}

/* ---------------- 3.3 View Batches ---------------- */
class ViewBatchPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private DefaultTableModel model;
    private JTable table;

    ViewBatchPage(CoreManagementSystem app) {
        super(app);
        addTitle("View Batches");

        model = new DefaultTableModel(new Object[]{"No", "Batch No", "Student Count", "Status"}, 0);
        table = new JTable(model);
        table.setFont(CoreGui.LABEL_FONT);
        table.setRowHeight(26);
        table.getTableHeader().setFont(CoreGui.HEAD_FONT);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder("Batch Details"));

        JPanel center = new JPanel(new BorderLayout());
        center.setBorder(BorderFactory.createEmptyBorder(15, 60, 15, 60));
        center.add(scroll, BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);

        addBackToHome();
    }

    // reloads the batch list every time the user opens the screen
    public void refresh() {
        model.setRowCount(0);
        for (int i = 0; i < CoreStore.batchCount; i++) {
            CoreBatch b = CoreStore.batches[i];
            model.addRow(new Object[]{i + 1, b.getBatchNo(), b.getStudentCount(), b.getStatus()});
        }
    }
}

/* ================= 4. GRADE MANAGEMENT ================= */
class GradeManagementPage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    GradeManagementPage(CoreManagementSystem app) {
        super(app);
        addTitle("Grade Management");

        JPanel center = new JPanel(new GridLayout(2, 2, 30, 30));
        center.setBorder(BorderFactory.createEmptyBorder(50, 90, 50, 90));
        center.add(menuButton("[1]  PRF Marks Update", "prf"));
        center.add(menuButton("[2]  DBMS Marks Update", "dbms"));

        JButton back = CoreGui.menuButton("[3]  Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        center.add(back);
        center.add(new JPanel());
        add(center, BorderLayout.CENTER);
    }
}

/* The PRF and the DBMS screens work in exactly the same way, so one class
   handles both of them.  module = "PRF" or "DBMS" */
class MarksUpdatePage extends CoreScreen {
    private static final long serialVersionUID = 1L;


    private final String module;
    private JTextField txtSearchId;
    private JLabel lblRegNo;
    private JLabel lblName;
    private JLabel lblNic;
    private JLabel lblCurrentMarks;
    private JTextField txtNewMarks;
    private JButton btnUpdate;
    private int currentIndex = -1;

    MarksUpdatePage(CoreManagementSystem app, String module) {
        super(app);
        this.module = module;
        addTitle(module + " Marks Update");

        JPanel form = newForm("Find the Student");
        txtSearchId = CoreGui.textField(20);
        JButton btnSearch = CoreGui.actionButton("Search");
        btnSearch.addActionListener(e -> searchStudent());
        addFormRow(form, 0, "Student Registration No :", txtSearchId);
        addFormRow(form, 1, "", btnSearch);

        JPanel details = newForm("Current Student Details");
        lblRegNo = CoreGui.value("-");
        lblName = CoreGui.value("-");
        lblNic = CoreGui.value("-");
        lblCurrentMarks = CoreGui.value("-");
        addDetailRow(details, 0, "Registration No           :", lblRegNo);
        addDetailRow(details, 1, "Student Name              :", lblName);
        addDetailRow(details, 2, "Student NIC               :", lblNic);
        addDetailRow(details, 3, "Current " + module + " Marks :", lblCurrentMarks);
        txtNewMarks = CoreGui.textField(20);
        addFormRow(details, 4, "Enter new " + module + " Marks :", txtNewMarks);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(15, 110, 15, 110));
        center.add(form);
        center.add(Box.createVerticalStrut(12));
        center.add(details);
        add(center, BorderLayout.CENTER);

        btnUpdate = CoreGui.actionButton("Update " + module + " Marks");
        btnUpdate.addActionListener(e -> updateMarks());
        btnUpdate.setEnabled(false);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        south.add(btnUpdate);
        JButton back = CoreGui.actionButton("Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        south.add(back);
        add(south, BorderLayout.SOUTH);
    }

    public void refresh() {
        currentIndex = -1;
        btnUpdate.setEnabled(false);
        txtNewMarks.setText("");
        lblRegNo.setText("-");
        lblName.setText("-");
        lblNic.setText("-");
        lblCurrentMarks.setText("-");
    }

    private void searchStudent() {
        String regNo = txtSearchId.getText().trim();
        if (regNo.isEmpty()) {
            CoreGui.warn(this, "Please enter the student registration no.");
            return;
        }

        int idx = CoreStore.findStudentIndex(regNo);
        if (idx == -1) {
            currentIndex = -1;
            btnUpdate.setEnabled(false);
            CoreGui.warn(this, "This student not exist in the system.");
            return;
        }

        currentIndex = idx;
        CoreStudent s = CoreStore.students[idx];
        lblRegNo.setText(s.getRegNo());
        lblName.setText(s.getName());
        lblNic.setText(s.getNic());
        lblCurrentMarks.setText(CoreStudent.marksDisplay(getCurrentMarks(s)));
        btnUpdate.setEnabled(true);
    }

    private int getCurrentMarks(CoreStudent s) {
        return module.equals("PRF") ? s.getPrfMarks() : s.getDbmsMarks();
    }

    private void updateMarks() {
        if (currentIndex == -1) {
            CoreGui.warn(this, "Please search a valid student first.");
            return;
        }

        int marks = CoreGui.readMarks(this, txtNewMarks.getText());
        if (marks == -99) {
            return;
        }

        CoreStudent s = CoreStore.students[currentIndex];
        if (module.equals("PRF")) {
            s.setPrfMarks(marks);
        } else {
            s.setDbmsMarks(marks);
        }

        lblCurrentMarks.setText(CoreStudent.marksDisplay(marks));
        txtNewMarks.setText("");
        CoreGui.info(this, "This student " + module + " Marks updated successfully.");
    }
}

/* ================= MAIN WINDOW ================= */
public class CoreManagementSystem extends JFrame {
    private static final long serialVersionUID = 1L;


    private final CardLayout cards = new CardLayout();
    private final JPanel container = new JPanel(cards);

    public CoreManagementSystem() {
        setTitle("iCET Student Management System");
        setSize(1000, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addScreen(new CoreHomePage(this), "home");
        addScreen(new StudentManagementPage(this), "student");
        addScreen(new AddStudentPage(this), "addStudent");
        addScreen(new UpdateStudentPage(this), "updateStudent");
        addScreen(new ViewStudentPage(this), "viewStudent");
        addScreen(new DeleteStudentPage(this), "deleteStudent");
        addScreen(new BatchManagementPage(this), "batch");
        addScreen(new AddBatchPage(this), "addBatch");
        addScreen(new UpdateBatchPage(this), "updateBatch");
        addScreen(new ViewBatchPage(this), "viewBatch");
        addScreen(new GradeManagementPage(this), "grade");
        addScreen(new MarksUpdatePage(this, "PRF"), "prf");
        addScreen(new MarksUpdatePage(this, "DBMS"), "dbms");

        add(container);
    }

    private void addScreen(JPanel screen, String key) {
        screen.setName(key);
        container.add(screen, key);
    }

    // moves to the given screen and reloads its data
    public void go(String key) {
        for (Component c : container.getComponents()) {
            if (c.getName().equals(key) && c instanceof CoreRefreshable) {
                ((CoreRefreshable) c).refresh();
            }
        }
        cards.show(container, key);
    }

    public static void main(String[] args) {
        new CoreManagementSystem().setVisible(true);
    }
}
