import javax.swing.*;
import java.awt.*;

class SearchStudentForm extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtPrfMarks;
    private JTextField txtDbmsMarks;

    private JButton btnAdd;
    private JButton btnCancel;

    SearchStudentForm() {
        setTitle("Search Student Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAdd = new JButton("Search Student");
        btnAdd.setFont(new Font("", Font.BOLD, 20));
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", Font.BOLD, 20));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnCancel);
        add("South", buttonPanel);

        JLabel lblTitle = new JLabel("Search Student Form");
        lblTitle.setFont(new Font("", Font.BOLD, 28));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        add("North", lblTitle);

        txtId = new JTextField(5);
        txtId.setFont(new Font("", Font.BOLD, 20));
        txtName = new JTextField(10);
        txtName.setFont(new Font("", Font.BOLD, 20));
        txtPrfMarks = new JTextField(3);
        txtPrfMarks.setFont(new Font("", Font.BOLD, 20));
        txtDbmsMarks = new JTextField(3);
        txtDbmsMarks.setFont(new Font("", Font.BOLD, 20));

        JLabel lblId = new JLabel("Student ID");
        lblId.setFont(new Font("", Font.BOLD, 20));
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("", Font.BOLD, 20));
        JLabel lblPrfMarks = new JLabel("PRF Marks");
        lblPrfMarks.setFont(new Font("", Font.BOLD, 20));
        JLabel lblDbmsMarks = new JLabel("DBMS Marks");
        lblDbmsMarks.setFont(new Font("", Font.BOLD, 20));

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblPrfMarks);
        panel.add(txtPrfMarks);
        panel.add(lblDbmsMarks);
        panel.add(txtDbmsMarks);
        add("Center", panel);   // <-- changed from West to Center
    }
}

class DemoSearchStud {
    public static void main(String[] args) {
        new SearchStudentForm().setVisible(true);   // <-- fixed class name
    }
}