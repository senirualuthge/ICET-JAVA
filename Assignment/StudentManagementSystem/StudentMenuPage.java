import javax.swing.*;
import java.awt.*;

public class StudentMenuPage extends JPanel {

    public StudentMenuPage(Main main) {
        JPanel menu = new JPanel();
        menu.setBackground(Ui.BG);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(Ui.menuButton("Add Student", () -> main.showPage("addStudent")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Update Student", () -> main.showPage("updateStudent")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("View Student Profile", () -> main.showPage("viewStudent")));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Delete Student Profile", () -> main.showPage("deleteStudent")));

        JPanel page = Ui.page(main, "Student Management",
                "Choose an option from the menu below to get started",
                Ui.centered(menu), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }
}
