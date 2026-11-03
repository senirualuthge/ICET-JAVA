import java.util.ArrayDeque;
import java.util.Deque;

/**
 * OOP Assignment 2
 * Inheritance and Polymorphism
 *
 * All 37 questions are answered in this single file.
 * Each question has a qNN() method.  The methods print the written
 * answer and, where the question asks for a program, run a small demo
 * built from the helper classes at the bottom of the file.
 *
 * Compile : javac OOPAssignment2.java
 * Run     : java OOPAssignment2
 *
 * Quick answer key (theory / multiple-choice):
 *   Q09 A-F         Q11 B,C          Q12 A-D          Q13 A-D
 *   Q16 B           Q17 D            Q18 none as written (B,C,E if
 *                                      "myMethod" is corrected to "aMethod")
 *   Q23 F           Q24 F            Q29 D            Q30 A,B,C
 *   Q31 B,D,E,F     Q33 D            Q35 A            Q36 B,C
 *   Q37 D
 */
public class OOPAssignment2 {

    public static void main(String[] args) {
        q01();
        q02();
        q03();
        q04();
        q05();
        q06();
        q07();
        q08();
        q09();
        q10();
        q11();
        q12();
        q13();
        q14();
        q15();
        q16();
        q17();
        q18();
        q19();
        q20();
        q21();
        q22();
        q23();
        q24();
        q25();
        q26();
        q27();
        q28();
        q29();
        q30();
        q31();
        q32();
        q33();
        q34();
        q35();
        q36();
        q37();
    }

    /* =====================================================================
       01. Class diagram: A at the top, B and C below A, D and E below C.
       ===================================================================== */
    static void q01() {
        System.out.println("---- Q01 ----");
        System.out.println("Classes       : A, B, C, D, E");
        System.out.println("Super classes : A (superclass of B and C)");
        System.out.println("                C (superclass of D and E)");
        System.out.println("Sub classes   : B, C  (direct subclasses of A)");
        System.out.println("                D, E  (direct subclasses of C)");
        System.out.println("C is both a subclass of A and a superclass of D and E.");
        System.out.println("Every class has exactly one direct superclass, so this");
        System.out.println("is single inheritance.  Object is the implicit root.");
        System.out.println();

        A1 a = new A1(10);
        B1 b = new B1(10, 20);
        C1 c = new C1(10, 30);
        D1 d = new D1(10, 30, 40);
        E1 e = new E1(10, 30, 50);

        a.printA();
        b.printA();
        b.printB();
        c.printA();
        c.printC();
        d.printA();
        d.printC();
        d.printD();
        e.printA();
        e.printC();
        e.printE();

        System.out.println("A reference can hold any object below it in the tree:");
        A1[] all = {a, b, c, d, e};
        for (A1 x : all) {
            x.describe();
        }
        System.out.println();
    }

    /* =====================================================================
       02. Inheritance with real-world examples.
       ===================================================================== */
    static void q02() {
        System.out.println("---- Q02 ----");
        System.out.println("Inheritance is the OOP mechanism by which a new class (the");
        System.out.println("subclass / child / derived class) acquires the fields and");
        System.out.println("methods of an existing class (the superclass / parent / base");
        System.out.println("class) and may add new members or replace inherited behaviour.");
        System.out.println("In Java it is written with the keyword extends, and it models");
        System.out.println("an \"is-a\" relationship.");
        System.out.println();
        System.out.println("Real-world examples:");
        System.out.println("  Vehicle  -> Car, Bus, Van       (a Car is-a Vehicle)");
        System.out.println("  Animal   -> Dog, Cat, Bird      (a Dog is-a Animal)");
        System.out.println("  Person   -> Student, Employee   (a Student is-a Person)");
        System.out.println("  Account  -> SavingsAccount,");
        System.out.println("              CurrentAccount       (both are Accounts)");
        System.out.println("  Shape    -> Circle, Rectangle   (a Circle is-a Shape)");
        System.out.println();
        System.out.println("The child inherits what is common (for example a Vehicle has");
        System.out.println("a registration number and can move) and adds what is special");
        System.out.println("(a Bus has passengerCapacity, a Van has cargoVolume).");
        System.out.println("Java allows a class to extend only one class, but a chain of");
        System.out.println("extends is allowed: Dog -> Mammal -> Vertebrate -> Object.");
        System.out.println();
    }

    /* =====================================================================
       03. How inheritance promotes reuse and reduces errors.
       ===================================================================== */
    static void q03() {
        System.out.println("---- Q03 ----");
        System.out.println("Software reuse:");
        System.out.println("  Common state and behaviour are written once in the superclass.");
        System.out.println("  Every subclass inherits them instead of copying the code.");
        System.out.println("  A subclass adds only its own extra fields and methods.");
        System.out.println();
        System.out.println("Saving development time:");
        System.out.println("  The inherited code is already designed, written and tested.");
        System.out.println("  New classes are produced by extension rather than from zero.");
        System.out.println("  Changes to shared behaviour are made in one place and all");
        System.out.println("  subclasses receive them automatically.");
        System.out.println();
        System.out.println("Preventing errors:");
        System.out.println("  One tested implementation replaces many hand-written copies,");
        System.out.println("  so there are fewer places for a copy/paste mistake to hide.");
        System.out.println("  The compiler checks the is-a relationship, access rules,");
        System.out.println("  constructor chaining and method signatures.");
        System.out.println("  Behaviour stays consistent across the whole family of classes.");
        System.out.println("  Overriding lets a subclass correct or specialise behaviour");
        System.out.println("  without breaking the superclass contract (Liskov substitution).");
        System.out.println();
        System.out.println("Caveat: inheritance is tightly coupled.  A change in a base");
        System.out.println("class can affect every subclass, so composition is preferred");
        System.out.println("when the relationship is not truly an is-a relationship.");
        System.out.println();
    }

    /* =====================================================================
       04. Five class hierarchies.
       ===================================================================== */
    static void q04() {
        System.out.println("---- Q04 ----");
        System.out.println("Student    <- GraduateStudent, UndergraduateStudent");
        System.out.println("Shape      <- Circle, Triangle, Rectangle, Sphere, Cube");
        System.out.println("Loan       <- CarLoan, HomeImprovementLoan, MortgageLoan");
        System.out.println("Employee   <- Faculty, Staff");
        System.out.println("BankAccount<- CheckingAccount, SavingsAccount");
        System.out.println();

        Student4 s = new Student4("Nimal", 1001);
        UndergraduateStudent4 u = new UndergraduateStudent4("Sunil", 1002, 2);
        GraduateStudent4 g = new GraduateStudent4("Kamal", 1003, "Artificial Intelligence");
        s.display();
        u.display();
        g.display();

        Shape4 circle = new Circle4("Circle", 5);
        Shape4 triangle = new Triangle4("Triangle", 6, 4);
        Shape4 rectangle = new Rectangle4("Rectangle", 8, 3);
        Shape4 sphere = new Sphere4("Sphere", 4);
        Shape4 cube = new Cube4("Cube", 3);
        Shape4[] shapes = {circle, triangle, rectangle, sphere, cube};
        for (Shape4 shape : shapes) {
            shape.display();
        }

        Loan4 carLoan = new CarLoan4(2_500_000, 12.5);
        Loan4 homeLoan = new HomeImprovementLoan4(1_200_000, 10.0);
        Loan4 mortgage = new MortgageLoan4(15_000_000, 9.5);
        carLoan.display();
        homeLoan.display();
        mortgage.display();

        Employee4 faculty = new Faculty4("Dr. Perera", 180_000, "Computing");
        Employee4 staff = new Staff4("Mrs. Silva", 75_000, "Administration");
        faculty.display();
        staff.display();

        BankAccount4 checking = new CheckingAccount4("CHK-001", 25_000, 10_000);
        BankAccount4 savings = new SavingsAccount4("SAV-001", 100_000, 7.5);
        checking.display();
        savings.display();
        System.out.println();
    }

