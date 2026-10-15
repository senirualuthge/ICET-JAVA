package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ViewBatchesScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public ViewBatchesScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("View Batches");
        setSize(650, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("View Batches"), BorderLayout.NORTH);

        String[] cols = {"Batch ID", "Batch Name", "Student Count", "Status"};
        DefaultTableModel dtm = new DefaultTableModel(cols, 0);
        JTable tbl = new JTable(dtm);
        tbl.setFillsViewportHeight(true);
        tbl.setFont(new Font("", Font.PLAIN, 16));
        tbl.getTableHeader().setFont(new Font("", Font.BOLD, 16));

        // Populate
        for (Batch b : sms.getAllBatches()) {
            dtm.addRow(new Object[]{
                b.getBatchId(),
                b.getBatchName(),
                sms.getStudentCountForBatch(b.getBatchId()),
                b.isEnrollmentOpen() ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED"
            });
        }

        if (dtm.getRowCount() == 0) {
            dtm.addRow(new Object[]{"-", "-", "-", "-"});
        }

        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(scroll, BorderLayout.CENTER);

        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }
}
