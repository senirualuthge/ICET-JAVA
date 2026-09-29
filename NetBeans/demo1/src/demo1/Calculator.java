/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package demo1;

/**
 *
 * @author cs
 */
public class Calculator extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Calculator.class.getName());

    /**
     * The operator the user has entered but not yet applied, e.g. the "+" in 7 + ...
     * Null when there is nothing pending.
     */
    private String pendingOperator;

    /**
     * The left-hand side held while pendingOperator is outstanding.
     */
    private double storedValue;

    /**
     * True when the next digit starts a new number rather than appending to the display.
     */
    private boolean awaitingOperand = true;

    /**
     * Creates new form Calculator
     */
    public Calculator() {
        initComponents();
        wireButtons();
        clear();
    }

    /**
     * Attaches one shared listener to every key. Dispatching on the button's own
     * label keeps this to a single handler instead of sixteen near-identical ones.
     */
    private void wireButtons() {
        javax.swing.JButton[] keys = {
            jButton1, jButton2, jButton3, jButton4,
            jButton5, jButton6, jButton7, jButton8,
            jButton9, jButton10, jButton11, jButton12,
            jButton13, jButton14, jButton15, jButton16
        };
        for (javax.swing.JButton key : keys) {
            key.addActionListener(e -> press(key.getText()));
        }
    }

    private void press(String key) {
        if ("C".equals(key)) {
            clear();
        } else if ("=".equals(key)) {
            equals();
        } else if (isOperator(key)) {
            operator(key);
        } else {
            digit(key);
        }
    }

    private static boolean isOperator(String key) {
        return "+".equals(key) || "-".equals(key) || "*".equals(key) || "/".equals(key);
    }

    /**
     * Appends a digit or decimal point, honouring the awaitingOperand reset.
     */
    private void digit(String key) {
        String text = txtDisplay.getText();
        if (awaitingOperand || "0".equals(text)) {
            txtDisplay.setText(".".equals(key) ? "0." : key);
            awaitingOperand = false;
            return;
        }
        // A second decimal point in the same number is ignored rather than throwing.
        if (".".equals(key) && text.contains(".")) {
            return;
        }
        txtDisplay.setText(text + key);
    }

    /**
     * Stores the left-hand side and holds the operator. Chaining operators
     * ("7 + 2 *") applies the pending one first, so the arithmetic follows
     * left-to-right rather than erroring out.
     */
    private void operator(String key) {
        if (pendingOperator != null && !awaitingOperand) {
            if (!applyPending()) {
                return;
            }
        } else {
            storedValue = readDisplay();
        }
        pendingOperator = key;
        awaitingOperand = true;
    }

    private void equals() {
        if (pendingOperator == null || awaitingOperand) {
            return;
        }
        if (applyPending()) {
            pendingOperator = null;
        }
    }

    /**
     * Applies pendingOperator to the current display value, writing the result back.
     * Returns false if the input was invalid, in which case the display is reset
     * and the calculator returns to a usable state.
     */
    private boolean applyPending() {
        double rhs = readDisplay();
        double result;
        switch (pendingOperator) {
            case "+" -> result = storedValue + rhs;
            case "-" -> result = storedValue - rhs;
            case "*" -> result = storedValue * rhs;
            case "/" -> {
                if (rhs == 0) {
                    showError();
                    return false;
                }
                result = storedValue / rhs;
            }
            default -> {
                showError();
                return false;
            }
        }
        storedValue = result;
        txtDisplay.setText(format(result));
        awaitingOperand = true;
        return true;
    }

    /**
     * Resets the pending calculation and shows Error. The display is set last so it
     * survives: clear() would otherwise immediately overwrite it with 0.
     */
    private void showError() {
        pendingOperator = null;
        storedValue = 0;
        awaitingOperand = true;
        txtDisplay.setText("Error");
    }

    private void clear() {
        txtDisplay.setText("0");
        pendingOperator = null;
        storedValue = 0;
        awaitingOperand = true;
    }

    private double readDisplay() {
        try {
            return Double.parseDouble(txtDisplay.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Drops a trailing ".0" on whole results so 4 / 2 reads as "2", not "2.0".
     * Non-finite results (overflow) are shown as an error rather than NaN.
     */
    private static String format(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return "Error";
        }
        if (value == Math.rint(value) && Math.abs(value) < 1e15) {
            return Long.toString((long) value);
        }
        String text = Double.toString(value);
        if (text.endsWith(".0")) {
            text = text.substring(0, text.length() - 2);
        }
        return text;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDisplay = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");

        txtDisplay.setEditable(false);
        txtDisplay.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 28));
        txtDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton1.setText("7");
        jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton2.setText("8");
        jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton3.setText("9");
        jButton3.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton4.setText("/");
        jButton4.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton5.setText("4");
        jButton5.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton6.setText("5");
        jButton6.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton7.setText("6");
        jButton7.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton8.setText("*");
        jButton8.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton9.setText("1");
        jButton9.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton10.setText("2");
        jButton10.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton11.setText("3");
        jButton11.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton12.setText("-");
        jButton12.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton13.setText("C");
        jButton13.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton14.setText("0");
        jButton14.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton15.setText(".");
        jButton15.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        jButton16.setText("=");
        jButton16.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDisplay, 0, 300, 32767))
                .addGap(8, 8, 32767)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton5, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton9, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton13, 0, 32767, 32767)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton6, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton10, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton14, 0, 32767, 32767)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton7, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton11, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton15, 0, 32767, 32767)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton8, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton12, 0, 32767, 32767)
                        .addGap(5, 5, 32767)
                        .addComponent(jButton16, 0, 32767, 32767)
                    )
                )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(8, 8, 32767)
                    .addComponent(txtDisplay, 0, 45, 32767)
                    .addGap(5, 5, 32767)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton2, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton3, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton4, 0, 55, 32767)
                        )
                        .addGap(5, 5, 32767)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton5, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton6, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton7, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton8, 0, 55, 32767)
                        )
                        .addGap(5, 5, 32767)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton9, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton10, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton11, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton12, 0, 55, 32767)
                        )
                        .addGap(5, 5, 32767)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton13, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton14, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton15, 0, 55, 32767)
                            .addGap(5, 5, 32767)
                            .addComponent(jButton16, 0, 55, 32767)
                        )
                    )
                    .addGap(8, 8, 32767))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Calculator().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txtDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    // End of variables declaration//GEN-END:variables
}
