package icet.sms.ui;

import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class DeleteStudentScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtId;
    private JButton btnDelete, btnBack;
    private JLabel lblInfo;

    public DeleteStudentScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Delete Student Profile");
        setSize(550, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Delete Student Profile"), BorderLayout.NORTH);

        // Find panel
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblFind = new JLabel("Enter Student ID:");
        lblFind.setFont(GuiUtils.LABEL_FONT);
        txtId = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        JButton btnFind = new JButton("Find Student");
        btnFind.setFont(GuiUtils.BTN_FONT);
        findPanel.add(lblFind);
        findPanel.add(txtId);
        findPanel.add(btnFind);
        findPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        add(findPanel, BorderLayout.NORTH);

        // Info panel
        lblInfo = new JLabel("Enter a Student ID and click Find Student to view details before deletion.",
                             SwingConstants.CENTER);
        lblInfo.setFont(new Font("", Font.PLAIN, 16));
        lblInfo.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        lblInfo.setOpaque(true);
        lblInfo.setBackground(new Color(245, 245, 245));
        add(lblInfo, BorderLayout.CENTER);

        // Buttons
        btnDelete = new JButton("Delete Student");
        btnDelete.setFont(GuiUtils.BTN_FONT);
        btnDelete.setEnabled(false);
        btnBack = new JButton("Back to Home Page");
        btnBack.setFont(GuiUtils.SMALL_BTN_FONT);

        JPanel btnPanel = new JPanel(new BorderLayout(10, 0));
        btnPanel.add(btnBack, BorderLayout.WEST);
        btnPanel.add(btnDelete, BorderLayout.EAST);
        add(btnPanel, BorderLayout.SOUTH);

        btnFind.addActionListener(e -> onFind());
        btnDelete.addActionListener(e -> onDelete());
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
            lblInfo.setText("Student not found.");
            btnDelete.setEnabled(false);
            return;
        }

        lblInfo.setText(String.format(
            "<HTML><U>Student Data:</U><br><br>" +
            "Reg No: %s<br>" +
            "Name: %s<br>" +
            "NIC: %s<br>" +
            "PRF: %s<br>" +
            "DBMS: %s<br>" +
            "GPA: %.2f</HTML>",
            s.getRegistrationNo(), s.getName(), s.getNic(),
            formatMark(s.getPrfMarks()), formatMark(s.getDbmsMarks()),
            s.calculateGPA()));
        lblInfo.setHorizontalAlignment(JLabel.LEFT);
        lblInfo.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
        btnDelete.setEnabled(true);
    }

    private String formatMark(int mark) {
        if (mark == -1) return "Absent (-1)";
        if (mark == -2) return "Not Conducted (-2)";
        return String.valueOf(mark);
    }

    private void onDelete() {
        String regNo = txtId.getText().trim();
        if (regNo.isEmpty()) return;

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this student?",
            "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        boolean ok = sms.deleteStudent(regNo);
        if (ok) {
            GuiUtils.showSuccess(this, "Student deleted successfully!");
            txtId.setText("");
            lblInfo.setText("Enter a Student ID and click Find Student to view details before deletion.");
            lblInfo.setHorizontalAlignment(JLabel.CENTER);
            btnDelete.setEnabled(false);
        } else {
            GuiUtils.showError(this, "Delete failed. Student may not exist.");
        }
    }
}
