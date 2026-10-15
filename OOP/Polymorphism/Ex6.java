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
class Collection{
	private Object[] objArray=new Object[0];
	
	public void add(Object obj){
		extendsArray();
		objArray[objArray.length-1]=obj;
	}
	public void printCollection(){
		System.out.print("{");
		for (int i = 0; i < objArray.length; i++){
			System.out.print(objArray[i].toString()+", ");
		}
		System.out.println("\b\b}");
	}
	private void extendsArray(){
		Object[] tempObjArray=new Object[objArray.length+1];
		for (int i = 0; i < objArray.length; i++){
			tempObjArray[i]=objArray[i];
		}
		objArray=tempObjArray;
	}
	public boolean add(int index, Object obj){
		if(index>=0 && index<=objArray.length){
			Object[] tempObjArray=new Object[objArray.length+1];
			for (int i = 0; i < objArray.length; i++){
				tempObjArray[i]=objArray[i];
			}
			for (int i = tempObjArray.length-1; i>index; i--){
				tempObjArray[i]=tempObjArray[i-1];
			}
			tempObjArray[index]=obj;
			objArray=tempObjArray;
			return true;
		}
		return false;
	}
	public boolean remove(int index){
		if(index>=0 && index<objArray.length){
			for (int i = index; i <objArray.length-1; i++){
				objArray[i]=objArray[i+1];
			}
			Object[] tempObjArray=new Object[objArray.length-1];
			for (int i = 0; i < tempObjArray.length; i++){
				tempObjArray[i]=objArray[i];
			}
			objArray=tempObjArray;
			return true;
		}
		return false;	
	}
	public boolean isEmpty(){
		return objArray.length==0;		
	} 
	public int size(){
		return objArray.length;
	}
	public Object get(int index){
		if(index>=0 && index<objArray.length){
			return objArray[index];
		}
		return null; //or throw an Exception
	}
	public boolean addFirst(Object obj){
		return add(0,obj);	
	}
	public boolean addLast(Object obj){
		return add(objArray.length,obj);
	}
	public boolean removeFirst(){
		return remove(0);
	}
	public boolean removeLast(){
		return remove(objArray.length-1);
	}
}

class Ex6 {
	public static void main(String args[]){
		Collection studentCollection=new Collection();
		studentCollection.add(new Student("S0001","Nimal",56,87));
		studentCollection.add(new Student("S0002","Amal",76,97));
		studentCollection.add(new Student("S0003","Bimal",36,47));
		studentCollection.add(new Student("S0004","Ranil",96,97));
		studentCollection.printCollection();//{[S0001,Nimal,56,87],[S0002,Amal,76,97]....]
		
		Collection integerCollection=new Collection();
		integerCollection.add(10);
		integerCollection.add(20);
		integerCollection.add(30);
		integerCollection.add(40);
		integerCollection.add(50);
		integerCollection.printCollection();//[10,20,30,40,50]
	}
}
