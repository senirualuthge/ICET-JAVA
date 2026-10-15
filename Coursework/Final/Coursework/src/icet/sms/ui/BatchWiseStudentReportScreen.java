package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class BatchWiseStudentReportScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JComboBox<String> cbBatch;
    private JTable tbl;
    private DefaultTableModel dtm;

    public BatchWiseStudentReportScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Batch-wise Student Report");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Batch-wise Student Report"), BorderLayout.NORTH);

        // Batch selector at top
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JLabel lbl = new JLabel("Select Batch:");
        lbl.setFont(GuiUtils.LABEL_FONT);
        cbBatch = GuiUtils.buildBatchComboBox(sms);
        JButton btnView = new JButton("View Report");
        btnView.setFont(GuiUtils.BTN_FONT);

        top.add(lbl);
        top.add(cbBatch);
        top.add(btnView);
        top.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        add(top, BorderLayout.NORTH);

        // Table
        String[] cols = {"Batch Name", "Registration No", "Student Name",
                         "PRF Marks", "DBMS Marks", "GPA"};
        dtm = new DefaultTableModel(cols, 0);
        tbl = new JTable(dtm);
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

        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(scroll, BorderLayout.CENTER);

        btnView.addActionListener(e -> refreshReport());
        // initial empty state
        dtm.addRow(new Object[]{"-", "-", "-", "-", "-", "-"});

        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }

    private void refreshReport() {
        String selected = (String) cbBatch.getSelectedItem();
        if (selected == null || selected.startsWith("--")) {
            GuiUtils.showWarning(this, "No batch selected.");
            return;
        }

        int batchId = Integer.parseInt(selected.replaceAll(".*?ID:\\s*(\\d+).*", "$1"));
        Batch b = sms.getBatch(batchId);
        if (b == null) {
            GuiUtils.showWarning(this, "Batch not found.");
            return;
        }

        dtm.setRowCount(0);
        for (Student s : sms.getStudentsForBatch(batchId)) {
            dtm.addRow(new Object[]{
                b.getBatchName(),
                s.getRegistrationNo(),
                s.getName(),
                formatMark(s.getPrfMarks()),
                formatMark(s.getDbmsMarks()),
                String.format("%.2f", s.calculateGPA())
            });
        }

        if (dtm.getRowCount() == 0) {
            dtm.addRow(new Object[]{b.getBatchName(), "-", "-", "-", "-", "-"});
        }
    }

    private String formatMark(int mark) {
        if (mark == -1) return "Absent";
        if (mark == -2) return "Not Conducted";
        return String.valueOf(mark);
    }
}
