package Collection;

// IntegerCollection3 - insert and remove by index, with bounds checks and a
// shrinkArray() helper that drops the last slot after a left shift.
// (Split out of Ex3.java; renamed from IntegerCollection, which also appears
// in Ex1.java and Ex2.java in this package.)
class IntegerCollection3 {
    private int[] dataArray = new int[0];

    public void add(int data) {
        extendsArray();
        dataArray[dataArray.length - 1] = data;
    }

    public void add(int index, int data) {
        if (index < 0 || index > dataArray.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + dataArray.length);
        }
        extendsArray();
        // shift elements right, starting from the end
        for (int i = dataArray.length - 1; i > index; i--) {
            dataArray[i] = dataArray[i - 1];
        }
        dataArray[index] = data;
    }

    public void remove(int index) {
        if (index < 0 || index >= dataArray.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + dataArray.length);
        }
        // shift elements left over the removed one
        for (int i = index; i < dataArray.length - 1; i++) {
            dataArray[i] = dataArray[i + 1];
        }
        shrinkArray();
    }

    public void printData() {
        System.out.print("[");
        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);
            if (i < dataArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private void extendsArray() {
        int[] tempDataArray = new int[dataArray.length + 1];
        for (int i = 0; i < dataArray.length; i++) {
            tempDataArray[i] = dataArray[i];
        }
        dataArray = tempDataArray;
    }

    private void shrinkArray() {
        int[] tempDataArray = new int[dataArray.length - 1];
        for (int i = 0; i < tempDataArray.length; i++) {
            tempDataArray[i] = dataArray[i];
        }
        dataArray = tempDataArray;
    }
}