import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * ===================================================================
 *  OOP STUDY GUIDE  (ICD122 / ICD125)  -  run it and READ the output
 * ===================================================================
 *  Compile :  javac OOPStudyGuide.java
 *  Run     :  java OOPStudyGuide          (console parts 1-4)
 *             java OOPStudyGuide gui      (also opens the JFrame demo, part 5)
 *
 *  Topics:
 *   1. Arrays + for loop:  length   vs   length-1
 *   2. Encapsulation + getters/setters
 *   3. Inheritance (extends, super(), overriding)
 *   4. Polymorphism (one reference type, many behaviours)
 *   5. Encapsulation + inheritance + polymorphism with JFrame
 *   6. Abstract classes
 *   7. Interfaces
 *   8. ArrayList (replaces the "grow the array by hand" code)
 *   9. Practice exercises WITH answers (try them first!)
 *
 *  HOW TO THINK when coding (the 4 questions):
 *   Q1. What DATA do I need to store?      -> fields (private)
 *   Q2. What can be DONE with that data?   -> methods (public)
 *   Q3. Do two classes share things?       -> inheritance (extends)
 *   Q4. Same action, different behaviour?  -> overriding + polymorphism
 * ===================================================================
 */

// ===================================================================
// MAIN
// ===================================================================
public class OOPStudyGuide {
    public static void main(String[] args) {
        ArrayLesson.run();
        EncapsulationLesson.run();
        InheritanceLesson.run();
        PolymorphismLesson.run();
        JFrameLesson.run(args.length > 0 && args[0].equals("gui"));
        AbstractLesson.run();
        InterfaceLesson.run();
        ArrayListLesson.run();
        PracticeAnswers.run();
    }
}

// ===================================================================
// PART 1 : ARRAYS AND LOOPS
// ===================================================================
class ArrayLesson {

