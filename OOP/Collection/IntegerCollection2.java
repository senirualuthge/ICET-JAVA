package Collection;

// IntegerCollection2 - a dynamic array grown by a private extendsArray()
// helper, plus size() and get().
// (Split out of Ex2.java; renamed from IntegerCollection, which also appears
// in Ex1.java and Ex3.java in this package.)
class IntegerCollection2 {
	private int[] dataArray=new int[0];

	public void add(int data){
		extendsArray();
		dataArray[dataArray.length-1]=data;
	}
	public void printData(){
		System.out.print("[");
		for (int i = 0; i < dataArray.length; i++){
			System.out.print(dataArray[i]+", ");
		}
		System.out.println("\b\b]");
	}
	public int size(){
		return dataArray.length;
	}
	public int get(int index){
		return dataArray[index];
	}
	private void extendsArray(){
		int[] tempDataArray=new int[dataArray.length+1];
		for (int i = 0; i < dataArray.length; i++){
			tempDataArray[i]=dataArray[i];
		}
		dataArray=tempDataArray;
	}
	public void add(int index, int data){

	}

}