// Holds the students in a plain array and grows it on demand.
// (Split out of the old ExStd1.java.)
class StudentCollection {
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