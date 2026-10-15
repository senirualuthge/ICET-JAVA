package Polymorphism;

class IntegerCollection{
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
class CollectionEx2{
	public static void main(String[] args) {
		IntegerCollection intC=new IntegerCollection();
		intC.add(10);
		intC.add(20);
		intC.add(30);
		intC.add(40);
		intC.add(50);
		for(int i=0; i<intC.size(); i++){
			System.out.println("Index at "+i+" : "+intC.get(i));
		}
	}
}
/*
0 : 10
1 : 20
2 : 30
3 : 40
4 : 50
*/

