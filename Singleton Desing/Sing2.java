import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Student{
	private String id;
	private String name;
	private int prfMarks;
	private int dbmsMarks;
	
	public Student(String id, String name, int prfMarks, int dbmsMarks){
		this.id=id;
		this.name=name;
		this.prfMarks=prfMarks;
		this.dbmsMarks=dbmsMarks;
	}
	public String toString(){
		return id+"\t"+name+"\t"+prfMarks+"\t"+dbmsMarks;
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public int getPrfMarks(){
		return prfMarks;
	}
	public int getDbmsMarks(){
		return dbmsMarks;
	}
}
class StudentCollection{
	private Student[] studentArray=new Student[]{
		new Student("S0001","Nimal",76,55),
		new Student("S0002","Bimal",96,75),
		new Student("S0003","Amal",26,95),
		new Student("S0004","Nioth",86,55),
	};	
	public boolean addNewStudent(Student student){
		extendsStudentArray();
		studentArray[studentArray.length-1]=student;		
		return true;
	}
	public Student[] getAllStudent(){
		Student[] tempStudentArray=new Student[studentArray.length];
		for (int i = 0; i < studentArray.length; i++){
			tempStudentArray[i]=studentArray[i];
		}
		return tempStudentArray;
	}
	public Student searchStudent(String id){
		for (int i = 0; i < studentArray.length; i++){
			if(id.equalsIgnoreCase(studentArray[i].getId())){
				return studentArray[i];
			}
		}
		return null;
	}
	private void extendsStudentArray(){
		Student[] tempStudentArray=new Student[studentArray.length+1];
		for (int i = 0; i < studentArray.length; i++){
			tempStudentArray[i]=studentArray[i];
		}
		studentArray=tempStudentArray;
	}
	public int search(Student student){
		for (int i = 0; i < studentArray.length; i++){
			if(student.getId().equalsIgnoreCase(studentArray[i].getId())){
				return i;
			}
		}
		return -1;
	}
	public boolean updateStudent(Student student){
		int index=search(student);
		if(index!=-1){
			studentArray[index]=student;
			return true;
		}
		return false;
	}
}

class AccessStudentCollection{
	private StudentCollection studentCollection;
	
	private static AccessStudentCollection accessStudentCollection;
	private AccessStudentCollection(){
		studentCollection=new StudentCollection();
	}
	public static AccessStudentCollection getInstance(){
		if(accessStudentCollection==null){
			accessStudentCollection=new AccessStudentCollection();
		}
		return accessStudentCollection;
	}
	public StudentCollection getStudentCollection(){
		return studentCollection;
	}
}

class AddStudentForm extends JFrame{
    private static final long serialVersionUID = 1L;

	private JTextField txtId;	
	private JTextField txtName;	
	private JTextField txtPrfMarks;	
	private JTextField txtDbmsMarks;	
	
	private JButton btnAdd;
	private JButton btnCancel;
	
	AddStudentForm(){
		setTitle("Add Student Form");
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add Student");
		btnAdd.setFont(new Font("",1,20));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Create a Student Object
				String id=txtId.getText();
				String name=txtName.getText();
				int prfMarks=Integer.parseInt(txtPrfMarks.getText());
				int dbmsMarks=Integer.parseInt(txtDbmsMarks.getText());
				Student s1=new Student(id,name,prfMarks,dbmsMarks);
				AccessStudentCollection accSt=AccessStudentCollection.getInstance();
				boolean isAdded=accSt.getStudentCollection().addNewStudent(s1);
				if(isAdded){
					JOptionPane.showMessageDialog(null,"Added Success");
				}
			}
		});
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		buttonPanel.add(btnAdd);
		buttonPanel.add(btnCancel);
		add("South",buttonPanel);
		
		JLabel lblTitle=new JLabel("Add New Student Form");
		lblTitle.setFont(new Font("",1,28));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtPrfMarks=new JTextField(3);
		txtPrfMarks.setFont(new Font("",1,20));
		JPanel prfTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		prfTextPanel.add(txtPrfMarks);
		textPanel.add(prfTextPanel);
		
		txtDbmsMarks=new JTextField(3);
		txtDbmsMarks.setFont(new Font("",1,20));
		JPanel dbmsTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbmsTextPanel.add(txtDbmsMarks);
		textPanel.add(dbmsTextPanel);

		add("East",textPanel);
		
		JLabel lblId=new JLabel("Student ID");	
		lblId.setFont(new Font("",1,20));
		JLabel lblName=new JLabel("Name");	
		lblName.setFont(new Font("",1,20));
		JLabel lblPrfMarks=new JLabel("PRF Marks");	
		lblPrfMarks.setFont(new Font("",1,20));
		JLabel lblDbmsMarks=new JLabel("DBMS Marks");	
		lblDbmsMarks.setFont(new Font("",1,20));
		JPanel labelPanel=new JPanel(new GridLayout(4,1,4,4));	
		labelPanel.add(lblId);
		labelPanel.add(lblName);	
		labelPanel.add(lblPrfMarks);	
		labelPanel.add(lblDbmsMarks);
		add("West",labelPanel);
	}
	public static void main(String arhs[]){
		new AddStudentForm().setVisible(true);
	}
}

