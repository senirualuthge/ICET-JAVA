package icet.sms.ui;

import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentManagementMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public StudentManagementMenu(StudentManagementSystem sms) {
        this.sms = sms;
        GuiUtils.setCurrentSms(sms);
        setTitle("Student Management");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Student Management"), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(4, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] opts = {
            "1.1 Add Student",
            "1.2 Update Student",
            "1.3 View Student Profile",
            "1.4 Delete Student Profile"
        };
        ActionListener handler = e -> {
            String cmd = e.getActionCommand();
            dispose();
            switch (cmd) {
                case "1.1 Add Student" -> new AddStudentScreen(sms).setVisible(true);
                case "1.2 Update Student" -> new UpdateStudentScreen(sms).setVisible(true);
                case "1.3 View Student Profile" -> new ViewStudentScreen(sms).setVisible(true);
                case "1.4 Delete Student Profile" -> new DeleteStudentScreen(sms).setVisible(true);
            }
        };

        for (String o : opts) {
            JButton b = new JButton(o);
            b.setFont(GuiUtils.BTN_FONT);
            b.setFocusPainted(false);
            b.addActionListener(handler);
            center.add(b);
        }

        add(center, BorderLayout.CENTER);
        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }
}
