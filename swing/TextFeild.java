import javax.swing.*;
import java.awt.*;

class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setEditable(true);
        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}