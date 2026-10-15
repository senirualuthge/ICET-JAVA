package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class AddBatchScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtBatchId;
    private JButton btnAdd, btnBack;

    public AddBatchScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Add Batch");
        setSize(450, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Add Batch"), BorderLayout.NORTH);

        JPanel form = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblBatchId = new JLabel("Batch ID (starting from 100):");
        lblBatchId.setFont(GuiUtils.LABEL_FONT);
        txtBatchId = GuiUtils.buildTextField(10, GuiUtils.LABEL_FONT);
        JButton btnFindBatch = new JButton("Add Batch");
        btnFindBatch.setFont(GuiUtils.BTN_FONT);

        form.add(lblBatchId);
        form.add(txtBatchId);
        form.add(btnFindBatch);
        add(form, BorderLayout.CENTER);

        btnBack = new JButton("Back to Home Page");
        btnBack.setFont(GuiUtils.SMALL_BTN_FONT);
        JPanel btnPanel = new JPanel(new BorderLayout(10, 0));
        btnPanel.add(btnBack, BorderLayout.WEST);
        add(btnPanel, BorderLayout.SOUTH);

        btnFindBatch.addActionListener(e -> onAdd());
        btnBack.addActionListener(e -> {
            dispose();
            new HomePage().setVisible(true);
        });
    }

    private void onAdd() {
        String raw = txtBatchId.getText().trim();
        if (raw.isEmpty()) {
            GuiUtils.showWarning(this, "Please enter a Batch ID.");
            return;
        }

        int batchId;
        try {
            batchId = Integer.parseInt(raw);
        } catch (NumberFormatException ex) {
            GuiUtils.showWarning(this, "Batch ID must be a number.");
            return;
        }

        if (batchId < 100) {
            GuiUtils.showWarning(this, "Batch ID must be 100 or greater.");
            return;
        }

        if (sms.batchExists(batchId)) {
            GuiUtils.showWarning(this, "This batch already added in the system.");
            return;
        }

        Batch added = sms.addBatch(batchId);
        if (added != null) {
            GuiUtils.showSuccess(this,
                "Batch added successfully!\n\n" +
                "Batch Name: " + added.getBatchName() +
                "\nBatch ID: " + added.getBatchId() +
                "\nStatus: ENROLLMENT OPEN");
            txtBatchId.setText("");
        } else {
            GuiUtils.showError(this, "Failed to add batch.");
        }
    }
}
