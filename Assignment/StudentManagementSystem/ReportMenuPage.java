import javax.swing.*;
import java.awt.*;

public class ReportMenuPage extends JPanel {

    public ReportMenuPage(Main main) {
        JPanel menu = new JPanel();
        menu.setBackground(Ui.BG);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(Ui.menuButton("Student Registration Report", () -> main.showPage("registrationReport")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Batch-wise Student Report", () -> main.showPage("batchSelection")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Industry Training Eligibility Report", () -> main.showPage("industryTraining")));

        JPanel page = Ui.page(main, "Report Management",
                "Choose an option from the menu below to get started",
                Ui.centered(menu), Main.HOME, "Back to Main Menu");
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }
}