    static void run() {
        System.out.println("=========== PART 1 : ARRAYS ===========");

        // STEP 1: create the array. "new int[5]" asks Java for 5 boxes in memory.
        // STEP 2: every box starts as 0. We then fill them one by one.
        int[] ar = new int[5];          // 5 boxes -> indexes 0,1,2,3,4
        ar[0] = 10; ar[1] = 20; ar[2] = 30; ar[3] = 40; ar[4] = 50;

        // RULE: length = how many items (5).  Last index = length - 1 (4).
        System.out.println("ar.length      = " + ar.length);        // 5
        System.out.println("last index     = " + (ar.length - 1));  // 4

        // ---- (A) i < ar.length  : visits EVERY element ----
        // i=0,1,2,3,4 ; when i becomes 5, 5<5 is false -> stop.
        System.out.print("i < length      : ");
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();                                        // 10 20 30 40 50

        // ---- (B) i < ar.length-1 : MISSES the last element ----
        // i=0,1,2,3 ; when i becomes 4, 4<4 is false -> stop. ar[4] never printed.
        System.out.print("i < length - 1  : ");
        for (int i = 0; i < ar.length - 1; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println("   <-- 50 is missing!");               // 10 20 30 40

        // ---- (C) i <= ar.length : CRASH (off-by-one) ----
        // i reaches 5 -> ar[5] does not exist.
        try {
            for (int i = 0; i <= ar.length; i++) {
                System.out.print(ar[i] + " ");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("\ni <= length     : CRASH -> " + ex.getMessage());
        }

        // ---- WHEN do we really use length-1 ? ----
        // When we compare an element with the NEXT one: ar[j] and ar[j+1].
        // j+1 must still be a valid index, so j must stop at length-2,
        // i.e.  j < length-1.   (This is the bubble sort in Q71 of the note.)
        System.out.println("\nBubble sort (descending) - why j < length-1 :");
        int[] marks = {56, 76, 36, 96};
        for (int i = 0; i < marks.length - 1; i++) {           // passes
            for (int j = 0; j < marks.length - 1; j++) {       // j+1 <= last index
                if (marks[j] < marks[j + 1]) {                 // compare neighbours
                    int temp = marks[j];                       // swap using temp
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
        for (int m : marks) System.out.print(m + " ");         // 96 76 56 36
        System.out.println();

        // Also: last index is used directly when ADDING to a grown array
        // (this is exactly extendsStudentArray() in the lecture note).
        int[] data = new int[3];
        data[0] = 1; data[1] = 2; data[2] = 3;
        int[] bigger = new int[data.length + 1];                // one more box
        for (int i = 0; i < data.length; i++) bigger[i] = data[i]; // copy old
        bigger[bigger.length - 1] = 4;                          // put new item at LAST index
        data = bigger;
        System.out.print("\nGrown array     : ");
        for (int d : data) System.out.print(d + " ");           // 1 2 3 4
        System.out.println("\n");

        /*
         * SUMMARY TABLE
         *   i < length       -> every element             (normal loop)
         *   i < length - 1   -> skips last element, OR used when you touch [i+1]
         *   i <= length      -> ArrayIndexOutOfBoundsException (bug)
         *   array[length-1]  -> the LAST element
         */
    }
}

// ===================================================================
// PART 2 : ENCAPSULATION + GETTER / SETTER
// ===================================================================
/*
 * Encapsulation = hide the data (private) + give controlled access
 * through public methods.  Nobody can put garbage into the object.
 *
 *   private int length;                 // hidden
 *   public void setLength(int l)        // SETTER : controlled WRITE
 *   public int  getLength()             // GETTER : controlled READ
 */
class Box {
    private int length;
    private int width;
    private int height;

    // Constructor: runs once when we write  new Box(...)
    public Box(int length, int width, int height) {
        set(length, width, height);       // reuse the setter (and its validation)
    }

    // Setter with VALIDATION - this is the real power of encapsulation
    public void setLength(int length) {
        if (length > 0) {
            this.length = length;         // this.length = field, length = parameter
        } else {
            System.out.println("  Rejected length " + length + " (must be > 0)");
        }
    }
    public void setWidth(int width)   { if (width  > 0) this.width  = width;  }
    public void setHeight(int height) { if (height > 0) this.height = height; }

    public void set(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public int getLength() { return length; }
    public int getWidth()  { return width;  }
    public int getHeight() { return height; }

    public int getVolume() { return length * width * height; }

    public String toString() {            // called by System.out.println(box)
        return "Box[" + length + "x" + width + "x" + height + "]";
    }
}

class EncapsulationLesson {
    static void run() {
        System.out.println("=========== PART 2 : ENCAPSULATION ===========");
        // STEP 1: "new Box(12,5,3)" -> Java makes the object, then runs the constructor.
        // STEP 2: the constructor calls set(...), which calls each setter (with validation).
        // STEP 3: println(b1) automatically calls b1.toString().
        Box b1 = new Box(12, 5, 3);
        System.out.println(b1 + " volume = " + b1.getVolume());      // 180

        // b1.length = 100;   // ILLEGAL: length is private
        b1.setLength(120);    // legal: goes through the setter
        b1.setLength(-5);     // setter protects the object
        System.out.println(b1 + " volume = " + b1.getVolume());      // 120x5x3 = 1800
        System.out.println();

        /*
         * Why  this.length = length ?
         *   Inside setLength(int length) the NAME "length" means the parameter.
         *   "this.length" means the field of the current object.
         *   Without "this", you write  length = length  (parameter to itself)
         *   and the field never changes  (Q13 in your note).
         */
    }
}

// ===================================================================
// PART 3 : INHERITANCE
// ===================================================================
/*
 * class B extends A   ->   B IS-A A
 *   - B automatically gets A's (non-private) fields and methods
 *   - B can add its own
 *   - B can override A's methods (same signature, new body)
 *   - Constructors: A's constructor ALWAYS runs first (super())
 */
class Vehicle {
    protected String id;                  // protected: subclasses can use it directly

    Vehicle(String id) {
        this.id = id;
        System.out.println("  Vehicle(" + id + ") constructor");
    }
    public void park() {                  // default behaviour
        System.out.println("  " + id + " : Vehicle parking");
    }
    public String getId() { return id; }
}

class Car extends Vehicle {
    private int doors;

    Car(String id, int doors) {
        super(id);                        // MUST be first line: builds the Vehicle part
        this.doors = doors;
        System.out.println("  Car(" + doors + " doors) constructor");
    }
    @Override                             // tells the compiler "I am overriding"
    public void park() {
        System.out.println("  " + id + " : Car parking (" + doors + " doors)");
    }
}

class Bus extends Vehicle {
    Bus(String id) { super(id); }
    @Override
    public void park() {
        System.out.println("  " + id + " : Bus parking (needs 2 slots)");
    }
}

class InheritanceLesson {
    static void run() {
        System.out.println("=========== PART 3 : INHERITANCE ===========");
        // STEP 1: new Car(...) starts the Car constructor.
        // STEP 2: its FIRST line super(id) jumps to the Vehicle constructor and runs it fully.
        // STEP 3: only then does the rest of the Car constructor run.
        // So the printed order is:  Vehicle(...)  then  Car(...)
        System.out.println("Creating a Car (watch the ORDER):");
        Car c1 = new Car("CAR-1", 4);     // Vehicle() first, then Car()
        c1.park();                        // Car's version (overridden)
        System.out.println("  inherited getId() -> " + c1.getId()); // came from Vehicle
        System.out.println();

        /*
         * If Vehicle had only  Vehicle(String id)  and Car had no super(id) call,
         * the compiler would insert  super();  and fail because Vehicle has no
         * no-arg constructor  (Q176-Q178 in your note).
         */
    }
}

// ===================================================================
// PART 4 : POLYMORPHISM
// ===================================================================
/*
 * Polymorphism = "many forms".
 *   Parent reference  +  child object   ->  the CHILD's method runs.
 *       Vehicle v = new Car(...);   v.park();   // Car's park()
 *   Java decides at RUNTIME which park() to run (dynamic method dispatch).
 *
 *   Benefit: CarPark only knows "Vehicle". Add Van tomorrow -> CarPark code
 *   does not change at all (extensibility).
 */
class CarPark {
    private Vehicle[] vehicles = new Vehicle[0];

    public void addVehicle(Vehicle v) {
        Vehicle[] temp = new Vehicle[vehicles.length + 1];   // grow by 1
        for (int i = 0; i < vehicles.length; i++) temp[i] = vehicles[i];
        temp[temp.length - 1] = v;                           // last index = length-1
        vehicles = temp;
    }
    public void parkAll() {
        for (Vehicle v : vehicles) {
            v.park();                     // SAME call, DIFFERENT behaviour
        }
    }
}

class PolymorphismLesson {
    static void run() {
        System.out.println("=========== PART 4 : POLYMORPHISM ===========");
        CarPark park = new CarPark();
        park.addVehicle(new Car("CAR-1", 4));   // child object stored as Vehicle
        park.addVehicle(new Bus("BUS-1"));
        park.addVehicle(new Car("CAR-2", 2));
        // STEP 1: the array type is Vehicle, but the real objects are Car, Bus, Car.
        // STEP 2: v.park() -> Java looks at the REAL object, not the variable type.
        // STEP 3: so Car's park(), then Bus's park(), then Car's park() run.
        System.out.println("\nparkAll():");
        park.parkAll();                         // Car, Bus, Car behaviours

        // Legal / illegal rules (Q180-Q183 in the note)
        Vehicle v = new Car("CAR-3", 4);        // legal  : child -> parent (auto)
        // Car c = new Vehicle("X");            // illegal: parent -> child
        // v.doors                              // illegal: Vehicle type doesn't know "doors"
        Car c = (Car) v;                        // legal  : cast back, object IS a Car
        System.out.println("\nCast back works: " + (c instanceof Car));
        System.out.println();
    }
}

// ===================================================================
// PART 5 : JFRAME = INHERITANCE + ENCAPSULATION + POLYMORPHISM
// ===================================================================
/*
 * Think of a form like any other class:
 *   - It EXTENDS JFrame            -> inheritance   (Calculator IS-A JFrame)
 *   - Components are PRIVATE       -> encapsulation (txtId, txtName ...)
 *   - Outside code uses getters / setters, never touches txtId directly
 *   - Button click uses an ActionListener -> polymorphism:
 *       addActionListener(ActionListener l)  accepts ANY object that is an ActionListener,
 *       and Java calls YOUR actionPerformed().
 */
class Student {
    private String id;
    private String name;
    private int prfMarks;
    private int dbmsMarks;

    Student(String id, String name, int prfMarks, int dbmsMarks) {
        this.id = id; this.name = name;
        this.prfMarks = prfMarks; this.dbmsMarks = dbmsMarks;
    }
    public String getId()      { return id; }
    public String getName()    { return name; }
    public int getPrfMarks()   { return prfMarks; }
    public int getDbmsMarks()  { return dbmsMarks; }
    public int getTotal()      { return prfMarks + dbmsMarks; }
    public String toString()   { return id + "\t" + name + "\t" + prfMarks + "\t" + dbmsMarks; }
}

class AddStudentForm extends JFrame {            // inheritance: AddStudentForm IS-A JFrame

    // ENCAPSULATION: all components private
    private JTextField txtId, txtName, txtPrf, txtDbms;
    private JButton btnAdd, btnClear;
    private JLabel lblResult;

    AddStudentForm() {
        // --- these methods are INHERITED from JFrame, so no "f1." needed ---
        setTitle("Add Student Form");
        setSize(420, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- build components ---
        txtId = new JTextField(); txtName = new JTextField();
        txtPrf = new JTextField(); txtDbms = new JTextField();

        JPanel form = new JPanel(new GridLayout(4, 2, 4, 4));   // label | textfield
        form.add(new JLabel("Student ID"));   form.add(txtId);
        form.add(new JLabel("Name"));         form.add(txtName);
        form.add(new JLabel("PRF Marks"));    form.add(txtPrf);
        form.add(new JLabel("DBMS Marks"));   form.add(txtDbms);
        add("Center", form);                  // BorderLayout region

        lblResult = new JLabel(" ", JLabel.CENTER);
        add("North", lblResult);

        btnAdd = new JButton("Add Student");
        btnClear = new JButton("Clear");
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(btnAdd); buttons.add(btnClear);
        add("South", buttons);

        // --- EVENT HANDLING (polymorphism) ---
        // "new ActionListener(){...}" = anonymous child of the ActionListener interface.
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Student s = getStudentFromForm();      // read via our own getter
                    lblResult.setText("Added: " + s.getName() + " total=" + s.getTotal());
                } catch (NumberFormatException ex) {
                    lblResult.setText("Marks must be numbers!");
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setStudentToForm(null);
            }
        });
    }

    // GETTER-style: turns what is typed into a Student object
    public Student getStudentFromForm() {
        return new Student(txtId.getText(),
                           txtName.getText(),
                           Integer.parseInt(txtPrf.getText()),    // text -> int
                           Integer.parseInt(txtDbms.getText()));
    }

    // SETTER-style: puts a Student into the text fields (null = clear)
    public void setStudentToForm(Student s) {
        txtId.setText(s == null ? "" : s.getId());
        txtName.setText(s == null ? "" : s.getName());
        txtPrf.setText(s == null ? "" : String.valueOf(s.getPrfMarks()));
        txtDbms.setText(s == null ? "" : String.valueOf(s.getDbmsMarks()));
        lblResult.setText(" ");
    }
}

class JFrameLesson {
    static void run(boolean openWindow) {
        System.out.println("=========== PART 5 : JFRAME ===========");
        // Polymorphism: a JFrame-typed variable holding our child object.
        // setVisible() is a JFrame method, so it is legal on this reference.
        // (Calling getStudentFromForm() on it would be ILLEGAL without a cast.)
        if (openWindow) {
            JFrame frame = new AddStudentForm();
            frame.setVisible(true);
            AddStudentForm form = (AddStudentForm) frame;      // cast to reach our own methods
            form.setStudentToForm(new Student("S0001", "Nimal", 56, 70));
            System.out.println("Window opened. Type marks and press Add Student.");
        } else {
            System.out.println("(skipped - run with:  java OOPStudyGuide gui)");
        }
    }
}


// ===================================================================
// PART 6 : ABSTRACT CLASSES
// ===================================================================
/*
 * An abstract class is a PARENT that is not complete on its own.
 *   - You cannot do  new Shape()   (it is only an idea, not a real thing)
 *   - It may contain normal fields/methods that children inherit
 *   - It may contain abstract methods: NO body, children MUST override them
 *
 * When to use:  "All shapes have an area, but the formula depends on the shape."
 *   Parent says WHAT must exist (area()), child says HOW (its own formula).
 */
abstract class Shape {
    private String name;

    Shape(String name) { this.name = name; }

    public String getName() { return name; }

    // abstract = no { } body, just a semicolon. Every child must write its own.
    public abstract double area();

    // normal method: shared by all children, and it USES the abstract one
    public void printInfo() {
        System.out.println("  " + name + " area = " + area());   // calls CHILD's area()
    }
}

class Circle extends Shape {
    private double radius;
    Circle(double radius) { super("Circle"); this.radius = radius; }
    public double area() { return Math.round(Math.PI * radius * radius * 100) / 100.0; }
}

class Rectangle extends Shape {
    private double w, h;
    Rectangle(double w, double h) { super("Rectangle"); this.w = w; this.h = h; }
    public double area() { return w * h; }
}

class AbstractLesson {
    static void run() {
        System.out.println("\n=========== PART 6 : ABSTRACT CLASS ===========");
        // Shape s = new Shape("x");     // ILLEGAL: Shape is abstract
        // STEP 1: parent-typed array (polymorphism again)
        Shape[] shapes = { new Circle(2), new Rectangle(3, 4) };
        // STEP 2: same call on every element; each child supplies its own area()
        for (Shape sh : shapes) {
            sh.printInfo();
        }
        /*
         * Remember:
         *   abstract class = may have BOTH finished and unfinished methods
         *   a child that does not override every abstract method must itself be abstract
         */
    }
}

// ===================================================================
// PART 7 : INTERFACES
// ===================================================================
/*
 * An interface is a pure CONTRACT: a list of methods a class promises to have.
 *   interface Printable { void print(); }
 *   class Invoice implements Printable { public void print(){...} }
 *
 * Compare:
 *   extends     -> a class can extend only ONE parent
 *   implements  -> a class can implement MANY interfaces
 *
 * Use it when UNRELATED classes must share one ability (Invoice and Report
 * are not related, but both can be printed).
 * (ActionListener in the JFrame part is exactly this: an interface.)
 */
interface Printable {
    void print();                       // automatically public abstract
}
interface Savable {
    void save();
}

class Invoice implements Printable, Savable {   // two interfaces at once
    private int no;
    Invoice(int no) { this.no = no; }
    public void print() { System.out.println("  Printing invoice #" + no); }
    public void save()  { System.out.println("  Saving invoice #" + no); }
}

class Report implements Printable {
    public void print() { System.out.println("  Printing monthly report"); }
}

class InterfaceLesson {
    static void run() {
        System.out.println("\n=========== PART 7 : INTERFACE ===========");
        // STEP 1: the variable type is the interface, objects are different classes
        Printable[] items = { new Invoice(101), new Report() };
        // STEP 2: one call, different behaviour (polymorphism through an interface)
        for (Printable p : items) {
            p.print();
        }
        // STEP 3: to use the extra ability, check and cast
        if (items[0] instanceof Savable) {
            ((Savable) items[0]).save();
        }
    }
}

// ===================================================================
// PART 8 : ArrayList
// ===================================================================
/*
 * In the lecture note we wrote extendsArray() and remove() by hand to make a
 * growing array (Q202-Q218).  Java already has this: ArrayList.
 *
 *   By hand (your note)            ArrayList
 *   -----------------------------  -----------------------
 *   extendsArray(); a[len-1]=x;    list.add(x);
 *   add(index, x) shifting         list.add(index, x);
 *   remove(index) shifting         list.remove(index);
 *   a.length                       list.size()
 *   a[i]                           list.get(i)
 *   isEmpty()                      list.isEmpty()
 *
 * <Student> tells Java "this list only holds Student objects" (generics),
 * so no casting is needed (unlike the Object[] Collection in Q218).
 */
class ArrayListLesson {
    static void run() {
        System.out.println("\n=========== PART 8 : ArrayList ===========");
        java.util.ArrayList<Student> list = new java.util.ArrayList<Student>();

        list.add(new Student("S0001", "Nimal", 56, 87));     // add at the end
        list.add(new Student("S0002", "Amal", 76, 97));
        list.add(1, new Student("S0003", "Bimal", 36, 47));  // insert at index 1
        System.out.println("  size = " + list.size());       // 3

        // normal loop: size()-1 is the last index, same rule as arrays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  [" + i + "] " + list.get(i).getName());
        }
        // for-each: no index needed
        int total = 0;
        for (Student s : list) {
            total += s.getTotal();
        }
        System.out.println("  sum of all totals = " + total);

        list.remove(1);                                      // remove Bimal
        System.out.println("  after remove, size = " + list.size());   // 2
    }
}

// ===================================================================
// PART 9 : PRACTICE EXERCISES (WITH ANSWERS)
// ===================================================================
/*
 * HOW TO PRACTISE:
 *   1. Read ONLY the exercise text.  Close the answer.
 *   2. Write the code yourself in a new file.
 *   3. Predict the output on paper, then run.
 *   4. Compare with the answer below.
 *
 * EXERCISE 1 (arrays)
 *   int[] a = {5, 8, 2, 9};  Print the largest value and the sum.
 *   Think: start max with a[0], then loop i from 1 while i < a.length.
 *
 * EXERCISE 2 (encapsulation)
 *   ScoreCard with private int marks. setMarks accepts 0-100 only.
 *   getGrade(): >=75 "A", >=50 "B", else "F".
 *
 * EXERCISE 3 (inheritance + polymorphism)
 *   Employee(name, baseSalary) with getSalary().
 *   Manager adds a bonus, Developer adds overtime. Store both in an Employee[]
 *   and print every salary with one loop.
 */
class ScoreCard {                                            // Exercise 2 answer
    private int marks;
    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) this.marks = marks;  // validation
    }
    public int getMarks() { return marks; }
    public String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 50) return "B";
        return "F";
    }
}

