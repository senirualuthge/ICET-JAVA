import javax.swing.*;
import java.awt.*;
import java.util.List;

public class IndustryTrainingPage extends JPanel implements Refreshable {

    private static final double MIN_GPA = 3.25;
    private static final int MIN_MARKS = 50;

    private final Main main;
    private final ReportTablePanel table = new ReportTablePanel();

    public IndustryTrainingPage(Main main) {
        this.main = main;
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        JPanel page = Ui.page(main, "Industry Training Eligibility Report",
                "Students with GPA above 3.25 and both marks above 50",
                table, Main.HOME);
        add(page, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        table.model.setRowCount(0);
        List<Student> students = Database.get().getStudents();
        int number = 1;
        for (Student student : students) {
            if (isEligible(student)) {
                Batch batch = Database.get().findBatch(student.getBatchNumber());
                table.addRow(number++, batch, student);
            }
        }
    }

    private boolean isEligible(Student student) {
        return student.getGpa() > MIN_GPA
                && student.getPrfMarks() > MIN_MARKS
                && student.getDbmsMarks() > MIN_MARKS;
    }
}
