package Collection;

// Student4 - entity used by StudentCollection4.
// (Split out of Ex4.java; renamed from Student, which also appears in
// Ex5.java in this package.)
class Student4 {
	private String id;
	private String name;
	private int prfMarks;
	private int dbmsMarks;
	public Student4(String id, String name, int prfMarks, int dbmsMarks){
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