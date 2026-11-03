import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Demo3Frame extends JFrame implements ActionListener {
    JTextField txtTitle;
    JButton btnSetTitle;

    Demo3Frame() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        txtTitle = new JTextField(10);
        txtTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(txtTitle);

        btnSetTitle = new JButton("Set Title");
        btnSetTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        btnSetTitle.addActionListener(this);
        add(btnSetTitle);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        setTitle(txtTitle.getText());
    }
}

// Named EventDemo3 because OOP/Demo3.java already declares Demo3 in the default package.
class EventDemo3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Demo3Frame().setVisible(true));
    }
}