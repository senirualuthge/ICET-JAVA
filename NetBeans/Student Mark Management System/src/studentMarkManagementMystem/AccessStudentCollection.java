package studentMarkManagementMystem;
public class AccessStudentCollection{
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
