package icet.sms.ui;

import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class UpdateStudentScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtFindId, txtName, txtNic;
    private JButton btnFind, btnUpdate, btnBack;
    private Student currentStudent;
    private boolean found = false;

    public UpdateStudentScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Update Student");
        setSize(600, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Update Student"), BorderLayout.NORTH);

        // Top: find by ID
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblFind = new JLabel("Enter Student ID:");
        lblFind.setFont(GuiUtils.LABEL_FONT);
        txtFindId = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        btnFind = new JButton("Find Student");
        btnFind.setFont(GuiUtils.BTN_FONT);
        findPanel.add(lblFind);
        findPanel.add(txtFindId);
        findPanel.add(btnFind);
        findPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        add(findPanel, BorderLayout.NORTH);

        // Center: display/update fields
        JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));

        JLabel lblNameLabel = new JLabel("Student Name:");
        lblNameLabel.setFont(GuiUtils.LABEL_FONT);
        txtName = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        txtName.setEnabled(false);
        form.add(lblNameLabel);
        form.add(txtName);

        JLabel lblNicLabel = new JLabel("Student NIC:");
        lblNicLabel.setFont(GuiUtils.LABEL_FONT);
        txtNic = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        txtNic.setEnabled(false);
        form.add(lblNicLabel);
        form.add(txtNic);

        add(form, BorderLayout.CENTER);

        // Bottom buttons
        btnUpdate = new JButton("Update Student");
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
        String regNo = txtFindId.getText().trim();
        if (regNo.isEmpty()) {
            GuiUtils.showWarning(this, "Please enter a Student ID.");
            return;
        }

        Student s = sms.getStudentByRegNo(regNo);
        if (s == null) {
            GuiUtils.showWarning(this, "This student not exist in the system.");
            currentStudent = null;
            found = false;
            txtName.setText("");
            txtNic.setText("");
            txtName.setEnabled(false);
            txtNic.setEnabled(false);
            btnUpdate.setEnabled(false);
            return;
        }

        currentStudent = s;
        found = true;
        txtName.setText(s.getName());
        txtNic.setText(s.getNic());
        txtName.setEnabled(true);
        txtNic.setEnabled(true);
        btnUpdate.setEnabled(true);
    }

    private void onUpdate() {
        if (!found || currentStudent == null) {
            GuiUtils.showWarning(this, "Please find a student first.");
            return;
        }

        String newName = txtName.getText().trim();
        String newNic  = txtNic.getText().trim();

        if (newName.isEmpty() && newNic.isEmpty()) {
            GuiUtils.showWarning(this, "No changes made.");
            return;
        }

        // NIC change check
        if (!newNic.equals(currentStudent.getNic()) && sms.studentExistsByNic(newNic)) {
            GuiUtils.showWarning(this, "This NIC already exists in the system.");
            return;
        }

        String regNo = currentStudent.getRegistrationNo();
        boolean ok = sms.updateStudent(regNo,
                newName.isEmpty() ? currentStudent.getName() : newName,
                newNic.isEmpty()  ? currentStudent.getNic()  : newNic);

        if (ok) {
            GuiUtils.showSuccess(this, "Student updated successfully!");
            currentStudent = sms.getStudentByRegNo(regNo); // refresh
        } else {
            GuiUtils.showError(this, "Update failed.");
        }
    }
}
