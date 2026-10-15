package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class StudentRegistrationReportScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public StudentRegistrationReportScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Student Registration Report");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Student Registration Report"), BorderLayout.NORTH);

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

        for (Student s : sms.getStudentsSortedByName()) {
            Batch b = sms.getBatch(s.getBatchId());
            String batchName = b == null ? "Unknown" : b.getBatchName();
            dtm.addRow(new Object[]{
                batchName,
                s.getRegistrationNo(),
                s.getName(),
                formatMark(s.getPrfMarks()),
                formatMark(s.getDbmsMarks()),
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

    private String formatMark(int mark) {
        if (mark == -1) return "Absent";
        if (mark == -2) return "Not Conducted";
        return String.valueOf(mark);
    }
}
