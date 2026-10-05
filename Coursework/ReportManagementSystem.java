import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/* =========================================================================
   iCET Student Management System
   OOP - Day 02 / Milestone 02 : REPORT MANAGEMENT

   This is a separate, self contained submission that covers only the
   Report Management use cases of the coursework document:

       4.1  Student Registration Report
            All students in alphabetical order of the student name, with
            the batch, the registration number, the marks and the GPA.

       4.2  Batch-wise Student Report
            The batch is selected from a drop down and every student
            registered in that batch is listed.

       4.3  Industry Training Eligibility Report
            Only the students who satisfy both criteria:
                1. GPA is greater than 3.25
                2. PRF marks and DBMS marks are both greater than 50

   Structure of this file:
      1. ReportStudent   - encapsulated student record + GPA calculation
      2. ReportBatch     - encapsulated batch record
      3. ReportStore     - every record and all the searching / report logic
      4. ReportGui       - helper class for fonts, tables and message boxes
      5. The screens     - Report Home, Registration, Batch, Eligibility
      6. ReportManagementSystem - the main window (main method)

   The three report screens are kept inside a CardLayout, so the whole
   milestone runs in one window and the user moves between the screens
   without opening extra windows.

   Note: the model classes carry a "Report" name (ReportStudent,
   ReportBatch, ReportStore) so that this submission can be kept in the
   same folder as the Milestone 01 file without a duplicate class name.
   ========================================================================= */

/* ---------------- 1. Student ---------------- */
class ReportStudent {

    private String regNo;
    private String nic;
    private String name;
    private int prfMarks;
    private int dbmsMarks;

    ReportStudent(String regNo, String nic, String name, int prfMarks, int dbmsMarks) {
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

    /* The batch number is hidden inside the 10 character registration
       number.  PR24105001 -> characters 4,5,6 -> 105 */
    public int getBatchNo() {
        return Integer.parseInt(regNo.substring(4, 7));
    }

    /* PR or OR prefix of the registration number */
    public String getMode() {
        return regNo.substring(0, 2);
    }

    /* Marks -> GPA value table of the coursework
           85 - 100  ->  4.0        75 - 84  ->  3.7        65 - 74  ->  3.5
           55 - 64   ->  3.0        50 - 54  ->  2.7        45 - 49  ->  2.0
           40 - 44   ->  1.5        35 - 39  ->  1.0         0 - 34  ->  0.0     */
    public static double marksToGPA(int marks) {
        if (marks < 0) return 0.0;          // -1 absent / -2 exam not conducted
        if (marks >= 85) return 4.00;
        if (marks >= 75) return 3.70;
        if (marks >= 65) return 3.50;
        if (marks >= 55) return 3.00;
        if (marks >= 50) return 2.70;
        if (marks >= 45) return 2.00;
        if (marks >= 40) return 1.50;
        if (marks >= 35) return 1.00;
        return 0.00;
    }

    /* Student GPA = (PRF Marks GPA + DBMS Marks GPA) / 2 */
    public double computeGPA() {
        return (marksToGPA(prfMarks) + marksToGPA(dbmsMarks)) / 2.0;
    }

    /* -1 -> Absent   |   -2 -> exam not conducted   |   otherwise the mark */
    public static String marksDisplay(int marks) {
        if (marks == -1) return "Absent";
        if (marks == -2) return "Not Conducted";
        return String.valueOf(marks);
    }
}

/* ---------------- 2. Batch ---------------- */
class ReportBatch {

    private int batchNo;
    private boolean enrollmentOpen;
    private int studentCount;

    ReportBatch(int batchNo, boolean enrollmentOpen, int studentCount) {
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

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getStatus() {
        return enrollmentOpen ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
    }
}

/* ---------------- 3. Store ----------------
   Holds every student and batch record together with the searching and
   the report logic used by the three report screens. */
class ReportStore {

    public static ReportStudent[] students = new ReportStudent[150];
    public static int studentCount = students.length;

