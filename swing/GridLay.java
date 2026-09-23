import javax.swing.*;
import java.awt.*;

class GridLay {
    public static void main(String[] args) {
        JFrame f0 = new JFrame();
        f0.setSize(300, 300);
        f0.setTitle("Window");
        f0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f0.setLayout(new GridLayout(3, 4));   

        JButton b0 = new JButton("North");
        b0.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b0);

        JButton b1 = new JButton("South");
        b1.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b1);

        JButton b2 = new JButton("East");
        b2.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b2);

        JButton b3 = new JButton("West");
        b3.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b3);

        JButton b4 = new JButton("Center");
        b4.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b4);

        f0.setVisible(true);
    }
}