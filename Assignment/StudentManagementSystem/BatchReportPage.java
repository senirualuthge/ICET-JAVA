import javax.swing.*;
import java.awt.*;

public class BatchReportPage extends JPanel implements Refreshable {

    private final Main main;
    private final ReportTablePanel table = new ReportTablePanel();
    private final JLabel batchLabel = Ui.subTitleLabel(" ");
    private Batch selectedBatch;

    public BatchReportPage(Main main) {
        this.main = main;
        batchLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        batchLabel.setForeground(Ui.PRIMARY);
        batchLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel content = new JPanel(new BorderLayout(0, 12));
        content.setBackground(Ui.BG);
        content.add(batchLabel, BorderLayout.NORTH);
        content.add(table, BorderLayout.CENTER);

        JPanel page = Ui.page(main, "Batch Student Report", null, content, Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    public void setSelectedBatch(Batch batch) {
        this.selectedBatch = batch;
    }

    @Override
    public void refresh() {
        table.model.setRowCount(0);
        if (selectedBatch == null) {
            batchLabel.setText("No batch selected");
            return;
        }
        batchLabel.setText(selectedBatch.toString());
        int number = 1;
        for (Student student : Database.get().studentsInBatch(selectedBatch.getBatchNumber())) {
            table.addRow(number++, selectedBatch, student);
        }
    }
}
