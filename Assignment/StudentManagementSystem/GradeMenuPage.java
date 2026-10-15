import javax.swing.*;
import java.awt.*;

public class GradeMenuPage extends JPanel {

    public GradeMenuPage(Main main) {
        JPanel menu = new JPanel();
        menu.setBackground(Ui.BG);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(Ui.menuButton("PRF Marks Update", () -> main.showPage("updatePrf")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("DBMS Marks Update", () -> main.showPage("updateDbms")));

        JPanel page = Ui.page(main, "Grade Management",
                "Choose an option from the menu below to get started",
                Ui.centered(menu), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }
}
