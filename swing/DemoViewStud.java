import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
class ViewStudentDetailsForm extends JFrame{
    private static final long serialVersionUID = 1L;

	private JTable tblStudentDetails;
	private DefaultTableModel dtm;
	
	private JButton btnReload;
	
	ViewStudentDetailsForm(){
		setTitle("View Student Form");
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblTitle=new JLabel("View Student Details Form");
		lblTitle.setFont(new Font("",1,28));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel buttonPanel=new JPanel(); //default layout->FlowLayout(CENTER)
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,10));
		buttonPanel.add(btnReload);
		add("South",buttonPanel);
		
		String[] columnsName={"Id","Name","PRF","DBMS"};
		dtm=new DefaultTableModel(columnsName,0);
		tblStudentDetails=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblStudentDetails);
		add("Center",tablePane);
	}
}
class DemoViewStud{
	public static void main(String[] args) {
		new ViewStudentDetailsForm().setVisible(true);
	}
}

