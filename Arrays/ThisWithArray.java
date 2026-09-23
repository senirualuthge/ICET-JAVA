import java.util.*;
public class ThisWithArray {

    private int[] data;          // instance field: the array belongs to THIS object
    private int size;            // instance field

    // Constructor 1: parameter has the SAME name as the field,
    // so "this.data" means "the field of THIS object",
    // and "data" alone means "the parameter".
    public ThisWithArray(int[] data) {
        this.data = data;        // this.data = field, data = parameter
        this.size = data.length; // this.size = field, data = parameter
    }

    // Constructor 2: "this(...)" calls the other constructor (constructor chaining).
    // this(...) must be the FIRST statement.
    public ThisWithArray(int[] data, int extra) {
        this(data);              // calls constructor 1 on THIS object
        this.size += extra;      // adds to the field
    }

    // Method that receives the array as a parameter with the same name again.
    public void replace(int[] data) {
        this.data = data;        // field = parameter (without "this" it would assign to itself)
    }

    // Returning "this" lets you chain calls: obj.fill(1).fill(2);
    public ThisWithArray fill(int value) {
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = value; // writing into THIS object's array
        }
        return this;             // returns the current object
    }

    // Passing "this" or "this.data" to another method.
    public void print() {
        System.out.println("Size: " + this.size + ", elements: " + java.util.Arrays.toString(this.data));
    }

    public static void main(String[] args) {
        // "this" CANNOT be used inside main: main is static,
        // so there is no "current object". We must create one first.
        ThisWithArray obj = new ThisWithArray(new int[]{10, 20, 30});

        obj.print();             // Size: 3, elements: [10, 20, 30]

        obj.replace(new int[]{1, 2, 3, 4});
        obj.print();             // Size: 3, elements: [1, 2, 3, 4]  (size not updated)

        obj.fill(7).print();     // chaining: fill then print -> [7, 7, 7, 7]

        ThisWithArray obj2 = new ThisWithArray(new int[]{5, 5}, 3);
        obj2.print();            // Size: 5, elements: [5, 5]
    }
}
