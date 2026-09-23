import javax.swing.*;
class SwingClose {
    public static void main(String[] args) {
        JFrame f0 = new JFrame();
        f0.setVisible(true);
        f0.setSize(300, 300);
        f0.setTitle("Calculator0");
        f0.setLocationRelativeTo(null);
        f0.setDefaultCloseOperation(0);      // 0-DO_NOTHING_ON_CLOSE
                                                        // 1-HIDE_ON_CLOSE 
                                                        // 2-DISPOSE_ON_CLOSE
                                                        // 3-EXIT_ON_CLOSE
        JFrame f1 = new JFrame();
        f1.setVisible(true);
        f1.setSize(300, 300);
        f1.setTitle("Calculator1");
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(1);  

        JFrame f2 = new JFrame();
        f2.setVisible(true);
        f2.setSize(300, 300);
        f2.setTitle("Calculator2");
        f2.setLocationRelativeTo(null);
        f2.setDefaultCloseOperation(2);   

        JFrame f3 = new JFrame();
        f3.setVisible(true);
        f3.setSize(300, 300);
        f3.setTitle("Calculator3");
        f3.setLocationRelativeTo(null);
        f3.setDefaultCloseOperation(3);  
        
        JFrame f4 = new JFrame();
        f4.setVisible(true);
        f4.setSize(300, 300);
        f4.setTitle("Calculator4");
        f4.setLocationRelativeTo(null);
        f4.setDefaultCloseOperation(4);  
    }
}