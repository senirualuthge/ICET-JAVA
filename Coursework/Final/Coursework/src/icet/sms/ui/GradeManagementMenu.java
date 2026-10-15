package icet.sms.ui;

import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class GradeManagementMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public GradeManagementMenu(StudentManagementSystem sms) {
        this.sms = sms;
        GuiUtils.setCurrentSms(sms);
        setTitle("Grade Management");
        setSize(450, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Grade Management"), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(2, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] opts = {"3.1 PRF Marks Update", "3.2 DBMS Marks Update"};
        for (String o : opts) {
            JButton b = new JButton(o);
            b.setFont(GuiUtils.BTN_FONT);
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                dispose();
                if (o.startsWith("3.1")) {
                    new PrfMarksUpdateScreen(sms).setVisible(true);
                } else {
                    new DbmsMarksUpdateScreen(sms).setVisible(true);
                }
            });
            center.add(b);
        }

        add(center, BorderLayout.CENTER);
        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }
}
