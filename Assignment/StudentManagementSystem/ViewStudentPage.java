import javax.swing.*;
import java.awt.*;

public class ViewStudentPage extends JPanel {

    private final Main main;
    private final JTextField searchField = Ui.textField(16);
    private final JLabel regValue = valueLabel();
    private final JLabel nameValue = valueLabel();
    private final JLabel nicValue = valueLabel();
    private final JLabel prfValue = valueLabel();
    private final JLabel dbmsValue = valueLabel();
    private final JLabel gpaValue = valueLabel();
    private final JPanel details = new JPanel();

    public ViewStudentPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private JLabel valueLabel() {
        JLabel label = new JLabel("-");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        return label;
    }

    private void buildLayout() {
        JButton searchBtn = Ui.actionButton("SEARCH", this::search);
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        searchRow.setBackground(Ui.BG);
        searchRow.add(Ui.fieldLabel("Enter Student Registration No"));
        searchRow.add(searchField);
        searchRow.add(searchBtn);

        details.setBackground(Ui.PANEL_BG);
        details.setLayout(new GridLayout(6, 2, 12, 12));
        details.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 224, 230)),
                BorderFactory.createEmptyBorder(18, 24, 18, 24)));
        details.add(Ui.fieldLabel("Registration No"));
        details.add(regValue);
        details.add(Ui.fieldLabel("Name"));
        details.add(nameValue);
        details.add(Ui.fieldLabel("NIC"));
        details.add(nicValue);
        details.add(Ui.fieldLabel("PRF Marks"));
        details.add(prfValue);
        details.add(Ui.fieldLabel("DBMS Marks"));
        details.add(dbmsValue);
        details.add(Ui.fieldLabel("GPA"));
        details.add(gpaValue);

        JPanel center = new JPanel();
        center.setBackground(Ui.BG);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(searchRow);
        center.add(Box.createVerticalStrut(18));
        details.setMaximumSize(new Dimension(520, 320));
        center.add(details);

        JPanel page = Ui.page(main, "View Student", "Enter a valid Student ID to view the profile",
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
        Student student = Database.get().findStudentById(id);
        if (student == null) {
            Ui.showError(this, "This student does not exist in the system");
            clear();
            return;
        }
        regValue.setText(student.getRegistrationNo());
        nameValue.setText(student.getName());
        nicValue.setText(student.getNic());
        prfValue.setText(GpaUtil.displayMarks(student.getPrfMarks()));
        dbmsValue.setText(GpaUtil.displayMarks(student.getDbmsMarks()));
        gpaValue.setText(String.valueOf(student.getGpa()));
    }

    private void clear() {
        regValue.setText("-");
        nameValue.setText("-");
        nicValue.setText("-");
        prfValue.setText("-");
        dbmsValue.setText("-");
        gpaValue.setText("-");
    }
}
