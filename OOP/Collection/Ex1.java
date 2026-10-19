package Collection;

// Exercises IntegerCollection1: append, then insert in the middle.
// Run: bash ../../run.sh Collection.Ex1
class Ex1 {
    public static void main(String[] args) {
        IntegerCollection1 intC = new IntegerCollection1();
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