class SearchStudentForm extends JFrame{
    private static final long serialVersionUID = 1L;

	private JTextField txtId;	
	private JTextField txtName;	
	private JTextField txtPrfMarks;	
	private JTextField txtDbmsMarks;	
	
	private JButton btnSearch;
	private JButton btnCancel;
	
	SearchStudentForm(){
		setTitle("Search Student Form");
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnSearch=new JButton("Search Student");
		btnSearch.setFont(new Font("",1,20));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				Student student=AccessStudentCollection.getInstance().getStudentCollection().searchStudent(id);
				if(student==null){
					JOptionPane.showMessageDialog(null,id+" student not found...");
				}else{
					txtName.setText(student.getName());
					txtPrfMarks.setText(student.getPrfMarks()+"");
					txtDbmsMarks.setText(student.getDbmsMarks()+"");
				}
			}
		});
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		buttonPanel.add(btnSearch);
		buttonPanel.add(btnCancel);
		add("South",buttonPanel);
		
		JLabel lblTitle=new JLabel("Search Student Form");
		lblTitle.setFont(new Font("",1,28));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtPrfMarks=new JTextField(3);
		txtPrfMarks.setFont(new Font("",1,20));
		JPanel prfTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		prfTextPanel.add(txtPrfMarks);
		textPanel.add(prfTextPanel);
		
		txtDbmsMarks=new JTextField(3);
		txtDbmsMarks.setFont(new Font("",1,20));
		JPanel dbmsTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbmsTextPanel.add(txtDbmsMarks);
		textPanel.add(dbmsTextPanel);

		add("East",textPanel);
		
		JLabel lblId=new JLabel("Student ID");	
		lblId.setFont(new Font("",1,20));
		JLabel lblName=new JLabel("Name");	
		lblName.setFont(new Font("",1,20));
		JLabel lblPrfMarks=new JLabel("PRF Marks");	
		lblPrfMarks.setFont(new Font("",1,20));
		JLabel lblDbmsMarks=new JLabel("DBMS Marks");	
		lblDbmsMarks.setFont(new Font("",1,20));
		JPanel labelPanel=new JPanel(new GridLayout(4,1,4,4));	
		labelPanel.add(lblId);
		labelPanel.add(lblName);	
		labelPanel.add(lblPrfMarks);	
		labelPanel.add(lblDbmsMarks);
		add("West",labelPanel);
	}
}

class UpdateStudentForm extends JFrame{
    private static final long serialVersionUID = 1L;

	private JTextField txtId;	
	private JTextField txtName;	
	private JTextField txtPrfMarks;	
	private JTextField txtDbmsMarks;	
	
