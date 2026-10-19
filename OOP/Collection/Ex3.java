package Collection;

// Exercises IntegerCollection3: append, insert at an index, then remove.
// Run: bash ../../run.sh Collection.Ex3
class Ex3 {
    public static void main(String[] args) {
        IntegerCollection3 intC = new IntegerCollection3();
        intC.add(10);
        intC.add(20);
        intC.add(30);
        intC.add(40);
        intC.add(50);
        intC.printData(); // [10, 20, 30, 40, 50]

        intC.add(2, 25);
        intC.printData(); // [10, 20, 25, 30, 40, 50]

        intC.remove(2);
        intC.printData(); // [10, 20, 30, 40, 50]
    }
}