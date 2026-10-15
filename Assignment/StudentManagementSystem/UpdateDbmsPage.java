public class UpdateDbmsPage extends UpdateMarksPage {

    public UpdateDbmsPage(Main main) {
        super(main, "DBMS");
    }

    @Override
    protected int getMarks(Student student) {
        return student.getDbmsMarks();
    }

    @Override
    protected void setMarks(Student student, int marks) {
        student.setDbmsMarks(marks);
    }
}
