// The student entity used by the ExStd1 exercise and the Swing forms.
// (Split out of the old ExStd1.java, which held four classes in one file.)
class ExStd1 {
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