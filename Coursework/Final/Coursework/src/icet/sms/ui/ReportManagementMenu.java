package icet.sms.ui;

import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class ReportManagementMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public ReportManagementMenu(StudentManagementSystem sms) {
        this.sms = sms;
        GuiUtils.setCurrentSms(sms);
        setTitle("Report Management");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Report Management"), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] opts = {
            "4.1 Student Registration Report",
            "4.2 Batch-wise Student Report",
            "4.3 Industry Training Eligibility Report"
        };
        for (String o : opts) {
            JButton b = new JButton(o);
            b.setFont(GuiUtils.BTN_FONT);
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                dispose();
                switch (o) {
                    case "4.1 Student Registration Report" ->
                        new StudentRegistrationReportScreen(sms).setVisible(true);
                    case "4.2 Batch-wise Student Report" ->
                        new BatchWiseStudentReportScreen(sms).setVisible(true);
                    case "4.3 Industry Training Eligibility Report" ->
                        new IndustryTrainingEligibilityReportScreen(sms).setVisible(true);
                }
            });
            center.add(b);
        }

        add(center, BorderLayout.CENTER);
        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }
}
