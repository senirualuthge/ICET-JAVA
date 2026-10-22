import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * =====================================================================
 * OOP CONCEPT MAP  (where OOP is used in this file)
 * =====================================================================
 * This program is written in a mostly PROCEDURAL style: every member is
 * `static`, so the class is used like a container of functions rather than
 * as an object that owns instance state. The OOP concepts it DOES use are
 * marked inline with [OOP: ...] tags:
 *
 *   Abstraction      - the TaskEx1 class groups related data + behaviour, and
 *                      behaviour is hidden behind named methods.
 *   Encapsulation    - Swing components keep their fields private and are driven
 *                      only through public setter/getter methods (setText, ...).
 *   Composition      - "has-a": TaskEx1 holds JFrame/JPanel/JLabel/Timer objects.
 *   Inheritance      - the Swing classes used here form an inheritance tree
 *                      (JButton -> AbstractButton -> JComponent -> Container ->
 *                      Component -> Object); their inherited methods (add, setSize,
 *                      setVisible, ...) are reused here.
 *   Polymorphism     - the lambdas passed to addActionListener are ActionListener
 *                      objects; the button only knows the interface, so any
 *                      implementation can be plugged in.
 *   Instantiation    - `new JFrame(...)`, `new Timer(...)` create objects.
 *
 * NOT used here (worth noting): no custom inheritance (`extends`), no
 * user-defined interfaces, no instance fields and no constructor -- so this
 * class does not demonstrate classic object-based encapsulation on its own.
 * =====================================================================
 */
class TaskEg1 {   // [OOP: Abstraction] a class = blueprint for data + behaviour

    // Water level that triggers the alert system
    static final int ALERT_LEVEL = 75;   // [OOP: Encapsulation] a named constant replaces a magic number

    static final Random RANDOM = new Random();   // [OOP: Instantiation + Composition] reusable helper object (has-a)

    // UI components
    // [OOP: Composition] TaskEx1 "has-a" set of Swing objects; their internal state
    // stays private and is changed only via methods such as setText()/setValue().
    static final JLabel levelLabel = new JLabel("100 %", SwingConstants.CENTER);            // [OOP: Instantiation] `new` builds an object
    static final JProgressBar levelBar = new JProgressBar(0, 100);                        // [OOP: Inheritance] JProgressBar comes from the Swing hierarchy
    static final JLabel alarmLabel = new JLabel("ALARM : OFF", SwingConstants.CENTER);
    static final JLabel splitterLabel = new JLabel("SPLITTER : CLOSED", SwingConstants.CENTER);
    static final JTextArea smsArea = new JTextArea(12, 40);
    static final Timer autoTimer;   // [OOP: Composition] field typed as the javax.swing.Timer class
    static int waterLevel = 0;

