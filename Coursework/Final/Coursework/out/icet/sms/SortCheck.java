package icet.sms;

import icet.sms.model.*;
import java.util.List;

public class SortCheck {
    public static void main(String[] args) throws Exception {
        String file = System.getProperty("user.home") + "/icet_sms_data.json";
        java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(file));

        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addBatch(100);
        sms.addBatch(200);
        sms.addStudent("Nuwan", "12345V", 75, 80, 100, true);
        sms.addStudent("Priya", "22222V", 80, 70, 100, false);
        sms.addStudent("Amali", "33333V", 60, 55, 200, true);
        sms.save();

        StudentManagementSystem sms2 = new StudentManagementSystem();
        sms2.load();

        sms2.addStudent("Kasun", "44444V", -2, -2, 100, true);
        sms2.addStudent("Sanjaya", "55555V", -2, -2, 200, true);
        sms2.addStudent("Nimal", "66666V", -2, -2, 100, false);

        List<Student> sorted = sms2.getStudentsSortedByName();
        System.out.println("Sorted students (" + sorted.size() + "):");
        for (Student s : sorted) {
            System.out.println("  " + s.getRegistrationNo() + " | " + s.getName());
        }
    }
}