    /* =====================================================================
       05. Expanded Shape hierarchy (2D and 3D).
       ===================================================================== */
    static void q05() {
        System.out.println("---- Q05 ----");
        System.out.println("Shape");
        System.out.println(" |- TwoDimensionalShape  <- Circle, Square, Triangle");
        System.out.println(" |- ThreeDimensionalShape<- Sphere, Cube, Tetrahedron");
        System.out.println();

        Shape5[] shapes = {
            new Circle5(5),
            new Square5(4),
            new Triangle5(6, 3),
            new Sphere5(3),
            new Cube5(2),
            new Tetrahedron5(4)
        };

        for (Shape5 shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();
    }

    /* =====================================================================
       06. Deep Student hierarchy.
       ===================================================================== */
    static void q06() {
        System.out.println("---- Q06 ----");
        System.out.println("Student");
        System.out.println(" |- UndergraduateStudent");
        System.out.println(" |   |- Freshman");
        System.out.println(" |   |- Sophomore");
        System.out.println(" |   |- Junior");
        System.out.println(" |   |- Senior");
        System.out.println(" |- GraduateStudent");
        System.out.println("     |- MastersStudent");
        System.out.println("     |- DoctoralStudent");
        System.out.println();

        Student6[] students = {
            new Student6("Nimal", 1001, 2.85),
            new Freshman6("Sunil", 2001, 3.10),
            new Sophomore6("Kamala", 2002, 3.25),
            new Junior6("Ruwan", 2003, 3.40),
            new Senior6("Dilini", 2004, 3.55),
            new UndergraduateStudent6("Chathura", 2005, 3.00, 2),
            new GraduateStudent6("Kasun", 3001, 3.70, "Data Mining"),
            new MastersStudent6("Ayesha", 3002, 3.80, "Cloud Computing", "Dr. Perera"),
            new DoctoralStudent6("Nadeesha", 3003, 3.90, "Machine Learning", "Explainable AI")
        };

        for (Student6 student : students) {
            student.display();
        }
        System.out.println("The loop uses a Student6 reference, but each object");
        System.out.println("executes its own overridden getLevel() method.");
        System.out.println();
    }

    /* =====================================================================
       07. Quadrilateral hierarchy with a Point class.
       ===================================================================== */
    static void q07() {
        System.out.println("---- Q07 ----");
        System.out.println("Quadrilateral");
        System.out.println(" |- Trapezoid");
        System.out.println(" |- Parallelogram");
        System.out.println("     |- Rectangle");
        System.out.println("         |- Square");
        System.out.println();

        Quadrilateral7[] shapes = {
            new Trapezoid7(
                new Point7(0, 0), new Point7(6, 0),
                new Point7(4, 3), new Point7(1, 3)),
            new Parallelogram7(
                new Point7(0, 0), new Point7(5, 0),
                new Point7(6, 3), new Point7(1, 3)),
            new Rectangle7(
                new Point7(0, 0), new Point7(4, 0),
                new Point7(4, 3), new Point7(0, 3)),
            new Square7(
                new Point7(0, 0), new Point7(4, 0),
                new Point7(4, 4), new Point7(0, 4))
        };

        for (Quadrilateral7 shape : shapes) {
            System.out.printf("%-14s area = %6.2f  perimeter = %6.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.area(), shape.perimeter());
        }
        System.out.println();
    }

    /* =====================================================================
       08. Software reuse in the CalculatorView / JFrame example.
       ===================================================================== */
    static void q08() {
        System.out.println("---- Q08 ----");
        System.out.println("class CalculatorView extends JFrame { }");
        System.out.println();
        System.out.println("CalculatorView inherits from javax.swing.JFrame.  JFrame");
        System.out.println("already contains all the code that creates a window, talks to");
        System.out.println("the operating system, handles repainting, minimising, closing");
        System.out.println("and the event-dispatch thread.");
        System.out.println();
        System.out.println("The program calls setSize(), setTitle(),");
        System.out.println("setDefaultCloseOperation() and setVisible().  None of these");
        System.out.println("methods is written in CalculatorView; they are reused from");
        System.out.println("JFrame and its ancestors (Frame, Window, Container, Component).");
        System.out.println("EXIT_ON_CLOSE is also an inherited constant.");
        System.out.println();
        System.out.println("Reuse in this example:");
        System.out.println("  1. Thousands of lines of window-management code are not rewritten.");
        System.out.println("  2. Only the difference (a calculator window) is added.");
        System.out.println("  3. The inherited, tested Swing behaviour is consistent with every");
        System.out.println("     other Swing application.");
        System.out.println("  4. If the window system needs a fix, it is fixed in JFrame once and");
        System.out.println("     CalculatorView receives the benefit.");
        System.out.println();
        System.out.println("The relationship is is-a: a CalculatorView is-a JFrame.  The");
        System.out.println("calculator-specific widgets would be added as fields (has-a).");
        System.out.println();
    }

    /* =====================================================================
       09. True / false statements.
       ===================================================================== */
    static void q09() {
        System.out.println("---- Q09 ----");
        System.out.println("A. True  - inheritance removes duplicated work and shortens development.");
        System.out.println("B. True  - Java has no multiple inheritance of classes; a class has");
        System.out.println("           one direct superclass.  Multiple inheritance of type is");
        System.out.println("           possible through interfaces.");
        System.out.println("C. True  - that is the definition of single inheritance.");
        System.out.println("D. True  - a subclass adds detail, so it represents a smaller,");
        System.out.println("           more specific set of objects.");
        System.out.println("E. True  - this is the is-a rule and the basis of polymorphism.");
        System.out.println("F. True  - has-a means composition: the whole holds references to");
        System.out.println("           its parts as fields.");
        System.out.println("Answer: A, B, C, D, E and F are all true.");
        System.out.println();
    }

    /* =====================================================================
       10. Compile errors in class B.
       ===================================================================== */
    static void q10() {
        System.out.println("---- Q10 ----");
        System.out.println("Line 2 and Line 4 cause compile errors.");
        System.out.println();
        System.out.println("class B does not extend A, so B has no is-a relationship with A.");
        System.out.println("  Line 2: printA();  -> cannot find symbol: method printA()");
        System.out.println("  Line 4: a          -> cannot find symbol: variable a");
        System.out.println();
        System.out.println("Line 1 (b) and Line 3 (printB()) are members of B, so they are");
        System.out.println("valid.  Line 5 (b) is also valid.");
        System.out.println("Adding  class B extends A  would make all five lines compile.");
        System.out.println();
    }

    /* =====================================================================
       11. is-a / has-a statements.
       ===================================================================== */
    static void q11() {
        System.out.println("---- Q11 ----");
        System.out.println("A. False - a class and its superclass form an is-a relationship.");
        System.out.println("B. True  - the subclass is a more specific kind of the superclass.");
        System.out.println("C. True  - a field is a part of the object, which is has-a.");
        System.out.println("D. False - a field is not a kind of the containing class.");
        System.out.println("Answer: B and C.");
        System.out.println();
    }

    /* =====================================================================
       12. Superclass / subclass statements.
       ===================================================================== */
    static void q12() {
        System.out.println("---- Q12 ----");
        System.out.println("A. True  - private members are not visible in the subclass;");
        System.out.println("           non-private (and protected) members are accessible.");
        System.out.println("B. True  - constructors are not inherited; they are invoked.");
        System.out.println("C. True  - super(...) must be the first statement of the");
        System.out.println("           subclass constructor.");
        System.out.println("D. True  - that is method overriding.");
        System.out.println("E. False - same name and same signature is overriding, not");
        System.out.println("           overloading.  Overloading needs a different parameter list.");
        System.out.println("Answer: A, B, C and D.");
        System.out.println();
    }

    /* =====================================================================
       13. Methods that may be inserted into Sub.
       ===================================================================== */
    static void q13() {
        System.out.println("---- Q13 ----");
        System.out.println("All four statements compile.");
        System.out.println("A. public void aMethod(int a)   - exact override");
        System.out.println("B. public void aMethod(int data)- same signature; parameter names");
        System.out.println("                                  are not part of the signature");
        System.out.println("C. public void aMethod(double a)- overload (different parameter type)");
        System.out.println("D. public void aMethod(int[] a) - overload (different parameter type)");
        System.out.println("Answer: A, B, C and D.");
        System.out.println();
    }

    /* =====================================================================
       14. Constructor problem.
       ===================================================================== */
    static void q14() {
        System.out.println("---- Q14 ----");
        System.out.println("Compilation fails.");
        System.out.println();
        System.out.println("class A declares only A(int).  It therefore has no no-argument");
        System.out.println("constructor.  class B has no constructor, so the compiler adds:");
        System.out.println("    B() { super(); }");
        System.out.println("super() looks for A() and cannot find it.");
        System.out.println("Error: constructor A in class A cannot be applied to given types;");
        System.out.println("       required: int; found: no arguments");
        System.out.println();
        System.out.println("Fix: give A a no-argument constructor, or give B a constructor");
        System.out.println("that calls super(someInt).");
        System.out.println();
    }

    /* =====================================================================
       15. Reference assignment errors.
       ===================================================================== */
    static void q15() {
        System.out.println("---- Q15 ----");
        System.out.println("Hierarchy: A <- B, A <- C, B <- D");
        System.out.println();
        System.out.println("Line 1  A a1 = new A();  OK");
        System.out.println("Line 2  B b1 = new B();  OK");
        System.out.println("Line 3  C c1 = new C();  OK");
        System.out.println("Line 4  D d1 = new D();  OK");
        System.out.println("Line 5  A a2 = a1;       OK");
        System.out.println("Line 6  a2 = b1;         OK (B is-a A, widening)");
        System.out.println("Line 7  a2 = c1;         OK (C is-a A, widening)");
        System.out.println("Line 8  a2 = d1;         OK (D is-a B is-a A)");
        System.out.println("Line 9  B b2 = a1;       ERROR - A is not necessarily B");
        System.out.println("Line 10 b2 = c1;         ERROR - C is not a B (sibling)");
        System.out.println("Line 11 b2 = d1;         OK (D is-a B)");
        System.out.println("Line 12 C c2 = a1;       ERROR - A is not necessarily C");
        System.out.println("Line 13 c2 = b1;         ERROR - B is not a C");
        System.out.println("Line 14 c2 = d1;         ERROR - D is a B, not a C");
        System.out.println("Line 15 D d2 = a1;       ERROR - A is not necessarily D");
        System.out.println("Line 16 d2 = b1;         ERROR - B is not a D");
        System.out.println("Line 17 d2 = c1;         ERROR - C is not a D");
        System.out.println();
        System.out.println("Compile errors: lines 9, 10, 12, 13, 14, 15, 16 and 17.");
        System.out.println("A downcast would need an explicit cast, for example");
        System.out.println("    B b2 = (B) a1;");
        System.out.println("which compiles but throws ClassCastException at run time when");
        System.out.println("a1 does not actually refer to a B object.");
        System.out.println();
    }

    /* =====================================================================
       16. Definition of overriding.
       ===================================================================== */
    static void q16() {
        System.out.println("---- Q16 ----");
        System.out.println("Answer: B.");
        System.out.println("Overriding replaces the inherited implementation of a method with");
        System.out.println("the same name, same parameter list and compatible return type.");
        System.out.println("A is a class-level statement, C describes overloading and D is");
        System.out.println("not a definition of overriding.");
        System.out.println();
    }

    /* =====================================================================
       17. Declarations that compile at line 12.
       ===================================================================== */
    static void q17() {
        System.out.println("---- Q17 ----");
        System.out.println("Answer: D.  class AnimalShape{}");
        System.out.println();
        System.out.println("A. class Animal extends Shape{} - Animal is already defined,");
        System.out.println("   so this is a duplicate class definition.");
        System.out.println("B. class Shape extends Animal{} - Shape is already defined.");
        System.out.println("C. class Lion extends Animal, Shape{} - Java does not allow a");
        System.out.println("   class to extend two classes (no multiple inheritance).");
        System.out.println("D. a new class name, so it compiles.");
        System.out.println();
    }

    /* =====================================================================
       18. Dynamic method dispatch.
       ===================================================================== */
    static void q18() {
        System.out.println("---- Q18 ----");
        System.out.println("As written, none of A-F compiles: the classes declare aMethod(),");
        System.out.println("but every option calls myMethod(), which does not exist.");
        System.out.println();
        System.out.println("If the options are corrected to aMethod(100), the calls that");
        System.out.println("prove dynamic method dispatch are B, C and E:");
        System.out.println("  B. a2.aMethod(100) -> B's version (A reference, B object)");
        System.out.println("  C. a3.aMethod(100) -> C's version (A reference, C object)");
        System.out.println("  E. b2.aMethod(100) -> C's version (B reference, C object)");
        System.out.println("F also reaches C's version, but through a C reference, so it");
        System.out.println("does not by itself demonstrate dispatch.");
        System.out.println();

        A18 a2 = new B18();
        A18 a3 = new C18();
        B18 b2 = new C18();
        a2.aMethod(100);
        a3.aMethod(100);
        b2.aMethod(100);
        System.out.println();
    }

    /* =====================================================================
       19. Missing superclass constructor call.
       ===================================================================== */
    static void q19() {
        System.out.println("---- Q19 ----");
        System.out.println("Compilation fails.");
        System.out.println("Super declares only Super(int), so it has no no-argument");
        System.out.println("constructor.  Sub(int) does not call super(i); the compiler adds");
        System.out.println("super() as the first statement, but Super() does not exist.");
        System.out.println("Error: constructor Super in class Super cannot be applied to");
        System.out.println("       given types; required: int; found: no arguments");
        System.out.println();
        System.out.println("Fixed version (the super call must be first):");
        System.out.println();
        Super19 s = new Sub19(100);
        System.out.println();
    }

    /* =====================================================================
       20. What may be passed to super(...).
       ===================================================================== */
    static void q20() {
        System.out.println("---- Q20 ----");
        System.out.println("C, D, E and F compile; A and B do not.");
        System.out.println();
        System.out.println("A. super(a) - a is an instance field; an explicit constructor");
        System.out.println("   invocation may not refer to instance members.");
        System.out.println("B. super(b) - b is an instance field of Sub; same error.");
        System.out.println("C. super(x) - x is static, so it is allowed.");
        System.out.println("D. super(y) - y is static, so it is allowed.");
        System.out.println("E. super(i) - i is the constructor parameter, allowed.");
        System.out.println("F. super(100) - a literal, allowed.");
        System.out.println();
        System.out.println("The rule: before the superclass constructor has run, the");
        System.out.println("subclass object is not fully constructed; only static members,");
        System.out.println("parameters and local variables may be used.  this and super may");
        System.out.println("not appear in the argument list.");
        System.out.println("If no line is inserted the code still compiles, because Super()");
        System.out.println("exists and is called implicitly.");
        System.out.println();

        Sub20 s = new Sub20(100);
        System.out.println();
    }

    /* =====================================================================
       21. Invoking a superclass constructor.
       ===================================================================== */
    static void q21() {
        System.out.println("---- Q21 ----");
        System.out.println("A subclass constructor always invokes a superclass constructor.");
        System.out.println("The call is either written explicitly as super(arguments) or");
        System.out.println("inserted implicitly as super().  It must be the first statement");
        System.out.println("of the subclass constructor.  JVM execution then goes up the");
        System.out.println("chain until Object(), and constructors run from the top down.");
        System.out.println();
        System.out.println("class Person {");
        System.out.println("    Person(String name) { ... }");
        System.out.println("}");
        System.out.println("class Student extends Person {");
        System.out.println("    Student(String name, int id) {");
        System.out.println("        super(name);   // first statement");
        System.out.println("        this.id = id;");
        System.out.println("    }");
        System.out.println("}");
        System.out.println();
        System.out.println("A constructor may call this(...) or super(...), but not both.");
        System.out.println("If the superclass has no no-argument constructor, the explicit");
        System.out.println("super(arguments) call is compulsory.");
        System.out.println();

        Student21 s = new Student21("Nimal", 1001);
        System.out.println("Created: " + s);
        System.out.println();
    }

    /* =====================================================================
       22. Fields are hidden, not overridden.
       ===================================================================== */
    static void q22() {
        System.out.println("---- Q22 ----");
        System.out.println("Methods are overridden; fields (and static members) are hidden.");
        System.out.println("The field that is read is chosen at compile time from the type");
        System.out.println("of the reference, not at run time from the object.");
        System.out.println();

        Parent22 p = new Child22();
        System.out.println("Parent22 p = new Child22();");
        System.out.println("p.value            = " + p.value);
        System.out.println("((Child22) p).value= " + ((Child22) p).value);
        System.out.println("p.show()           :");
        p.show();
        System.out.println("((Child22) p).showSuperValue() :");
        ((Child22) p).showSuperValue();
        System.out.println();
        System.out.println("Inside Child22, the simple name value means Child22.value;");
        System.out.println("super.value is needed to reach the hidden parent field.");
        System.out.println("Static fields behave the same way: they are hidden, not overridden.");
        System.out.println();
    }

    /* =====================================================================
       23. Calling C.test() from A.
       ===================================================================== */
    static void q23() {
        System.out.println("---- Q23 ----");
        System.out.println("Answer: F.  It is not possible to invoke C's test() directly");
        System.out.println("from a method of A.");
        System.out.println();
        System.out.println("A. test()              calls A's own (overridden) version.");
        System.out.println("B. super.test()        calls B's version.");
        System.out.println("C. super.super.test()  is not legal Java.");
        System.out.println("D. ::test()            is not legal Java syntax here.");
        System.out.println("E. C.test()            needs an instance and still dispatches");
        System.out.println("                       virtually to A's override.");
        System.out.println();
        System.out.println("Java does not allow a class to skip a level of the hierarchy.");
        System.out.println("A workaround is to add a method in B that calls super.test(),");
        System.out.println("and then call that method from A.");
        System.out.println();
    }

    /* =====================================================================
       24. Mixer output.
       ===================================================================== */
    static void q24() {
        System.out.println("---- Q24 ----");
        System.out.println("Trace:");
        System.out.println("  m2 = new Mixer();        m2.m1 = null");
        System.out.println("  m3 = new Mixer(m2);      m3.m1 = m2;  m3.go() -> hi");
        System.out.println("  m4 = m3.m1;              m4 = m2;     m4.go() -> hi");
        System.out.println("  m5 = m2.m1;              m5 = null;   m5.go() -> NPE");
        System.out.println();
        System.out.println("Answer: F.  It prints \"hi hi \" and then throws");
        System.out.println("NullPointerException.");
        System.out.println();

        Mixer24 m2 = new Mixer24();
        Mixer24 m3 = new Mixer24(m2);
        m3.go();
        Mixer24 m4 = m3.m1;
        m4.go();
        try {
            Mixer24 m5 = m2.m1;
            m5.go();
        } catch (NullPointerException ex) {
            System.out.println();
            System.out.println("NullPointerException: m2.m1 is null");
        }
        System.out.println();
    }

    /* =====================================================================
       25. Object diagrams.
       ===================================================================== */
    static void q25() {
        System.out.println("---- Q25 ----");
        System.out.println("Hierarchy: A <- B <- C");
        System.out.println("           A <- B <- D");
        System.out.println();
        System.out.println("Step 1:  A[] ar = new A[5];");
        System.out.println("  stack            heap");
        System.out.println("  +------+         +----------------------------------+");
        System.out.println("  | ar   |-------->| A[5]                             |");
        System.out.println("  +------+         | [0]=null [1]=null [2]=null       |");
        System.out.println("                   | [3]=null [4]=null                |");
        System.out.println("                   +----------------------------------+");
        System.out.println();
        System.out.println("Step 2:  ar[0] = new A();");
        System.out.println("  ar[0] ---> A object");
        System.out.println();
        System.out.println("Step 3:  ar[1] = new B();");
        System.out.println("  ar[1] ---> B object  ---> (B part) + (inherited A part)");
        System.out.println();
        System.out.println("Step 4:  ar[2] = new C();");
        System.out.println("  ar[2] ---> C object  ---> (C part) + (B part) + (A part)");
        System.out.println();
        System.out.println("Step 5:  ar[3] = new D();");
        System.out.println("  ar[3] ---> D object  ---> (D part) + (B part) + (A part)");
        System.out.println();
        System.out.println("After step 5:");
        System.out.println("  +------+         +----------------------------------+");
        System.out.println("  | ar   |-------->| A[5]                             |");
        System.out.println("  +------+         | [0] -> A object                  |");
        System.out.println("                   | [1] -> B object                  |");
        System.out.println("                   | [2] -> C object                  |");
        System.out.println("                   | [3] -> D object                  |");
        System.out.println("                   | [4] -> null                      |");
        System.out.println("                   +----------------------------------+");
        System.out.println();
        System.out.println("Step 6:  A[] ar2 = {new A(), new B(), new C(), new D()};");
        System.out.println("  +------+         +----------------------------------+");
        System.out.println("  | ar2  |-------->| A[4]  (a different array object) |");
        System.out.println("  +------+         | [0] -> new A object              |");
        System.out.println("                   | [1] -> new B object              |");
        System.out.println("                   | [2] -> new C object              |");
        System.out.println("                   | [3] -> new D object              |");
        System.out.println("                   +----------------------------------+");
        System.out.println();
        System.out.println("The elements are references.  A B, C and D object is stored");
        System.out.println("through an A reference (widening / upcasting); the array does");
        System.out.println("not copy the objects and does not slice off the subclass parts.");
        System.out.println();
    }

    /* =====================================================================
       26. Runtime polymorphism with Figure.
       ===================================================================== */
    static void q26() {
        System.out.println("---- Q26 ----");
        System.out.println("Runtime polymorphism (dynamic method dispatch) means that a");
        System.out.println("call through a superclass reference is resolved using the actual");
        System.out.println("class of the object at run time, not the declared type of the");
        System.out.println("reference.");
        System.out.println();
        System.out.println("  Figure figref;");
        System.out.println("  figref = r;   // Figure reference, Rectangle object");
        System.out.println("  figref.area();// Rectangle.area() runs");
        System.out.println("  figref = t;   // same reference, Triangle object");
        System.out.println("  figref.area();// Triangle.area() runs");
        System.out.println();
        System.out.println("The compiler only checks that Figure has an area() method.");
        System.out.println("The JVM uses the object's actual class to choose the version.");
        System.out.println("The reference type controls what can be called; the object type");
        System.out.println("controls which override executes.  This needs overriding (same");
        System.out.println("signature) and an is-a relationship (upcasting).");
        System.out.println();
        System.out.println("Output:");
        Figure26 f = new Figure26(10, 10);
        Rectangle26 r = new Rectangle26(9, 5);
        Triangle26 t = new Triangle26(10, 8);
        Figure26 figref;
        figref = r;
        System.out.println("Area is " + figref.area());
        figref = t;
        System.out.println("Area is " + figref.area());
        figref = f;
        System.out.println("Area is " + figref.area());
        System.out.println();
    }

    /* =====================================================================
       27. Static initialisers.
       ===================================================================== */
    static void q27() {
        System.out.println("---- Q27 ----");
        System.out.println("As written the program does not compile: class F is never");
        System.out.println("declared.  new F() gives \"cannot find symbol: class F\", so");
        System.out.println("there is no output and none of A-D is correct.");
        System.out.println();
        System.out.println("The intended code almost certainly uses new E().  Then:");
        System.out.println("  new D() initialises A, B, D  -> A B D");
        System.out.println("  new E() initialises C, E     -> C E (A and B are already done)");
        System.out.println("  total                        -> A B D C E");
        System.out.println("That matches option C if its F is a typo for E.");
        System.out.println();
        System.out.println("Static initialisers run once per class, when the class is first");
        System.out.println("actively used, and superclasses run before subclasses.");
        System.out.println("Option A would require the static blocks to run once per object.");
        System.out.println("Option D would be the result if new E()/new F() were omitted.");
        System.out.println();
        System.out.println("Corrected output:");
        new D27();
        new E27();
        System.out.println();
        System.out.println();
    }

    /* =====================================================================
       28. Class diagram.
       ===================================================================== */
    static void q28() {
        System.out.println("---- Q28 ----");
        System.out.println("            A");
        System.out.println("            |");
        System.out.println("            B");
        System.out.println("          /   \\");
        System.out.println("         C     D");
        System.out.println("        / \\");
        System.out.println("       E   F");
        System.out.println("       |");
        System.out.println("       G");
        System.out.println();
        System.out.println("A is the root.  B extends A.  C and D extend B.");
        System.out.println("E and F extend C.  G extends E.");
        System.out.println("Each arrow in a UML diagram points from the subclass to its");
        System.out.println("superclass; the tree above is drawn with the superclass on top.");
        System.out.println();
    }

    /* =====================================================================
       29. Reaching Vertebrate.move() from a Dog instance.
       ===================================================================== */
    static void q29() {
        System.out.println("---- Q29 ----");
        System.out.println("Answer: D.  None of the above.");
        System.out.println();
        System.out.println("A. d.super().super().move();  not legal Java");
        System.out.println("B. d.parent().parent().move();not legal Java");
        System.out.println("C. d.move();                  calls Dog's override and prints");
        System.out.println("                              \"walks on paws\"");
        System.out.println();
        System.out.println("Even ((Vertebrate) d).move() still dispatches to Dog's override.");
        System.out.println("Java has no syntax for calling a grandparent implementation.");
        System.out.println("A method in Mammal could call super.move(), and Dog could call");
        System.out.println("that method; that is the usual workaround.");
        System.out.println();
    }

    /* =====================================================================
       30. Static methods and this / super.
       ===================================================================== */
    static void q30() {
        System.out.println("---- Q30 ----");
        System.out.println("A. True  - a static method belongs to the class (class method).");
        System.out.println("B. True  - it is called without a particular instance.");
        System.out.println("C. True  - there is no this inside a static context.");
        System.out.println("D. False - super is also instance-related and cannot be used in");
        System.out.println("           a static method.");
        System.out.println("Answer: A, B and C.");
        System.out.println();
    }

    /* =====================================================================
       31. What super(...) arguments may not refer to.
       ===================================================================== */
    static void q31() {
        System.out.println("---- Q31 ----");
        System.out.println("The arguments of an explicit super(...) call may not refer to:");
        System.out.println("  B. instance variables of this class or a superclass");
        System.out.println("  D. instance methods of this class or a superclass");
        System.out.println("  E. the keyword this");
        System.out.println("  F. the keyword super");
        System.out.println();
        System.out.println("A and C are allowed: static variables and static methods exist");
        System.out.println("before any object is constructed.  Parameters, local variables");
        System.out.println("and literals are also allowed.");
        System.out.println("Answer: B, D, E and F.");
        System.out.println();
    }

    /* =====================================================================
       32. Vehicle queue without fixed-length arrays.
       ===================================================================== */
    static void q32() {
        System.out.println("---- Q32 ----");
        VehicleQueue32 queue = new VehicleQueue32();
        queue.enQueue(new Car32("C001"));
        queue.enQueue(new Bus32("B001"));
        queue.enQueue(new Bus32("B002"));
        queue.enQueue(new Car32("C002"));
        queue.enQueue(new Car32("C003"));
        queue.enQueue(new Van32("V001"));
        queue.enQueue(new Van32("V002"));
        queue.enQueue(new Bus32("B003"));

        queue.printVehicleQueue();
        System.out.println("callPark():");
        queue.callPark();
        queue.printVehicleQueue();

        System.out.println();
        System.out.println("Note: the comment in the question shows only C001 removed");
        System.out.println("after callPark(), but it also lists eight parking messages.");
        System.out.println("Those two expectations contradict each other.  This program");
        System.out.println("parks every vehicle (the eight messages), so the queue is empty");
        System.out.println("afterwards.  The question's sample code also writes");
        System.out.println("new Car(\"V002\") even though the expected output treats V002 as");
        System.out.println("a van; this program uses new Van(\"V002\") and prints");
        System.out.println("VanParking V002, correcting the duplicated V001 line.");
        System.out.println("Queue behaviour uses ArrayDeque, not a fixed-length array.");
        System.out.println();
    }

    /* =====================================================================
       33. Statements legal after //Here.
       ===================================================================== */
    static void q33() {
        System.out.println("---- Q33 ----");
        System.out.println("Answer: D.  Base b = new Base(10);");
        System.out.println();
        System.out.println("A. MyOver m = new MyOver();  - MyOver has no no-argument");
        System.out.println("   constructor, so this does not compile.");
        System.out.println("B. super();                  - Base has no no-argument constructor,");
        System.out.println("   and super() is not the first statement of the constructor.");
        System.out.println("C. this(\"Hello\", 10);        - a this(...) call must be the first");
        System.out.println("   statement; here it is after this(i), so it is illegal.");
        System.out.println("D. a local variable declaration that creates a Base object; legal.");
        System.out.println();
    }

    /* =====================================================================
       34. CustomerStack.
       ===================================================================== */
    static void q34() {
        System.out.println("---- Q34 ----");
        CustomerStack34 stack = new CustomerStack34();
        stack.push(new Customer34(1001, "Danapala"));
        stack.push(new Customer34(1002, "Gunapala"));
        stack.push(new Customer34(1003, "Somapala"));
        stack.push(new Customer34(1004, "Siripala"));
        stack.printCustomerStack();

        stack.pop();
        stack.printCustomerStack();

        System.out.println();
        System.out.println("The comments in the question contain typos: after the first");
        System.out.println("print, 1003 is Somapala (not Gunapala) and 1002 is Gunapala");
        System.out.println("(not a second Gunapala).  After pop() the top element 1004 is");
        System.out.println("removed, so the second print has only three customers.");
        System.out.println("The stack is an ArrayDeque, so its size is not fixed.");
        System.out.println();
    }

    /* =====================================================================
       35. Overload resolution.
       ===================================================================== */
    static void q35() {
        System.out.println("---- Q35 ----");
        System.out.println("c.m(a): a is an A, so only m(A) is applicable -> A");
        System.out.println("c.m(b): b is a B; m(B) is more specific than m(A) -> B");
        System.out.println("c.m(c): c is a C; m(C) is the most specific -> C");
        System.out.println();
        System.out.println("These methods overload each other (different parameter types);");
        System.out.println("the choice is made at compile time from the static types.");
        System.out.println("There is no overriding here because the signatures differ.");
        System.out.println();

        A35 a = new A35();
        B35 b = new B35();
        C35 c = new C35();
        c.m(a);
        c.m(b);
        c.m(c);
        System.out.println();
        System.out.println("Answer: A. ABC");
        System.out.println();
    }

    /* =====================================================================
       36. Has-a statements.
       ===================================================================== */
    static void q36() {
        System.out.println("---- Q36 ----");
        System.out.println("A. False - has-a is composition, not inheritance.");
        System.out.println("B. True  - the part is stored in an instance variable (a reference).");
        System.out.println("C. True  - in the ordinary case there is a whole type and a part");
        System.out.println("           type.  (A rare self-reference such as a linked-list");
        System.out.println("           node has-a node uses only one type.)");
        System.out.println("D. False - composition does not require polymorphism.");
        System.out.println("E. False - depending on an interface keeps the coupling loose.");
        System.out.println("Answer: B and C.");
        System.out.println();
    }

    /* =====================================================================
       37. Constructor, field hiding and dynamic dispatch.
       ===================================================================== */
    static void q37() {
        System.out.println("---- Q37 ----");
        System.out.println("Answer: D. Prints Sub : null -> Panadura");
        System.out.println();
        System.out.println("Execution order for new RegularCustomer():");
        System.out.println("  1. Customer's instance field name is set to \"Danapala\".");
        System.out.println("  2. Customer's constructor runs and calls printCustomer().");
        System.out.println("  3. The call is virtual, so RegularCustomer.printCustomer() runs.");
        System.out.println("  4. RegularCustomer's own field initialisers have NOT run yet,");
        System.out.println("     so its hidden name is still null.");
        System.out.println("  5. city is static and was set to \"Panadura\" when the class was");
        System.out.println("     initialised, so it is already available.");
        System.out.println("  6. After super() returns, RegularCustomer.name becomes \"Somapala\".");
        System.out.println();
        System.out.println("This shows two rules at once: methods are overridden and called");
        System.out.println("virtually, while fields are hidden and read from the reference");
        System.out.println("type.  Calling an overridable method from a constructor is a");
        System.out.println("well-known design trap for exactly this reason.");
        System.out.println();
        System.out.println("Actual output:");
        new RegularCustomer37();
        System.out.println();
    }

    /* =====================================================================
       Helper classes
       ===================================================================== */

    /* ---------------------------- Q01 ---------------------------- */
    static class A1 {
        private final int a;

        A1(int a) {
            this.a = a;
        }

        int getA() {
            return a;
        }

        void printA() {
            System.out.println("A.a = " + a);
        }

        void describe() {
            System.out.println("I am an A object.");
        }
    }

    static class B1 extends A1 {
        private final int b;

        B1(int a, int b) {
            super(a);
            this.b = b;
        }

        void printB() {
            System.out.println("B.b = " + b);
        }

        @Override
        void describe() {
            System.out.println("I am a B object (B is-a A).");
        }
    }

    static class C1 extends A1 {
        private final int c;

        C1(int a, int c) {
            super(a);
            this.c = c;
        }

        void printC() {
            System.out.println("C.c = " + c);
        }

        @Override
        void describe() {
            System.out.println("I am a C object (C is-a A).");
        }
    }

    static class D1 extends C1 {
        private final int d;

        D1(int a, int c, int d) {
            super(a, c);
            this.d = d;
        }

        void printD() {
            System.out.println("D.d = " + d);
        }

        @Override
        void describe() {
            System.out.println("I am a D object (D is-a C is-a A).");
        }
    }

    static class E1 extends C1 {
        private final int e;

        E1(int a, int c, int e) {
            super(a, c);
            this.e = e;
        }

        void printE() {
            System.out.println("E.e = " + e);
        }

        @Override
        void describe() {
            System.out.println("I am an E object (E is-a C is-a A).");
        }
    }

    /* ---------------------------- Q04 ---------------------------- */
    static class Student4 {
        private final String name;
        private final int id;

        Student4(String name, int id) {
            this.name = name;
            this.id = id;
        }

        String getName() {
            return name;
        }

        int getId() {
            return id;
        }

        void display() {
            System.out.println("Student          : " + name + " (" + id + ")");
        }
    }

    static class UndergraduateStudent4 extends Student4 {
        private final int year;

        UndergraduateStudent4(String name, int id, int year) {
            super(name, id);
            this.year = year;
        }

        @Override
        void display() {
            System.out.println("Undergraduate    : " + getName() + " (" + getId()
                    + "), year " + year);
        }
    }

    static class GraduateStudent4 extends Student4 {
        private final String researchArea;

        GraduateStudent4(String name, int id, String researchArea) {
            super(name, id);
            this.researchArea = researchArea;
        }

        @Override
        void display() {
            System.out.println("Graduate         : " + getName() + " (" + getId()
                    + "), research " + researchArea);
        }
    }

    static class Shape4 {
        private final String name;

        Shape4(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void display() {
            System.out.println("Shape            : " + name);
        }
    }

    static class Circle4 extends Shape4 {
        private final double radius;

        Circle4(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        @Override
        void display() {
            System.out.printf("Circle           : radius %.2f, area %.2f%n",
                    radius, Math.PI * radius * radius);
        }
    }

    static class Triangle4 extends Shape4 {
        private final double base;
        private final double height;

        Triangle4(String name, double base, double height) {
            super(name);
            this.base = base;
            this.height = height;
        }

        @Override
        void display() {
            System.out.printf("Triangle         : base %.2f, height %.2f, area %.2f%n",
                    base, height, 0.5 * base * height);
        }
    }

    static class Rectangle4 extends Shape4 {
        private final double width;
        private final double height;

        Rectangle4(String name, double width, double height) {
            super(name);
            this.width = width;
            this.height = height;
        }

        @Override
        void display() {
            System.out.printf("Rectangle        : %.2f x %.2f, area %.2f%n",
                    width, height, width * height);
        }
    }

    static class Sphere4 extends Shape4 {
        private final double radius;

        Sphere4(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        @Override
        void display() {
            System.out.printf("Sphere           : radius %.2f, volume %.2f%n",
                    radius, 4.0 / 3.0 * Math.PI * radius * radius * radius);
        }
    }

    static class Cube4 extends Shape4 {
        private final double side;

        Cube4(String name, double side) {
            super(name);
            this.side = side;
        }

        @Override
        void display() {
            System.out.printf("Cube             : side %.2f, volume %.2f%n",
                    side, side * side * side);
        }
    }

    static class Loan4 {
        private final double amount;
        private final double rate;

        Loan4(double amount, double rate) {
            this.amount = amount;
            this.rate = rate;
        }

        double getAmount() {
            return amount;
        }

        double getRate() {
            return rate;
        }

        void display() {
            System.out.printf("Loan             : amount %.2f, rate %.2f%%%n",
                    amount, rate);
        }
    }

    static class CarLoan4 extends Loan4 {
        CarLoan4(double amount, double rate) {
            super(amount, rate);
        }

        @Override
        void display() {
            System.out.printf("CarLoan          : amount %.2f, rate %.2f%%%n",
                    getAmount(), getRate());
        }
    }

    static class HomeImprovementLoan4 extends Loan4 {
        HomeImprovementLoan4(double amount, double rate) {
            super(amount, rate);
        }

        @Override
        void display() {
            System.out.printf("HomeImprovement  : amount %.2f, rate %.2f%%%n",
                    getAmount(), getRate());
        }
    }

    static class MortgageLoan4 extends Loan4 {
        MortgageLoan4(double amount, double rate) {
            super(amount, rate);
        }

        @Override
        void display() {
            System.out.printf("MortgageLoan     : amount %.2f, rate %.2f%%%n",
                    getAmount(), getRate());
        }
    }

    static class Employee4 {
        private final String name;
        private final double salary;

        Employee4(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        String getName() {
            return name;
        }

        double getSalary() {
            return salary;
        }

        void display() {
            System.out.printf("Employee         : %s, salary %.2f%n", name, salary);
        }
    }

    static class Faculty4 extends Employee4 {
        private final String department;

        Faculty4(String name, double salary, String department) {
            super(name, salary);
            this.department = department;
        }

        @Override
        void display() {
            System.out.printf("Faculty          : %s, salary %.2f, department %s%n",
                    getName(), getSalary(), department);
        }
    }

    static class Staff4 extends Employee4 {
        private final String section;

        Staff4(String name, double salary, String section) {
            super(name, salary);
            this.section = section;
        }

        @Override
        void display() {
            System.out.printf("Staff            : %s, salary %.2f, section %s%n",
                    getName(), getSalary(), section);
        }
    }

    static class BankAccount4 {
        private final String accountNumber;
        private final double balance;

        BankAccount4(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        String getAccountNumber() {
            return accountNumber;
        }

        double getBalance() {
            return balance;
        }

        void display() {
            System.out.printf("BankAccount      : %s, balance %.2f%n",
                    accountNumber, balance);
        }
    }

    static class CheckingAccount4 extends BankAccount4 {
        private final double overdraftLimit;

        CheckingAccount4(String accountNumber, double balance, double overdraftLimit) {
            super(accountNumber, balance);
            this.overdraftLimit = overdraftLimit;
        }

        @Override
        void display() {
            System.out.printf("CheckingAccount  : %s, balance %.2f, overdraft %.2f%n",
                    getAccountNumber(), getBalance(), overdraftLimit);
        }
    }

    static class SavingsAccount4 extends BankAccount4 {
        private final double interestRate;

        SavingsAccount4(String accountNumber, double balance, double interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        @Override
        void display() {
            System.out.printf("SavingsAccount   : %s, balance %.2f, interest %.2f%%%n",
                    getAccountNumber(), getBalance(), interestRate);
        }
    }

    /* ---------------------------- Q05 ---------------------------- */
    abstract static class Shape5 {
        public abstract double area();

        @Override
        public String toString() {
            return String.format("%-13s area = %8.2f",
                    getClass().getSimpleName(), area());
        }
    }

    abstract static class TwoDimensionalShape5 extends Shape5 {
    }

    abstract static class ThreeDimensionalShape5 extends Shape5 {
        public abstract double volume();

        @Override
        public String toString() {
            return String.format("%-13s area = %8.2f, volume = %8.2f",
                    getClass().getSimpleName(), area(), volume());
        }
    }

    static class Circle5 extends TwoDimensionalShape5 {
        private final double radius;

        Circle5(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Square5 extends TwoDimensionalShape5 {
        private final double side;

        Square5(double side) {
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }
    }

    static class Triangle5 extends TwoDimensionalShape5 {
        private final double base;
        private final double height;

        Triangle5(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double area() {
            return 0.5 * base * height;
        }
    }

    static class Sphere5 extends ThreeDimensionalShape5 {
        private final double radius;

        Sphere5(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return 4.0 * Math.PI * radius * radius;
        }

        @Override
        public double volume() {
            return 4.0 / 3.0 * Math.PI * radius * radius * radius;
        }
    }

    static class Cube5 extends ThreeDimensionalShape5 {
        private final double side;

        Cube5(double side) {
            this.side = side;
        }

        @Override
        public double area() {
            return 6.0 * side * side;
        }

        @Override
        public double volume() {
            return side * side * side;
        }
    }

    static class Tetrahedron5 extends ThreeDimensionalShape5 {
        private final double edge;

        Tetrahedron5(double edge) {
            this.edge = edge;
        }

        @Override
        public double area() {
            return Math.sqrt(3.0) * edge * edge;
        }

        @Override
        public double volume() {
            return edge * edge * edge / (6.0 * Math.sqrt(2.0));
        }
    }

    /* ---------------------------- Q06 ---------------------------- */
    static class Student6 {
        private final String name;
        private final int id;
        private final double gpa;

        Student6(String name, int id, double gpa) {
            this.name = name;
            this.id = id;
            this.gpa = gpa;
        }

        String getLevel() {
            return "Student";
        }

        void display() {
            System.out.printf("%-12s %-6d %-14s GPA %.2f%n",
                    name, id, getLevel(), gpa);
        }
    }

    static class UndergraduateStudent6 extends Student6 {
        private final int yearOfStudy;

        UndergraduateStudent6(String name, int id, double gpa, int yearOfStudy) {
            super(name, id, gpa);
            this.yearOfStudy = yearOfStudy;
        }

        @Override
        String getLevel() {
            return "Undergraduate";
        }

        int getYearOfStudy() {
            return yearOfStudy;
        }
    }

    static class GraduateStudent6 extends Student6 {
        private final String thesisTitle;

        GraduateStudent6(String name, int id, double gpa, String thesisTitle) {
            super(name, id, gpa);
            this.thesisTitle = thesisTitle;
        }

        @Override
        String getLevel() {
            return "Graduate";
        }

        String getThesisTitle() {
            return thesisTitle;
        }
    }

    static class Freshman6 extends UndergraduateStudent6 {
        Freshman6(String name, int id, double gpa) {
            super(name, id, gpa, 1);
        }

        @Override
        String getLevel() {
            return "Freshman";
        }
    }

    static class Sophomore6 extends UndergraduateStudent6 {
        Sophomore6(String name, int id, double gpa) {
            super(name, id, gpa, 2);
        }

        @Override
        String getLevel() {
            return "Sophomore";
        }
    }

    static class Junior6 extends UndergraduateStudent6 {
        Junior6(String name, int id, double gpa) {
            super(name, id, gpa, 3);
        }

        @Override
        String getLevel() {
            return "Junior";
        }
    }

    static class Senior6 extends UndergraduateStudent6 {
        Senior6(String name, int id, double gpa) {
            super(name, id, gpa, 4);
        }

        @Override
        String getLevel() {
            return "Senior";
        }
    }

    static class MastersStudent6 extends GraduateStudent6 {
        private final String supervisor;

        MastersStudent6(String name, int id, double gpa,
                        String thesisTitle, String supervisor) {
            super(name, id, gpa, thesisTitle);
            this.supervisor = supervisor;
        }

        @Override
        String getLevel() {
            return "Masters";
        }
    }

    static class DoctoralStudent6 extends GraduateStudent6 {
        private final String researchTopic;

        DoctoralStudent6(String name, int id, double gpa,
                         String thesisTitle, String researchTopic) {
            super(name, id, gpa, thesisTitle);
            this.researchTopic = researchTopic;
        }

        @Override
        String getLevel() {
            return "Doctoral";
        }
    }

    /* ---------------------------- Q07 ---------------------------- */
    static class Point7 {
        private final double x;
        private final double y;

        Point7(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getX() {
            return x;
        }

        double getY() {
            return y;
        }

        double distance(Point7 other) {
            return Math.hypot(x - other.x, y - other.y);
        }

        @Override
        public String toString() {
            return String.format("(%.1f, %.1f)", x, y);
        }
    }

    abstract static class Quadrilateral7 {
        private final Point7 p1;
        private final Point7 p2;
        private final Point7 p3;
        private final Point7 p4;

        Quadrilateral7(Point7 p1, Point7 p2, Point7 p3, Point7 p4) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        }

        Point7 getP1() {
            return p1;
        }

        Point7 getP2() {
            return p2;
        }

        Point7 getP3() {
            return p3;
        }

        Point7 getP4() {
            return p4;
        }

        public abstract double area();

        double perimeter() {
            return p1.distance(p2) + p2.distance(p3)
                    + p3.distance(p4) + p4.distance(p1);
        }

        /** Perpendicular distance from p to the line through a and b. */
        static double distanceToLine(Point7 p, Point7 a, Point7 b) {
            double numerator = Math.abs(
                    (b.getX() - a.getX()) * (a.getY() - p.getY())
                    - (a.getX() - p.getX()) * (b.getY() - a.getY()));
            return numerator / a.distance(b);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " [" + p1 + ", " + p2
                    + ", " + p3 + ", " + p4 + "]";
        }
    }

    static class Trapezoid7 extends Quadrilateral7 {
        Trapezoid7(Point7 p1, Point7 p2, Point7 p3, Point7 p4) {
            super(p1, p2, p3, p4);
        }

        @Override
        public double area() {
            // p1-p2 and p3-p4 are the parallel bases.
            double base1 = getP1().distance(getP2());
            double base2 = getP3().distance(getP4());
            double height = distanceToLine(getP1(), getP3(), getP4());
            return 0.5 * (base1 + base2) * height;
        }
    }

    static class Parallelogram7 extends Quadrilateral7 {
        Parallelogram7(Point7 p1, Point7 p2, Point7 p3, Point7 p4) {
            super(p1, p2, p3, p4);
        }

        @Override
        public double area() {
            // Magnitude of the cross product of p1->p2 and p1->p4.
            double cross = (getP2().getX() - getP1().getX())
                    * (getP4().getY() - getP1().getY())
                    - (getP2().getY() - getP1().getY())
                    * (getP4().getX() - getP1().getX());
            return Math.abs(cross);
        }
    }

    static class Rectangle7 extends Parallelogram7 {
        Rectangle7(Point7 p1, Point7 p2, Point7 p3, Point7 p4) {
            super(p1, p2, p3, p4);
        }

        @Override
        public double area() {
            return getP1().distance(getP2()) * getP2().distance(getP3());
        }
    }

    static class Square7 extends Rectangle7 {
        Square7(Point7 p1, Point7 p2, Point7 p3, Point7 p4) {
            super(p1, p2, p3, p4);
        }

        @Override
        public double area() {
            double side = getP1().distance(getP2());
            return side * side;
        }
    }

    /* ---------------------------- Q18 ---------------------------- */
    static class A18 {
        public void aMethod(int a) {
            System.out.println("aMethod of A");
        }
    }

    static class B18 extends A18 {
        @Override
        public void aMethod(int a) {
            System.out.println("aMethod of B");
        }
    }

    static class C18 extends B18 {
        @Override
        public void aMethod(int a) {
            System.out.println("aMethod of C");
        }
    }

    /* ---------------------------- Q19 ---------------------------- */
    static class Super19 {
        Super19(int i) {
            System.out.println("Super(int)");
        }
    }

    static class Sub19 extends Super19 {
        Sub19(int i) {
            super(i);
            System.out.println("Sub(int)");
        }
    }

    /* ---------------------------- Q20 ---------------------------- */
    static class Super20 {
        int a = 10;
        static int x = 100;

        Super20() {
            System.out.println("Super()");
        }

        Super20(int i) {
            System.out.println("Super(int) with " + i);
        }
    }

    static class Sub20 extends Super20 {
        int b = 20;
        static int y = 200;

        Sub20(int i) {
            super(i);
            System.out.println("Sub(int) with " + i);
        }
    }

    /* ---------------------------- Q21 ---------------------------- */
    static class Person21 {
        private final String name;

        Person21(String name) {
            this.name = name;
            System.out.println("Person(String) runs");
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Student21 extends Person21 {
        private final int id;

        Student21(String name, int id) {
            super(name);
            this.id = id;
            System.out.println("Student(String,int) runs");
        }

        @Override
        public String toString() {
            return super.toString() + " (" + id + ")";
        }
    }

    /* ---------------------------- Q22 ---------------------------- */
    static class Parent22 {
        int value = 10;

        void show() {
            System.out.println("Parent22.show() reads value = " + value);
        }
    }

    static class Child22 extends Parent22 {
        int value = 20;

        @Override
        void show() {
            System.out.println("Child22.show() reads value = " + value);
        }

        void showSuperValue() {
            System.out.println("super.value = " + super.value);
        }
    }

    /* ---------------------------- Q24 ---------------------------- */
    static class Mixer24 {
        Mixer24 m1;

        Mixer24() {
        }

        Mixer24(Mixer24 m) {
            m1 = m;
        }

        void go() {
            System.out.print("hi ");
        }
    }

    /* ---------------------------- Q26 ---------------------------- */
    static class Figure26 {
        double dim1;
        double dim2;

        Figure26(double a, double b) {
            dim1 = a;
            dim2 = b;
        }

        double area() {
            System.out.println("undefined");
            return 0;
        }
    }

    static class Rectangle26 extends Figure26 {
        Rectangle26(double a, double b) {
            super(a, b);
        }

        @Override
        double area() {
            System.out.println("Inside Area for Rectangle.");
            return dim1 * dim2;
        }
    }

    static class Triangle26 extends Figure26 {
        Triangle26(double a, double b) {
            super(a, b);
        }

        @Override
        double area() {
            System.out.println("Inside Area for Triangle.");
            return dim1 * dim2 / 2;
        }
    }

    /* ---------------------------- Q27 ---------------------------- */
    static class A27 {
        static {
            System.out.print("A ");
        }
    }

    static class B27 extends A27 {
        static {
            System.out.print("B ");
        }
    }

    static class C27 extends B27 {
        static {
            System.out.print("C ");
        }
    }

    static class D27 extends B27 {
        static {
            System.out.print("D ");
        }
    }

    static class E27 extends C27 {
        static {
            System.out.print("E ");
        }
    }

    /* ---------------------------- Q32 ---------------------------- */
    abstract static class Vehicle32 {
        private final String registration;

        Vehicle32(String registration) {
            this.registration = registration;
        }

        String getRegistration() {
            return registration;
        }

        abstract void park();

        @Override
        public String toString() {
            return registration;
        }
    }

    static class Car32 extends Vehicle32 {
        Car32(String registration) {
            super(registration);
        }

        @Override
        void park() {
            System.out.println("CarParking " + getRegistration());
        }
    }

    static class Bus32 extends Vehicle32 {
        Bus32(String registration) {
            super(registration);
        }

        @Override
        void park() {
            System.out.println("BusParking " + getRegistration());
        }
    }

    static class Van32 extends Vehicle32 {
        Van32(String registration) {
            super(registration);
        }

        @Override
        void park() {
            System.out.println("VanParking " + getRegistration());
        }
    }

    static class VehicleQueue32 {
        private final Deque<Vehicle32> queue = new ArrayDeque<>();

        void enQueue(Vehicle32 vehicle) {
            if (vehicle == null) {
                throw new IllegalArgumentException("vehicle cannot be null");
            }
            queue.addLast(vehicle);
        }

        Vehicle32 deQueue() {
            return queue.pollFirst();
        }

        boolean isEmpty() {
            return queue.isEmpty();
        }

        void printVehicleQueue() {
            System.out.println(queue);
        }

        void callPark() {
            while (!queue.isEmpty()) {
                queue.removeFirst().park();
            }
        }
    }

    /* ---------------------------- Q34 ---------------------------- */
    static class Customer34 {
        private final int code;
        private final String name;

        Customer34(int code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public String toString() {
            return code + "-" + name;
        }
    }

    static class CustomerStack34 {
        private final Deque<Customer34> stack = new ArrayDeque<>();

        void push(Customer34 customer) {
            if (customer == null) {
                throw new IllegalArgumentException("customer cannot be null");
            }
            stack.push(customer);
        }

        Customer34 pop() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return stack.pop();
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        void printCustomerStack() {
            StringBuilder text = new StringBuilder("[");
            boolean first = true;
            for (Customer34 customer : stack) {
                if (!first) {
                    text.append(", ");
                }
                text.append(customer);
                first = false;
            }
            text.append("]");
            System.out.println(text);
        }
    }

    /* ---------------------------- Q35 ---------------------------- */
    static class A35 {
        void m(A35 a) {
            System.out.print("A");
        }
    }

    static class B35 extends A35 {
        void m(B35 b) {
            System.out.print("B");
        }
    }

    static class C35 extends B35 {
        void m(C35 c) {
            System.out.print("C");
        }
    }

    /* ---------------------------- Q37 ---------------------------- */
    static class Customer37 {
        String name = "Danapala";
        static String city = "Galle";

        Customer37() {
            printCustomer();
        }

        void printCustomer() {
            System.out.println("Super : " + name + " -> " + city);
        }
    }

    static class RegularCustomer37 extends Customer37 {
        String name = "Somapala";
        static String city = "Panadura";

        @Override
        void printCustomer() {
            System.out.println("Sub : " + name + " -> " + city);
        }
    }
}
