public final class GpaUtil {

    private GpaUtil() {
    }

    public static double marksToGpa(int marks) {
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

    public static double studentGpa(Student student) {
        return (marksToGpa(student.getPrfMarks()) + marksToGpa(student.getDbmsMarks())) / 2.0;
    }

    public static String displayMarks(int marks) {
        if (marks == -1) return "Absent";
        if (marks == -2) return "Not Conducted";
        return String.valueOf(marks);
    }

    public static String formatGpa(double gpa) {
        return String.format("%.2f", gpa);
    }
}