    static {
        // [OOP note] A static initializer runs once when the class is loaded.
        // The lambda `e -> randomizeWaterLevel()` is an OBJECT that implements the
        // ActionListener interface; see [OOP: Polymorphism] below.
        // continuous randomisation, 1.5 seconds per update
        autoTimer = new Timer(1000, e -> randomizeWaterLevel());   // [OOP: Polymorphism] lambda implements ActionListener
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Water Level Monitor");   // [OOP: Instantiation + Composition] the window is an object TaskEx1 uses
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // [OOP: Encapsulation] change state via a public setter, not a field; JFrame.EXIT_ON_CLOSE is an inherited constant
        frame.setLayout(new BorderLayout(10, 10));

        // ---------- top : current level ----------
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));   // [OOP: Composition] a container object holding other objects
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        levelLabel.setFont(new Font("SansSerif", Font.BOLD, 36));   // [OOP: Encapsulation] setFont() is a public method that hides the component's internals
        levelBar.setStringPainted(true);
        levelBar.setFont(new Font("SansSerif", Font.BOLD, 14));

        topPanel.add(levelLabel, BorderLayout.NORTH);   // [OOP: Inheritance] add(...) is inherited from java.awt.Container
        topPanel.add(levelBar, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);

        // ---------- center : status + sms ----------
        JPanel statusPanel = new JPanel(new GridLayout(1, 2, 10, 10));   // [OOP: Composition]
        statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        alarmLabel.setOpaque(true);   // [OOP: Encapsulation] every change goes through a public method
        alarmLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        splitterLabel.setOpaque(true);
        splitterLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        statusPanel.add(alarmLabel);
        statusPanel.add(splitterLabel);
        frame.add(statusPanel, BorderLayout.CENTER);

        // ---------- bottom : buttons + sms log ----------
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));   // [OOP: Composition]
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));   // [OOP: Composition] FlowLayout.CENTER is an inherited constant

        JButton randomButton = new JButton("Randomize Water Level");   // [OOP: Instantiation]
        randomButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        // [OOP: Polymorphism] the lambda IS-A ActionListener (interface implementation);
        // the button stores it as the interface type and calls actionPerformed() at runtime.
        randomButton.addActionListener(e -> randomizeWaterLevel());

        JCheckBox autoBox = new JCheckBox("Auto Randomize");
        autoBox.setFont(new Font("SansSerif", Font.BOLD, 14));
        autoBox.addActionListener(e -> {   // [OOP: Polymorphism] another ActionListener implementation plugged into the same interface
            if (autoBox.isSelected()) {
                autoTimer.start();
            } else {
                autoTimer.stop();
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        resetButton.addActionListener(e -> {   // [OOP: Polymorphism] third swap-in ActionListener
            autoBox.setSelected(false);
            autoTimer.stop();
            waterLevel = 0;
            applyLevel();
        });

        buttonPanel.add(randomButton);
        buttonPanel.add(autoBox);
        buttonPanel.add(resetButton);

        smsArea.setEditable(false);
        smsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(smsArea);   // [OOP: Composition] wraps (decorates) another component object
        scrollPane.setBorder(BorderFactory.createTitledBorder("SMS Log"));

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        applyLevel();

        frame.setSize(650, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Creates a new random water level and updates the whole system. */
    // [OOP: Abstraction] behaviour is packaged into a named method that hides the "how".
    static void randomizeWaterLevel() {
        waterLevel = RANDOM.nextInt(101); // 0 - 100
        applyLevel();
    }

    /** Updates the level, then the alarm, splitter and SMS based on that level. */
    // [OOP: Abstraction / Encapsulation] callers only say applyLevel(); the update
    // details (labels, colours, SMS) stay hidden inside this method.
    static void applyLevel() {
        boolean alert = waterLevel >= ALERT_LEVEL;

        levelBar.setValue(waterLevel);
        levelLabel.setText(waterLevel + " mm");

        // alarm : ON when 75 or above, OFF when below
        if (alert) {
            alarmLabel.setText("ALARM : ON");
            alarmLabel.setBackground(Color.RED);
            alarmLabel.setForeground(Color.WHITE);
            levelBar.setForeground(Color.RED);
        } else {
            alarmLabel.setText("ALARM : OFF");
            alarmLabel.setBackground(new Color(220, 220, 220));
            alarmLabel.setForeground(Color.DARK_GRAY);
            levelBar.setForeground(new Color(0, 130, 0));
        }

        // splitter : OPEN when the level reaches 75, CLOSED when it does not
        if (alert) {
            splitterLabel.setText("SPLITTER : OPEN");
            splitterLabel.setBackground(new Color(0, 130, 0));
            splitterLabel.setForeground(Color.WHITE);
        } else {
            splitterLabel.setText("SPLITTER : CLOSED");
            splitterLabel.setBackground(new Color(220, 220, 220));
            splitterLabel.setForeground(Color.DARK_GRAY);
        }

        sendSms(alert);
    }

    /** Sends (logs) an SMS every time the water level updates. */
    // [OOP: Abstraction] a private-ish helper method: callers ask for the effect, not the steps.
    static void sendSms(boolean alert) {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String message = "Water level updated to " + waterLevel + "mm"
                + " | Alarm: " + (alert ? "ON" : "OFF")
                + " | Splitter: " + (alert ? "OPEN" : "CLOSED");

        System.out.println("[SMS " + time + "] " + message);
        smsArea.append("[SMS " + time + "] " + message + "\n");
        smsArea.setCaretPosition(smsArea.getDocument().getLength());
    }
}
