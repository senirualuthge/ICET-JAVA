import javax.swing.*;
import java.awt.*;

class SwingFont {
    public static void main(String[] args) {
        JFrame f0 = new JFrame();
        f0.setSize(300, 300);
        f0.setTitle("Calculator0");
        f0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f0.setLayout(new FlowLayout());

        JButton b0 = new JButton();
        b0.setText("Close");
        b0.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b0);

        JButton b1 = new JButton();
        b1.setText("Cancle");
        b1.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b1);

        f0.setVisible(true); // call this last, after adding components

    }
}