import javax.swing.*;
import java.awt.*;

public class UpdateStudentPage extends JPanel {

    private final Main main;
    private final JTextField searchField = Ui.textField(16);
    private final JTextField nameField = Ui.textField(18);
    private final JTextField nicField = Ui.textField(18);
    private final JButton updateBtn = Ui.actionButton("UPDATE", this::updateStudent);
    private final JButton updateNewBtn = Ui.actionButton("UPDATE NEW STUDENT", this::resetForm);
    private JButton cancelBtn;
    private Student current;

    public UpdateStudentPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private void buildLayout() {
        updateBtn.setEnabled(false);
        updateNewBtn.setVisible(false);

        JButton searchBtn = Ui.actionButton("SEARCH", this::search);
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        searchRow.setBackground(Ui.BG);
        searchRow.add(Ui.fieldLabel("Enter Student Registration No"));
        searchRow.add(searchField);
        searchRow.add(searchBtn);

        JPanel form = Ui.formPanel(
                searchRow,
                Ui.formRow("Name", nameField),
                Ui.formRow("NIC", nicField)
        );

        cancelBtn = Ui.actionButton("CANCEL", () -> main.showPage(Main.STUDENT_MENU));
        cancelBtn.setBackground(Color.GRAY);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttons.setBackground(Ui.BG);
        buttons.add(cancelBtn);
        buttons.add(updateBtn);
        buttons.add(updateNewBtn);

        JPanel center = new JPanel();
        center.setBackground(Ui.BG);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(form);
        center.add(buttons);

        JPanel page = Ui.page(main, "Update Student", "Search a student to update name or NIC",
                Ui.centered(center), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    private void search() {
        String id = searchField.getText().trim();
        if (id.isEmpty()) {
            Ui.showError(this, "Please enter the Student ID.");
            return;
        }
        current = Database.get().findStudentById(id);
        if (current == null) {
            Ui.showError(this, "This student not exist in the system");
            nameField.setText("");
            nicField.setText("");
            updateBtn.setEnabled(false);
            return;
        }
        nameField.setText(current.getName());
        nicField.setText(current.getNic());
        updateBtn.setEnabled(true);
    }

    private void updateStudent() {
        if (current == null) {
            return;
        }
        String name = nameField.getText().trim();
        String nic = nicField.getText().trim();
        if (name.isEmpty() || nic.isEmpty()) {
            Ui.showError(this, "Please enter the student name and NIC.");
            return;
        }
        if (!nic.equalsIgnoreCase(current.getNic())) {
            Student existing = Database.get().findStudentByNic(nic);
            if (existing != null && existing != current) {
                Ui.showError(this, "This NIC already exists in the system.");
                return;
            }
        }
        current.setName(name);
        current.setNic(nic);
        Ui.showInfo(this, current.getRegistrationNo() + " Details Successfully Updated!");
        updateBtn.setEnabled(false);
        cancelBtn.setVisible(false);
        updateBtn.setVisible(false);
        updateNewBtn.setVisible(true);
    }

    private void resetForm() {
        current = null;
        searchField.setText("");
        nameField.setText("");
        nicField.setText("");
        updateBtn.setEnabled(false);
        updateBtn.setVisible(true);
        cancelBtn.setVisible(true);
        updateNewBtn.setVisible(false);
    }
}
