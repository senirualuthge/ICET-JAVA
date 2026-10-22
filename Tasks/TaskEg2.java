import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * =====================================================================
 * SAME LOGIC AS TaskEg1, DIFFERENT VISUAL
 * =====================================================================
 * TaskEg1 showed the water level with a horizontal JProgressBar.
 * This file keeps exactly the same behaviour (random level -> alarm ->
 * splitter -> SMS log) but shows the level inside a VERTICAL WATER TANK
 * that fills from the bottom, with a moving water surface.
 *
 * There is NO image file, NO GIF and NO third-party library here. The tank
 * is purely "virtual": it is drawn with Java 2D shapes every time Swing asks
 * the component to repaint itself. See the big comment above WaterTank for
 * the step-by-step drawing pipeline.
 *
 * OOP CONCEPT MAP  (where OOP is used in this file)
 * =====================================================================
 *   Custom drawing   - WaterTank extends JPanel and overrides
 *                      paintComponent(), so the "tank" is a real object
 *                      instead of a ready-made Swing component.
 *   Inheritance      - WaterTank IS-A JPanel; the drawing hook
 *                      paintComponent() is inherited and overridden.
 *   Encapsulation    - WaterTank keeps its level/colour state private and
 *                      exposes only setLevel(); callers cannot corrupt it.
 *   Polymorphism     - lambdas are ActionListener objects; Swing's Timer
 *                      calls actionPerformed() on the interface type.
 *   Composition      - TaskEg2 holds the frame, tank, labels, timer.
 *   Abstraction      - applyLevel() hides the whole "change tank + alarm +
 *                      splitter + SMS" sequence behind one method call.
 *
 * NOT used here (worth noting): no user-defined interface, no custom
 * exception, no instance fields in TaskEg2 itself -- like TaskEg1 it is
 * written in a mostly procedural style with `static` members.
 * =====================================================================
 */
class TaskEg2 {   // [OOP: Abstraction] a class = blueprint for data + behaviour

    // Water level that triggers the alert system
    static final int ALERT_LEVEL = 75;   // [OOP: Encapsulation] a named constant replaces a magic number

    static final Random RANDOM = new Random();   // [OOP: Instantiation + Composition] reusable helper object (has-a)

    // UI components
    // [OOP: Composition] TaskEg2 "has-a" set of Swing objects; their internal
    // state stays private and is changed only via methods such as setText().
    static final JLabel levelLabel = new JLabel("0 mm", SwingConstants.CENTER);   // [OOP: Instantiation] `new` builds an object
    static final WaterTank tank = new WaterTank();                              // [OOP: Instantiation] our own component replaces JProgressBar
    static final JLabel alarmLabel = new JLabel("ALARM : OFF", SwingConstants.CENTER);
    static final JLabel splitterLabel = new JLabel("SPLITTER : CLOSED", SwingConstants.CENTER);
    static final JTextArea smsArea = new JTextArea(10, 40);
    static final Timer autoTimer;   // [OOP: Composition] field typed as the javax.swing.Timer class
    static int waterLevel = 0;

