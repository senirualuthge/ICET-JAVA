package icet.sms;

import icet.sms.model.*;
import java.util.List;

public class SMSTest {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        Batch b100 = sms.addBatch(100);
        assert b100 != null && b100.isEnrollmentOpen() : "Batch 100 open by default";
        assert sms.addBatch(100) == null : "Duplicate batch rejected";

        // PR #1
        Student s1 = sms.addStudent("Nuwan", "12345V", -2, -2, 100, true);
        assert s1.getRegistrationNo().equals("PR00010001") : "s1=" + s1.getRegistrationNo();
        assert s1.getPrfMarks() == -2 && s1.getDbmsMarks() == -2;

        // Duplicate NIC rejected
        assert sms.addStudent("Kasun", "12345V", -2, -2, 100, true) == null;

        // NIC lookup
        assert sms.getStudentByNic("12345V") != null;
        assert sms.getStudentByRegNo("PR99999999") == null;

        // Update batch to closed
        sms.updateBatchStatus(100, 0);
        assert !sms.getBatch(100).isEnrollmentOpen();

        // Update student (NIC change)
        assert sms.updateStudent(s1.getRegistrationNo(), "Nuwan Silva", "67890V");
        assert sms.getStudentByNic("67890V") != null;
        assert sms.getStudentByNic("12345V") == null;

        // Duplicate NIC on update rejected
        Student s2 = sms.addStudent("Amali", "11111V", 75, 80, 100, true);
        // PR #2 -> PR00010002
        assert s2.getRegistrationNo().equals("PR00010002") : "s2=" + s2.getRegistrationNo();
        assert !sms.updateStudent(s1.getRegistrationNo(), "X", "11111V");

        // Delete s1
        assert sms.deleteStudent(s1.getRegistrationNo());
        assert sms.getStudentByRegNo(s1.getRegistrationNo()) == null;

        // OR #1
        Student s3 = sms.addStudent("Priya", "22222V", 80, 70, 100, false);
        assert s3.getRegistrationNo().equals("OR00010001") : "s3=" + s3.getRegistrationNo();
        assert Math.abs(s3.calculateGPA() - 3.75) < 0.01 : "GPA=" + s3.calculateGPA();
        assert s3.isEligibleForIndustryTraining();

        // PR #3
        Student s4 = sms.addStudent("Lakshan", "33333V", 60, 80, 100, true);
        assert s4.getRegistrationNo().equals("PR00010003") : "s4=" + s4.getRegistrationNo();
        assert s4.isEligibleForIndustryTraining();

        // PR #4
        Student s5 = sms.addStudent("Ruwan", "44444V", 40, 80, 100, true);
        assert s5.getRegistrationNo().equals("PR00010004") : "s5=" + s5.getRegistrationNo();
        assert !s5.isEligibleForIndustryTraining(); // GPA 3.0

        // PR #5
        Student s6 = sms.addStudent("Nimal", "55555V", 80, 40, 100, true);
        assert s6.getRegistrationNo().equals("PR00010005") : "s6=" + s6.getRegistrationNo();
        assert !s6.isEligibleForIndustryTraining(); // DBMS 40

        // PR #6
        Student s7 = sms.addStudent("Test1", "66666V", -2, -2, 100, true);
        assert s7.getRegistrationNo().equals("PR00010006") : "s7=" + s7.getRegistrationNo();

        // PR #7
        Student s8 = sms.addStudent("Test2", "77777V", -2, -2, 100, true);
        assert s8.getRegistrationNo().equals("PR00010007") : "s8=" + s8.getRegistrationNo();

        // OR #2
        Student s9 = sms.addStudent("TestOnline", "88888V", -2, -2, 100, false);
        assert s9.getRegistrationNo().equals("OR00010002") : "s9=" + s9.getRegistrationNo();

        // Marks updates
        sms.updatePrfMarks(s3.getRegistrationNo(), -1);
        assert s3.getPrfMarks() == -1;
        sms.updateDbmsMarks(s3.getRegistrationNo(), 90);
        assert s3.getDbmsMarks() == 90;

        // Alphabetical sort
        List<Student> sorted = sms.getStudentsSortedByName();
        assert sorted.size() == 8 : "size=" + sorted.size();
        for (int i = 1; i < sorted.size(); i++) {
            assert sorted.get(i-1).getName().compareToIgnoreCase(sorted.get(i).getName()) <= 0;
        }

        // Eligible: Priya + Lakshan = 2
        assert sms.getStudentsEligibleForIndustryTraining().size() == 2;

        System.out.println("=== ALL TESTS PASSED ===");
        System.out.println("Total students: " + sms.getAllStudents().size());
        System.out.println("Total batches: " + sms.getAllBatches().size());
        System.out.println("Eligible: " + sms.getStudentsEligibleForIndustryTraining().size());
        System.out.println("Sorted:");
        for (Student s : sorted) {
            System.out.printf("  %-15s %-12s GPA=%.2f%s%n",
                s.getRegistrationNo(), s.getName(),
                s.calculateGPA(),
                s.isEligibleForIndustryTraining() ? " [ELIGIBLE]" : "");
        }
    }
}
