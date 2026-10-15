package Polymorphism;

class IntegerCollection {
    private int[] dataArray = new int[0];

    public void add(int data) {
        int[] newArray = new int[dataArray.length + 1];
        for (int i = 0; i < dataArray.length; i++) {
            newArray[i] = dataArray[i];
        }
        newArray[dataArray.length] = data;
        dataArray = newArray;
    }

    public int size() {
        return dataArray.length;
    }

    public int get(int index) {
        if (index < 0 || index >= dataArray.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + dataArray.length);
        }
        return dataArray[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= dataArray.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + dataArray.length);
        }

        int[] newArray = new int[dataArray.length - 1];
        for (int i = 0, j = 0; i < dataArray.length; i++) {
            if (i != index) {
                newArray[j++] = dataArray[i];
            }
        }
        dataArray = newArray;
    }

    public void printData() {
        System.out.print("[");
        for (int i = 0; i < dataArray.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(dataArray[i]);
        }
        System.out.println("]");
    }

    // public void add(int index ,int data){
    // for(int)
    // } 
}
class CollectionEx1 {
    public static void main(String[] args) {
        IntegerCollection intC = new IntegerCollection();
        intC.add(10);
        intC.add(20);
        intC.add(30);
        intC.add(40);
        intC.add(50);
        // int.add(2,25);
        intC.printData(); // [10,20,30,40,50]
    }
}

