package Polymorphism;

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
		return "["+id+","+name+","+prfMarks+","+dbmsMarks+"]";
	}
	public String getId(){
		return id;
	}
}
class StudentCollection{
	private Student[] studentArray=new Student[0];
	
	public void add(Student student){
		extendsArray();
		studentArray[studentArray.length-1]=student;
	}
	public void printStudents(){
		System.out.print("{");
		for (int i = 0; i < studentArray.length; i++){
			System.out.print(studentArray[i].toString()+", ");
		}
		System.out.println("\b\b}");
	}
	private void extendsArray(){
		Student[] tempDataArray=new Student[studentArray.length+1];
		for (int i = 0; i < studentArray.length; i++){
			tempDataArray[i]=studentArray[i];
		}
		studentArray=tempDataArray;
	}
	public boolean add(int index, Student student){
		if(index>=0 && index<=studentArray.length){
			Student[] tempDataArray=new Student[studentArray.length+1];
			for (int i = 0; i < studentArray.length; i++){
				tempDataArray[i]=studentArray[i];
			}
			for (int i = tempDataArray.length-1; i>index; i--){
				tempDataArray[i]=tempDataArray[i-1];
			}
			tempDataArray[index]=student;
			studentArray=tempDataArray;
			return true;
		}
		return false;
	}
	public boolean remove(int index){
		if(index>=0 && index<studentArray.length){
			for (int i = index; i <studentArray.length-1; i++){
				studentArray[i]=studentArray[i+1];
			}
			Student[] tempDataArray=new Student[studentArray.length-1];
			for (int i = 0; i < tempDataArray.length; i++){
				tempDataArray[i]=studentArray[i];
			}
			studentArray=tempDataArray;
			return true;
		}
		return false;	
	}
	public boolean isEmpty(){
		return studentArray.length==0;		
	} 
	public int size(){
		return studentArray.length;
	}
	public Student get(int index){
		if(index>=0 && index<studentArray.length){
			return studentArray[index];
		}
		return null; //or throw an Exception
	}
	public boolean addFirst(Student student){
		return add(0,student);	
	}
	public boolean addLast(Student student){
		return add(studentArray.length,student);
	}
	public boolean removeFirst(){
		return remove(0);
	}
	public boolean removeLast(){
		return remove(studentArray.length-1);
	}
}

class Ex5 {
	public static void main(String args[]){
		StudentCollection studentCollection=new StudentCollection();
		studentCollection.add(new Student("S0001","Nimal",56,87));
		studentCollection.add(new Student("S0002","Amal",76,97));
		studentCollection.add(new Student("S0003","Bimal",36,47));
		studentCollection.add(new Student("S0004","Ranil",96,97));
		
		studentCollection.printStudents();//{[S0001,Nimal,56,87],[S0002,Amal,76,97]....]
	}
}