class Employee {                                             // Exercise 3 answer
    protected String name;
    protected double baseSalary;
    Employee(String name, double baseSalary) { this.name = name; this.baseSalary = baseSalary; }
    public double getSalary() { return baseSalary; }
    public String getName() { return name; }
}
class Manager extends Employee {
    private double bonus;
    Manager(String name, double baseSalary, double bonus) { super(name, baseSalary); this.bonus = bonus; }
    @Override public double getSalary() { return baseSalary + bonus; }
}
class Developer extends Employee {
    private int overtimeHours;
    Developer(String name, double baseSalary, int overtimeHours) { super(name, baseSalary); this.overtimeHours = overtimeHours; }
    @Override public double getSalary() { return baseSalary + overtimeHours * 500; }
}

class PracticeAnswers {
    static void run() {
        System.out.println("\n=========== PART 9 : PRACTICE ANSWERS ===========");

        // ---- Exercise 1 answer ----
        int[] a = {5, 8, 2, 9};
        int max = a[0];                       // assume first is biggest
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {  // start at 1: a[0] already used
            if (a[i] > max) max = a[i];       // found bigger -> replace
            sum += a[i];                      // keep adding
        }
        System.out.println("  Ex1: max = " + max + ", sum = " + sum);   // 9 and 24

        // ---- Exercise 2 answer ----
        ScoreCard sc = new ScoreCard();
        sc.setMarks(80);
        sc.setMarks(150);                     // rejected, stays 80
        System.out.println("  Ex2: marks = " + sc.getMarks() + ", grade = " + sc.getGrade()); // 80, A

        // ---- Exercise 3 answer ----
        Employee[] staff = {
            new Manager("Kamal", 100000, 25000),
            new Developer("Nimali", 90000, 10)
        };
        for (Employee e : staff) {            // same call, different formula
            System.out.println("  Ex3: " + e.getName() + " earns " + e.getSalary());
        }
        // Manager 125000.0, Developer 95000.0
    }
}
