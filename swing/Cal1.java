import javax.swing.*;
import java.awt.*;

class Cal1 extends JFrame {
    private static final long serialVersionUID = 1L;

    Cal1() {
        setLayout(new BorderLayout());

        JTextField txtDisplay = new JTextField();
        txtDisplay.setFont(new Font("", Font.BOLD, 25));
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        add("North", txtDisplay);

        String[] buttonName = {"7","8","9","*","4","5","6","/","1","2","3","+","0",".","=","-"};
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 4, 4));
        for (String name : buttonName) {
            JButton btn = new JButton(name);
            btn.setFont(new Font("", Font.BOLD, 25));
            buttonPanel.add(btn);
        }
        add("Center", buttonPanel);
    }
}