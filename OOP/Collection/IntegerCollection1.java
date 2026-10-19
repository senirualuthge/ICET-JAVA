package Collection;

// IntegerCollection1 - the first hand-rolled dynamic array: add() at the end
// and an overloaded add(index, data) that shifts elements to make room.
// (Split out of Ex1.java; renamed from IntegerCollection, which also appears
// in Ex2.java and Ex3.java in this package.)
class IntegerCollection1 {
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