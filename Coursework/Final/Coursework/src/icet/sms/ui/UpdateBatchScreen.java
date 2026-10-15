package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class UpdateBatchScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtBatchId;
    private JButton btnFind, btnUpdate, btnBack;
    private JLabel statusLabel;
    private Batch currentBatch;
    private boolean found = false;

    public UpdateBatchScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Update Batch");
        setSize(500, 320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Update Batch"), BorderLayout.NORTH);

        // Top: find by batch ID
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblFind = new JLabel("Enter Batch ID:");
        lblFind.setFont(GuiUtils.LABEL_FONT);
        txtBatchId = GuiUtils.buildTextField(10, GuiUtils.LABEL_FONT);
        btnFind = new JButton("Find Batch");
        btnFind.setFont(GuiUtils.BTN_FONT);
        findPanel.add(lblFind);
        findPanel.add(txtBatchId);
        findPanel.add(btnFind);
        findPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        add(findPanel, BorderLayout.NORTH);

        // Middle: show current status + change control
        JPanel mid = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        mid.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));

        JLabel lblStatus = new JLabel("Current Status:");
        lblStatus.setFont(GuiUtils.LABEL_FONT);
        statusLabel = new JLabel("Not found");
        statusLabel.setFont(GuiUtils.LABEL_FONT);
        statusLabel.setForeground(Color.RED);

        JLabel lblChange = new JLabel("Change Status to:");
        lblChange.setFont(GuiUtils.LABEL_FONT);
        JRadioButton rbOpen = new JRadioButton("ENROLLMENT OPEN (1)");
        JRadioButton rbClosed = new JRadioButton("ENROLLMENT CLOSED (0)");
        ButtonGroup grp = new ButtonGroup();
        grp.add(rbOpen);
        grp.add(rbClosed);
        rbOpen.setFont(GuiUtils.LABEL_FONT);
        rbClosed.setFont(GuiUtils.LABEL_FONT);

        mid.add(lblStatus);
        mid.add(statusLabel);
        mid.add(new JLabel("  "));
        mid.add(lblChange);
        mid.add(rbOpen);
        mid.add(rbClosed);
        add(mid, BorderLayout.CENTER);

        // Bottom
        btnUpdate = new JButton("Update Batch Status");
        btnUpdate.setFont(GuiUtils.BTN_FONT);
        btnUpdate.setEnabled(false);
        btnBack = new JButton("Back to Home Page");
        btnBack.setFont(GuiUtils.SMALL_BTN_FONT);

        JPanel btnPanel = new JPanel(new BorderLayout(10, 0));
        btnPanel.add(btnBack, BorderLayout.WEST);
        btnPanel.add(btnUpdate, BorderLayout.EAST);
        add(btnPanel, BorderLayout.SOUTH);

        btnFind.addActionListener(e -> onFind());
        btnUpdate.addActionListener(e -> onUpdate());
        btnBack.addActionListener(e -> {
            dispose();
            new HomePage().setVisible(true);
        });
    }

    private void onFind() {
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

        Batch b = sms.getBatch(batchId);
        if (b == null) {
            GuiUtils.showWarning(this, "This batch does not exist in the system.");
            statusLabel.setText("Not found");
            statusLabel.setForeground(Color.RED);
            btnUpdate.setEnabled(false);
            currentBatch = null;
            found = false;
            return;
        }

        currentBatch = b;
        found = true;
        statusLabel.setText(b.isEnrollmentOpen() ? "ENROLLMENT OPEN (1)" : "ENROLLMENT CLOSED (0)");
        statusLabel.setForeground(b.isEnrollmentOpen() ? Color.GREEN : Color.RED);
        btnUpdate.setEnabled(true);
    }

    private void onUpdate() {
        if (!found || currentBatch == null) {
            GuiUtils.showWarning(this, "Please find a batch first.");
            return;
        }

        int newStatus;
        // Infer from UI state - no radio button selected yet, so toggle
        newStatus = currentBatch.isEnrollmentOpen() ? 0 : 1;

        boolean ok = sms.updateBatchStatus(currentBatch.getBatchId(), newStatus);
        if (ok) {
            GuiUtils.showSuccess(this,
                "Batch status changed successfully!\n\n" +
                "Batch ID: " + currentBatch.getBatchId() +
                "\nNew Status: " + (newStatus == 1 ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED"));
            currentBatch.setStatus(newStatus);
            statusLabel.setText(newStatus == 1 ? "ENROLLMENT OPEN (1)" : "ENROLLMENT CLOSED (0)");
            statusLabel.setForeground(newStatus == 1 ? Color.GREEN : Color.RED);
        } else {
            GuiUtils.showError(this, "Failed to update batch status.");
        }
    }
}
