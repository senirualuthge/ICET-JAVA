import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    public HomePage(Main main) {
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        setBorder(new javax.swing.border.EmptyBorder(40, 60, 40, 60));

        JLabel brand = new JLabel("iCET", SwingConstants.CENTER);
        brand.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        brand.setForeground(Ui.PRIMARY);

        JLabel tagline = new JLabel("Connecting Intelligence", SwingConstants.CENTER);
        tagline.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        tagline.setForeground(Color.GRAY);

        JLabel title = new JLabel("iCET Learning Management System", SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        title.setForeground(Ui.PRIMARY);

        JLabel subtitle = Ui.subTitleLabel("Choose an option from the menu below to get started");

        JPanel north = new JPanel(new GridLayout(4, 1));
        north.setBackground(Ui.BG);
        north.add(brand);
        north.add(tagline);
        north.add(title);
        north.add(subtitle);
        add(north, BorderLayout.NORTH);

        JPanel menu = new JPanel();
        menu.setBackground(Ui.BG);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(Ui.menuButton("Student Management", () -> main.showPage(Main.STUDENT_MENU)));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Batch Management", () -> main.showPage(Main.BATCH_MENU)));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Grade Management", () -> main.showPage(Main.GRADE_MENU)));
        menu.add(Box.createVerticalStrut(16));
        menu.add(Ui.menuButton("Report Generator", () -> main.showPage(Main.REPORT_MENU)));

        add(Ui.centered(menu), BorderLayout.CENTER);
    }
}
