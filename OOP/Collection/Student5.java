package Collection;

// Student5 - entity used by StudentCollection5.
// (Split out of Ex5.java; renamed from Student, which also appears in
// Ex4.java in this package.)
class Student5 {
	private String id;
	private String name;
	private int prfMarks;
	private int dbmsMarks;
	public Student5(String id, String name, int prfMarks, int dbmsMarks){
		this.id=id;
		this.name=name;
		this.prfMarks=prfMarks;
		this.dbmsMarks=dbmsMarks;
	}
	public String toString(){
		return "["+id+","+name+","+prfMarks+","+dbmsMarks+"]";
	}
	public String getId(){
		return id;
	}
}