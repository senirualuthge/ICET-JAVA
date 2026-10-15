import javax.swing.*;
import java.awt.*;

public class UpdateBatchPage extends JPanel {

    private final Main main;
    private final JTextField searchField = Ui.textField(12);
    private final JLabel currentLabel = new JLabel(" ");
    private final JComboBox<String> statusCombo = new JComboBox<>(new String[]{"ENROLLMENTOPEN", "ENROLLMENTCLOSED"});
    private final JButton updateBtn = Ui.actionButton("UPDATE", this::updateBatch);
    private Batch current;

    public UpdateBatchPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private void buildLayout() {
        updateBtn.setEnabled(false);
        statusCombo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        statusCombo.setPreferredSize(new Dimension(220, 30));
        currentLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        currentLabel.setForeground(Ui.PRIMARY);

        JButton searchBtn = Ui.actionButton("SEARCH", this::search);
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        searchRow.setBackground(Ui.BG);
        searchRow.add(Ui.fieldLabel("Batch ID"));
        searchRow.add(searchField);
        searchRow.add(searchBtn);

        JPanel form = Ui.formPanel(
                searchRow,
                Ui.formRow("Current Status", currentLabel),
                Ui.formRow("New Status", statusCombo)
        );

        JButton cancelBtn = Ui.actionButton("CANCEL", () -> main.showPage(Main.BATCH_MENU));
        cancelBtn.setBackground(Color.GRAY);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttons.setBackground(Ui.BG);
        buttons.add(cancelBtn);
        buttons.add(updateBtn);

        JPanel center = new JPanel();
        center.setBackground(Ui.BG);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(form);
        center.add(buttons);

        JPanel page = Ui.page(main, "Update Batch", "Search a batch to update its enrollment status",
                Ui.centered(center), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    private void search() {
        String text = searchField.getText().trim();
        if (text.isEmpty()) {
            Ui.showError(this, "Please enter the Batch ID.");
            return;
        }
        int batchNumber;
        try {
            batchNumber = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Ui.showError(this, "This batch does not exist in the system.");
            return;
        }
        current = Database.get().findBatch(batchNumber);
        if (current == null) {
            Ui.showError(this, "This batch does not exist in the system.");
            currentLabel.setText(" ");
            updateBtn.setEnabled(false);
            return;
        }
        currentLabel.setText(current.toString() + " — " + current.getStatusText());
        statusCombo.setSelectedIndex(current.isOpen() ? 0 : 1);
        updateBtn.setEnabled(true);
    }

    private void updateBatch() {
        if (current == null) {
            return;
        }
        int newStatus = statusCombo.getSelectedIndex() == 0
                ? Batch.ENROLLMENT_OPEN : Batch.ENROLLMENT_CLOSED;
        current.setStatus(newStatus);
        currentLabel.setText(current.toString() + " — " + current.getStatusText());
        Ui.showInfo(this, current.toString() + " status updated to " + current.getStatusText() + "!");
    }
}
