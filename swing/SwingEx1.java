import javax.swing.*;
import java.awt.*;

class SwingEx1 {
    public static void main(String[] args) {
        JFrame f0 = new JFrame();
        f0.setSize(300, 300);
        f0.setTitle("Window");
        f0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //f0.setLayout(new BorderLayout());

        f0.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton b0 = new JButton("North");
        b0.setText("North");
        b0.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b0, BorderLayout.NORTH);

        JButton b1 = new JButton("South");
        b1.setText("South");
        b1.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b1, BorderLayout.SOUTH);

        JButton b2 = new JButton("East");
        b2.setText("East");
        b2.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b2, BorderLayout.EAST);

        JButton b3 = new JButton("West");
        b3.setText("West");
        b3.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b3, BorderLayout.WEST);

        JButton b4 = new JButton("Center");
        b4.setText("Center");               
        b4.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        f0.add(b4, BorderLayout.CENTER);

        f0.setVisible(true);

    }
}