    public static ReportBatch[] batches = new ReportBatch[6];
    public static int batchCount = batches.length;

    static {
        students[0] = new ReportStudent("PR24105001", "199501012345", "Gunawardena Weerasinghe", 85, 66);
        students[1] = new ReportStudent("PR24105002", "199503153872", "Senanayake Silva", 39, 45);
        students[2] = new ReportStudent("PR24105003", "199506202198", "Silva Kumara", -1, 93);
        students[3] = new ReportStudent("PR24105004", "199509102983", "Kumara Herath", 72, 58);
        students[4] = new ReportStudent("PR24105005", "199511258739", "Rathnayake Herath", 44, -1);
        students[5] = new ReportStudent("PR24105006", "199512303498", "Wijesinghe Bandara", 91, 37);
        students[6] = new ReportStudent("PR24105007", "199502183764", "Rajapaksha Herath", 60, 88);
        students[7] = new ReportStudent("PR24105008", "199504223198", "Senanayake Karunaratne", 38, 21);
        students[8] = new ReportStudent("PR24105009", "199508153210", "Karunaratne Jayasinghe", 95, 79);
        students[9] = new ReportStudent("PR24105010", "199510293417", "Gunawardena Silva", 49, 40);
        students[10] = new ReportStudent("OR24105011", "199601102375", "Weerasinghe Rajapaksha", -1, 76);
        students[11] = new ReportStudent("OR24105012", "199604182938", "Silva Rathnayake", 67, 54);
        students[12] = new ReportStudent("OR24105013", "199606243879", "Fernando Perera", 23, -1);
        students[13] = new ReportStudent("OR24105014", "199608142178", "Kumara Abeysekera", 58, 69);
        students[14] = new ReportStudent("OR24105015", "199610312475", "Ekanayake Rathnayake", 88, 92);
        students[15] = new ReportStudent("PR24105016", "199611173452", "Herath Gunawardena", 81, 25);
        students[16] = new ReportStudent("PR24105017", "199603293481", "Abeysekera Silva", 73, 84);
        students[17] = new ReportStudent("PR24105018", "199605083217", "Weerasinghe Silva", 29, 33);
        students[18] = new ReportStudent("OR24105019", "199607232198", "Jayasinghe Dias", 62, 60);
        students[19] = new ReportStudent("OR24105020", "199609192375", "Bandara Rathnayake", -1, 71);
        students[20] = new ReportStudent("PR24105021", "199701212483", "Silva Perera", 79, 59);
        students[21] = new ReportStudent("PR24105022", "199703132487", "De Silva Dias", 53, -1);
        students[22] = new ReportStudent("OR24105023", "199706253478", "Abeysekera Jayasinghe", 94, 98);
        students[23] = new ReportStudent("OR24105024", "199708083298", "Rajapaksha Senanayake", 47, 27);
        students[24] = new ReportStudent("PR24105025", "199710243651", "Kumara Karunaratne", 35, 48);
        students[25] = new ReportStudent("PR24106001", "199712152983", "Silva Abeysekera", 93, 35);
        students[26] = new ReportStudent("PR24106002", "199702182734", "Jayasinghe Bandara", 15, 91);
        students[27] = new ReportStudent("PR24106003", "199704293187", "Rathnayake Kumara", -1, 60);
        students[28] = new ReportStudent("PR24106004", "199705142375", "Weerasinghe Rajapaksha", 82, -1);
        students[29] = new ReportStudent("PR24106005", "199709083751", "Senanayake Herath", 45, 72);
        students[30] = new ReportStudent("PR24106006", "199801032874", "Perera Ekanayake", 88, 49);
        students[31] = new ReportStudent("PR24106007", "199803232871", "Herath Jayasinghe", 23, 26);
        students[32] = new ReportStudent("PR24106008", "199806193428", "Kumara Gunawardena", 79, 80);
        students[33] = new ReportStudent("PR24106009", "199808013764", "Abeysekera Silva", 37, 14);
        students[34] = new ReportStudent("PR24106010", "199810242374", "Dias Fernando", -1, 89);
        students[35] = new ReportStudent("OR24106011", "199812302984", "Karunaratne Weerasinghe", 68, 67);
        students[36] = new ReportStudent("OR24106012", "199802152348", "Ekanayake Bandara", 100, -1);
        students[37] = new ReportStudent("OR24106013", "199805213471", "Rajapaksha Kumara", 59, 31);
        students[38] = new ReportStudent("OR24106014", "199807172398", "Silva De Silva", 29, 94);
        students[39] = new ReportStudent("OR24106015", "199811283472", "Gunawardena Rathnayake", 92, 53);
        students[40] = new ReportStudent("PR24106016", "199901122471", "Bandara Karunaratne", 12, 78);
        students[41] = new ReportStudent("PR24106017", "199903052984", "Fernando Perera", 77, 5);
        students[42] = new ReportStudent("PR24106018", "199906213874", "De Silva Silva", 38, 90);
        students[43] = new ReportStudent("OR24106019", "199908093412", "Rajapaksha Gunawardena", 66, 24);
        students[44] = new ReportStudent("OR24106020", "199910273894", "Herath Weerasinghe", 9, 86);
        students[45] = new ReportStudent("PR24106021", "199912153482", "Karunaratne Dias", 84, 39);
        students[46] = new ReportStudent("PR24106022", "199902202394", "Jayasinghe Silva", 51, -1);
        students[47] = new ReportStudent("OR24106023", "199904163874", "Senanayake Abeysekera", 32, 61);
        students[48] = new ReportStudent("OR24106024", "199907293481", "Silva Jayasinghe", -1, 73);
        students[49] = new ReportStudent("OR24106025", "199911083479", "Rathnayake Kumara", 97, 100);
        students[50] = new ReportStudent("PR24107001", "200001112374", "Gunawardena Kumara", 95, 38);
        students[51] = new ReportStudent("PR24107002", "200003143478", "Rajapaksha Silva", -1, 91);
        students[52] = new ReportStudent("PR24107003", "200006293874", "Perera Jayasinghe", 63, -1);
        students[53] = new ReportStudent("PR24107004", "200008103471", "Silva Ekanayake", 88, 74);
        students[54] = new ReportStudent("PR24107005", "200010252984", "Dias Senanayake", 32, 55);
        students[55] = new ReportStudent("PR24107006", "200012043894", "Herath Abeysekera", 76, 82);
        students[56] = new ReportStudent("PR24107007", "200002193874", "Rathnayake Fernando", 97, 66);
        students[57] = new ReportStudent("PR24107008", "200004212374", "Kumara Herath", 54, 49);
        students[58] = new ReportStudent("PR24107009", "200005183492", "Weerasinghe Silva", -1, 99);
        students[59] = new ReportStudent("PR24107010", "200007153871", "Senanayake Karunaratne", 23, 13);
        students[60] = new ReportStudent("OR24107011", "200101232984", "Abeysekera Silva", 90, 80);
        students[61] = new ReportStudent("OR24107012", "200103083471", "Bandara Gunawardena", 35, 70);
        students[62] = new ReportStudent("OR24107013", "200106273894", "Karunaratne Weerasinghe", 81, 93);
        students[63] = new ReportStudent("OR24107014", "200108123984", "Perera Herath", 61, 36);
        students[64] = new ReportStudent("OR24107015", "200110043728", "Fernando Dias", 44, 59);
        students[65] = new ReportStudent("PR24107016", "200112213874", "Weerasinghe Gunawardena", 67, 85);
        students[66] = new ReportStudent("PR24107017", "200102253471", "Rathnayake Kumara", 100, 47);
        students[67] = new ReportStudent("PR24107018", "200104103874", "Senanayake Fernando", 17, 90);
        students[68] = new ReportStudent("OR24107019", "200105293784", "Silva Bandara", 85, -1);
        students[69] = new ReportStudent("OR24107020", "200107202983", "Herath Rajapaksha", 29, 22);
        students[70] = new ReportStudent("PR24107021", "200201013874", "Kumara Jayasinghe", 70, 77);
        students[71] = new ReportStudent("PR24107022", "200203253471", "Abeysekera Perera", 42, 34);
        students[72] = new ReportStudent("OR24107023", "200206143874", "Rathnayake Jayasinghe", -1, 63);
        students[73] = new ReportStudent("OR24107024", "200208083471", "Kumara Weerasinghe", 60, 100);
        students[74] = new ReportStudent("PR24107025", "200210293874", "Rajapaksha Ekanayake", 86, 29);
        students[75] = new ReportStudent("PR24108001", "200212183471", "Fernando Rajapaksha", 86, 79);
        students[76] = new ReportStudent("PR24108002", "200202103874", "Silva Gunawardena", 57, 62);
        students[77] = new ReportStudent("PR24108003", "200204123894", "Perera Wijesinghe", 91, 87);
        students[78] = new ReportStudent("PR24108004", "200205283471", "Herath Abeysekera", 35, -1);
        students[79] = new ReportStudent("PR24108005", "200207153874", "Rajapaksha Ekanayake", -1, 54);
        students[80] = new ReportStudent("PR24108006", "200301093874", "Karunaratne Silva", 76, 46);
        students[81] = new ReportStudent("PR24108007", "200303283471", "Weerasinghe Fernando", 48, 99);
        students[82] = new ReportStudent("PR24108008", "200306153874", "Silva Bandara", 94, 39);
        students[83] = new ReportStudent("PR24108009", "200308123471", "Abeysekera Weerasinghe", 23, 70);
        students[84] = new ReportStudent("PR24108010", "200310083874", "Kumara Karunaratne", 69, -1);
        students[85] = new ReportStudent("OR24108011", "200312243471", "Dias Rajapaksha", -1, 75);
        students[86] = new ReportStudent("OR24108012", "200302273874", "Herath Perera", 80, 83);
        students[87] = new ReportStudent("OR24108013", "200304203471", "Rathnayake Gunawardena", 55, 58);
        students[88] = new ReportStudent("OR24108014", "200305123874", "Ekanayake Jayasinghe", 88, 92);
        students[89] = new ReportStudent("OR24108015", "200307213471", "Gunawardena Silva", 32, 30);
        students[90] = new ReportStudent("PR24108016", "200401153874", "Rajapaksha Perera", 100, 91);
        students[91] = new ReportStudent("PR24108017", "200403123471", "Karunaratne Jayasinghe", 67, 40);
        students[92] = new ReportStudent("PR24108018", "200406293874", "Weerasinghe Abeysekera", 43, 63);
        students[93] = new ReportStudent("OR24108019", "200408083471", "Rathnayake Fernando", -1, 95);
        students[94] = new ReportStudent("OR24108020", "200410213874", "Kumara Herath", 90, 68);
        students[95] = new ReportStudent("PR24108021", "200412153471", "Silva Weerasinghe", 60, -1);
        students[96] = new ReportStudent("PR24108022", "200402203874", "Herath Karunaratne", 77, 66);
        students[97] = new ReportStudent("OR24108023", "200404273471", "Abeysekera Silva", 25, 21);
        students[98] = new ReportStudent("OR24108024", "200405143874", "Gunawardena Ekanayake", 71, 88);
        students[99] = new ReportStudent("OR24108025", "200407183471", "Weerasinghe Kumara", 84, 37);
        students[100] = new ReportStudent("PR24109001", "200501023874", "Weerasinghe Kumara", 92, 67);
        students[101] = new ReportStudent("PR24109002", "200503193471", "Rajapaksha Abeysekera", 68, 91);
        students[102] = new ReportStudent("PR24109003", "200506153874", "Gunawardena Perera", 59, 85);
        students[103] = new ReportStudent("PR24109004", "200508213471", "Karunaratne Silva", 85, 73);
        students[104] = new ReportStudent("PR24109005", "200510083874", "Herath Wijesinghe", 63, 70);
        students[105] = new ReportStudent("PR24109006", "200512293471", "Rathnayake Ekanayake", 76, 63);
        students[106] = new ReportStudent("PR24109007", "200502123874", "Silva Fernando", 91, 76);
        students[107] = new ReportStudent("PR24109008", "200504153471", "Abeysekera Rajapaksha", 70, 88);
        students[108] = new ReportStudent("PR24109009", "200505283874", "Fernando Bandara", 84, 55);
        students[109] = new ReportStudent("PR24109010", "200507173471", "Perera Herath", 63, 64);
        students[110] = new ReportStudent("OR24109011", "200203456782", "Weerasinghe Jayasinghe", 72, 79);
        students[111] = new ReportStudent("OR24109012", "200305678901", "Silva Karunaratne", 89, 80);
        students[112] = new ReportStudent("OR24109013", "199601234567", "Rathnayake Gunawardena", 45, 59);
        students[113] = new ReportStudent("OR24109014", "199511223344", "Herath Kumara", 81, 92);
        students[114] = new ReportStudent("OR24109015", "200412345678", "Abeysekera Silva", 77, 68);
        students[115] = new ReportStudent("PR24109016", "200512345678", "Ekanayake Bandara", 68, 100);
        students[116] = new ReportStudent("PR24109017", "199909876543", "Rajapaksha Fernando", 63, 77);
        students[117] = new ReportStudent("PR24109018", "199812346789", "Gunawardena Weerasinghe", 88, 83);
        students[118] = new ReportStudent("OR24109019", "200010203040", "Kumara Karunaratne", 75, 45);
        students[119] = new ReportStudent("OR24109020", "200608789012", "Silva Dias", 90, 62);
        students[120] = new ReportStudent("PR24109021", "200012345678", "Perera Weerasinghe", 57, 66);
        students[121] = new ReportStudent("PR24109022", "199812345679", "Karunaratne Rajapaksha", 79, 59);
        students[122] = new ReportStudent("OR24109023", "199902345678", "Jayasinghe Silva", 92, 78);
        students[123] = new ReportStudent("OR24109024", "199712345670", "Rathnayake Perera", 62, 85);
        students[124] = new ReportStudent("OR24109025", "200102345671", "Silva Ekanayake", 100, 56);
        students[125] = new ReportStudent("PR24110001", "200203456782", "Silva Karunaratne", -2, -2);
        students[126] = new ReportStudent("PR24110002", "200305678901", "Herath Fernando", -2, -2);
        students[127] = new ReportStudent("PR24110003", "199601234567", "Kumara Jayasinghe", -2, -2);
        students[128] = new ReportStudent("PR24110004", "199511223344", "Weerasinghe Perera", -2, -2);
        students[129] = new ReportStudent("PR24110005", "200412345678", "Abeysekera Rajapaksha", -2, -2);
        students[130] = new ReportStudent("PR24110006", "200512345678", "Rathnayake Karunaratne", -2, -2);
        students[131] = new ReportStudent("PR24110007", "199909876543", "Ekanayake Bandara", -2, -2);
        students[132] = new ReportStudent("PR24110008", "199812346789", "Gunawardena Perera", -2, -2);
        students[133] = new ReportStudent("PR24110009", "200010203040", "Silva Wijesinghe", -2, -2);
        students[134] = new ReportStudent("PR24110010", "200608789012", "Rajapaksha Jayasinghe", -2, -2);
        students[135] = new ReportStudent("OR24110011", "200012345678", "Rathnayake Fernando", -2, -2);
        students[136] = new ReportStudent("OR24110012", "199812345679", "Karunaratne Kumara", -2, -2);
        students[137] = new ReportStudent("OR24110013", "199902345678", "Perera Silva", -2, -2);
        students[138] = new ReportStudent("OR24110014", "199712345670", "Gunawardena Ekanayake", -2, -2);
        students[139] = new ReportStudent("OR24110015", "200102345671", "Bandara Rajapaksha", -2, -2);
        students[140] = new ReportStudent("PR24110016", "200203456782", "Silva Herath", -2, -2);
        students[141] = new ReportStudent("PR24110017", "200305678901", "Rathnayake Weerasinghe", -2, -2);
        students[142] = new ReportStudent("PR24110018", "199601234567", "Perera Gunawardena", -2, -2);
        students[143] = new ReportStudent("OR24110019", "199511223344", "Herath Karunaratne", -2, -2);
        students[144] = new ReportStudent("OR24110020", "200412345678", "Silva Rajapaksha", -2, -2);
        students[145] = new ReportStudent("PR24110021", "200203456782", "Ekanayake Kumara", -2, -2);
        students[146] = new ReportStudent("PR24110022", "200305678901", "Bandara Herath", -2, -2);
        students[147] = new ReportStudent("OR24110023", "199601234567", "Weerasinghe Rajapaksha", -2, -2);
        students[148] = new ReportStudent("OR24110024", "199511223344", "Karunaratne Abeysekera", -2, -2);
        students[149] = new ReportStudent("OR24110025", "200412345678", "Perera Dias", -2, -2);

        batches[0] = new ReportBatch(105, false, 0);
        batches[1] = new ReportBatch(106, false, 0);
        batches[2] = new ReportBatch(107, false, 0);
        batches[3] = new ReportBatch(108, false, 0);
        batches[4] = new ReportBatch(109, true, 0);
        batches[5] = new ReportBatch(110, true, 0);

        for (int i = 0; i < studentCount; i++) {
            int batchNo = Integer.parseInt(students[i].getRegNo().substring(4, 7));
            int bIdx = findBatchIndex(batchNo);
            if (bIdx != -1) {
                batches[bIdx].setStudentCount(batches[bIdx].getStudentCount() + 1);
            }
        }
    }

