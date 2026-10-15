import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BatchSelectionPage extends JPanel implements Refreshable {

    private final Main main;
    private final JPanel listPanel = new JPanel();

    public BatchSelectionPage(Main main) {
        this.main = main;
        listPanel.setBackground(Ui.BG);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        JPanel page = Ui.page(main, "Batch-wise Student Report",
                "Choose an option from the menu below to get started",
                Ui.centered(listPanel), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        listPanel.removeAll();
        List<Batch> batches = Database.get().getBatches();
        if (batches.isEmpty()) {
            JLabel empty = Ui.subTitleLabel("No batches available in the system.");
            empty.setAlignmentX(Component.LEFT_ALIGNMENT);
            listPanel.add(empty);
        }
        for (Batch batch : batches) {
            JButton button = Ui.menuButton(batch.toString(), () -> showBatchReport(batch));
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            listPanel.add(button);
            listPanel.add(Box.createVerticalStrut(12));
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    private void showBatchReport(Batch batch) {
        main.showBatchReport(batch);
    }
}
