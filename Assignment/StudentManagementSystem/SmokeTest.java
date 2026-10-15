public class SmokeTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testBatchIds();
        testStudentIds();
        testNicDuplicate();
        testEnrollmentClosed();
        testGpa();
        testMarksValidation();
        testEligibility();

        System.out.println("\nPassed: " + passed + "  Failed: " + failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void testBatchIds() {
        Database db = Database.get();
        check(db.nextBatchNumber() == 100, "first batch number is 100");
        check(db.addBatch(100), "add batch 100");
        check(!db.addBatch(100), "duplicate batch 100 rejected");
        check(db.nextBatchNumber() == 101, "next batch number is 101");
        check(db.addBatch(105), "add batch 105");
        check(db.findBatch(999) == null, "missing batch returns null");
    }

    private static void testStudentIds() {
        Database db = Database.get();
        Batch b105 = db.findBatch(105);
        String id1 = db.generateStudentId(b105, false);
        check(id1.equals("OR24105001"), "first online id in batch 105 = OR24105001, got " + id1);
        db.addStudent(new Student(id1, "111111111V", "Abeysekera Silva", 105, false));
        String id2 = db.generateStudentId(b105, true);
        check(id2.equals("PR24105002"), "second id (physical) = PR24105002, got " + id2);
        db.addStudent(new Student(id2, "222222222V", "Bandara Perera", 105, true));
        String id3 = db.generateStudentId(b105, false);
        check(id3.equals("OR24105003"), "third id continues sequence = OR24105003, got " + id3);
        check(id3.length() == 10, "student id length is 10");
        check(db.findStudentById(" pr24105002 ").getName().equals("Bandara Perera"), "find by id ignores case/whitespace");
        check(db.findStudentById("PR24199999") == null, "unknown id returns null");
    }

    private static void testNicDuplicate() {
        Database db = Database.get();
        check(db.nicExists("111111111V"), "nic exists after add");
        check(!db.nicExists("999999999V"), "unknown nic not found");
        Student s = db.findStudentByNic("222222222V");
        check(s != null && s.getName().equals("Bandara Perera"), "find by nic");
    }

    private static void testEnrollmentClosed() {
        Batch batch = Database.get().findBatch(100);
        check(batch.isOpen(), "new batch starts ENROLLMENTOPEN");
        batch.setStatus(Batch.ENROLLMENT_CLOSED);
        check(!batch.isOpen(), "batch closes");
        check(batch.getStatusText().equals("ENROLLMENTCLOSED"), "closed status text");
        batch.setStatus(Batch.ENROLLMENT_OPEN);
        check(batch.isOpen(), "batch reopens");
    }

    private static void testGpa() {
        check(GpaUtil.marksToGpa(90) == 4.25, "90 -> 4.25");
        check(GpaUtil.marksToGpa(85) == 4.00, "85 -> 4.00");
        check(GpaUtil.marksToGpa(75) == 3.70, "75 -> 3.70");
        check(GpaUtil.marksToGpa(50) == 2.00, "50 -> 2.00");
        check(GpaUtil.marksToGpa(0) == 0.0, "0 -> 0.0 (below 20)");
        check(GpaUtil.marksToGpa(19) == 0.0, "19 -> 0.0");
        check(GpaUtil.marksToGpa(20) == 0.70, "20 -> 0.70");
        check(GpaUtil.marksToGpa(40) == 1.30, "40 -> 1.30");
        check(GpaUtil.marksToGpa(-1) == 0.0, "absent -> 0.0");
        check(GpaUtil.marksToGpa(-2) == 0.0, "not conducted -> 0.0");

        Student s = new Student("PR24100001", "x", "Test", 100, false);
        s.setPrfMarks(94);
        s.setDbmsMarks(39);
        check(s.getGpa() == 2.625, "94/39 -> 2.625, got " + s.getGpa());
        s.setPrfMarks(-1);
        s.setDbmsMarks(93);
        check(s.getGpa() == 2.125, "absent/93 -> 2.125, got " + s.getGpa());
        s.setPrfMarks(-2);
        s.setDbmsMarks(-2);
        check(s.getGpa() == 0.0, "not conducted -> 0.0");

        check(GpaUtil.displayMarks(-1).equals("Absent"), "display -1 as Absent");
        check(GpaUtil.displayMarks(-2).equals("Not Conducted"), "display -2 as Not Conducted");
        check(GpaUtil.displayMarks(77).equals("77"), "display 77");
        check(GpaUtil.formatGpa(2.625).equals("2.63"), "format 2.63");
        check(GpaUtil.formatGpa(4.0).equals("4.00"), "format 4.00");
    }

    private static void testMarksValidation() {
        check(isValidMarks(-1), "-1 valid");
        check(isValidMarks(0), "0 valid");
        check(isValidMarks(100), "100 valid");
        check(isValidMarks(55), "55 valid");
        check(!isValidMarks(-2), "-2 not enterable");
        check(!isValidMarks(-5), "-5 invalid");
        check(!isValidMarks(101), "101 invalid");
    }

    private static boolean isValidMarks(int marks) {
        return marks == Student.MARK_ABSENT || (marks >= 0 && marks <= 100);
    }

    private static void testEligibility() {
        Student eligible = new Student("PR24100009", "e1", "Eligible One", 100, false);
        eligible.setPrfMarks(85);
        eligible.setDbmsMarks(70);
        check(isEligible(eligible), "gpa>3.25 and both>50 eligible");

        Student lowGpa = new Student("PR24100010", "e2", "Low Gpa", 100, false);
        lowGpa.setPrfMarks(51);
        lowGpa.setDbmsMarks(51);
        check(!isEligible(lowGpa), "gpa<=3.25 not eligible");

        Student lowMark = new Student("PR24100011", "e3", "Low Mark", 100, false);
        lowMark.setPrfMarks(95);
        lowMark.setDbmsMarks(50);
        check(!isEligible(lowMark), "mark exactly 50 not eligible (must be >50)");

        Student absent = new Student("PR24100012", "e4", "Absent Kid", 100, false);
        absent.setPrfMarks(-1);
        absent.setDbmsMarks(99);
        check(!isEligible(absent), "absent not eligible");
    }

    private static boolean isEligible(Student student) {
        return student.getGpa() > 3.25
                && student.getPrfMarks() > 50
                && student.getDbmsMarks() > 50;
    }

    private static void check(boolean condition, String label) {
        if (condition) {
            passed++;
            System.out.println("PASS  " + label);
        } else {
            failed++;
            System.out.println("FAIL  " + label);
        }
    }
}
