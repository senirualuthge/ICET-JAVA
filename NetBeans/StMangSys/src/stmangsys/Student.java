/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stmangsys;

/**
 * Represents a student registered in the system.
 *
 * Marks convention (coursework spec):
 *   -1 : student was absent for the exam
 *   -2 : exam has not been conducted yet (default when adding a student)
 *
 * @author cs
 */
public class Student {

    public static final int MARK_ABSENT = -1;
    public static final int MARK_NOT_CONDUCTED = -2;

    private String registrationNo; // system generated, e.g. PR24105003
    private String name;
    private String nic;
    private String batchNo;        // e.g. 101
    private int prfMarks;
    private int dbmsMarks;

    public Student(String registrationNo, String name, String nic, String batchNo, int prfMarks, int dbmsMarks) {
        this.registrationNo = registrationNo;
        this.name = name;
        this.nic = nic;
        this.batchNo = batchNo;
        this.prfMarks = prfMarks;
        this.dbmsMarks = dbmsMarks;
    }

    @Override
    public String toString() {
        return registrationNo + "\t" + name + "\t" + nic + "\t" + batchNo + "\t" + prfMarks + "\t" + dbmsMarks;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }

    public String getBatchNo() {
        return batchNo;
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

    /**
     * True when the given marks value is a real mark (0..100).
     * Absent (-1) and not-conducted (-2) are not real marks.
     */
    public static boolean isRealMark(int marks) {
        return marks >= 0 && marks <= 100;
    }

    /**
     * Text shown on the profile for a marks value:
     * -1 -> "ABSENT", -2 -> "NOT CONDUCTED", otherwise the number itself.
     */
    public static String marksText(int marks) {
        if (marks == MARK_ABSENT) {
            return "ABSENT";
        }
        if (marks == MARK_NOT_CONDUCTED) {
            return "NOT CONDUCTED";
        }
        return String.valueOf(marks);
    }

    /**
     * GPA for a single subject mark, using the GPA value table from the spec.
     * Returns -1 when no GPA applies (absent / not conducted).
     */
    public static double marksGpa(int marks) {
        if (!isRealMark(marks)) {
            return -1;
        }
        if (marks >= 90) {
            return 4.25;
        } else if (marks >= 80) {
            return 4.00;
        } else if (marks >= 75) {
            return 3.70;
        } else if (marks >= 70) {
            return 3.30;
        } else if (marks >= 65) {
            return 3.00;
        } else if (marks >= 60) {
            return 2.70;
        } else if (marks >= 55) {
            return 2.30;
        } else if (marks >= 50) {
            return 2.00;
        } else if (marks >= 45) {
            return 1.70;
        } else if (marks >= 40) {
            return 1.30;
        } else if (marks >= 30) {
            return 1.00;
        } else {
            return 0.70; // 0 - 29
        }
    }

    /**
     * Student GPA = (PRF GPA + DBMS GPA) / 2.
     * A subject with no GPA (absent / not conducted) counts as 0,
     * matching the sample profile in the spec (PRF 94, DBMS 39 -> 2.625).
     */
    public double getGpa() {
        double prfGpa = Math.max(marksGpa(prfMarks), 0);
        double dbmsGpa = Math.max(marksGpa(dbmsMarks), 0);
        return (prfGpa + dbmsGpa) / 2.0;
    }

    /**
     * GPA formatted for display, e.g. 2.625 or 4.0.
     */
    public String getGpaText() {
        double gpa = getGpa();
        if (gpa == Math.floor(gpa)) {
            return String.valueOf((long) gpa);
        }
        return String.valueOf(gpa);
    }

    /**
     * Industry training eligibility criteria from the spec (section 4.3):
     * 1. GPA must be greater than 3.25
     * 2. Both PRF and DBMS marks must be greater than 50
     */
    public boolean isEligibleForIndustryTraining() {
        return getGpa() > 3.25
                && isRealMark(prfMarks) && prfMarks > 50
                && isRealMark(dbmsMarks) && dbmsMarks > 50;
    }
}
