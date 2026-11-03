import javax.swing.*;
import java.awt.*;

/**
 * AppStructure - a reusable skeleton for any JFrame + JTextField + JButton app.
 *
 * STRUCTURE
 *   1. FIELDS   -> every component is declared once, at the top
 *   2. CONSTRUCTOR -> builds the window, then connects the buttons
 *   3. buildUI()  -> ONLY layout (what goes where)
 *   4. wireEvents() -> ONLY behaviour (what happens on click)
 *   5. main()     -> starts the app on the Event Dispatch Thread
 *
 * To reuse: rename the class, add/remove fields, and change the
 * inside of the button listeners. Never mix layout and logic.
 */
public class AppStructure extends JFrame {

    private static final long serialVersionUID = 1L;

    // ---------- 1. FIELDS (components) ----------
    private final JTextField txtInput = new JTextField(15);
    private final JButton btnSubmit = new JButton("Submit");
    private final JButton btnClear = new JButton("Clear");
    private final JLabel lblOutput = new JLabel("Nothing submitted yet.");
    private final JLabel lblCount = new JLabel("Characters: 0");

    // ---------- 2. CONSTRUCTOR ----------
    public AppStructure() {
        super("App Structure");
        buildUI();
        wireEvents();
    }

    // ---------- 3. LAYOUT ----------
    private void buildUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 200);
        setLocationRelativeTo(null);          // centre on screen
        setLayout(new BorderLayout(10, 10));

        // North: where the user types
        JPanel inputRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        inputRow.add(new JLabel("Input:"));
        inputRow.add(txtInput);
        add(inputRow, BorderLayout.NORTH);

        // Center: results
        JPanel outputArea = new JPanel(new GridLayout(2, 1, 4, 4));
        outputArea.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
        outputArea.add(lblOutput);
        outputArea.add(lblCount);
        add(outputArea, BorderLayout.CENTER);

        // South: actions
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        buttonRow.add(btnSubmit);
        buttonRow.add(btnClear);
        add(buttonRow, BorderLayout.SOUTH);
    }

    // ---------- 4. BEHAVIOUR ----------
    private void wireEvents() {
        btnSubmit.addActionListener(e -> handleSubmit());
        btnClear.addActionListener(e -> handleClear());

        // Enter key in the text field also submits
        txtInput.addActionListener(e -> handleSubmit());
    }

    private void handleSubmit() {
        String text = txtInput.getText().trim();

        if (text.isEmpty()) {
            lblOutput.setText("Please type something first.");
            lblCount.setText("Characters: 0");
            return;
        }

        lblOutput.setText("You typed: " + text);
        lblCount.setText("Characters: " + text.length());
    }

    private void handleClear() {
        txtInput.setText("");
        lblOutput.setText("Nothing submitted yet.");
        lblCount.setText("Characters: 0");
        txtInput.requestFocus();              // cursor back in the field
    }

    // ---------- 5. START ----------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppStructure().setVisible(true));
    }
}
