import javax.swing.*;
import java.awt.*;

class PageEx2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Form");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());   // outer layout

        JButton btn1 = new JButton("Add Students");
        btn1.setFont(new Font("", Font.BOLD, 25));

        JPanel topPanel = new JPanel();
        topPanel.add(btn1);
        frame.add(topPanel, BorderLayout.NORTH);   // works now

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // inner grid
        formPanel.add(new JLabel("ID Number:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Name:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("PRF Marks:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("DBMS Marks:"));
        formPanel.add(new JTextField());

        frame.add(formPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}