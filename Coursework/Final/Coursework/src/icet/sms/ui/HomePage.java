package icet.sms.ui;

import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public HomePage() {
        this.sms = new StudentManagementSystem();
        this.sms.load();  // restore previously saved data
        setTitle("iCET Student Management System - Home Page");
        GuiUtils.setCurrentSms(sms);  // register for persistence on back-navigation
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("iCET Student Management System");
        title.setFont(new Font("", Font.BOLD, 36));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Four management panels
        JPanel center = new JPanel(new GridLayout(2, 2, 20, 20));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        center.add(buildMenuCard("Student Management",
                new String[]{"Add Student", "Update Student",
                             "View Student Profile", "Delete Student Profile"},
                e -> new StudentManagementMenu(sms).setVisible(true)));

        center.add(buildMenuCard("Batch Management",
                new String[]{"Add Batch", "Update Batch", "View Batches"},
                e -> new BatchManagementMenu(sms).setVisible(true)));

        center.add(buildMenuCard("Grade Management",
                new String[]{"PRF Marks Update", "DBMS Marks Update"},
                e -> new GradeManagementMenu(sms).setVisible(true)));

        center.add(buildMenuCard("Report Management",
                new String[]{"Student Registration Report",
                             "Batch-wise Student Report",
                             "Industry Training Eligibility Report"},
                e -> new ReportManagementMenu(sms).setVisible(true)));

        add(center, BorderLayout.CENTER);

        // Footer + Clear Data
        JPanel bottom = new JPanel(new BorderLayout(10, 0));

        JLabel footer = new JLabel("Please select an option from the menu above");
        footer.setFont(new Font("", Font.PLAIN, 16));
        footer.setHorizontalAlignment(JLabel.CENTER);
        bottom.add(footer, BorderLayout.CENTER);

        JButton clearBtn = new JButton("Clear All Data");
        clearBtn.setFont(GuiUtils.SMALL_BTN_FONT);
        clearBtn.setForeground(Color.RED);
        clearBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete all data? This cannot be undone.",
                "Clear All Data", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    java.nio.file.Files.deleteIfExists(
                        java.nio.file.Paths.get(
                            System.getProperty("user.home") + "/icet_sms_data.json"));
                } catch (Exception ignored) {}
                resetSms();
                JOptionPane.showMessageDialog(this,
                    "All data has been cleared.", "Done", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        bottom.add(clearBtn, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);
    }

    private JPanel buildMenuCard(String heading, String[] options,
                                  java.awt.event.ActionListener onOptionClick) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        card.setBackground(new Color(240, 248, 255));

        JLabel head = new JLabel(heading);
        head.setFont(new Font("", Font.BOLD, 24));
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        card.add(head, BorderLayout.NORTH);

        JPanel opts = new JPanel(new GridLayout(options.length, 1, 5, 5));
        for (String opt : options) {
            JButton b = new JButton(opt);
            b.setFont(new Font("", Font.BOLD, 18));
            b.setFocusPainted(false);
            b.setPreferredSize(new Dimension(300, 45));
            b.addActionListener(onOptionClick);
            opts.add(b);
        }
        card.add(opts, BorderLayout.CENTER);
        return card;
    }

    /**
     * Reset the SMS instance (used when clearing all data).
     * Note: 'sms' is final, so we replace its reference via the holder
     * and recreate the data store. Sub-screens that hold a reference to
     * the old sms will continue to work with their own instance; new
     * screens opened after this will use the fresh instance.
     */
    private void resetSms() {
        GuiUtils.setCurrentSms(null);
        // The home page's sms field is final; we recreate via a new HomePage.
        // For simplicity, dispose this frame and open a fresh home page.
        dispose();
        new HomePage().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage().setVisible(true));
    }
}
