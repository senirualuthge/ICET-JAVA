package icet.sms.ui;

import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class PrfMarksUpdateScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtId;
    private JTextField txtNewMarks;
    private JButton btnFind, btnUpdate, btnBack;
    private JLabel lblCurrent;
    private Student currentStudent;
    private boolean found = false;

    public PrfMarksUpdateScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("PRF Marks Update");
        setSize(550, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("PRF Marks Update"), BorderLayout.NORTH);

        // Find student
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblFind = new JLabel("Enter Student ID:");
        lblFind.setFont(GuiUtils.LABEL_FONT);
        txtId = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        btnFind = new JButton("Find Student");
        btnFind.setFont(GuiUtils.BTN_FONT);
        findPanel.add(lblFind);
        findPanel.add(txtId);
        findPanel.add(btnFind);
        findPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        add(findPanel, BorderLayout.NORTH);

        // Display current + input
        JPanel mid = new JPanel(new GridLayout(2, 2, 8, 8));
        mid.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));

        JLabel lblCurrentLabel = new JLabel("Current PRF Marks:");
        lblCurrentLabel.setFont(GuiUtils.LABEL_FONT);
        lblCurrent = new JLabel("Not found");
        lblCurrent.setFont(GuiUtils.LABEL_FONT);
        lblCurrent.setForeground(Color.RED);

        JLabel lblNewLabel = new JLabel("New PRF Marks:");
        lblNewLabel.setFont(GuiUtils.LABEL_FONT);
        txtNewMarks = GuiUtils.buildTextField(10, GuiUtils.LABEL_FONT);

        mid.add(lblCurrentLabel);
        mid.add(lblCurrent);
        mid.add(lblNewLabel);
        mid.add(txtNewMarks);
        add(mid, BorderLayout.CENTER);

        // Buttons
        btnUpdate = new JButton("Update PRF Marks");
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
        String regNo = txtId.getText().trim();
        if (regNo.isEmpty()) {
            GuiUtils.showWarning(this, "Please enter a Student ID.");
            return;
        }

        Student s = sms.getStudentByRegNo(regNo);
        if (s == null) {
            GuiUtils.showWarning(this, "This student does not exist in the system.");
            lblCurrent.setText("Not found");
            lblCurrent.setForeground(Color.RED);
            btnUpdate.setEnabled(false);
            currentStudent = null;
            found = false;
            return;
        }

        currentStudent = s;
        found = true;
        lblCurrent.setText(formatMark(s.getPrfMarks()));
        lblCurrent.setForeground(Color.BLACK);
        txtNewMarks.setText("");
        btnUpdate.setEnabled(true);
    }

    private void onUpdate() {
        if (!found || currentStudent == null) {
            GuiUtils.showWarning(this, "Please find a student first.");
            return;
        }

        String raw = txtNewMarks.getText().trim();
        if (raw.isEmpty()) {
            GuiUtils.showWarning(this, "Please enter the new PRF marks.");
            return;
        }

        int newMarks;
        try {
            newMarks = Integer.parseInt(raw);
        } catch (NumberFormatException ex) {
            GuiUtils.showWarning(this, "Marks must be a number.");
            return;
        }

        // Validate: -1 for absent, 0-100 for marks
        if (newMarks != -1 && (newMarks < 0 || newMarks > 100)) {
            GuiUtils.showWarning(this,
                "Invalid marks!\n" +
                "- Enter -1 if the student is absent.\n" +
                "- Otherwise, marks must be between 0 and 100.");
            return;
        }

        boolean ok = sms.updatePrfMarks(currentStudent.getRegistrationNo(), newMarks);
        if (ok) {
            GuiUtils.showSuccess(this,
                "PRF Marks updated successfully!\n\n" +
                "Registration No: " + currentStudent.getRegistrationNo() +
                "\nNew PRF Marks: " + formatMark(newMarks) +
                "\nGPA: " + String.format("%.2f", currentStudent.calculateGPA()));
            currentStudent.setPrfMarks(newMarks);
            lblCurrent.setText(formatMark(newMarks));
        } else {
            GuiUtils.showError(this, "Failed to update PRF marks.");
        }
    }

    private String formatMark(int mark) {
        if (mark == -1) return "Absent (-1)";
        if (mark == -2) return "Not Conducted (-2)";
        return String.valueOf(mark);
    }
}
