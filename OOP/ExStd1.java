import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

class ExStd1{
	private String id;
	private String name;
	private int prfMarks;
	private int dbmsMarks;
	
	public ExStd1(String id, String name, int prfMarks, int dbmsMarks){
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
	private ExStd1[] studentArray=new ExStd1[]{
		new ExStd1("S0001","Nimal",76,55),
		new ExStd1("S0002","Bimal",96,75),
		new ExStd1("S0003","Amal",26,95),
		new ExStd1("S0004","Nioth",86,55),
	};	
	public boolean addNewStudent(ExStd1 student){
		extendsStudentArray();
		studentArray[studentArray.length-1]=student;		
		return true;
	}
	public ExStd1[] getAllStudent(){
		ExStd1[] tempStudentArray=new ExStd1[studentArray.length];
		for (int i = 0; i < studentArray.length; i++){
			tempStudentArray[i]=studentArray[i];
		}
		return tempStudentArray;
	}
	public ExStd1 searchStudent(String id){
		for (int i = 0; i < studentArray.length; i++){
			if(id.equalsIgnoreCase(studentArray[i].getId())){
				return studentArray[i];
			}
		}
		return null;
	}
	private void extendsStudentArray(){
		ExStd1[] tempStudentArray=new ExStd1[studentArray.length+1];
		for (int i = 0; i < studentArray.length; i++){
			tempStudentArray[i]=studentArray[i];
		}
		studentArray=tempStudentArray;
	}
	public int search(ExStd1 student){
		for (int i = 0; i < studentArray.length; i++){
			if(student.getId().equalsIgnoreCase(studentArray[i].getId())){
				return i;
			}
		}
		return -1;
	}
	public boolean updateStudent(ExStd1 student){
		int index=search(student);
		if(index!=-1){
			studentArray[index]=student;
			return true;
		}
		return false;
	}
}

class AccessStudentCollection{
	private static StudentCollection studentCollection;
	public static StudentCollection getStudentCollection(){
		if(studentCollection==null){
			studentCollection=new StudentCollection();
		}
		return studentCollection;
	}
}

class ViewStudentDetailsForm extends JFrame{
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
				ExStd1[] studentArray=AccessStudentCollection.getStudentCollection().getAllStudent();
				for (int i = 0; i < studentArray.length; i++){
					ExStd1 student=studentArray[i];
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

/*class Student{
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
	private static StudentCollection studentCollection;
	public static StudentCollection getStudentCollection(){
		if(studentCollection==null){
			studentCollection=new StudentCollection();
		}
		return studentCollection;
	}
}

class AccessStudentCollection{
	private static StudentCollection studentCollection;
	public static StudentCollection getStudentCollection(){
		if(studentCollection==null){
			studentCollection=new StudentCollection();
		}
		return studentCollection;
	}
}


import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
class ViewStudentDetailsForm extends JFrame{
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
				Student[] studentArray=AccessStudentCollection.getStudentCollection().getAllStudent();
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

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
class ViewStudentDetailsForm extends JFrame{
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
				Student[] studentArray=AccessStudentCollection.getStudentCollection().getAllStudent();
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
 */ 