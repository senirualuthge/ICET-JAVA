package icet.sms.ui;

import icet.sms.model.StudentManagementSystem;
import javax.swing.*;
import java.awt.*;

public class BatchManagementMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private final StudentManagementSystem sms;

    public BatchManagementMenu(StudentManagementSystem sms) {
        this.sms = sms;
        GuiUtils.setCurrentSms(sms);
        setTitle("Batch Management");
        setSize(450, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(GuiUtils.buildTitlePanel("Batch Management"), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] opts = {"2.1 Add Batch", "2.2 Update Batch", "2.3 View Batches"};
        for (String o : opts) {
            JButton b = new JButton(o);
            b.setFont(GuiUtils.BTN_FONT);
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                dispose();
                switch (o) {
                    case "2.1 Add Batch" -> new AddBatchScreen(sms).setVisible(true);
                    case "2.2 Update Batch" -> new UpdateBatchScreen(sms).setVisible(true);
                    case "2.3 View Batches" -> new ViewBatchesScreen(sms).setVisible(true);
                }
            });
            center.add(b);
        }

        add(center, BorderLayout.CENTER);
        add(GuiUtils.buildButtonPanel(this), BorderLayout.SOUTH);
    }
}
