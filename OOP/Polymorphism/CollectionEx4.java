package Polymorphism;

import java.util.ArrayList;

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
}
class StudentCollection {
	private final ArrayList<Student> students = new ArrayList<>();

	public void add(Student student) {
		students.add(student);
	}

	public void printStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
class CollectionEx4 {
	public static void main(String args[]){
		StudentCollection studentCollection=new StudentCollection();
		studentCollection.add(new Student("S0001","Nimal",56,87));
		studentCollection.add(new Student("S0002","Amal",76,97));
		studentCollection.add(new Student("S0003","Bimal",36,47));
		studentCollection.add(new Student("S0004","Ranil",96,97));
		
		studentCollection.printStudents();//{[S0001,Nimal,56,87],[S0002,Amal,76,97]....]
	}
}

