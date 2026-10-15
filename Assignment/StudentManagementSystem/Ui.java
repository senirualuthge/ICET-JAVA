import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Ui {

    public static final Color PRIMARY = new Color(25, 60, 120);
    public static final Color ACCENT = new Color(0, 120, 215);
    public static final Color BG = Color.WHITE;
    public static final Color PANEL_BG = new Color(245, 247, 250);

    private Ui() {
    }

    public static JButton menuButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        button.setPreferredSize(new Dimension(420, 52));
        button.setBackground(PANEL_BG);
        button.setForeground(PRIMARY);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(8, 20, 8, 20));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> action.run());
        return button;
    }

    public static JButton actionButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        button.setPreferredSize(new Dimension(180, 40));
        button.setBackground(ACCENT);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> action.run());
        return button;
    }

    public static JButton listLink(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        button.setForeground(PRIMARY);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setPreferredSize(new Dimension(420, 32));
        button.setBorder(new EmptyBorder(4, 20, 4, 20));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> action.run());
        return button;
    }

    public static JLabel titleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        label.setForeground(PRIMARY);
        return label;
    }

    public static JLabel subTitleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        label.setForeground(Color.GRAY);
        return label;
    }

    public static JLabel fieldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        label.setForeground(PRIMARY);
        return label;
    }

    public static JTextField textField(int columns) {
        JTextField field = new JTextField(columns);
        field.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        return field;
    }

    public static JPanel page(Main main, String title, String subtitle, JComponent content, String backTarget) {
        return page(main, title, subtitle, content, backTarget, "Back to Home Page");
    }

    public static JPanel page(Main main, String title, String subtitle, JComponent content,
                              String backTarget, String backLabel) {
        JPanel page = new JPanel(new BorderLayout());
        page.setBackground(BG);
        page.setBorder(new EmptyBorder(24, 60, 12, 60));

        JPanel north = new JPanel();
        north.setBackground(BG);
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        JLabel brand = new JLabel("iCET  ·  Connecting Intelligence");
        brand.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        brand.setForeground(Color.GRAY);
        brand.setAlignmentX(Component.LEFT_ALIGNMENT);
        north.add(brand);
        north.add(Box.createVerticalStrut(10));

        JLabel heading = new JLabel("Learning Management System", SwingConstants.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        heading.setForeground(PRIMARY);
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        north.add(heading);
        north.add(Box.createVerticalStrut(6));

        JLabel titleLine = titleLabel(title);
        titleLine.setAlignmentX(Component.CENTER_ALIGNMENT);
        north.add(titleLine);
        if (subtitle != null && !subtitle.isEmpty()) {
            JLabel subtitleLine = subTitleLabel(subtitle);
            subtitleLine.setAlignmentX(Component.CENTER_ALIGNMENT);
            north.add(Box.createVerticalStrut(2));
            north.add(subtitleLine);
        }

        page.add(north, BorderLayout.NORTH);
        if (content != null) {
            page.add(content, BorderLayout.CENTER);
        }

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 6));
        south.setBackground(BG);
        south.add(listLink(backLabel, () -> main.showPage(backTarget)));
        page.add(south, BorderLayout.SOUTH);
        return page;
    }

    public static JPanel formPanel(JComponent... rows) {
        JPanel panel = new JPanel();
        panel.setBackground(BG);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 0, 20, 0));
        for (JComponent row : rows) {
            row.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(row);
            panel.add(Box.createVerticalStrut(14));
        }
        return panel;
    }

    public static JPanel formRow(String label, JComponent input) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        row.setBackground(BG);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        JLabel jLabel = fieldLabel(label);
        jLabel.setPreferredSize(new Dimension(160, 28));
        row.add(jLabel);
        row.add(input);
        return row;
    }

    public static void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "iCET", JOptionPane.INFORMATION_MESSAGE);
    }

    public static JPanel centered(JComponent component) {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        wrapper.add(component, gbc);
        return wrapper;
    }
}
