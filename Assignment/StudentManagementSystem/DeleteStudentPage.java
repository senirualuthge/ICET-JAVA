import javax.swing.*;
import java.awt.*;

public class DeleteStudentPage extends JPanel {

    private final Main main;
    private final JTextField searchField = Ui.textField(16);
    private final JLabel infoLabel = new JLabel(" ");
    private final JButton deleteBtn = Ui.actionButton("DELETE", this::deleteStudent);
    private Student current;

    public DeleteStudentPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private void buildLayout() {
        deleteBtn.setEnabled(false);
        infoLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        infoLabel.setForeground(Ui.PRIMARY);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton searchBtn = Ui.actionButton("SEARCH", this::search);
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        searchRow.setBackground(Ui.BG);
        searchRow.add(Ui.fieldLabel("Enter Student Registration No"));
        searchRow.add(searchField);
        searchRow.add(searchBtn);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttons.setBackground(Ui.BG);
        buttons.add(deleteBtn);

        JPanel center = new JPanel();
        center.setBackground(Ui.BG);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(searchRow);
        center.add(Box.createVerticalStrut(16));
        center.add(infoLabel);
        center.add(Box.createVerticalStrut(8));
        center.add(buttons);

        JPanel page = Ui.page(main, "Delete Student", "Search a student to delete from the system",
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
            Ui.showError(this, "This student does not exist in the system");
            infoLabel.setText(" ");
            deleteBtn.setEnabled(false);
            return;
        }
        infoLabel.setText("<html><div style='text-align:center'>"
                + current.getRegistrationNo() + "<br>"
                + current.getName() + " — " + current.getNic() + "<br>"
                + "PRF: " + GpaUtil.displayMarks(current.getPrfMarks())
                + " | DBMS: " + GpaUtil.displayMarks(current.getDbmsMarks())
                + " | GPA: " + GpaUtil.formatGpa(current.getGpa())
                + "</div></html>");
        deleteBtn.setEnabled(true);
    }

    private void deleteStudent() {
        if (current == null) {
            return;
        }
        String registrationNo = current.getRegistrationNo();
        Database.get().removeStudent(current);
        current = null;
        infoLabel.setText(" ");
        deleteBtn.setEnabled(false);
        searchField.setText("");
        Ui.showInfo(this, registrationNo + " deleted successfully!");
    }
}
