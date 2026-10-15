public class UpdatePrfPage extends UpdateMarksPage {

    public UpdatePrfPage(Main main) {
        super(main, "PRF");
    }

    @Override
    protected int getMarks(Student student) {
        return student.getPrfMarks();
    }

    @Override
    protected void setMarks(Student student, int marks) {
        student.setPrfMarks(marks);
    }
}
