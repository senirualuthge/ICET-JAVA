package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class IndustryTrainingEligibilityReportScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public IndustryTrainingEligibilityReportScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Industry Training Eligibility Report");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Industry Training Eligibility Report"), BorderLayout.NORTH);

        // Criteria info panel
        JPanel criteriaPanel = new JPanel();
        criteriaPanel.setLayout(new BoxLayout(criteriaPanel, BoxLayout.Y_AXIS));
        criteriaPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        criteriaPanel.add(new JLabel(
            "<html><b>Eligibility Criteria:</b><br>" +
            "&nbsp;&nbsp;1. GPA &gt; 3.25<br>" +
            "&nbsp;&nbsp;2. PRF Marks &gt; 50<br>" +
            "&nbsp;&nbsp;3. DBMS Marks &gt; 50</html>"));
        criteriaPanel.setOpaque(false);
        add(criteriaPanel, BorderLayout.NORTH);

        String[] cols = {"Batch Name", "Registration No", "Student Name",
                         "PRF Marks", "DBMS Marks", "GPA"};
        DefaultTableModel dtm = new DefaultTableModel(cols, 0);
        JTable tbl = new JTable(dtm);
        tbl.setFillsViewportHeight(true);
        tbl.setFont(new Font("", Font.PLAIN, 14));
        tbl.getTableHeader().setFont(new Font("", Font.BOLD, 14));
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(120);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(160);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(90);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(90);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(70);

        for (Student s : sms.getStudentsEligibleForIndustryTraining()) {
            Batch b = sms.getBatch(s.getBatchId());
            String batchName = b == null ? "Unknown" : b.getBatchName();
            dtm.addRow(new Object[]{
                batchName,
                s.getRegistrationNo(),
                s.getName(),
                s.getPrfMarks(),
                s.getDbmsMarks(),
                String.format("%.2f", s.calculateGPA())
            });
        }

        if (dtm.getRowCount() == 0) {
            dtm.addRow(new Object[]{"-", "-", "-", "-", "-", "-"});
        }

        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(scroll, BorderLayout.CENTER);

        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }
}
