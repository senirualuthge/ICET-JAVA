package Polymorphism;

class IntegerCollection {
    private int[] dataArray=new int[0];

    public void add(int data){
        int[] newArray=new int[dataArray.length+1];
        for(int i=0;i<dataArray.length;i++){
            newArray[i]=dataArray[i];
        }
        newArray[dataArray.length]=data;
        dataArray=newArray;
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
    public void add(int index, int data){
        // not implemented yet
    }
}

class CollectionEx1{
    public static void main(String[] args) {
        IntegerCollection intC=new IntegerCollection();
        intC.add(10);
        intC.add(20);
        intC.add(30);
        intC.add(40);
        intC.add(50);
        intC.printData();
    }
}
