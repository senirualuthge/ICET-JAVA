// Holds the students in a plain array and grows it on demand.
// (Split out of the old ExStd1.java.)
public final class StudentCollection {

    private ExStd1[] studentArray = new ExStd1[]{
            new ExStd1("S0001", "Nimal", 76, 55),
            new ExStd1("S0002", "Bimal", 96, 75),
            new ExStd1("S0003", "Amal", 26, 95),
            new ExStd1("S0004", "Nioth", 86, 55),
    };

    public boolean addNewStudent(ExStd1 student) {
        extendStudentArray();
        studentArray[studentArray.length - 1] = student;
        return true;
    }

    public ExStd1[] getAllStudent() {
        ExStd1[] copy = new ExStd1[studentArray.length];
        System.arraycopy(studentArray, 0, copy, 0, studentArray.length);
        return copy;
    }

    public ExStd1 searchStudent(String id) {
        for (ExStd1 student : studentArray) {
            if (id.equalsIgnoreCase(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public int search(ExStd1 student) {
        for (int i = 0; i < studentArray.length; i++) {
            if (student.getId().equalsIgnoreCase(studentArray[i].getId())) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateStudent(ExStd1 student) {
        int index = search(student);
        if (index != -1) {
            studentArray[index] = student;
            return true;
        }
        return false;
    }

    private void extendStudentArray() {
        ExStd1[] temp = new ExStd1[studentArray.length + 1];
        System.arraycopy(studentArray, 0, temp, 0, studentArray.length);
        studentArray = temp;
    }
}
