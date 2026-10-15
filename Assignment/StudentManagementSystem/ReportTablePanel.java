import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReportTablePanel extends JPanel {

    protected static final String[] COLUMNS = {
            "No", "Batch Name", "Registration No", "Student Name",
            "NIC", "PRF Marks", "DBMS Marks", "GPA"
    };

    protected final DefaultTableModel model = new DefaultTableModel(COLUMNS, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ReportTablePanel() {
        JTable table = new JTable(model);
        table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
        table.setRowHeight(28);
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        table.getTableHeader().setBackground(Ui.PANEL_BG);
        table.setGridColor(new Color(220, 224, 230));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < COLUMNS.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 224, 230)));
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    protected void addRow(int number, Batch batch, Student student) {
        model.addRow(new Object[]{
                number,
                batch != null ? batch.toString() : student.getBatchNumber() + " Batch",
                student.getRegistrationNo(),
                student.getName(),
                student.getNic(),
                student.getPrfMarks(),
                student.getDbmsMarks(),
                GpaUtil.formatGpa(student.getGpa())
        });
    }
}
