import java.io.*;
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

class Scanner{
	public static void main(String[] args) {
		String line="S0001,Nimal,76,45";
		String[] rowData=line.split(",");
		String id=rowData[0];
		String name=rowData[1];
		int prfMarks=Integer.parseInt(rowData[2]);
		int dbmsMarks=Integer.parseInt(rowData[3]);
		
		Student s1=new Student(id,name,prfMarks,dbmsMarks);
		System.out.println(s1.toString());
	}
}
