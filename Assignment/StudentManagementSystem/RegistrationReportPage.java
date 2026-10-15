import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class RegistrationReportPage extends JPanel implements Refreshable {

    private final Main main;
    private final ReportTablePanel table = new ReportTablePanel();

    public RegistrationReportPage(Main main) {
        this.main = main;
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        JPanel page = Ui.page(main, "Student Registration Report",
                "All students sorted alphabetically by name",
                table, Main.HOME);
        add(page, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        table.model.setRowCount(0);
        List<Student> students = Database.get().getStudents();
        students.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
        int number = 1;
        for (Student student : students) {
            Batch batch = Database.get().findBatch(student.getBatchNumber());
            table.addRow(number++, batch, student);
        }
    }
}
