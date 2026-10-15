import javax.swing.*;
import java.awt.*;

public class AddBatchPage extends JPanel implements Refreshable {

    private final Main main;
    private final JTextField numberField = Ui.textField(8);

    public AddBatchPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private void buildLayout() {
        numberField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        JButton addBtn = Ui.actionButton("ADD BATCH", this::addBatch);
        JButton cancelBtn = Ui.actionButton("CANCEL", () -> main.showPage(Main.BATCH_MENU));
        cancelBtn.setBackground(Color.GRAY);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttons.setBackground(Ui.BG);
        buttons.add(cancelBtn);
        buttons.add(addBtn);

        JPanel form = Ui.formPanel(
                Ui.formRow("Batch Number", numberField)
        );

        JPanel note = new JPanel(new FlowLayout(FlowLayout.LEFT));
        note.setBackground(Ui.BG);
        JLabel noteLabel = Ui.subTitleLabel("Batch IDs start from 100 and must be unique.");
        noteLabel.setHorizontalAlignment(SwingConstants.LEFT);
        note.add(noteLabel);

        JPanel center = new JPanel();
        center.setBackground(Ui.BG);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(form);
        center.add(note);
        center.add(buttons);

        JPanel page = Ui.page(main, "Add Batch", "Add a new batch to the system",
                Ui.centered(center), Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        numberField.setText(String.valueOf(Database.get().nextBatchNumber()));
    }

    private void addBatch() {
        String text = numberField.getText().trim();
        int batchNumber;
        try {
            batchNumber = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Ui.showError(this, "Please enter a valid batch number.");
            return;
        }
        if (batchNumber < 100) {
            Ui.showError(this, "Batch IDs start from 100.");
            return;
        }
        if (Database.get().findBatch(batchNumber) != null) {
            Ui.showError(this, "This batch already exists in the system.");
            return;
        }
        if (Database.get().addBatch(batchNumber)) {
            numberField.setText(String.valueOf(Database.get().nextBatchNumber()));
            Ui.showInfo(this, "Batch " + batchNumber + " added successfully!");
        }
    }
}
