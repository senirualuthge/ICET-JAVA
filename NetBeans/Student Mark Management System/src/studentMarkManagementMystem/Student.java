package studentMarkManagementMystem;

public class Student{
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
		return id+","+name+","+prfMarks+","+dbmsMarks;
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

