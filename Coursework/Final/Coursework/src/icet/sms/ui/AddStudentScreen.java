package icet.sms.ui;

import icet.sms.model.Batch;
import icet.sms.model.Student;
import icet.sms.model.StudentManagementSystem;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class AddStudentScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    private JTextField txtNic, txtName, txtId;
    private JComboBox<String> cbBatch;
    private JRadioButton rbPhysical, rbOnline;
    private ButtonGroup modeGroup;
    private JButton btnAdd, btnBack;

    public AddStudentScreen(StudentManagementSystem sms) {
        this.sms = sms;
        setTitle("Add New Student");
        setSize(600, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Add New Student"), BorderLayout.NORTH);

        // Center form panel
        JPanel form = new JPanel(new GridLayout(6, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));

        // Batch dropdown
        JLabel lblBatch = new JLabel("Select Batch:");
        lblBatch.setFont(GuiUtils.LABEL_FONT);
        cbBatch = GuiUtils.buildBatchComboBox(sms);
        form.add(lblBatch);
        form.add(cbBatch);

        // Student ID display (auto-generated, read-only)
        JLabel lblId = new JLabel("Registration No (auto):");
        lblId.setFont(GuiUtils.LABEL_FONT);
        txtId = new JTextField(15);
        txtId.setFont(GuiUtils.LABEL_FONT);
        txtId.setEditable(false);
        txtId.setForeground(Color.GRAY);
        txtId.setText("Select batch & mode first");
        form.add(lblId);
        form.add(txtId);

        // NIC
        JLabel lblNic = new JLabel("Student NIC:");
        lblNic.setFont(GuiUtils.LABEL_FONT);
        txtNic = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        form.add(lblNic);
        form.add(txtNic);

        // Name
        JLabel lblName = new JLabel("Student Name:");
        lblName.setFont(GuiUtils.LABEL_FONT);
        txtName = GuiUtils.buildTextField(15, GuiUtils.LABEL_FONT);
        form.add(lblName);
        form.add(txtName);

        // Mode selection
        JLabel lblMode = new JLabel("Lecture Mode:");
        lblMode.setFont(GuiUtils.LABEL_FONT);
        JPanel modePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbPhysical = new JRadioButton("Physical (PR)");
        rbOnline   = new JRadioButton("Online (OR)");
        modeGroup = new ButtonGroup();
        modeGroup.add(rbPhysical);
        modeGroup.add(rbOnline);
        rbPhysical.setFont(GuiUtils.LABEL_FONT);
        rbOnline.setFont(GuiUtils.LABEL_FONT);
        rbPhysical.setSelected(true);
        modePanel.add(rbPhysical);
        modePanel.add(rbOnline);
        form.add(lblMode);
        form.add(modePanel);

        add(form, BorderLayout.CENTER);

        // Bottom buttons
        btnAdd = new JButton("Add Student");
        btnAdd.setFont(GuiUtils.BTN_FONT);
        btnBack = new JButton("Back to Home Page");
        btnBack.setFont(GuiUtils.SMALL_BTN_FONT);

        JPanel btnPanel = new JPanel(new BorderLayout(10, 0));
        btnPanel.add(btnBack, BorderLayout.WEST);
        btnPanel.add(btnAdd, BorderLayout.EAST);
        add(btnPanel, BorderLayout.SOUTH);

        cbBatch.addActionListener(e -> refreshFormState());
        refreshFormState();

        btnAdd.addActionListener(e -> onAdd());
        btnBack.addActionListener(e -> {
            dispose();
            new HomePage().setVisible(true);
        });
    }

    private void refreshFormState() {
        String selected = (String) cbBatch.getSelectedItem();
        if (selected == null || selected.startsWith("--")) {
            txtId.setText("No batches available");
            btnAdd.setEnabled(false);
            return;
        }
        btnAdd.setEnabled(true);
        // ID will be regenerated on Add click with current mode
        txtId.setText("Will be generated on Add");
    }

    private void onAdd() {
        String selected = (String) cbBatch.getSelectedItem();
        if (selected == null || selected.startsWith("--")) {
            GuiUtils.showWarning(this, "No batch selected.");
            return;
        }

        // Extract batch ID from selection like "Batch 100 (ID: 100)"
        int batchId = Integer.parseInt(selected.replaceAll(".*?ID:\\s*(\\d+).*", "$1"));

        Batch b = sms.getBatch(batchId);
        if (b == null) {
            GuiUtils.showWarning(this, "Batch not found.");
            return;
        }

        if (!b.isEnrollmentOpen()) {
            GuiUtils.showWarning(this,
                "ENROLLMENT CLOSED for " + b.getBatchName() +
                "\nCannot add students to this batch.");
            return;
        }

        String nic = txtNic.getText().trim();
        String name = txtName.getText().trim();

        if (nic.isEmpty() || name.isEmpty()) {
            GuiUtils.showWarning(this, "Please enter both NIC and Name.");
            return;
        }

        // Check NIC already exists
        if (sms.studentExistsByNic(nic)) {
            Student existing = sms.getStudentByNic(nic);
            GuiUtils.showWarning(this,
                "This student already exists in the system.\n\n" +
                "Reg No: " + existing.getRegistrationNo() +
                "\nName: " + existing.getName() +
                "\nNIC: " + existing.getNic() +
                "\nPRF: " + existing.getPrfMarks() +
                "\nDBMS: " + existing.getDbmsMarks() +
                "\nGPA: " + String.format("%.2f", existing.calculateGPA()));
            return;
        }

        boolean isPhysical = rbPhysical.isSelected();
        Student added = sms.addStudent(name, nic, -2, -2, batchId, isPhysical);

        if (added != null) {
            GuiUtils.showSuccess(this,
                "Student added successfully!\n\n" +
                "Registration No: " + added.getRegistrationNo());
            // Optionally show the registration number prominently
            txtId.setText(added.getRegistrationNo());
            txtId.setForeground(Color.BLACK);
            // Clear fields for next entry
            txtNic.setText("");
            txtName.setText("");
        } else {
            GuiUtils.showError(this, "Failed to add student. Please try again.");
        }
    }
}
