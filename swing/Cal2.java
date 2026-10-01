import javax.swing.*;
import java.awt.*;

class Cal2Frame extends JFrame{
    private static final long serialVersionUID = 1L;

    JTextField txtDisplay;
    Cal2Frame() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);

        txtDisplay = new JTextField();
        txtDisplay.setFont(new Font("Arial", Font.BOLD, 28));
        add("North", txtDisplay);

    }    
}
class Cal2{
    public static void main(String args []){
        Cal2Frame c2 = new Cal2Frame();
        c2.setVisible(true);
    

        // ---- Button panel ----
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5)); // 4 rows, 4 cols, gaps

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(btn);
        }

        c2.add(panel, BorderLayout.CENTER);
    }
}
     