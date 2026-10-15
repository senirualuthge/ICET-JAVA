import javax.swing.*;
import java.awt.*;

public class AddStudentPage extends JPanel implements Refreshable {

    private final Main main;
    private final JComboBox<Batch> batchCombo = new JComboBox<>();
    private final JTextField nicField = Ui.textField(18);
    private final JTextField nameField = Ui.textField(18);
    private final JComboBox<String> modeCombo = new JComboBox<>(new String[]{"Physical", "Online"});
    private final JLabel resultLabel = new JLabel(" ");

    public AddStudentPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private void buildLayout() {
        batchCombo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        modeCombo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        batchCombo.setPreferredSize(new Dimension(200, 30));
        modeCombo.setPreferredSize(new Dimension(200, 30));

        JButton addBtn = Ui.actionButton("ADD STUDENT", this::addStudent);
        JButton cancelBtn = Ui.actionButton("CANCEL", () -> main.showPage(Main.STUDENT_MENU));
        cancelBtn.setBackground(Color.GRAY);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttons.setBackground(Ui.BG);
        buttons.add(cancelBtn);
        buttons.add(addBtn);

        resultLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        resultLabel.setForeground(new Color(0, 130, 60));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel form = Ui.formPanel(
                Ui.formRow("Batch Number", batchCombo),
                Ui.formRow("NIC", nicField),
                Ui.formRow("Name", nameField),
                Ui.formRow("Lecturer Mode", modeCombo)
        );

        JPanel center = new JPanel();
        center.setBackground(Ui.BG);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(form);
        center.add(buttons);
        center.add(Box.createVerticalStrut(10));
        center.add(resultLabel);

        JPanel page = Ui.page(main, "Add Student", "Select a batch and enter the student details",
                Ui.centered(center), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    private void refreshBatches() {
        Batch selected = (Batch) batchCombo.getSelectedItem();
        batchCombo.removeAllItems();
        for (Batch batch : Database.get().getBatches()) {
            batchCombo.addItem(batch);
        }
        if (selected != null) {
            for (Batch batch : Database.get().getBatches()) {
                if (batch.getBatchNumber() == selected.getBatchNumber()) {
                    batchCombo.setSelectedItem(batch);
                    break;
                }
            }
        }
        if (batchCombo.getItemCount() > 0 && batchCombo.getSelectedIndex() < 0) {
            batchCombo.setSelectedIndex(0);
        }
    }

    @Override
    public void refresh() {
        refreshBatches();
    }

    private void addStudent() {
        refreshBatches();
        Batch batch = (Batch) batchCombo.getSelectedItem();
        if (batch == null) {
            Ui.showError(this, "No batches available. Please add a batch first.");
            return;
        }
        if (!batch.isOpen()) {
            Ui.showError(this, "Student can not be added to this batch because enrollment is closed!");
            return;
        }
        String nic = nicField.getText().trim();
        String name = nameField.getText().trim();
        if (nic.isEmpty() || name.isEmpty()) {
            Ui.showError(this, "Please enter the student NIC and name.");
            return;
        }
        if (Database.get().nicExists(nic)) {
            Student existing = Database.get().findStudentByNic(nic);
            Ui.showError(this, "This student is already added to the system!\n\n"
                    + "Registration No: " + existing.getRegistrationNo()
                    + "\nName: " + existing.getName()
                    + "\nNIC: " + existing.getNic());
            return;
        }
        boolean physical = modeCombo.getSelectedIndex() == 0;
        String registrationNo = Database.get().generateStudentId(batch, physical);
        Student student = new Student(registrationNo, nic, name, batch.getBatchNumber(), physical);
        Database.get().addStudent(student);
        resultLabel.setText(registrationNo + " — Student added successfully");
        nicField.setText("");
        nameField.setText("");
        Ui.showInfo(this, "Student added successfully!\n\nRegistration No: " + registrationNo);
    }
}
