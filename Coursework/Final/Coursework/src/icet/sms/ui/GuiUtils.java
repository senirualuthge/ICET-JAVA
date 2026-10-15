package icet.sms.ui;

import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.util.List;
import java.awt.*;

public class GuiUtils {

    private GuiUtils() {}

    public static Font BIG_FONT  = new Font("", Font.BOLD, 28);
    public static Font LABEL_FONT = new Font("", Font.BOLD, 20);
    public static Font BTN_FONT   = new Font("", Font.BOLD, 20);
    public static Font SMALL_BTN_FONT = new Font("", Font.BOLD, 14);

    public static void showWarning(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void showSuccess(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Build a standard title bar panel.
     */
    public static JPanel buildTitlePanel(String title) {
        JLabel lbl = new JLabel(title);
        lbl.setFont(BIG_FONT);
        lbl.setHorizontalAlignment(JLabel.CENTER);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(lbl);
        return p;
    }

    /**
     * Build a standard button panel with a Back-to-Home button on the left
     * and any extra buttons on the right.
     */
    public static JPanel buildButtonPanel(JFrame frame, String... extraLabels) {
        JPanel p = new JPanel(new BorderLayout(10, 0));

        JButton backBtn = new JButton("Back to Home Page");
        backBtn.setFont(SMALL_BTN_FONT);
        backBtn.addActionListener(e -> {
            // Save data before returning home
            try {
                icet.sms.model.StudentManagementSystem sms = findSms(frame);
                if (sms != null) sms.save();
            } catch (Exception ignored) {}
            frame.dispose();
            new HomePage().setVisible(true);
        });
        p.add(backBtn, BorderLayout.WEST);

        if (extraLabels != null && extraLabels.length > 0) {
            JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            for (String lbl : extraLabels) {
                JButton b = new JButton(lbl);
                b.setFont(BTN_FONT);
                right.add(b);
            }
            p.add(right, BorderLayout.EAST);
        }
        return p;
    }

    /**
     * Find the StudentManagementSystem instance attached to this window hierarchy.
     * Works by walking all owned frames looking for one whose content pane
     * contains a known SMS-referencing component, or by scanning child frames.
     */
    private static icet.sms.model.StudentManagementSystem findSms(JFrame frame) {
        // Walk owned frames (sub-windows opened from this home page)
        for (Frame owned : Frame.getFrames()) {
            if (owned == frame) continue;
            if (owned instanceof JFrame jf) {
                // Try to find the menu frame that holds the SMS reference
                Container cp = jf.getContentPane();
                if (cp instanceof JPanel jp && jp.getLayout() instanceof java.awt.GridLayout) {
                    // This is a menu frame; we need its SMS. Walk its buttons' action listeners
                    // that were created with a lambda capturing sms.
                    // Since we can't easily extract that, use a simpler heuristic:
                    // The first owned JFrame that is not the home page is a menu.
                    // We'll store SMS references in a thread-local instead.
                }
            }
        }
        // Fallback: use a thread-local set by each menu constructor
        return HomeSmsHolder.get();
    }

    /**
     * Simple holder used to pass the current SMS instance between screens.
     * Each menu frame sets this when opened; the home page clears it.
     */
    private static class HomeSmsHolder {
        private static final ThreadLocal<icet.sms.model.StudentManagementSystem> HOLDER = new ThreadLocal<>();
        static void set(icet.sms.model.StudentManagementSystem sms) { HOLDER.set(sms); }
        static icet.sms.model.StudentManagementSystem get() { return HOLDER.get(); }
        static void clear() { HOLDER.remove(); }
    }

    public static void setCurrentSms(icet.sms.model.StudentManagementSystem sms) {
        HomeSmsHolder.set(sms);
    }

    public static JComboBox<String> buildBatchComboBox(StudentManagementSystem sms,
                                                        Object... insertAtStart) {
        List<icet.sms.model.Batch> batches = sms.getAllBatches();
        String[] items;
        if (batches.isEmpty()) {
            items = new String[] {"-- No Batches Available --"};
        } else {
            items = new String[batches.size()];
            for (int i = 0; i < batches.size(); i++) {
                items[i] = batches.get(i).getBatchName() +
                           " (ID: " + batches.get(i).getBatchId() + ")";
            }
        }
        JComboBox<String> cb = new JComboBox<>(items);
        cb.setFont(LABEL_FONT);
        return cb;
    }

    public static JTextField buildTextField(int columns, Font font) {
        JTextField tf = new JTextField(columns);
        tf.setFont(font == null ? LABEL_FONT : font);
        return tf;
    }
}