    static {
        // [OOP note] A static initializer runs once when the class is loaded.
        // The lambda `e -> randomizeWaterLevel()` is an OBJECT that implements
        // the ActionListener interface; see [OOP: Polymorphism] below.
        // continuous randomisation, 1 second per update
        autoTimer = new Timer(1000, e -> randomizeWaterLevel());   // [OOP: Polymorphism] lambda implements ActionListener
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Water Level Monitor - Vertical Tank");   // [OOP: Instantiation + Composition] the window is an object TaskEg2 uses
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // [OOP: Encapsulation] change state via a public setter, not a field
        frame.setLayout(new BorderLayout(10, 10));

        // ---------- top : numeric level ----------
        levelLabel.setFont(new Font("SansSerif", Font.BOLD, 34));   // [OOP: Encapsulation] setFont() hides the component's internals
        levelLabel.setBorder(BorderFactory.createEmptyBorder(12, 10, 0, 10));
        frame.add(levelLabel, BorderLayout.NORTH);   // [OOP: Inheritance] add(...) is inherited from java.awt.Container

        // ---------- center : vertical tank + status ----------
        JPanel centerPanel = new JPanel(new BorderLayout(12, 12));   // [OOP: Composition] a container object holding other objects
        centerPanel.setBorder(BorderFactory.createEmptyBorder(6, 14, 0, 14));

        // [OOP: Composition] the tank is just another component placed in the
        // layout; the layout manager decides its final width and height.
        centerPanel.add(tank, BorderLayout.CENTER);

        // status column: a vertical stack (BoxLayout) instead of a grid, so the
        // two status tiles read top-to-bottom next to the tall tank.
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));   // [OOP: Composition]
        statusPanel.setPreferredSize(new Dimension(240, 0));

        JLabel infoLabel = new JLabel("ALERT LEVEL : " + ALERT_LEVEL + " mm", SwingConstants.CENTER);
        infoLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        infoLabel.setForeground(Color.DARK_GRAY);
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);   // [OOP: Inheritance] constants inherited from Component
        infoLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));

        alarmLabel.setOpaque(true);   // [OOP: Encapsulation] every visual change goes through a public method
        alarmLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        alarmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        alarmLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        alarmLabel.setPreferredSize(new Dimension(240, 70));

        splitterLabel.setOpaque(true);
        splitterLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        splitterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        splitterLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        splitterLabel.setPreferredSize(new Dimension(240, 70));

        statusPanel.add(javax.swing.Box.createVerticalStrut(20));   // spacer objects, not magic pixel offsets in code
        statusPanel.add(infoLabel);
        statusPanel.add(javax.swing.Box.createVerticalStrut(16));
        statusPanel.add(alarmLabel);
        statusPanel.add(javax.swing.Box.createVerticalStrut(14));
        statusPanel.add(splitterLabel);
        statusPanel.add(javax.swing.Box.createVerticalGlue());   // pushes everything above to the top

        centerPanel.add(statusPanel, BorderLayout.EAST);
        frame.add(centerPanel, BorderLayout.CENTER);

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

        // First paint: level 0, no alarm, empty tank.
        applyLevel();

        frame.setSize(760, 780);
        frame.setMinimumSize(new Dimension(640, 700));
        frame.setLocationRelativeTo(null);   // centre on screen
        frame.setVisible(true);              // [OOP: Encapsulation] inherited Component method
    }

    /** Creates a new random water level and updates the whole system. */
    // [OOP: Abstraction] behaviour is packaged into a named method that hides the "how".
    static void randomizeWaterLevel() {
        waterLevel = RANDOM.nextInt(101); // 0 - 100
        applyLevel();
    }

    /** Updates the tank, then the alarm, splitter and SMS based on that level. */
    // [OOP: Abstraction / Encapsulation] callers only say applyLevel(); the update
    // details (tank drawing, labels, colours, SMS) stay hidden inside this method.
    static void applyLevel() {
        boolean alert = waterLevel >= ALERT_LEVEL;

        // THE ONLY BEHAVIOURAL DIFFERENCE FROM TaskEg1:
        // levelBar.setValue(waterLevel)  ->  tank.setLevel(waterLevel)
        // setLevel() stores the number and calls repaint(); Swing then calls
        // paintComponent() later, on the Event Dispatch Thread. The method does
        // NOT draw anything itself -- it only schedules a repaint.
        tank.setLevel(waterLevel);
        levelLabel.setText(waterLevel + " mm");

        // alarm : ON when 75 or above, OFF when below
        if (alert) {
            alarmLabel.setText("ALARM : ON");
            alarmLabel.setBackground(Color.RED);
            alarmLabel.setForeground(Color.WHITE);
        } else {
            alarmLabel.setText("ALARM : OFF");
            alarmLabel.setBackground(new Color(220, 220, 220));
            alarmLabel.setForeground(Color.DARK_GRAY);
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
    // [OOP: Abstraction] a helper method: callers ask for the effect, not the steps.
    static void sendSms(boolean alert) {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String message = "Water level updated to " + waterLevel + "mm"
                + " | Alarm: " + (alert ? "ON" : "OFF")
                + " | Splitter: " + (alert ? "OPEN" : "CLOSED");

        System.out.println("[SMS " + time + "] " + message);
        smsArea.append("[SMS " + time + "] " + message + "\n");
        smsArea.setCaretPosition(smsArea.getDocument().getLength());   // auto-scroll to newest line
    }

    /*
     * =================================================================
     * HOW THE "VIRTUAL TANK" AND THE WATER LEVEL ARE CREATED
     * =================================================================
     * Nothing is loaded from disk. A Swing panel is a blank rectangle that
     * the framework asks to paint; by overriding paintComponent() we take
     * over that rectangle and draw the tank ourselves with Java 2D.
     *
     *  1. GEOMETRY  - getWidth()/getHeight() give the panel's current pixel
     *                 size (set by the layout manager, ~320 x 380). We shrink
     *                 that by fixed margins to get the tank rectangle
     *                 (tankX, tankY, tankW, tankH). Everything else is
     *                 measured from those four numbers, so the drawing
     *                 scales with the panel instead of using magic pixels.
     *
     *  2. EMPTY TANK - a rounded rectangle ("inner") is filled light grey-blue:
     *                 that is the air inside the tank. The same shape is used
     *                 later as a CLIP so water can never spill outside.
     *
     *  3. LEVEL MATH - the only real "physics" in the program:
     *
     *                     fraction  = level / 100.0        (0.0 .. 1.0)
     *                     waterH    = innerH * fraction    (pixels tall)
     *                     surfaceY  = innerY + innerH * (1 - fraction)
     *
     *                 Screen Y grows DOWNWARD, so level 0 puts the surface at
     *                 innerY + innerH (the bottom) and level 100 puts it at
     *                 innerY (the top). That single multiplication is what
     *                 turns the number 0-100 into a vertical position.
     *
     *  4. WATER BODY - the surface is not a straight line: a loop walks across
     *                 the tank in 61 steps and offsets each point with
     *                 sin(x * 3PI + phase), which produces the wave. The
     *                 resulting Path2D is closed down to the tank bottom to
     *                 become a filled shape, and it is filled with a
     *                 GradientPaint (light at the surface, dark at the base)
     *                 so the water looks deep. Because the clip is the tank's
     *                 inner rounded rectangle, the wave is cut off at the
     *                 glass instead of being drawn over it.
     *
     *  5. ANIMATION - phase increases inside a 50 ms Swing Timer. Each tick
     *                 only calls repaint(); Swing re-runs paintComponent()
     *                 about 20 times per second, so the same sine equation
     *                 now produces a moving surface. No water is "moved":
     *                 the picture is simply redrawn with phase shifted.
     *
     *  6. DECORATION - a scale is drawn by looping value = 0,10,...,100 and
     *                 converting each value with the SAME surfaceY formula,
     *                 which guarantees the 75 % tick and the dashed alert
     *                 line sit exactly where the water surface will be at 75.
     *                 The tank outline is drawn last so it covers the edges.
     *
     *  7. STATE      - level and alert are private fields. setLevel() clamps
     *                 the value to 0..100, stores it, and requests a repaint.
     *                 The paint code only READS those fields, so the drawing
     *                 is always a pure function of (level, alert, phase).
     * =================================================================
     */
    static class WaterTank extends JPanel {   // [OOP: Inheritance] IS-A JPanel, so it can be added to any Swing container

        // JPanel (via Component) is Serializable; this id silences the compiler
        // warning and identifies the class if its state is ever serialised.
        private static final long serialVersionUID = 1L;

        // [OOP: Encapsulation] private state: outside code cannot set a level
        // of 500 or a random colour, so the drawing can never be inconsistent.
        private int level = 0;          // 0 - 100, the number shared with TaskEg2
        private boolean alert = false;  // true when level >= ALERT_LEVEL
        private double phase = 0;       // moves the water wave

        WaterTank() {
            // [OOP: Abstraction] the layout manager reads this hint to decide
            // how much space the tank wants.
            setPreferredSize(new Dimension(320, 380));
            setBackground(new Color(247, 250, 253));

            // [OOP: Polymorphism] Swing's Timer takes an ActionListener; the
            // lambda below is that interface implementation. The timer only
            // invalidates the picture, it never touches the level.
            Timer waveTimer = new Timer(50, e -> {
                phase += 0.25;   // shift the sine wave by a quarter step
                repaint();       // "please paint me again soon"
            });
            waveTimer.start();
        }

        /** The only public way to change the displayed level. */
        // [OOP: Encapsulation] validate + store + schedule repaint. Note there
        // is no drawing here: drawing belongs to paintComponent().
        void setLevel(int newLevel) {
            level = Math.max(0, Math.min(100, newLevel));   // clamp to 0..100
            alert = level >= ALERT_LEVEL;                   // colour switch flag
            repaint();                                      // asynchronous: Swing calls paintComponent()
        }

        /**
         * [OOP: Inheritance + Polymorphism] JPanel calls this hook; we override
         * it, so the same call paints our tank instead of an empty panel.
         * Called by Swing, never by our own code.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);   // first let JPanel paint the background colour

            // [OOP: Encapsulation] a copy of the Graphics object, so the
            // changes we make (clip, colour, stroke) do not leak to siblings.
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);            // smooth curves
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);  // smooth % labels

            // --- 1. geometry: panel size minus margins = tank rectangle ---
            int marginLeft = 20, marginRight = 58, marginTop = 18, marginBottom = 22;   // extra space on the right for "%" labels
            int tankX = marginLeft;
            int tankY = marginTop;
            int tankW = getWidth() - marginLeft - marginRight;
            int tankH = getHeight() - marginTop - marginBottom;

            int rim = 5;                                  // glass thickness in pixels
            int innerX = tankX + rim;
            int innerY = tankY + rim;
            int innerW = tankW - 2 * rim;
            int innerH = tankH - 2 * rim;

            // The rounded rectangle is BOTH the air area and the clip for water.
            RoundRectangle2D inner = new RoundRectangle2D.Float(innerX, innerY, innerW, innerH, 26, 26);

            // --- 2. empty tank (the part above the water) ---
            g2.setColor(new Color(232, 240, 247));   // pale blue-grey "air"
            g2.fill(inner);

            // --- 3. everything from here is confined to the tank's inside ---
            g2.setClip(inner);   // water cannot paint over the glass or the labels

            if (level > 0) {   // level 0 = empty tank, nothing to fill
                // 0..100 -> 0.0..1.0 -> pixel height, measured from the bottom
                float fraction = level / 100f;
                float surfaceY = innerY + innerH * (1 - fraction);   // screen Y grows downward
                float amplitude = 5f;                                // wave height in pixels

                // 4. wavy surface: 61 points, each shifted by a sine wave
                Path2D.Float surface = new Path2D.Float();
                int steps = 60;
                for (int i = 0; i <= steps; i++) {
                    double t = i / (double) steps;                                  // 0.0 .. 1.0 across the tank
                    float x = (float) (innerX + innerW * t);
                    float y = (float) (surfaceY + Math.sin(t * Math.PI * 3 + phase) * amplitude);   // phase animates it
                    if (i == 0) {
                        surface.moveTo(x, y);   // first point starts the path
                    } else {
                        surface.lineTo(x, y);   // connect the rest
                    }
                }

                // close the wave down to the bottom to get a filled water body
                Path2D.Float water = (Path2D.Float) surface.clone();
                water.lineTo(innerX + innerW, innerY + innerH);   // bottom-right
                water.lineTo(innerX, innerY + innerH);            // bottom-left
                water.closePath();                                // back to the surface start

                // fill with a vertical gradient: light on top, dark at the base
                Color topColor = alert ? new Color(255, 112, 67) : new Color(66, 165, 245);      // red-ish when alarming
                Color bottomColor = alert ? new Color(183, 28, 28) : new Color(13, 71, 161);     // deep red / deep blue
                g2.setPaint(new GradientPaint(0, surfaceY, topColor, 0, innerY + innerH, bottomColor));
                g2.fill(water);

                // bright line on the water surface so the level is easy to read
                g2.setStroke(new BasicStroke(2f));
                g2.setColor(alert ? new Color(255, 205, 190) : new Color(187, 222, 251));
                g2.draw(surface);
            }

            // --- 5. scale: a tick and a "%" label every 10 units ---
            // The same surfaceY formula is reused, which is why the scale and
            // the water always agree with each other.
            g2.setFont(new Font("SansSerif", Font.PLAIN, 11));
            for (int value = 0; value <= 100; value += 10) {
                int ty = Math.round(innerY + innerH * (1 - value / 100f));
                g2.setColor(new Color(120, 144, 165));
                g2.drawLine(innerX + 5, ty, innerX + 16, ty);               // tick on the left glass
                g2.drawLine(innerX + innerW - 5, ty, innerX + innerW - 16, ty);   // tick on the right glass
                g2.setColor(new Color(96, 116, 134));
                g2.drawString(value + "%", tankX + tankW + 10, ty + 4);     // label outside the tank
            }

            // --- 6. dashed alert marker at exactly ALERT_LEVEL % ---
            int alertY = Math.round(innerY + innerH * (1 - ALERT_LEVEL / 100f));
            g2.setColor(new Color(211, 47, 47, 190));
            // BasicStroke with a dash pattern: 7 px on, 5 px off
            g2.setStroke(new BasicStroke(1.6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                    10f, new float[]{7f, 5f}, 0f));
            g2.drawLine(innerX, alertY, innerX + innerW, alertY);
            g2.setFont(new Font("SansSerif", Font.BOLD, 10));
            g2.drawString("ALERT " + ALERT_LEVEL, innerX + 22, alertY - 5);

            // --- 7. glass highlight: a translucent white vertical stripe ---
            g2.setStroke(new BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(new Color(255, 255, 255, 70));   // 70/255 alpha = faint
            g2.drawLine(innerX + 16, innerY + 30, innerX + 16, innerY + innerH - 30);

            g2.setClip(null);   // stop clipping before drawing the outline on the rim

            // --- 8. tank outline, drawn last so it sits on top of the water ---
            g2.setStroke(new BasicStroke(3f));
            g2.setColor(new Color(55, 71, 79));   // dark slate
            g2.draw(new RoundRectangle2D.Float(tankX, tankY, tankW, tankH, 30, 30));

            g2.dispose();   // free the copied Graphics context
        }
    }
}
