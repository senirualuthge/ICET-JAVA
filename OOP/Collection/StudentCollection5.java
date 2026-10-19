package Collection;

// StudentCollection5 - a full-featured collection over a plain array:
// add (append or at index), remove, get, size, isEmpty, addFirst/addLast,
// removeFirst/removeLast, each growing or shrinking the backing array.
// (Split out of Ex5.java; renamed from StudentCollection, which also appears
// in Ex4.java in this package.)
class StudentCollection5 {
	private Student5[] studentArray=new Student5[0];

	public void add(Student5 student){
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
		Student5[] tempDataArray=new Student5[studentArray.length+1];
		for (int i = 0; i < studentArray.length; i++){
			tempDataArray[i]=studentArray[i];
		}
		studentArray=tempDataArray;
	}
	public boolean add(int index, Student5 student){
		if(index>=0 && index<=studentArray.length){
			Student5[] tempDataArray=new Student5[studentArray.length+1];
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
			Student5[] tempDataArray=new Student5[studentArray.length-1];
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
	public Student5 get(int index){
		if(index>=0 && index<studentArray.length){
			return studentArray[index];
		}
		return null; //or throw an Exception
	}
	public boolean addFirst(Student5 student){
		return add(0,student);
	}
	public boolean addLast(Student5 student){
		return add(studentArray.length,student);
	}
	public boolean removeFirst(){
		return remove(0);
	}
	public boolean removeLast(){
		return remove(studentArray.length-1);
	}
}