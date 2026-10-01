/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stmangsys;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory collection of students. Keeps the array-style style used in the
 * coursework while providing the operations needed by the GUI forms:
 * search by registration number or NIC, sequential ID generation per batch,
 * add / update / delete and marks updates.
 *
 * @author cs
 */
public class StudentCollection {

    private Student[] studentArray = new Student[]{
        new Student("PR24101001", "Nimal Perera", "199012345678", "101", Student.MARK_NOT_CONDUCTED, Student.MARK_NOT_CONDUCTED),
        new Student("PR24101002", "Bimal Silva", "199523456789", "101", Student.MARK_NOT_CONDUCTED, Student.MARK_NOT_CONDUCTED),
        new Student("OR24101003", "Amal Fernando", "199834567890", "101", Student.MARK_NOT_CONDUCTED, Student.MARK_NOT_CONDUCTED),
        new Student("PR24102001", "Nirosha Jayasinghe", "199945678901", "102", Student.MARK_NOT_CONDUCTED, Student.MARK_NOT_CONDUCTED)
    };

    public boolean addNewStudent(Student student) {
        if (student == null || student.getRegistrationNo() == null) {
            return false;
        }
        if (search(student.getRegistrationNo()) != -1) {
            return false;
        }
        if (searchStudentByNic(student.getNic()) != null) {
            return false;
        }
        extendsStudentArray();
        studentArray[studentArray.length - 1] = student;
        return true;
    }

    public Student[] getAllStudent() {
        Student[] tempStudentArray = new Student[studentArray.length];
        for (int i = 0; i < studentArray.length; i++) {
            tempStudentArray[i] = studentArray[i];
        }
        return tempStudentArray;
    }

    /**
     * All students registered in the given batch.
     */
    public Student[] getStudentsByBatch(String batchNo) {
        Student[] temp = new Student[studentArray.length];
        int count = 0;
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i].getBatchNo().equals(batchNo)) {
                temp[count] = studentArray[i];
                count++;
            }
        }
        Student[] result = new Student[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    /**
     * All students sorted alphabetically by student name (case-insensitive).
     * Used by the reports (spec section 4).
     */
    public Student[] getAllStudentSortedByName() {
        Student[] result = getAllStudent();
        sortByName(result);
        return result;
    }

    /**
     * Students of the given batch sorted alphabetically by student name.
     * Used by the batch-wise student report (spec section 4.2).
     */
    public Student[] getStudentsByBatchSortedByName(String batchNo) {
        Student[] result = getStudentsByBatch(batchNo);
        sortByName(result);
        return result;
    }

    private void sortByName(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    public Student searchStudent(String registrationNo) {
        if (registrationNo == null) {
            return null;
        }
        for (int i = 0; i < studentArray.length; i++) {
            if (registrationNo.equalsIgnoreCase(studentArray[i].getRegistrationNo())) {
                return studentArray[i];
            }
        }
        return null;
    }

    public Student searchStudentByNic(String nic) {
        if (nic == null) {
            return null;
        }
        for (int i = 0; i < studentArray.length; i++) {
            if (nic.equalsIgnoreCase(studentArray[i].getNic())) {
                return studentArray[i];
            }
        }
        return null;
    }

    /**
     * Next registration number for the given batch and lecture mode.
     * Format: PR/OR + 2-digit year + batch number + 3-digit running number,
     * e.g. PR24105003. Sequential, based on the last Student ID in the
     * selected batch (regardless of lecture mode prefix).
     */
    public String generateRegistrationNo(String batchNo, boolean physical) {
        String prefix = physical ? "PR" : "OR";
        String year = "24"; // "2024" intake as in the spec examples
        int highest = 0;
        for (int i = 0; i < studentArray.length; i++) {
            Student s = studentArray[i];
            if (s.getBatchNo().equals(batchNo)
                    && s.getRegistrationNo().length() > prefix.length() + year.length() + batchNo.length()) {
                try {
                    int seq = Integer.parseInt(s.getRegistrationNo().substring(prefix.length() + year.length() + batchNo.length()));
                    if (seq > highest) {
                        highest = seq;
        }
                } catch (NumberFormatException e) {
                    // ignore ids that don't match the pattern
                }
            }
        }
        String seqText = String.valueOf(highest + 1);
        while (seqText.length() < 3) {
            seqText = "0" + seqText;
        }
        return prefix + year + batchNo + seqText;
    }

    public boolean updateStudent(Student student) {
        if (student == null) {
            return false;
        }
        int index = search(student.getRegistrationNo());
        if (index != -1) {
            studentArray[index] = student;
            return true;
        }
        return false;
    }

    /**
     * Updates name and NIC only (coursework 1.2). NIC uniqueness is checked by the caller.
     */
    public boolean updateStudentDetails(String registrationNo, String name, String nic) {
        Student student = searchStudent(registrationNo);
        if (student == null) {
            return false;
        }
        student.setName(name);
        student.setNic(nic);
        return true;
    }

    public boolean deleteStudent(String registrationNo) {
        if (registrationNo == null) {
            return false;
        }
        for (int i = 0; i < studentArray.length; i++) {
            if (registrationNo.equalsIgnoreCase(studentArray[i].getRegistrationNo())) {
                Student[] shrunkStudentArray = new Student[studentArray.length - 1];
                for (int j = 0; j < i; j++) {
                    shrunkStudentArray[j] = studentArray[j];
                }
                for (int j = i + 1; j < studentArray.length; j++) {
                    shrunkStudentArray[j - 1] = studentArray[j];
                }
                studentArray = shrunkStudentArray;
                return true;
            }
        }
        return false;
    }

    /**
     * Marks update used by Grade Management.
     * Returns false when the student does not exist.
     */
    public boolean updatePrfMarks(String registrationNo, int marks) {
        Student student = searchStudent(registrationNo);
        if (student == null) {
            return false;
        }
        student.setPrfMarks(marks);
        return true;
    }

    public boolean updateDbmsMarks(String registrationNo, int marks) {
        Student student = searchStudent(registrationNo);
        if (student == null) {
            return false;
        }
        student.setDbmsMarks(marks);
        return true;
    }

    private void extendsStudentArray() {
        Student[] tempStudentArray = new Student[studentArray.length + 1];
        for (int i = 0; i < StudentCollection.this.studentArray.length; i++) {
            tempStudentArray[i] = StudentCollection.this.studentArray[i];
        }
        studentArray = tempStudentArray;
    }

    private int search(String registrationNo) {
        if (registrationNo == null) {
            return -1;
        }
        for (int i = 0; i < studentArray.length; i++) {
            if (registrationNo.equalsIgnoreCase(studentArray[i].getRegistrationNo())) {
                return i;
            }
        }
        return -1;
    }
}
