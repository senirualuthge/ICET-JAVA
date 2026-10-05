package studentMarkManagementMystem;
public class StudentCollection{
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