	private JButton btnUpdate;
	private JButton btnCancel;
	
	UpdateStudentForm(){
		setTitle("Update Student Form");
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnUpdate=new JButton("Update");
		btnUpdate.setFont(new Font("",1,20));
		btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				int prfMarks=Integer.parseInt(txtPrfMarks.getText());
				int dbmsMarks=Integer.parseInt(txtDbmsMarks.getText());
				Student student=new Student(id,name,prfMarks,dbmsMarks);	
				boolean isUpdate=AccessStudentCollection.getInstance().getStudentCollection().updateStudent(student);
				if(isUpdate){
					JOptionPane.showMessageDialog(null,"Update Success");
				}else{
					JOptionPane.showMessageDialog(null,"Update Fail");
				}
			}
		});
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		buttonPanel.add(btnUpdate);
		buttonPanel.add(btnCancel);
		add("South",buttonPanel);
		
		JLabel lblTitle=new JLabel("Update Student Form");
		lblTitle.setFont(new Font("",1,28));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtId.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				Student student=AccessStudentCollection.getInstance().getStudentCollection().searchStudent(id);
				if(student==null){
					JOptionPane.showMessageDialog(null,id+" student not found...");
				}else{
					txtName.setText(student.getName());
					txtPrfMarks.setText(student.getPrfMarks()+"");
					txtDbmsMarks.setText(student.getDbmsMarks()+"");
				}
			}
		});
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtPrfMarks=new JTextField(3);
		txtPrfMarks.setFont(new Font("",1,20));
		JPanel prfTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		prfTextPanel.add(txtPrfMarks);
		textPanel.add(prfTextPanel);
		
		txtDbmsMarks=new JTextField(3);
		txtDbmsMarks.setFont(new Font("",1,20));
		JPanel dbmsTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbmsTextPanel.add(txtDbmsMarks);
		textPanel.add(dbmsTextPanel);

		add("East",textPanel);
		
		JLabel lblId=new JLabel("Student ID");	
		lblId.setFont(new Font("",1,20));
		JLabel lblName=new JLabel("Name");	
		lblName.setFont(new Font("",1,20));
		JLabel lblPrfMarks=new JLabel("PRF Marks");	
		lblPrfMarks.setFont(new Font("",1,20));
		JLabel lblDbmsMarks=new JLabel("DBMS Marks");	
		lblDbmsMarks.setFont(new Font("",1,20));
		JPanel labelPanel=new JPanel(new GridLayout(4,1,4,4));	
		labelPanel.add(lblId);
		labelPanel.add(lblName);	
		labelPanel.add(lblPrfMarks);	
		labelPanel.add(lblDbmsMarks);
		add("West",labelPanel);
	}
}

class DeleteStudentForm extends JFrame{
    private static final long serialVersionUID = 1L;

	private JTextField txtId;	
	private JTextField txtName;	
	private JTextField txtPrfMarks;	
	private JTextField txtDbmsMarks;	
	
	private JButton btnDelete;
	private JButton btnCancel;
	
	DeleteStudentForm(){
		setTitle("Delete Student Form");
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnDelete=new JButton("Delete");
		btnDelete.setFont(new Font("",1,20));
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnCancel);
		add("South",buttonPanel);
		
		JLabel lblTitle=new JLabel("Delete Student Form");
		lblTitle.setFont(new Font("",1,28));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtPrfMarks=new JTextField(3);
		txtPrfMarks.setFont(new Font("",1,20));
		JPanel prfTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		prfTextPanel.add(txtPrfMarks);
		textPanel.add(prfTextPanel);
		
		txtDbmsMarks=new JTextField(3);
		txtDbmsMarks.setFont(new Font("",1,20));
		JPanel dbmsTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbmsTextPanel.add(txtDbmsMarks);
		textPanel.add(dbmsTextPanel);

		add("East",textPanel);
		
