package icet.sms.ui;

import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class ViewStudentScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtId;
    private JButton btnView, btnBack;
    private JLabel lblRegNo, lblName, lblNic, lblPrf, lblDbms, lblGpa;

    public ViewStudentScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("View Student Profile");
        setSize(550, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("View Student Profile"), BorderLayout.NORTH);

        // Find panel
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblFind = new JLabel("Enter Student ID:");
        lblFind.setFont(GuiUtils.LABEL_FONT);
        txtId = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        btnView = new JButton("View Profile");
        btnView.setFont(GuiUtils.BTN_FONT);
        findPanel.add(lblFind);
        findPanel.add(txtId);
        findPanel.add(btnView);
        findPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        add(findPanel, BorderLayout.NORTH);

        // Data panel
        JPanel dataPanel = new JPanel(new GridLayout(6, 2, 6, 6));
        dataPanel.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
        dataPanel.setBackground(new Color(245, 245, 245));

        lblRegNo = lbl("Registration No:", true);
        lblName  = lbl("Student Name:", true);
        lblNic   = lbl("NIC:", true);
        lblPrf   = lbl("PRF Marks:", true);
        lblDbms  = lbl("DBMS Marks:", true);
        lblGpa   = lbl("Student GPA:", true);

        dataPanel.add(lblRegNo);
        dataPanel.add(new JLabel("")); // placeholder - filled on view
        dataPanel.add(new JLabel("Student Name:"));
        dataPanel.add(lblName);
        dataPanel.add(new JLabel("NIC:"));
        dataPanel.add(lblNic);
        dataPanel.add(new JLabel("PRF Marks:"));
        dataPanel.add(lblPrf);
        dataPanel.add(new JLabel("DBMS Marks:"));
        dataPanel.add(lblDbms);
        dataPanel.add(new JLabel("Student GPA:"));
        dataPanel.add(lblGpa);

        add(dataPanel, BorderLayout.CENTER);

        // Buttons
        btnBack = new JButton("Back to Home Page");
        btnBack.setFont(GuiUtils.SMALL_BTN_FONT);
        JPanel btnPanel = new JPanel(new BorderLayout(10, 0));
        btnPanel.add(btnBack, BorderLayout.WEST);
        add(btnPanel, BorderLayout.SOUTH);

        btnView.addActionListener(e -> onView());
        btnBack.addActionListener(e -> {
            dispose();
            new HomePage().setVisible(true);
        });

        clearDisplay();
    }

    private JLabel lbl(String text, boolean bold) {
        JLabel l = new JLabel(text);
        l.setFont(bold ? GuiUtils.LABEL_FONT : new Font("", Font.PLAIN, 18));
        l.setHorizontalAlignment(JLabel.LEFT);
        return l;
    }

    private void clearDisplay() {
        lblRegNo.setText("Registration No: -");
        lblName.setText("Student Name: -");
        lblNic.setText("NIC: -");
        lblPrf.setText("PRF Marks: -");
        lblDbms.setText("DBMS Marks: -");
        lblGpa.setText("Student GPA: -");
    }

    private void onView() {
        String regNo = txtId.getText().trim();
        if (regNo.isEmpty()) {
            GuiUtils.showWarning(this, "Please enter a Student ID.");
            return;
        }

        Student s = sms.getStudentByRegNo(regNo);
        if (s == null) {
            GuiUtils.showWarning(this, "This student does not exist in the system.");
            clearDisplay();
            return;
        }

        lblRegNo.setText("Registration No: " + s.getRegistrationNo());
        lblName.setText(s.getName());
        lblNic.setText(s.getNic());

        lblPrf.setText(formatMark(s.getPrfMarks()));
        lblDbms.setText(formatMark(s.getDbmsMarks()));
        lblGpa.setText(String.format("%.2f", s.calculateGPA()));
    }

    private String formatMark(int mark) {
        if (mark == -1) return "Absent (-1)";
        if (mark == -2) return "Not Conducted (-2)";
        return String.valueOf(mark);
    }
}