    /* ---------- searching ---------- */

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

    public static ReportBatch getBatch(int batchNo) {
        int idx = findBatchIndex(batchNo);
        return (idx == -1) ? null : batches[idx];
    }

    /* ---------- report logic ---------- */

    /* student indexes ordered alphabetically by the student name */
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

    /* indexes of every student registered in the given batch */
    public static int[] indicesOfBatch(int batchNo) {
        int[] temp = new int[studentCount];
        int size = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getBatchNo() == batchNo) {
                temp[size] = i;
                size++;
            }
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    /* Industry Training Eligibility Criteria
           1. GPA must be greater than 3.25
           2. PRF marks and DBMS marks must both be greater than 50     */
    public static boolean isEligibleForIndustry(ReportStudent s) {
        return s.computeGPA() > 3.25 && s.getPrfMarks() > 50 && s.getDbmsMarks() > 50;
    }

    /* fills one JTable row : No | Batch | Reg No | Name | NIC | PRF | DBMS | GPA */
    public static void addReportRow(DefaultTableModel model, int no, ReportStudent s) {
        model.addRow(new Object[]{
                no,
                s.getBatchNo(),
                s.getRegNo(),
                s.getName(),
                s.getNic(),
                ReportStudent.marksDisplay(s.getPrfMarks()),
                ReportStudent.marksDisplay(s.getDbmsMarks()),
                String.format("%.2f", s.computeGPA())
        });
    }
}

/* ---------------- 4. GUI helper ----------------
   Keeps every screen of this milestone looking the same. */
class ReportGui {

