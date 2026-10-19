import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

// Swing view over StudentCollection, via AccessStudentCollection.
// (Split out of the old ExStd1.java, which also carried a large commented-out
// duplicate of the whole exercise - that dead code has been dropped.)
public final class ViewStudentDetailsForm extends JFrame {
    private static final long serialVersionUID = 1L;

    private final JTable tblStudentDetails;
    private final DefaultTableModel dtm;

    private ViewStudentDetailsForm() {
        setTitle("View Student Form");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        final JLabel lblTitle = new JLabel("View Student Details Form");
        lblTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        add("North", lblTitle);

        final JPanel buttonPanel = new JPanel(); // default layout -> FlowLayout(CENTER)
        final JButton btnReload = new JButton("Reload");
        btnReload.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        btnReload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dtm.setRowCount(0);
                ExStd1[] studentArray = AccessStudentCollection.getStudentCollection()
                        .getAllStudent();
                for (int i = 0; i < studentArray.length; i++) {
                    ExStd1 student = studentArray[i];
                    Object[] rowData = { student.getId(), student.getName(),
                            student.getPrfMarks(), student.getDbmsMarks() };
                    dtm.addRow(rowData);
                }
            }
        });

        buttonPanel.add(btnReload);
        add("South", buttonPanel);

        final String[] columnsName = { "Id", "Name", "PRF", "DBMS" };
        dtm = new DefaultTableModel(columnsName, 0);
        tblStudentDetails = new JTable(dtm);
        tblStudentDetails.setEnabled(false); // read-only view: no cell editing, no column reordering
        tblStudentDetails.setAutoCreateRowSorter(true);
        final JScrollPane tablePane = new JScrollPane(tblStudentDetails);
        add("Center", tablePane);
    }

    public static void main(String args[]) {
        // Swing components must be created and shown on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewStudentDetailsForm().setVisible(true);
            }
        });
    }
}
