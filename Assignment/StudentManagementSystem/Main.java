import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main extends JFrame {

    public static final String HOME = "home";
    public static final String STUDENT_MENU = "studentMenu";
    public static final String BATCH_MENU = "batchMenu";
    public static final String GRADE_MENU = "gradeMenu";
    public static final String REPORT_MENU = "reportMenu";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cards = new JPanel(cardLayout);
    private final Map<String, JComponent> pages = new LinkedHashMap<>();
    private final HomePage homePage = new HomePage(this);
    private final BatchReportPage batchReportPage = new BatchReportPage(this);

    public Main() {
        setTitle("iCET Student Management System");
        setSize(960, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cards.setBackground(Color.WHITE);

        register(HOME, homePage);
        register(STUDENT_MENU, new StudentMenuPage(this));
        register("addStudent", new AddStudentPage(this));
        register("updateStudent", new UpdateStudentPage(this));
        register("viewStudent", new ViewStudentPage(this));
        register("deleteStudent", new DeleteStudentPage(this));
        register(BATCH_MENU, new BatchMenuPage(this));
        register("addBatch", new AddBatchPage(this));
        register("updateBatch", new UpdateBatchPage(this));
        register("viewBatches", new ViewBatchesPage(this));
        register(GRADE_MENU, new GradeMenuPage(this));
        register("updatePrf", new UpdatePrfPage(this));
        register("updateDbms", new UpdateDbmsPage(this));
        register(REPORT_MENU, new ReportMenuPage(this));
        register("registrationReport", new RegistrationReportPage(this));
        register("batchSelection", new BatchSelectionPage(this));
        register("batchReport", batchReportPage);
        register("industryTraining", new IndustryTrainingPage(this));

        setContentPane(cards);
        showPage(HOME);
    }

    private void register(String key, JComponent page) {
        pages.put(key, page);
        cards.add(page, key);
    }

    public void showPage(String key) {
        JComponent page = pages.get(key);
        if (page instanceof Refreshable refreshable) {
            refreshable.refresh();
        }
        cardLayout.show(cards, key);
    }

    public void showBatchReport(Batch batch) {
        batchReportPage.setSelectedBatch(batch);
        showPage("batchReport");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
