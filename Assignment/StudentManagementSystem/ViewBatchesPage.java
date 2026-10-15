import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBatchesPage extends JPanel implements Refreshable {

    private final Main main;
    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Batch Name", "Student Count", "Status"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ViewBatchesPage(Main main) {
        this.main = main;
        buildLayout();
    }

    private void buildLayout() {
        JTable table = new JTable(model);
        table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        table.setRowHeight(32);
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        table.getTableHeader().setBackground(Ui.PANEL_BG);
        table.setGridColor(new Color(220, 224, 230));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < 3; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(560, 340));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 224, 230)));

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(Ui.BG);
        center.add(scrollPane, BorderLayout.CENTER);

        JPanel page = Ui.page(main, "View Batches", "All batches registered in the system",
                center, Main.HOME);
        setLayout(new BorderLayout());
        setBackground(Ui.BG);
        add(page, BorderLayout.CENTER);
    }

    @Override
    public void refresh() {
        model.setRowCount(0);
        for (Batch batch : Database.get().getBatches()) {
            model.addRow(new Object[]{
                    batch.toString(),
                    Database.get().studentCountInBatch(batch.getBatchNumber()),
                    batch.getStatusText()
            });
        }
    }
}