		JLabel lblId=new JLabel("Student ID");	
		lblId.setFont(new Font("",1,20));
		JLabel lblName=new JLabel("Name");	
		lblName.setFont(new Font("",1,20));
		JLabel lblPrfMarks=new JLabel("PRF Marks");	
		lblPrfMarks.setFont(new Font("",1,20));
		JLabel lblDbmsMarks=new JLabel("DBMS Marks");	
		lblDbmsMarks.setFont(new Font("",1,20));
		JPanel labelPanel=new JPanel(new GridLayout(4,1,4,4));	
		labelPanel.add(lblId);
		labelPanel.add(lblName);	
		labelPanel.add(lblPrfMarks);	
		labelPanel.add(lblDbmsMarks);
		add("West",labelPanel);
	}
}

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
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				Student[] studentArray=AccessStudentCollection.getInstance().getStudentCollection().getAllStudent();
				for (int i = 0; i < studentArray.length; i++){
					Student student=studentArray[i];
					Object[] rowData={student.getId(),student.getName(),student.getPrfMarks(),student.getDbmsMarks()};
					dtm.addRow(rowData);
				}
			}
		});

		buttonPanel.add(btnReload);
		add("South",buttonPanel);
		
		String[] columnsName={"Id","Name","PRF","DBMS"};
		dtm=new DefaultTableModel(columnsName,0);
		tblStudentDetails=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblStudentDetails);
		add("Center",tablePane);
	}
	public static void main(String args[]){
		new ViewStudentDetailsForm().setVisible(true);
	}
}

class StudentMainForm extends JFrame{
    private static final long serialVersionUID = 1L;

	private JButton btnAddStudentForm;
	private JButton btnSearchStudentForm;
	private JButton btnUpdateStudentForm;
	private JButton btnDeleteStudentForm;
	private JButton btnViewStudentDetailsForm;
	private JButton btnExit;
	
	private AddStudentForm addStudentForm;
	private ViewStudentDetailsForm viewStudentDetailsForm;
	private SearchStudentForm searchStudentForm;
	private UpdateStudentForm updateStudentForm;
	

	StudentMainForm(){
		setTitle("Student Main Form");
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		btnAddStudentForm=new JButton("Add Student Form");
		btnAddStudentForm.setFont(new Font("",1,20));
		btnAddStudentForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addStudentForm==null){
					addStudentForm=new AddStudentForm();
				}
				addStudentForm.setVisible(true);
			}
		});
		add(btnAddStudentForm);
		btnSearchStudentForm=new JButton("Search Student Form");
		btnSearchStudentForm.setFont(new Font("",1,20));
		btnSearchStudentForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchStudentForm==null){
					searchStudentForm=new SearchStudentForm();
				}
				searchStudentForm.setVisible(true);
			}
		});
		add(btnSearchStudentForm);
		btnUpdateStudentForm=new JButton("Update Student Form");
		btnUpdateStudentForm.setFont(new Font("",1,20));
		btnUpdateStudentForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateStudentForm==null){
					updateStudentForm=new UpdateStudentForm();
				}
				updateStudentForm.setVisible(true);
			}
		});
		add(btnUpdateStudentForm);
		btnDeleteStudentForm=new JButton("Delete Student Form");
		btnDeleteStudentForm.setFont(new Font("",1,20));
		add(btnDeleteStudentForm);
		btnViewStudentDetailsForm=new JButton("View Student Details Form");
		btnViewStudentDetailsForm.setFont(new Font("",1,20));
		btnViewStudentDetailsForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewStudentDetailsForm==null){
					viewStudentDetailsForm=new ViewStudentDetailsForm();
				}
				viewStudentDetailsForm.setVisible(true);
			}
		});
		add(btnViewStudentDetailsForm);
		btnExit=new JButton("Add Student Form");
		btnExit.setFont(new Font("",1,20));
		add(btnExit);
	}
	public static void main(String arg[]){
		new StudentMainForm().setVisible(true);
	}
}
