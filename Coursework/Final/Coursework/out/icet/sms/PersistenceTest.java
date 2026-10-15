package icet.sms;

import icet.sms.model.*;
import icet.sms.util.JsonUtil;
import java.util.List;

public class PersistenceTest {
    public static void main(String[] args) throws Exception {
        String file = System.getProperty("user.home") + "/icet_sms_data.json";

        // Clean start: remove any old file
        java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(file));

        // --- Session 1: create data and save ---
        System.out.println("=== Session 1: Create & Save ===");
        StudentManagementSystem sms1 = new StudentManagementSystem();

        // Add batches
        sms1.addBatch(100);
        sms1.addBatch(200);

        // Add students
        Student s1 = sms1.addStudent("Nuwan", "12345V", 75, 80, 100, true);
        Student s2 = sms1.addStudent("Priya", "22222V", 80, 70, 100, false);
        Student s3 = sms1.addStudent("Amali", "33333V", 60, 55, 200, true);

        System.out.println("Before save:");
        System.out.println("  Students: " + sms1.getAllStudents().size());
        System.out.println("  Batches: " + sms1.getAllBatches().size());
        System.out.println("  s1=" + s1.getRegistrationNo() + " s2=" + s2.getRegistrationNo() + " s3=" + s3.getRegistrationNo());
        System.out.println("  Eligible: " + sms1.getStudentsEligibleForIndustryTraining().size());

        sms1.save();
        System.out.println("Saved to: " + file);
        System.out.println("File exists: " + java.nio.file.Files.exists(java.nio.file.Paths.get(file)));

        // Print the JSON for inspection
        String json = JsonUtil.readFile(file);
        System.out.println("JSON content:");
        System.out.println(json);

        // --- Session 2: fresh SMS, load, verify ---
        System.out.println("\n=== Session 2: Load & Verify ===");
        StudentManagementSystem sms2 = new StudentManagementSystem();
        sms2.load();

        System.out.println("After load:");
        System.out.println("  Students: " + sms2.getAllStudents().size());
        System.out.println("  Batches: " + sms2.getAllBatches().size());

        // Verify data integrity
        assert sms2.getAllStudents().size() == 3 : "Expected 3 students, got " + sms2.getAllStudents().size();
        assert sms2.getAllBatches().size() == 2 : "Expected 2 batches, got " + sms2.getAllBatches().size();

        // Verify specific students
        Student loadedS1 = sms2.getStudentByRegNo(s1.getRegistrationNo());
        assert loadedS1 != null : "s1 not found after load";
        assert loadedS1.getName().equals("Nuwan") : "s1 name mismatch: " + loadedS1.getName();
        assert loadedS1.getPrfMarks() == 75 : "s1 PRF mismatch";
        assert loadedS1.getDbmsMarks() == 80 : "s1 DBMS mismatch";

        Student loadedS2 = sms2.getStudentByRegNo(s2.getRegistrationNo());
        assert loadedS2 != null : "s2 not found after load";
        assert loadedS2.getName().equals("Priya") : "s2 name mismatch";
        assert loadedS2.getPrfMarks() == 80 : "s2 PRF mismatch";
        assert loadedS2.getDbmsMarks() == 70 : "s2 DBMS mismatch";

        Student loadedS3 = sms2.getStudentByRegNo(s3.getRegistrationNo());
        assert loadedS3 != null : "s3 not found after load";
        assert loadedS3.getName().equals("Amali") : "s3 name mismatch";
        assert loadedS3.getBatchId() == 200 : "s3 batch mismatch";

        // Verify batches
        Batch b100 = sms2.getBatch(100);
        assert b100 != null : "Batch 100 not found";
        assert b100.isEnrollmentOpen() : "Batch 100 should be open";

        Batch b200 = sms2.getBatch(200);
        assert b200 != null : "Batch 200 not found";
        assert b200.isEnrollmentOpen() : "Batch 200 should be open";

        // Verify eligible students restored correctly
        List<Student> eligible = sms2.getStudentsEligibleForIndustryTraining();
        System.out.println("  Eligible after load: " + eligible.size());
        assert eligible.size() == 2 : "Expected 2 eligible, got " + eligible.size();

        // Verify counters restored (batch 100 had 1 PR student: Nuwan; batch 200 had 1 PR: Amali)
        // So next PR for batch 100 = PR00010002, next PR for batch 200 = PR00020002
        Student s4 = sms2.addStudent("Kasun", "44444V", -2, -2, 100, true);
        assert s4.getRegistrationNo().equals("PR00010002") : "Counter for batch 100 not restored correctly, got " + s4.getRegistrationNo();
        System.out.println("  Next PR for batch 100: " + s4.getRegistrationNo() + " (expected PR00010002)");

        Student s5 = sms2.addStudent("Sanjaya", "55555V", -2, -2, 200, true);
        assert s5.getRegistrationNo().equals("PR00020002") : "Counter for batch 200 not restored correctly, got " + s5.getRegistrationNo();
        System.out.println("  Next PR for batch 200: " + s5.getRegistrationNo() + " (expected PR00020002)");

        // OR counter for batch 100 had 1 (Priya), next OR = OR00010002
        Student s6 = sms2.addStudent("Nimal", "66666V", -2, -2, 100, false);
        assert s6.getRegistrationNo().equals("OR00010002") : "OR counter not restored, got " + s6.getRegistrationNo();
        System.out.println("  Next OR for batch 100: " + s6.getRegistrationNo() + " (expected OR00010002)");

        // Verify sorted (Amali, Kasun, Nimal, Nuwan, Priya, Sanjaya)
        List<Student> sorted = sms2.getStudentsSortedByName();
        assert sorted.size() == 6 : "Expected 6 students, got " + sorted.size();
        String[] expectedOrder = {"Amali", "Kasun", "Nimal", "Nuwan", "Priya", "Sanjaya"};
        for (int i = 0; i < sorted.size(); i++) {
            assert sorted.get(i).getName().equals(expectedOrder[i]) :
                "Sort broken at index " + i + ": expected " + expectedOrder[i] + " got " + sorted.get(i).getName();
        }

        System.out.println("\n=== ALL PERSISTENCE TESTS PASSED ===");
        System.out.println("Data correctly saved and restored across sessions.");
    }
}