    public static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 22);
    public static final Font HEAD_FONT = new Font("Arial", Font.BOLD, 15);
    public static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font NOTE_FONT = new Font("Arial", Font.ITALIC, 12);
    public static final Font TABLE_FONT = new Font("Arial", Font.PLAIN, 12);

    public static JLabel title(String text) {
        JLabel l = new JLabel(text, JLabel.CENTER);
        l.setFont(TITLE_FONT);
        l.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));
        return l;
    }

    public static JButton menuButton(String text) {
        JButton b = new JButton(text);
        b.setFont(HEAD_FONT);
        b.setPreferredSize(new Dimension(300, 55));
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

    public static JLabel note(String text) {
        JLabel l = new JLabel(text);
        l.setFont(NOTE_FONT);
        return l;
    }

    public static void info(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "iCET Student Management System",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warn(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}

/* ---------------- 5. Screens ----------------
   Every screen is rebuilt each time it is opened, because a report always
   has to show the data of the current system. */
interface ReportScreen {
    void refresh();
}

/* base class of the three report screens */
abstract class ReportPage extends JPanel implements ReportScreen {
    private static final long serialVersionUID = 1L;


    protected final ReportManagementSystem app;
    protected final DefaultTableModel model;
    protected final JTable table;
    private final JPanel center = new JPanel(new BorderLayout());
    private final JLabel lblCount = ReportGui.label("Total students : 0");

    ReportPage(ReportManagementSystem app, String titleText) {
        this.app = app;
        setLayout(new BorderLayout());
        add(ReportGui.title(titleText), BorderLayout.NORTH);

        model = new DefaultTableModel(
                new Object[]{"No", "Batch", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA"}, 0);
        table = new JTable(model);
        table.setFont(ReportGui.TABLE_FONT);
        table.setRowHeight(24);
        table.getTableHeader().setFont(ReportGui.HEAD_FONT);

        center.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        add(center, BorderLayout.CENTER);
    }

    /* places the table inside the screen. topRow is an optional drop down
       or criteria line shown above the table. */
    protected void installTable(String borderTitle, Component topRow) {
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder(borderTitle));

        if (topRow != null) {
            center.add(topRow, BorderLayout.NORTH);
        }
        center.add(scroll, BorderLayout.CENTER);
        center.add(lblCount, BorderLayout.SOUTH);
    }

    protected void setTotal(int total) {
        lblCount.setText("Total students : " + total);
    }

    /* the "Back to Home Page" button required by the coursework */
    protected void addBackToHome() {
        JButton back = ReportGui.actionButton("Back to Home Page");
        back.addActionListener(e -> app.go("home"));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panel.add(back);
        add(panel, BorderLayout.SOUTH);
    }
}

/* ---- 4.1 Student Registration Report ---- */
class RegistrationReportPage extends ReportPage {
    private static final long serialVersionUID = 1L;


    RegistrationReportPage(ReportManagementSystem app) {
        super(app, "4.1  Student Registration Report");

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        top.add(ReportGui.note("All registered students of the system, in alphabetical order of the student name."));

        installTable("Student Registration Details", top);
        addBackToHome();
    }

    public void refresh() {
        model.setRowCount(0);
        int[] order = ReportStore.sortedIndicesByName();
        for (int i = 0; i < order.length; i++) {
            ReportStore.addReportRow(model, i + 1, ReportStore.students[order[i]]);
        }
        setTotal(order.length);
    }
}

/* ---- 4.2 Batch-wise Student Report ---- */
class BatchReportPage extends ReportPage {
    private static final long serialVersionUID = 1L;


    private JComboBox<Integer> cmbBatch;

    BatchReportPage(ReportManagementSystem app) {
        super(app, "4.2  Batch-wise Student Report");

        cmbBatch = new JComboBox<Integer>();
        cmbBatch.setFont(ReportGui.LABEL_FONT);
        cmbBatch.setPreferredSize(new Dimension(180, 26));
        cmbBatch.addActionListener(e -> generateReport());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        top.add(ReportGui.label("Select Batch :"));
        top.add(cmbBatch);

        installTable("Students of the Selected Batch", top);
        addBackToHome();
    }

    public void refresh() {
        cmbBatch.removeAllItems();
        for (int i = 0; i < ReportStore.batchCount; i++) {
            cmbBatch.addItem(ReportStore.batches[i].getBatchNo());
        }
        generateReport();
    }

    private void generateReport() {
        model.setRowCount(0);
        if (cmbBatch.getSelectedIndex() == -1) {
            setTotal(0);
            return;
        }

        int batchNo = (Integer) cmbBatch.getSelectedItem();
        int[] indexes = ReportStore.indicesOfBatch(batchNo);
        for (int i = 0; i < indexes.length; i++) {
            ReportStore.addReportRow(model, i + 1, ReportStore.students[indexes[i]]);
        }
        setTotal(indexes.length);

        if (indexes.length == 0) {
            ReportGui.warn(this, "There are no students registered in batch " + batchNo + ".");
        }
    }
}

/* ---- 4.3 Industry Training Eligibility Report ---- */
class EligibilityReportPage extends ReportPage {
    private static final long serialVersionUID = 1L;


    EligibilityReportPage(ReportManagementSystem app) {
        super(app, "4.3  Industry Training Eligibility Report");

        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(ReportGui.label("Eligibility Criteria :  GPA > 3.25   AND   PRF Marks > 50   AND   DBMS Marks > 50"));
        top.add(ReportGui.note("A student is eligible for industry training only when all three conditions are satisfied."));

        installTable("Eligible Students", top);
        addBackToHome();
    }

    public void refresh() {
        model.setRowCount(0);
        int no = 1;
        for (int i = 0; i < ReportStore.studentCount; i++) {
            ReportStudent s = ReportStore.students[i];
            if (ReportStore.isEligibleForIndustry(s)) {
                ReportStore.addReportRow(model, no, s);
                no++;
            }
        }
        setTotal(no - 1);
    }
}

/* ---- Report Management Home Page ---- */
class ReportHomePage extends JPanel {
    private static final long serialVersionUID = 1L;


    ReportHomePage(ReportManagementSystem app) {
        setLayout(new BorderLayout());
        add(ReportGui.title("Report Management"), BorderLayout.NORTH);

        JPanel menu = new JPanel(new GridLayout(3, 1, 20, 20));
        menu.setBorder(BorderFactory.createEmptyBorder(20, 300, 15, 300));
        menu.add(option(app, "[1]  Student Registration Report", "registrationReport"));
        menu.add(option(app, "[2]  Batch-wise Student Report", "batchReport"));
        menu.add(option(app, "[3]  Industry Training Eligibility Report", "eligibilityReport"));
        add(menu, BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton exit = ReportGui.actionButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        south.add(exit);
        add(south, BorderLayout.SOUTH);
    }

    private JButton option(ReportManagementSystem app, String text, String key) {
        JButton b = ReportGui.menuButton(text);
        b.addActionListener(e -> app.go(key));
        return b;
    }
}

/* ---------------- 6. Main window ---------------- */
public final class ReportManagementSystem extends JFrame {
    private static final long serialVersionUID = 1L;


    private final CardLayout cards = new CardLayout();
    private final JPanel container = new JPanel(cards);

    public ReportManagementSystem() {
        setTitle("iCET Student Management System - Report Management");
        setSize(1120, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addScreen(new ReportHomePage(this), "home");
        addScreen(new RegistrationReportPage(this), "registrationReport");
        addScreen(new BatchReportPage(this), "batchReport");
        addScreen(new EligibilityReportPage(this), "eligibilityReport");

        add(container);
    }

    private void addScreen(JPanel screen, String key) {
        screen.setName(key);
        container.add(screen, key);
    }

    /* moves to the given screen and regenerates its report */
    public void go(String key) {
        for (Component c : container.getComponents()) {
            if (c.getName().equals(key) && c instanceof ReportScreen) {
                ((ReportScreen) c).refresh();
            }
        }
        cards.show(container, key);
    }

    public static void main(String[] args) {
        new ReportManagementSystem().setVisible(true);
    }
}
