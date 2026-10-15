import javax.swing.*;
import java.awt.*;

public abstract class UpdateMarksPage extends JPanel {

    protected final Main main;
    protected final JTextField searchField = Ui.textField(16);
    protected final JLabel nameValue = valueLabel();
    protected final JLabel nicValue = valueLabel();
    protected final JLabel marksValue = valueLabel();
    protected final JTextField marksField = Ui.textField(8);
    protected final JButton updateBtn;
    protected Student current;
    private final String subject;
    private final JButton updateNewBtn;
    private JButton cancelBtn;

    protected UpdateMarksPage(Main main, String subject) {
        this.main = main;
        this.subject = subject;
        this.updateBtn = Ui.actionButton("UPDATE", this::updateMarks);
        this.updateNewBtn = Ui.actionButton("UPDATE NEW STUDENT", this::resetForm);
        buildLayout();
    }

    private JLabel valueLabel() {
        JLabel label = new JLabel("-");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        return label;
    }

    protected abstract int getMarks(Student student);

    protected abstract void setMarks(Student student, int marks);

    private void buildLayout() {
        updateBtn.setEnabled(false);
        updateNewBtn.setVisible(false);
        marksField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        JButton searchBtn = Ui.actionButton("SEARCH", this::search);
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        searchRow.setBackground(Ui.BG);
        searchRow.add(Ui.fieldLabel("Enter Student Registration No"));
        searchRow.add(searchField);
        searchRow.add(searchBtn);

        JPanel form = Ui.formPanel(
                searchRow,
                Ui.formRow("Name", nameValue),
                Ui.formRow("NIC", nicValue),
                Ui.formRow(subject + " Marks", marksValue),
                Ui.formRow("Enter New " + subject + " Marks", marksField)
        );

        JLabel hint = Ui.subTitleLabel("Enter -1 for absent, or a mark between 0 and 100.");
        hint.setHorizontalAlignment(SwingConstants.LEFT);

        cancelBtn = Ui.actionButton("CANCEL", () -> main.showPage(Main.GRADE_MENU));
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
        center.add(hint);
        center.add(Box.createVerticalStrut(8));
        center.add(buttons);

        JPanel page = Ui.page(main, subject + " Marks Update",
                "Search a student to update " + subject + " marks",
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
            clearStudent();
            return;
        }
        showStudent();
        updateBtn.setEnabled(true);
    }

    private void showStudent() {
        nameValue.setText(current.getName());
        nicValue.setText(current.getNic());
        marksValue.setText(GpaUtil.displayMarks(getMarks(current)));
    }

    private void clearStudent() {
        nameValue.setText("-");
        nicValue.setText("-");
        marksValue.setText("-");
        marksField.setText("");
        updateBtn.setEnabled(false);
    }

    private void updateMarks() {
        if (current == null) {
            return;
        }
        String text = marksField.getText().trim();
        int marks;
        try {
            marks = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Ui.showError(this, "Invalid marks! Marks must be -1 (absent) or a whole number between 0 and 100.");
            return;
        }
        if (marks != Student.MARK_ABSENT && (marks < 0 || marks > 100)) {
            Ui.showError(this, "Invalid marks! Marks must be -1 (absent) or a value between 0 and 100.");
            return;
        }
        setMarks(current, marks);
        showStudent();
        marksField.setText("");
        Ui.showInfo(this, current.getRegistrationNo() + " Student's " + subject
                + " Marks Successfully Updated!");
        updateBtn.setEnabled(false);
        cancelBtn.setVisible(false);
        updateBtn.setVisible(false);
        updateNewBtn.setVisible(true);
    }

    private void resetForm() {
        current = null;
        searchField.setText("");
        clearStudent();
        updateBtn.setVisible(true);
        cancelBtn.setVisible(true);
        updateNewBtn.setVisible(false);
    }
}
