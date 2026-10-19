// Lazy singleton accessor for the one StudentCollection instance.
// (Split out of the old ExStd1.java.)
class AccessStudentCollection {
	private static StudentCollection studentCollection;
	public static StudentCollection getStudentCollection(){
		if(studentCollection==null){
			studentCollection=new StudentCollection();
		}
		return studentCollection;
	}
}