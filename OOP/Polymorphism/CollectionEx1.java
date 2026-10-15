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

    // Overloaded: insert data at a specific index
    public void add(int index, int data) {
        if (index < 0 || index > dataArray.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + dataArray.length);
        }
        int[] newArray = new int[dataArray.length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = dataArray[i];
        }
        newArray[index] = data;
        for (int i = index; i < dataArray.length; i++) {
            newArray[i + 1] = dataArray[i];
        }
        dataArray = newArray;
    }

    public void printData() {
        if (dataArray.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);
            if (i < dataArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int size() {
        return dataArray.length;
    }

    public int get(int index) {
        return dataArray[index];
    }
}

class CollectionEx1 {
    public static void main(String[] args) {
        IntegerCollection intC = new IntegerCollection();
        intC.add(10);
        intC.add(20);
        intC.add(30);
        intC.add(40);
        intC.add(50);
        intC.printData();   // [10, 20, 30, 40, 50]

        intC.add(2, 25);    // insert 25 at index 2
        intC.printData();   // [10, 20, 25, 30, 40, 50]
    }
}