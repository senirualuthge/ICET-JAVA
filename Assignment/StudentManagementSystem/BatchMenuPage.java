import javax.swing.*;
import java.awt.*;

public class BatchMenuPage extends JPanel {

    public BatchMenuPage(Main main) {
        JPanel menu = new JPanel();
        menu.setBackground(Ui.BG);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(Ui.menuButton("Add Batch", () -> main.showPage("addBatch")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Update Batch", () -> main.showPage("updateBatch")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("View Batches", () -> main.showPage("viewBatches")));

        JPanel page = Ui.page(main, "Batch Management",
                "Choose an option from the menu below to get started",
                Ui.centered(menu), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }
}
