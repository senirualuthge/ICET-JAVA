import java.util.*;

public class OOPAssignment1{

    static Scanner input = new Scanner(System.in);

    

    /*
       01. 

       a) Class / Template
          A class is a blueprint (template) that describes the state
          (attributes) and the behaviour (methods) that the objects of
          that class will have. It does not hold real data; it only
          defines the structure. Declared with the `class` keyword.
              class Box{
                  int length;
                  int width;
                  int height;
              }

       b) Object / Instance
          An object is a concrete instance of a class. It is a real
          piece of memory that holds actual values for the attributes
          declared by the class. Created with the `new` keyword.
              Box b1 = new Box();   // b1 is an object of type Box

       c) Methods / Functions
          A method is a block of code defined inside a class that
          performs a specific task. It can use the attributes of the
          object it belongs to. It may return a value or may be void.
              void printVolume(){
                  System.out.println(length*width*height);
              }

       d) Attributes / Properties
          Attributes are the data holders (variables) declared inside a
          class that describe the state of an object. In Java they are
          called fields or variables; in other languages properties.
              int length;    // attribute of Box

       e) Reference Variables
          A variable that holds the memory address (reference) of an
          object instead of a value. Declared with a class (object)
          type. The default value of a reference variable is null.
              Box b1;              // b1 is a reference variable
              b1 = new Box();      // now it points to a Box object
              Box[] boxes;         // array of references

       f) Primitive Variables
          Variables that directly store a basic value (8 simple types)
          rather than an object address. Default values are 0 for
          numeric types, false for boolean, '\0' for char.
              int length = 12;          // primitive
              double price = 45.50;      // primitive

       g) Method Parameters
          Values passed into a method when it is called. Parameters are
          declared in the method signature. In Java primitives are
          always passed by value.
              void printCode(int code){ ... }   // 'code' is a parameter

       h) Local Variables
          Variables declared inside a method body or a block. They are
          created when the block starts, used only inside that block,
          and destroyed when the block ends.
              void printVolume(){
                  int volume;         // local variable
                  volume = length*width*height;
              }

       i) Default Values
          The value automatically given to a variable by the JVM when
          no value is assigned at declaration.
              int    a;     // 0
              double b;     // 0.0
              char   c;     // '\0' (null character)
              boolean d;    // false
              Box    e;     // null   (reference type)

       j) Declaration Values (Initializer Values)
          Values supplied directly in the declaration statement of a
          variable. Instance variable initializers run every time an
          object is created.
              class Box{ int length = 12; }   // declaration value

       k) Constructor
          A special method that has the SAME name as the class, has no
          return type (not even void), and is invoked automatically when
          an object is created. Its job is to give the object a valid
          initial state. If the class declares no constructor, Java
          supplies a default no-argument constructor automatically.
              Box(){
                  System.out.println("default constructor");
              }

       l) Instance Blocks
          A block written without any keyword inside a class body. It
          runs once for EVERY object created, and it is placed after the
          declaration-value initializers but before the constructor body.
              class Box{
                  int length;
                  { System.out.println("A box object is created.."); }
              }

       m) Static Variables
          Variables declared with the `static` keyword. Only ONE copy
          exists for the whole class, and it is SHARED by all objects of
          that class. It is loaded with the class, so it can be accessed
          through the class name.
              class Test{ static int y = 20; }

       n) Instance Variables
          Variables declared WITHOUT the `static` keyword. Every object
          of the class gets its OWN separate copy, and each copy is
          accessed through the object reference.
              class Test{ int x = 10; }
    */

    /*
       04. Difference between "attributes" and "methods" in a Java object
           (real-world examples)
       ATTRIBUTES store DATA (state). They hold values and describe WHAT
       the object currently is. They have no behaviour and are not called.

       METHODS store BEHAVIOUR (actions). They contain a block of code
       and describe WHAT the object can DO.

       Real-world example - a Bank Account:
         - attributes : accountNumber, balance, ownerName
                        -> data the account currently holds
         - methods    : deposit(amount), withdraw(amount), printBalance()
                        -> actions the account allows you to perform

       Real-world example - a Car:
         - attributes : colour, speed, fuelLevel
         - methods    : start(), accelerate(), applyBrakes()

       Real-world example - a Student:
         - attributes : indexNumber, name, gpa
         - methods    : calculateGPA(), printTranscript(), payFees()

       Java demonstration:
           class BankAccount{
               private String accountNumber;   // attribute
               private double balance;         // attribute
               public void deposit(double a){}  // method
               public void printBalance(){}     // method
           }
    */

    /*
       12. Purpose of a constructor in a Java class
       A constructor is a special method that has the same name as the
       class, has NO return type, and is called automatically by the
       `new` keyword when an object is created.

       PURPOSES OF A CONSTRUCTOR
         1. To give a newly created object a VALID INITIAL STATE - the
            object can never exist with meaningless data.
         2. To INITIALISE the attributes of the object, either with
            declaration values, a default no-argument constructor, or a
            parameterised constructor.
         3. To enforce RULES at creation time (e.g. a length must be
            positive) so invalid objects cannot be built.
         4. To allow OBJECT INITIALISATION OVERLOADING - `new Box()`,
            `new Box(5,4,3)`, `new Box(10)`.
         5. To perform any setup work the object needs before use.

       Example:
           class Box{
               int length, width, height;
               Box(){                        // default constructor
                   length = 2; width = 2; height = 2;
               }
               Box(int l,int w,int h){       // parameterised constructor
                   length = l; width = w; height = h;
               }
           }
       Note: If NO constructor is declared, the compiler provides a
       default no-argument constructor automatically.
    */

    /*
       13. Difference between "constructors" and "methods" in a Java object
                          CONSTRUCTOR                METHOD
       ------------------------------------------------------------------
       Purpose      Initialises an object         Performs a task/operation
       Name         MUST be the class name        Any valid name
       Return type  NO return type at all        May return a value or void
       Invocation   AUTOMATIC, by `new`           Called explicitly by name
       When it runs At object CREATION time        Any time it is called
       Reuse        Cannot be reused/inherited   Can be inherited & overridden
       Overloading  Yes, by parameter count       Yes, by parameter list
       (common)     Used to set the initial state Used to expose behaviour

       Real-world example:
         Constructor = the building constructor of a house. When the house
         is built (new House(...)) the constructor decides the initial
         state - colour of the walls, number of rooms, whether the door is
         locked. It runs automatically and can never be "re-called".

         Method = the actions a finished house allows: openDoor(),
         closeWindow(), switchOnLight(). You call them when you want, as
         many times as you want.
    */

    /*
       23. Describe "encapsulation", the key concept of OOP
       Encapsulation is the concept of BUNDLING data (attributes) and
       the methods that operate on that data together inside a single
       unit (a class), and then PROTECTING the data from direct,
       uncontrolled outside access.

       Java implements the protection with the `private` access modifier.
       The data is only reachable from inside the class, through
       PUBLIC getter and setter methods. This is also called
       "information hiding" or "data hiding".

       WHY IT IS IMPORTANT
         - PROTECTION : the internal data cannot be corrupted from
                        outside the class.
         - VALIDATION : the class can reject illegal values
                        (e.g. a negative salary).
         - FLEXIBILITY: the internal representation can be changed later
                        without affecting the outside code.
         - ABSTRACTION: the outside user only needs to know the public
                        methods, not how the data is stored.

       Example:
           class Employee{
               private double monthlySalary;      // hidden data
               public double getMonthlySalary(){    // getter
                   return monthlySalary;
               }
               public void setMonthlySalary(double s){
                   if (s > 0) monthlySalary = s;   // validation
               }
           }
       Outside the class, `emp.monthlySalary = -100;` is a compile-time
       error because the attribute is private, so the invalid salary can
       never reach the object. The rule is enforced by the compiler.
    */

    /*
       24. Difference between "tightly encapsulated" and "loosely
           encapsulated" classes
       TIGHTLY ENCAPSULATED
         - Every attribute is declared `private`.
         - No attribute can be read or written directly from outside.
         - All access goes through public getter/setter methods.
         - Validation rules live inside the class.
         - Data can never be put into an invalid state.
         Example:
             class Box{
                 private int length;   // private
                 public int getLength(){ return length; }
                 public void setLength(int l){
                     if (l > 0) length = l;
                 }
             }

       LOOSELY ENCAPSULATED
         - Attributes are declared with default (package) or `public`
           access, so outside code can read and write them DIRECTLY.
         - The class is only a data holder; the data is exposed.
         - No validation is possible from outside.
         - Any outside class can corrupt the object's state.
         Example:
             class Box{
                 public int length;    // anyone can change this
             }
             // outside:
             b1.length = -50;   // illegal value accepted with no complaint

       In short: tightly encapsulated = data private + controlled access
       through methods; loosely encapsulated = data exposed directly.
    */

    /*
       34. Difference between "static variables" and "instance variables"
       Keyword        Both are declared with a data type, but a static
                      variable uses the `static` keyword.
       Copies         Instance variable -> ONE COPY PER OBJECT.
                      Static variable    -> ONE COPY FOR THE WHOLE CLASS.
       Memory         Instance variables live in the object on the heap.
                      Static variables live in the class area .
       Access         Instance variable is accessed through an object
                      reference:  obj.x
                      Static variable is normally accessed through the
                      class name:   Test.y
       Sharing        Instance variables are independent - changing
                      obj1.x does not affect obj2.x.
                      Static variables are SHARED - changing Test.y or
                      obj1.y changes it for every object.
       this keyword   `this.x` is legal in any method.
                      `this.y` is ALSO legal inside an instance method,
                      but a static method has no `this`, so a static
                      variable must be used without `this` in static
                      methods.
       Initialisation Instance variable initializers run every time an
                      object is created (`new`).
                      Static variables are initialised ONCE, when the
                      class is loaded into memory.
       Memory cost    More memory (one copy per object).
                      Less memory (a single shared copy).
       Example:
           class Test{
               int x = 10;        // instance variable
               static int y = 20;  // static variable
           }
           Test t1 = new Test();
           Test t2 = new Test();
           t1.x = 1;   // t2.x is untouched - separate copies
           t1.y = 2;   // t2.y is ALSO 2 - shared
    */

    /*
       37. Difference between "static methods" and "instance methods"
       Keyword        Static method is declared with the `static`
                      keyword; an instance method is declared without it.
       Belonging to   A static method belongs to the CLASS.
                      An instance method belongs to each OBJECT.
       Calling        Static method:
                          Demo.staticMethod();      // via class name
                          obj.staticMethod();       // allowed but not advised
                      Instance method:
                          obj.instanceMethod();      // via object only
       `this`         A static method has NO `this` reference, so it
                      CANNOT read or write instance variables directly
                      (compile-time error).
                      An instance method has `this` and can freely use
                      both instance and static variables.
       Memory         One copy in the class area.
                      One copy per object.
       `main`         `public static void main(...)` is static, so it can
                      be the starting point of the JVM. A non-static
                      method can never be the entry point.
       Purpose        Utility/helper work that does not need object data.
                      Operations that need the object's own state.
       Example:
           class Demo{
               static void s(){ System.out.println("static"); }
               void i(){        System.out.println("instance"); }
               public static void main(String a){
                   s();        // OK
                  
                   new Demo().i();   // OK
               }
           }
    */

    /*
       45. "Method call by value" vs "method call by reference"
       CALL BY VALUE
         A COPY of the argument is passed to the parameter. The method
         works on its own copy, so the original variable is NEVER
         changed. This is how Java passes PRIMITIVE values (int, double,
         char, boolean).

       CALL BY REFERENCE
         The actual REFERENCE (memory address) of the object is passed.
         Inside the method the same object is reached, so any change to
         the object's attributes IS visible to the caller. This is how
         Java passes OBJECT references.

       Java is therefore ALWAYS "call by value" - but when the value
       being copied is a reference, the effect looks like call by
       reference. Re-assigning the parameter inside the method
       (`v = vh;`) only changes the local copy of the reference and is
       NOT visible outside, whereas changing the object's attributes
       (`v.i = 20;`) IS visible outside.

       Example:
           class ValHold{ public int i = 10; }
           void another(ValHold v, int i){
               i = 0;        // by value    -> caller's i unchanged
               v.i = 20;     // by reference-> caller sees 20
               v = new ValHold(); // new local reference -> caller unchanged
           }
    */

   

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
        q38();
        q39();
        q40();
        q41();
        q42();
        q43();
        q44();
        q45();
        q46();
        q47();
        q48();
        q49();
        q50();
        q51();
        q52();
        q53();
    }

    
    static void q01() {
        System.out.println("---- Q01 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file (items a to n).");
    }

    
    static void q02() {
        System.out.println("---- Q02 ----");
        System.out.println("class Test{ int a=8; int b=9; }");
        System.out.println("class Demo{ main(){ System.out.print(a);");
        System.out.println("                    System.out.println(b); } }");
        System.out.println("Answer: D. Compile time error");
        System.out.println("Reason : a and b are instance variables of Test.");
        System.out.println("        main() belongs to Demo and there is no");
        System.out.println("        object reference, so the compiler reports");
        System.out.println("        \"cannot find symbol: variable a\".");
    }

    
    static void q03() {
        System.out.println("---- Q03 ----");
        TestQ03 t1 = new TestQ03();
        System.out.print(t1.a);
        System.out.println(t1.b);
        System.out.println("Output : 89");
        System.out.println("Reason : t1.a is 8 and t1.b is 9, print() gives no");
        System.out.println("        new line, println() ends the line.");
    }

    /*
       04.
     */
    static void q04() {
        System.out.println("---- Q04 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       05. 
     */
    static void q05() {
        System.out.println("---- Q05 ----");
        System.out.println("Line 1 : Box b1=new Box();                 -> LEGAL");
        System.out.println("Line 2 : println(\"...\"+length);             -> ILLEGAL");
        System.out.println("Line 3 : println(\"...\"+width);              -> ILLEGAL");
        System.out.println("Line 4 : println(\"...\"+height);             -> ILLEGAL");
        System.out.println("Reason  : length, width and height are instance");
        System.out.println("          variables of Box. They can only be read");
        System.out.println("          through an object reference, so they must");
        System.out.println("          be written as b1.length, b1.width, b1.height.");
    }

    /*
       06.  
     */
    static void q06() {
        System.out.println("---- Q06 ----");
        BoxQ06 b1 = new BoxQ06();
        b1.printVolume();
        System.out.println("length of box : " + b1.length);
        System.out.println("width of box : " + b1.width);
        System.out.println("height of box : " + b1.height);
        System.out.println("Reason : length, width and height are instance");
        System.out.println("        variables with no declaration values, so");
        System.out.println("        they hold the default value 0 and");
        System.out.println("        volume = 0*0*0 = 0.");
    }

    /*
       07.
     */
    static void q07() {
        System.out.println("---- Q07 ----");
        BoxQ07 b1 = new BoxQ07();
        b1.printVolume();
        System.out.println("length of box : " + b1.length);
        System.out.println("width of box : " + b1.width);
        System.out.println("height of box : " + b1.height);
        System.out.println("Reason : the declaration-value initializers run");
        System.out.println("        every time an object is created, so");
        System.out.println("        volume = 12*5*3 = 180.");
    }

    /*
       08. 
     */
    static void q08() {
        System.out.println("---- Q08 ----");
        BoxQ08 b1 = new BoxQ08();
        System.out.println("length of box : " + b1.length);
        System.out.println("width of box : " + b1.width);
        System.out.println("height of box : " + b1.height);
        System.out.println("Reason : the compiler supplies a default no-");
        System.out.println("        argument constructor because none is");
        System.out.println("        declared. That constructor sets 2, 2, 2.");
    }

    /*
       09. 
     */
    static void q09() {
        System.out.println("---- Q09 ----");
        BoxQ09 b1 = new BoxQ09(5, 4, 3);
        b1.printVolume();
        BoxQ09 b2 = new BoxQ09(12, 5, 3);
        b2.printVolume();
        System.out.println("Reason : each object gets its own copy of the");
        System.out.println("        attributes, so b1 = 5*4*3 = 60 and");
        System.out.println("        b2 = 12*5*3 = 180.");
    }

    /*
       10.
     */
    static void q10() {
        System.out.println("---- Q10 ----");
        System.out.println("Box b1=new Box();            -> LEGAL");
        System.out.println("println(\"...\"+b1.length);      -> LEGAL");
        System.out.println("println(\"...\"+b1.width);       -> COMPILE TIME ERROR");
        System.out.println("println(\"...\"+b1.height);      -> LEGAL");
        System.out.println("Reason : width is declared private, so it is only");
        System.out.println("        visible inside Box. Demo is another class,");
        System.out.println("        so \"width has private access in Box\".");
        System.out.println("        This is exactly what encapsulation does.");
    }

    /*
       11.
     */
    static void q11() {
        System.out.println("---- Q11 ----");
        System.out.println("Line 1 : int length;      -> LEGAL (declaration)");
        System.out.println("Line 2 : int width;       -> LEGAL (declaration)");
        System.out.println("Line 3 : int height;      -> LEGAL (declaration)");
        System.out.println("Line 4 : length=12;       -> ILLEGAL");
        System.out.println("Line 5 : width=5;         -> ILLEGAL");
        System.out.println("Line 6 : height=3;        -> ILLEGAL");
        System.out.println("Reason : a class body may only contain member");
        System.out.println("        declarations - fields, methods,");
        System.out.println("        constructors and initialiser blocks.");
        System.out.println("        Assignment statements are not allowed");
        System.out.println("        there. They must go inside a method,");
        System.out.println("        a constructor or an instance block.");
    }

    /*
       12. 
     */
    static void q12() {
        System.out.println("---- Q12 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       13.
     */
    static void q13() {
        System.out.println("---- Q13 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       14. 
     */
    static void q14() {
        System.out.println("---- Q14 ----");
        System.out.println("A. Box b1;                  -> LEGAL");
        BoxQ14 a1;
        System.out.println("B. Box b1=new Box();        -> LEGAL");
        BoxQ14 b1 = new BoxQ14();
        System.out.println("C. new Box();               -> LEGAL");
        new BoxQ14();
        System.out.println("D. Box b1=new Box(12,5,3);  -> ILLEGAL, no such constructor");
        System.out.println("E. Box b1=new Box(10);      -> ILLEGAL, no such constructor");
        System.out.println("Answer: A, B and C");
        System.out.println("Reason : Box declares no constructor, so only the");
        System.out.println("        compiler supplied no-argument constructor");
        System.out.println("        new Box() exists. A only declares a");
        System.out.println("        reference, C creates an object without");
        System.out.println("        keeping the reference, B keeps it.");
    }

    /*
       15. b1.WIDTH and b1.height do not exist.
     */
    static void q15() {
        System.out.println("---- Q15 ----");
        System.out.println("The program DOES NOT COMPILE.");
        System.out.println("Line 1 : System.out.print(b1.length);  -> LEGAL (0)");
        System.out.println("Line 2 : System.out.print(b1.WIDTH);   -> ILLEGAL");
        System.out.println("Line 3 : System.out.print(b1.height);  -> ILLEGAL");
        System.out.println("Reason : Java is case sensitive, so WIDTH is a");
        System.out.println("        different name from the declared width.");
        System.out.println("        Box also has no height attribute at all.");
        System.out.println("        The first error reported is at line 2.");
    }

    /*
       16. 
     */
    static void q16() {
        System.out.println("---- Q16 ----");
        TestQ16 t1 = new TestQ16(1, 2);
        System.out.print(t1.a + " " + t1.b + " ");
        TestQ16 t2 = new TestQ16();
        System.out.println(t2.a + " " + t2.b);
        System.out.println("Answer: C. 1 2 3 4");
        System.out.println("Reason : Test(int,int) sets a=1, b=2 for t1.");
        System.out.println("        Test() has an empty body, but the");
        System.out.println("        declaration values a=3 and b=4 still run");
        System.out.println("        for every new object, so t2 gets 3 and 4.");
    }

    /*
       17. 
     */
    static void q17() {
        System.out.println("---- Q17 ----");
        System.out.println("Required output: Values : 100, 200");
        System.out.println();
        System.out.println("A. int x; int y; MyClass(int i,int j){ x=i; y=j; }");
        MyClass17A a = new MyClass17A(100, 200);
        a.printValues();
        System.out.println("   -> A is CORRECT (values are copied into the fields)");
        System.out.println();
        System.out.println("B. int x=100; int y=200; MyClass(int i,int j){ }");
        MyClass17B b = new MyClass17B(100, 200);
        b.printValues();
        System.out.println("   -> B is CORRECT (fields already hold 100 and 200,");
        System.out.println("      the empty constructor body changes nothing)");
        System.out.println();
        System.out.println("C. int x; int y; MyClass(int i,int j){ i=x; j=y; }");
        MyClass17C c = new MyClass17C(100, 200);
        c.printValues();
        System.out.println("   -> C is WRONG (assigns the fields INTO the");
        System.out.println("      parameters, so x and y keep their defaults 0)");
        System.out.println();
        System.out.println("D. int x; int y; MyClass(int i,int j){ x=100; y=200; }");
        MyClass17D d = new MyClass17D(100, 200);
        d.printValues();
        System.out.println("   -> D is CORRECT (hard-codes 100 and 200, so it");
        System.out.println("      gives the required output for THIS call only)");
        System.out.println();
        System.out.println("Answer: A, B and D");
    }

    /*
       18.
     */
    static void q18() {
        System.out.println("---- Q18 ----");
        A18 a1 = new A18(100);
        A18 a2 = new A18(101);
        System.out.println(a1.a + " " + a2.a);
        a1 = a2;
        a1.a = 0;
        System.out.println(a1.a + " " + a2.a);
        System.out.println("Reason : a1 and a2 are references. a1=a2 copies the");
        System.out.println("        address, so both now refer to the SAME");
        System.out.println("        object. Setting a1.a=0 therefore changes");
        System.out.println("        that one shared object, and both print 0.");
    }

    /*
       19.
     */
    static void q19() {
        System.out.println("---- Q19 ----");
        Item19 t1 = new Item19(2001);
        t1.printCode(3001);
        System.out.println("Reason : inside printCode, the parameter code=3001");
        System.out.println("        shadows the attribute code=2001, so the");
        System.out.println("        simple name code refers to the parameter.");
    }

    /*
       20. 
     */
    static void q20() {
        System.out.println("---- Q20 ----");
        Item20 t1 = new Item20(2001);
        t1.printCode(3001);
        System.out.println("Reason : this.code explicitly means the attribute");
        System.out.println("        of the current object, which the constructor");
        System.out.println("        set to 2001. The parameter 3001 is ignored.");
    }

    /*
       21. 
     */
    static void q21() {
        System.out.println("---- Q21 ----");
        System.out.println("A. A(int i){a=i;}    -> ILLEGAL. Declaring any");
        System.out.println("                        constructor removes the");
        System.out.println("                        compiler supplied no-arg one,");
        System.out.println("                        so new A() has nothing to call.");
        System.out.println("B. void A(int i){a=i;} -> LEGAL. It has a return");
        System.out.println("                        type, so it is a METHOD named A,");
        System.out.println("                        not a constructor. A stays a");
        System.out.println("                        class with an implicit no-arg");
        System.out.println("                        constructor.");
        A21B b = new A21B();
        System.out.println("                        a = " + b.a + "  (proof: compiles)");
        System.out.println("C. A(){}             -> LEGAL and obvious.");
        A21C c = new A21C();
        System.out.println("                        a = " + c.a + "  (proof: compiles)");
        System.out.println("D. Insert nothing     -> LEGAL. The compiler supplies");
        System.out.println("                        the default no-arg constructor.");
        A21D d = new A21D();
        System.out.println("                        a = " + d.a + "  (proof: compiles)");
        System.out.println("Answer: B, C and D");
    }

    /*
       22.
     */
    static void q22() {
        System.out.println("---- Q22 ----");
        System.out.println("Demo calls new A(100), so the parameter is always 100.");
        System.out.println();
        System.out.println("A. A(int i){a=i;}");
        new A22A(100).printValue();
        System.out.println("   -> CORRECT, it prints 100");
        System.out.println();
        System.out.println("B. A(int a){a=a;}");
        new A22B(100).printValue();
        System.out.println("   -> WRONG,   it prints 0");
        System.out.println();
        System.out.println("C. A(int a){a=this.a;}");
        new A22C(100).printValue();
        System.out.println("   -> WRONG,   it prints 0");
        System.out.println();
        System.out.println("D. A(int a){this.a=a;}");
        new A22D(100).printValue();
        System.out.println("   -> CORRECT, it prints 100");
        System.out.println();
        System.out.println("E. A(int i){a=100;}");
        new A22E(100).printValue();
        System.out.println("   -> CORRECT, it prints 100");
        System.out.println();
        System.out.println("F. A(int i){i=a;}");
        new A22F(100).printValue();
        System.out.println("   -> WRONG,   it prints 0");
        System.out.println();
        System.out.println("Answer: A, D and E");
        System.out.println("Reason : the parameter name a SHADOWS the attribute,");
        System.out.println("        so in B, C and F the simple name a is the");
        System.out.println("        parameter, not the field, and the field is");
        System.out.println("        never written. Using this.a (D) or a different");
        System.out.println("        parameter name (A, E) makes the assignment");
        System.out.println("        reach the attribute.");
    }

    /*
       23. 
     */
    static void q23() {
        System.out.println("---- Q23 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       24. 
     */
    static void q24() {
        System.out.println("---- Q24 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       25.
     */
    static void q25() {
        System.out.println("---- Q25 ----");
        System.out.println("class Test{");
        System.out.println("    int a=100;                 //Line 1");
        System.out.println("    System.out.print(a);        //Line 2");
        System.out.println("}");
        System.out.println("Answer: D. Compiler error at line 2");
        System.out.println("Reason : line 1 is a valid field declaration, but a");
        System.out.println("        class body cannot contain executable");
        System.out.println("        statements. System.out.print(a) must be");
        System.out.println("        placed inside a method, constructor or");
        System.out.println("        instance initialiser block.");
    }

    /*
       26. Create the fully encapsulated class "Date".
     */
    static void q26() {
        System.out.println("---- Q26 ----");
        Date d1 = new Date();
        d1.printDate();                     // 1970-1-1
        // d1.year = 2016;   // Illegal - year is private
        // d1.month = 5;     // Illegal - month is private
        // d1.day = 30;      // Illegal - day is private
        d1.setYear(2016);
        d1.setMonth(5);
        d1.setDay(31);
        System.out.println("Year : " + d1.getYear());
        System.out.println("Month :" + d1.getMonth());
        System.out.println("Day        : " + d1.getDay());
        System.out.println("Reason : year, month and day are declared private,");
        System.out.println("        so they CANNOT be accessed from another");
        System.out.println("        class. Values can only be read through the");
        System.out.println("        getters and changed through the setters.");
    }

    /*
       27.
     */
    static void q27() {
        System.out.println("---- Q27 ----");
        Customer c1;                                     // Line 1
        c1 = new Customer("C001", "Danapala");           // Line 2
        c1.printCustomer();                              // Line 3
        Customer c2;                                     // Line 4
        c2 = new Customer();                             // Line 5
        c2.setCustomerDetail("C002", "Gunapala");        // Line 6
        c2.printCustomer();                              // Line 7
        Customer c3;                                     // Line 8
        c3 = new Customer();                             // Line 9
        c3.setId("C003");                                // Line 10
        c3.setName("Somapala");                          // Line 11
        c3.printCustomer();                              // Line 12
        System.out.println("Line 1  : declares a reference variable c1 only.");
        System.out.println("           No object exists yet, so c1 holds null.");
        System.out.println("Line 2  : creates the object and calls the");
        System.out.println("           parameterised constructor, so");
        System.out.println("           id=\"C001\", name=\"Danapala\".");
        System.out.println("Line 3  : prints id + \" - \" + name.");
        System.out.println("Line 4  : declares a reference variable c2 only.");
        System.out.println("Line 5  : calls the empty constructor, so id and");
        System.out.println("           name are both null at this moment.");
        System.out.println("Line 6  : the grouped setter sets both attributes");
        System.out.println("           at once using this to avoid shadowing.");
        System.out.println("Line 7  : prints C002 - Gunapala.");
        System.out.println("Line 8  : declares a reference variable c3 only.");
        System.out.println("Line 9  : calls the empty constructor again.");
        System.out.println("Line 10 : sets only the id through its own setter.");
        System.out.println("Line 11 : sets only the name through its setter.");
        System.out.println("Line 12 : prints C003 - Somapala.");
        System.out.println("Note    : all three printCustomer() calls work from");
        System.out.println("           DemoCustomer even though the attributes");
        System.out.println("           are private, because printCustomer()");
        System.out.println("           is a public method of the same class.");
    }

    /*
       28. Demo refers to MyClass but the class is named Test.
     */
    static void q28() {
        System.out.println("---- Q28 ----");
        System.out.println("System.out.println(MyClass.x);   //Line 1 -> ERROR");
        System.out.println("System.out.println(MyClass.y);   //Line 2 -> ERROR");
        System.out.println("MyClass c1=new MyClass();        //Line 3 -> ERROR");
        System.out.println("System.out.println(c1.x);        //Line 4 -> ERROR");
        System.out.println("System.out.println(c1.y);        //Line 5 -> ERROR");
        System.out.println("Answer: A. Compile error at line 1");
        System.out.println("Reason : the class in the file is named Test, not");
        System.out.println("        MyClass. The compiler fails on the very");
        System.out.println("        first reference and reports that MyClass");
        System.out.println("        cannot be found, so every later line also");
        System.out.println("        fails. Even if the name were fixed,");
        System.out.println("        MyClass.x would still be illegal because");
        System.out.println("        x is an instance variable - only y is static.");
    }

    /*
       29. 
     */
    static void q29() {
        System.out.println("---- Q29 ----");
        MyClass29 c1 = new MyClass29();
        MyClass29 c2 = new MyClass29();
        MyClass29 c3 = new MyClass29();
        c1.x = 1;
        c1.y = 2;
        c2.x = 10;
        c2.y = 20;
        c3.x = 100;
        c3.y = 200;
        System.out.println(c1.x + " " + c1.y + " " + c2.x + " " + c2.y + " " + c3.x + " " + c3.y);
        System.out.println("Answer: F. None of the above");
        System.out.println("Reason : x is an instance variable, so c1.x=1,");
        System.out.println("        c2.x=10 and c3.x=100 stay independent.");
        System.out.println("        y is static - there is only ONE copy, so");
        System.out.println("        the last assignment (c3.y=200) wins for all");
        System.out.println("        three references. Result: 1 200 10 200 100 200");
    }

    /*
       30. 
     */
    static void q30() {
        System.out.println("---- Q30 ----");
        System.out.print("Enter the length (0.0 < length < 20.0) : ");
        double length = input.nextDouble();
        System.out.print("Enter the width  (0.0 < width  < 20.0) : ");
        double width = input.nextDouble();

        Rectangle30 r = new Rectangle30();
        System.out.println("Default length : " + r.getLength());
        System.out.println("Default width  : " + r.getWidth());

        r.setLength(length);
        r.setWidth(width);

        System.out.println("length : " + r.getLength());
        System.out.println("width  : " + r.getWidth());
        System.out.println("area        : " + r.getArea());
        System.out.println("perimeter   : " + r.getPerimeter());
    }

    /*
       31.
     */
    static void q31() {
        System.out.println("---- Q31 ----");
        System.out.println("Line 1 : instanceMethod();      -> COMPILE ERROR");
        System.out.println("Line 2 : staticMethod();         -> LEGAL");
        System.out.println("Line 3 : Demo.instanceMethod();  -> COMPILE ERROR");
        System.out.println("Line 4 : Demo.staticMethod();    -> LEGAL");
        System.out.println("Line 5 : Demo d1=new Demo();     -> LEGAL");
        System.out.println("Line 6 : d1.instanceMethod();    -> LEGAL");
        System.out.println("Line 7 : d1.staticMethod();      -> LEGAL");
        System.out.println("Answer: A. Compile error at line 1");
        System.out.println("Reason : main is static, so it has no this and no");
        System.out.println("        object to call through. instanceMethod()");
        System.out.println("        can only be reached through an object.");
        System.out.println("        The compiler fails at the first such call,");
        System.out.println("        which is line 1.");
        System.out.println();
        System.out.println("The four legal lines actually run as follows:");
        Demo31.mainRun();
    }

    /*
       32. 
     */
    static void q32() {
        System.out.println("---- Q32 ----");
        Test32 t1 = new Test32(1, 2);
        Test32 t2 = new Test32(10, 20);
        Test32 t3 = new Test32(100, 200);
        t1.printXY();
        t2.printXY();
        t3.printXY();
        System.out.println();
        System.out.println("Answer: F. None of the above");
        System.out.println("Reason : x is per object, so x is 1, 10 and 100.");
        System.out.println("        y is static - a single shared copy - so by");
        System.out.println("        the time the printing starts y is already");
        System.out.println("        200 for all three objects.");
        System.out.println("        Result: 1 200 10 200 100 200");
    }

    /*
       33. 
     */
    static void q33() {
        System.out.println("---- Q33 ----");
        System.out.println("Line 1 : println(x)   in mA (instance) -> LEGAL");
        System.out.println("Line 2 : println(y)   in mA (instance) -> LEGAL");
        System.out.println("Line 3 : staticMethod() in mA          -> LEGAL");
        System.out.println("Line 4 : instanceMethod() in mA         -> LEGAL");
        System.out.println("Line 5 : println(x)   in mB (static)  -> ILLEGAL");
        System.out.println("Line 6 : println(y)   in mB (static)  -> LEGAL");
        System.out.println("Line 7 : staticMethod() in mB          -> LEGAL");
        System.out.println("Line 8 : instanceMethod() in mB        -> ILLEGAL");
        System.out.println("Illegal lines: 5 and 8");
        System.out.println("Reason : mB is static, so it has no this and no");
        System.out.println("        object, therefore it cannot read the");
        System.out.println("        instance variable x (line 5) nor call");
        System.out.println("        the instance method (line 8).");
        System.out.println("        A static method may freely use static");
        System.out.println("        members - that is why lines 6 and 7 pass.");
    }

    /*
       34. 
     */
    static void q34() {
        System.out.println("---- Q34 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       35. 
     */
    static void q35() {
        System.out.println("---- Q35 ----");
        System.out.println("Line 1 : println(a);        -> ERROR  (A)");
        System.out.println("Line 2 : println(b);        -> LEGAL");
        System.out.println("Line 3 : println(c);        -> ERROR  (C)");
        System.out.println("Line 4 : println(Demo.a);   -> ERROR  (D)");
        System.out.println("Line 5 : println(Demo.b);   -> LEGAL");
        System.out.println("Line 6 : println(Demo.c);   -> ERROR  (F)");
        System.out.println("Line 7 : println(ob.a);     -> LEGAL");
        System.out.println("Line 8 : println(ob.b);     -> LEGAL");
        System.out.println("Line 9 : println(ob.c);     -> ERROR  (I)");
        System.out.println("Answer: A, C, D, F and I");
        System.out.println("Reason : a is an instance variable, so it needs an");
        System.out.println("        object (main is static -> line 1 fails;");
        System.out.println("        through a class name -> line 4 fails).");
        System.out.println("        c is a local variable of main, so it cannot");
        System.out.println("        be reached through the class name (line 6)");
        System.out.println("        and it is not a field of Demo at all");
        System.out.println("        (line 9).");
    }

    /*
       36. 
     */
    static void q36() {
        System.out.println("---- Q36 ----");
        Date d1 = new Date();
        d1.set(Date.YEAR, 2016);   // set(int field, int value)
        d1.set(Date.MONTH, 5);
        d1.set(Date.DAY, 30);
        d1.printDate();             // 2016-5-30
        System.out.println("Reason : the constants YEAR, MONTH and DAY hold");
        System.out.println("        the field codes 1, 2 and 3. set() looks at");
        System.out.println("        the code and updates the matching private");
        System.out.println("        attribute, so the caller never touches the");
        System.out.println("        data directly.");
    }

    /*
       37. 
     */
    static void q37() {
        System.out.println("---- Q37 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

    /*
       38. 
     */
    static void q38() {
        System.out.println("---- Q38 ----");
        Box38 b1 = new Box38();
        System.out.println("Reason : the static block runs ONCE, when the Box");
        System.out.println("        class is loaded into memory by the JVM.");
        System.out.println("        It does not run again for each new object.");
    }

    /*
       39.
     */
    static void q39() {
        System.out.println("---- Q39 ----");
        Box39 b1 = new Box39();
        Box39 b2 = new Box39();
        System.out.println("Reason : the instance block has no keyword, so it");
        System.out.println("        belongs to the object. It runs once for");
        System.out.println("        EVERY object created - twice here, because");
        System.out.println("        two Box objects are created.");
    }

    /*
       40. 
     */
    static void q40() {
        System.out.println("---- Q40 ----");
        Cylinder40 c1 = new Cylinder40();          // default constructor
        System.out.println("--- default constructed cylinder ---");
        System.out.println("length : " + c1.getLength());
        System.out.println("radius : " + c1.getRadius());
        System.out.println("volume : " + c1.getVolume());
        System.out.println("area   : " + c1.getArea());

        System.out.print("Enter the length of the cylinder : ");
        double length = input.nextDouble();
        System.out.print("Enter the radius of the cylinder : ");
        double radius = input.nextDouble();

        Cylinder40 c2 = new Cylinder40(length, radius);   // parameterised ctor
        System.out.println("--- parameterised constructed cylinder ---");
        System.out.println("length : " + c2.getLength());
        System.out.println("radius : " + c2.getRadius());
        System.out.println("volume : " + c2.getVolume());
        System.out.println("area (total surface) : " + c2.getArea());
        System.out.println("lateral area        : " + c2.getLateralArea());

        System.out.println("--- using the setters ---");
        c2.setLength(5.0);
        c2.setRadius(2.0);
        System.out.println("length : " + c2.getLength());
        System.out.println("radius : " + c2.getRadius());
        System.out.println("volume : " + c2.getVolume());
        System.out.println("area (total surface) : " + c2.getArea());
    }

    /*
       41. 
     */
    static void q41() {
        System.out.println("---- Q41 ----");
        Box41 b1 = new Box41();
        Box41 b2 = new Box41();
        Box41 b3 = new Box41();
        System.out.println("Reason : the static block belongs to the CLASS and");
        System.out.println("        runs once when Box is loaded. The instance");
        System.out.println("        block belongs to the OBJECT and runs once");
        System.out.println("        per new object, so it runs three times.");
    }

    /*
       42. 
     */
    static void q42() {
        System.out.println("---- Q42 ----");
        System.out.println("Line 1 : println(this.x) in mA (instance) -> LEGAL");
        System.out.println("Line 2 : println(this.y) in mA (instance) -> LEGAL");
        System.out.println("Line 3 : println(this.x) in mB (static)  -> COMPILE ERROR");
        System.out.println("Line 4 : println(this.y) in mB (static)  -> COMPILE ERROR");
        System.out.println("Answer: C. Compile error at line 3");
        System.out.println("Reason : this always points to the CURRENT OBJECT.");
        System.out.println("        A static method runs without any object, so");
        System.out.println("        it has no this at all. The compiler fails on");
        System.out.println("        the first use of this, which is line 3.");
    }

    /*
       43. 
     */
    static void q43() {
        System.out.println("---- Q43 ----");
        System.out.println("MyClass{ static{ '1 ' }  { '2 ' }  MyClass(){ '3 ' }  static mB(){ '4 ' } }");
        System.out.println("Rule : the static block runs ONCE, when the class is loaded.");
        System.out.println("       For every object created afterwards the order is");
        System.out.println("       declaration values, instance block, constructor body.");
        System.out.println();
        System.out.println("Each fragment is considered on its own, as the only line");
        System.out.println("inserted at line 12:");
        System.out.println("A. new MyClass();          ->  1 2 3");
        System.out.println("B. new MyClass();          ->  1 2 3");
        System.out.println("   new MyClass();               2 3");
        System.out.println("C. MyClass.mB();           ->  1 4");
        System.out.println("D. new MyClass().mA();     ->  COMPILE ERROR - MyClass has no");
        System.out.println("                              method mA, so this fragment");
        System.out.println("                              cannot be inserted at all.");
        System.out.println("E. MyClass.mB();           ->  1 4     (same as C)");
        System.out.println("F. MyClass c1;             ->  1       (the class is loaded,");
        System.out.println("                                       but no object is made)");
        System.out.println();
        System.out.println("Live run - watch that 1 appears only ONCE, because the");
        System.out.println("static block belongs to the class, not to the objects:");
        new MyClass43();
        System.out.println();
        new MyClass43();
        System.out.println();
        MyClass43.mB();
        System.out.println();
        MyClass43 c1 = null;                 
        System.out.println("(nothing more - c1 is only a reference variable)");
    }

    /*
       44. 
     */
    static void q44() {
        System.out.println("---- Q44 ----");
        MyPoint44 p = new MyPoint44();
        p.myMethod();
        System.out.println();
        System.out.println("Answer: C. ( 5, 3 ) ( 3, 5 ) ( 5, 3 )");
        System.out.println("Reason : x and y are PRIMITIVE int parameters, so");
        System.out.println("        Java passes them BY VALUE. switchCoords");
        System.out.println("        swaps only its own local copies and prints");
        System.out.println("        ( 3, 5 ), but the caller's x and y are");
        System.out.println("        still 5 and 3 for the last print.");
    }

    /*
       45. 
     */
    static void q45() {
        System.out.println("---- Q45 ----");
        System.out.println("Theory question. Full answer is in the commented");
        System.out.println("section at the top of this file.");
    }

   
    static void q46() {
        System.out.println("---- Q46 ----");
        System.out.println("Line 1 : Cat cat;              -> LEGAL (declaration)");
        System.out.println("Line 2 : Cat[] cats;           -> LEGAL (declaration)");
        System.out.println("Line 3 : cat=new Cat[5];       -> ILLEGAL");
        System.out.println("Line 4 : cat=new Cat();        -> LEGAL");
        System.out.println("Line 5 : cats=new Cat();       -> ILLEGAL");
        System.out.println("Line 6 : cats=new Cat[5];      -> LEGAL");
        System.out.println("Reason : cat is a Cat reference, so it may only");
        System.out.println("        hold a Cat object - never a Cat array.");
        System.out.println("        cats is a Cat[] reference, so it may only");
        System.out.println("        hold a Cat array - never a single Cat.");
        System.out.println("        Illegal lines: 3 and 5");
    }

    /*
       47. 
     */
    static void q47() {
        System.out.println("---- Q47 ----");
        Cat47[] cats = { new Cat47("Aldo"), new Cat47("Bear"), new Cat47("Toby"),
                new Cat47("Teddy"), new Cat47("Henry") };
       
        System.out.print("[");
        for (int i = 0; i < cats.length; i++) {
            System.out.print(cats[i].getName());
            if (i < cats.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
       
        System.out.println("Required output: [Aldo, Bear, Toby, Teddy, Henry]");
    }

    /*
       48. 
     */
    static void q48() {
        System.out.println("---- Q48 ----");
        System.out.print("Enter the first employee first name : ");
        String first1 = input.next();
        System.out.print("Enter the first employee last name  : ");
        String last1 = input.next();
        System.out.print("Enter the first employee monthly salary : ");
        double salary1 = input.nextDouble();

        System.out.print("Enter the second employee first name : ");
        String first2 = input.next();
        System.out.print("Enter the second employee last name  : ");
        String last2 = input.next();
        System.out.print("Enter the second employee monthly salary : ");
        double salary2 = input.nextDouble();

        Employee48 e1 = new Employee48(first1, last1, salary1);
        Employee48 e2 = new Employee48(first2, last2, salary2);

        System.out.println();
        System.out.println("--- initial yearly salaries ---");
        System.out.println(e1.getFullName() + " yearly salary : " + e1.getYearlySalary());
        System.out.println(e2.getFullName() + " yearly salary : " + e2.getYearlySalary());

        // a non positive salary must be rejected
        System.out.println();
        System.out.print("Enter a new monthly salary for " + e1.getFullName() + " : ");
        e1.setMonthlySalary(input.nextDouble());

        // 10% raise for every employee
        e1.raiseSalary(10);
        e2.raiseSalary(10);

        System.out.println();
        System.out.println("--- yearly salaries after a 10% raise ---");
        System.out.println(e1.getFullName() + " yearly salary : " + e1.getYearlySalary());
        System.out.println(e2.getFullName() + " yearly salary : " + e2.getYearlySalary());
    }

    /*
       49. 
     */
    static void q49() {
        System.out.println("---- Q49 ----");
        Item49 item1 = new Item49(1001);
        item1.printCode();
        Item49 item2 = new Item49(2002);
        item2.setCode(item1);
        item2.printCode();
        System.out.println("Reason : setCode(Item item) receives a COPY OF THE");
        System.out.println("        REFERENCE, so inside the method item and");
        System.out.println("        this point to the SAME object (item1).");
        System.out.println("        this.code = item.code copies 1001 into");
        System.out.println("        item2, so both objects now hold 1001.");
    }

    /*
       50. 
     */
    static void q50() {
        System.out.println("---- Q50 ----");
        Date d1 = new Date();
        d1.set(Date.YEAR, 2016);   // set(int field, int value)
        d1.set(Date.MONTH, 05);
        d1.set(Date.DAY, 30);
        d1.printDate();             // 2016-5-30
        Date d2 = new Date(2016, 1, 31);
        d2.printDate();             // 2016-1-31
        Date d3 = new Date(d2);
        d3.printDate();             // 2016-1-31
        Date d4 = new Date();
        d4.set(d1);
        d4.printDate();
        Date d5 = Date.getDateInstance();
        d5.printDate();             // 1970-1-1
        System.out.println("Reason : Date(Date) is a COPY CONSTRUCTOR - it");
        System.out.println("        copies the values, not the reference,");
        System.out.println("        so changing d3 would never affect d2.");
        System.out.println("        getDateInstance() is a FACTORY METHOD, a");
        System.out.println("        static method that builds and returns a");
        System.out.println("        brand new object with the defaults.");
    }

    /*
       51. 
     */
    static void q51() {
        System.out.println("---- Q51 ----");
        ValHold51 v = new ValHold51();
        v.i = 30;
        int i = 99;
        another51(v, i);
        System.out.println(v.i);
        System.out.println("Answer: D. 10 0 20");
        System.out.println("Reason : i=0 changes only the local copy, so 0 is");
        System.out.println("        printed. v.i=20 changes the SHARED object,");
        System.out.println("        but v=vh then repoints the local reference");
        System.out.println("        to a NEW ValHold whose i is 10, so the");
        System.out.println("        method prints 10 0. Back in amethod, v still");
        System.out.println("        refers to the first object, so it prints 20.");
    }

    static void another51(ValHold51 v, int i) {
        i = 0;
        v.i = 20;
        ValHold51 vh = new ValHold51();
        v = vh;
        System.out.println(v.i + " " + i);
    }

    /*
       52. 
     */
    static void q52() {
        System.out.println("---- Q52 ----");
        MyClass52 c1 = new MyClass52(100);
        System.out.println("Reason : new MyClass(100) runs MyClass(int i),");
        System.out.println("        which FIRST calls this(i,i) ->");
        System.out.println("        MyClass(int,int), which FIRST calls");
        System.out.println("        this() -> MyClass(). Each constructor body");
        System.out.println("        runs only AFTER the chained call returns,");
        System.out.println("        so the order is innermost first:");
        System.out.println("        MyClass() -> MyClass(int,int) -> MyClass(int)");
    }

    /*
       53. 
     */
    static void q53() {
        System.out.println("---- Q53 ----");
        Box53 b1 = new Box53();
        b1.setLength(12);
        b1.setWidth(5);
        b1.setHeight(3);
        b1.printVolume();

        b1.setDimension(120, 50, 30);
        System.out.println("Volume " + b1.getVolume());

        Box53 b2 = new Box53(4, 2, 3);
        b2.printVolume();

        Box53 b3 = new Box53(b2);
        
        b3.printVolume();

        Box53 b4 = new Box53(10); // length for a square cube
        b4.printVolume();

        Box53 b5 = new Box53();
        b5.setDimension(12); // length for a square cube
        b5.printVolume();

        Box53 b6 = new Box53();
        b6.printVolume();
        b6.setDimension(b1);
        // copy dimensions of b1 into b6
        b6.printVolume();

        Box53 b7 = b3.getCopy();
        b7.printVolume();

        System.out.println("Note : b3 and b7 hold the same dimensions but are");
        System.out.println("       two different objects - the copy constructor");
        System.out.println("       and getCopy() copy the VALUES, not the");
        System.out.println("       reference.");
    }

  

    // Q03
    static class TestQ03 {
        int a = 8;
        int b = 9;
    }

    // Q06
    static class BoxQ06 {
        int length;
        int width;
        int height;

        void printVolume() {
            int volume;
            volume = length * width * height;
            System.out.println("Volume : " + volume);
        }
    }

    // Q07
    static class BoxQ07 {
        int length = 12;
        int width = 5;
        int height = 3;

        void printVolume() {
            int volume;
            volume = length * width * height;
            System.out.println("Volume : " + volume);
        }
    }

    // Q08
    static class BoxQ08 {
        int length;
        int width;
        int height;

        BoxQ08() {
            System.out.println("default constructor");
            length = 2;
            width = 2;
            height = 2;
        }
    }

    // Q09
    static class BoxQ09 {
        int length;
        int width;
        int height;

        BoxQ09(int l, int w, int h) {
            System.out.println("Parameterized constructor");
            length = l;
            width = w;
            height = h;
        }

        void printVolume() {
            int volume;
            volume = length * width * height;
            System.out.println("Volume : " + volume);
        }
    }

    // Q14
    static class BoxQ14 {
        int length;
        int width;
        int height;
    }

    // Q16
    static class TestQ16 {
        int a = 3;
        int b = 4;

        TestQ16(int i, int j) {
            a = i;
            b = j;
        }

        TestQ16() {
        }
    }

    // Q17 - option A
    static class MyClass17A {
        int x;
        int y;

        MyClass17A(int i, int j) {
            x = i;
            y = j;
        }

        void printValues() {
            System.out.println("Values : " + x + ", " + y);
        }
    }

    // Q17 
    static class MyClass17B {
        int x = 100;
        int y = 200;

        MyClass17B(int i, int j) {
        }

        void printValues() {
            System.out.println("Values : " + x + ", " + y);
        }
    }

    // Q17 
    static class MyClass17C {
        int x;
        int y;

        MyClass17C(int i, int j) {
            i = x;
            j = y;
        }

        void printValues() {
            System.out.println("Values : " + x + ", " + y);
        }
    }

    // Q17 
    static class MyClass17D {
        int x;
        int y;

        MyClass17D(int i, int j) {
            x = 100;
            y = 200;
        }

        void printValues() {
            System.out.println("Values : " + x + ", " + y);
        }
    }

    // Q18
    static class A18 {
        int a;

        A18(int i) {
            a = i;
        }
    }

    // Q19
    static class Item19 {
        int code;

        Item19(int i) {
            code = i;
        }

        void printCode(int code) {
            System.out.println("Code : " + code);
        }
    }

    // Q20
    static class Item20 {
        int code;

        Item20(int i) {
            code = i;
        }

        void printCode(int code) {
            System.out.println("Code : " + this.code);
        }
    }

    // Q21 
    static class A21B {
        int a;

        void A(int i) {
            a = i;
        }
    }

    // Q21 
    static class A21C {
        int a;

        A21C() {
        }
    }

    // Q21 
    static class A21D {
        int a;
    }
 
    static class A22 {
        int a;

        void printValue() {
            System.out.println(a);
        }
    }

    static class A22A extends A22 {
        A22A(int i) {
            a = i;
        }
    }

    static class A22B extends A22 {
        A22B(int a) {
            a = a;
        }
    }

    static class A22C extends A22 {
        A22C(int a) {
            a = this.a;
        }
    }

    static class A22D extends A22 {
        A22D(int a) {
            this.a = a;
        }
    }

    static class A22E extends A22 {
        A22E(int i) {
            a = 100;
        }
    }

    static class A22F extends A22 {
        A22F(int i) {
            i = a;
        }
    }

    // Q27
    static class Customer {
        private String id;
        private String name;

        public Customer() {
        }

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public void printCustomer() {
            System.out.println(id + " - " + name);
        }

        public void setCustomerDetail(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Q29
    static class MyClass29 {
        int x;
        static int y;
    }

    // Q30
    static class Rectangle30 {
        private double length = 1.0;
        private double width = 1.0;

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            if (length <= 0.0 || length >= 20.0) {
                System.out.println("Invalid length " + length
                        + " - it must be greater than 0.0 and less than 20.0");
                return;
            }
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            if (width <= 0.0 || width >= 20.0) {
                System.out.println("Invalid width " + width
                        + " - it must be greater than 0.0 and less than 20.0");
                return;
            }
            this.width = width;
        }

        public double getArea() {
            return length * width;
        }

        public double getPerimeter() {
            return 2 * (length + width);
        }
    }

    // Q31
    static class Demo31 {
        static void staticMethod() {
            System.out.println("staticMethod");
        }

        void instanceMethod() {
            System.out.println("instanceMethod");
        }

        static void mainRun() {
            staticMethod();
            Demo31.staticMethod();
            Demo31 d1 = new Demo31();
            d1.instanceMethod();
            d1.staticMethod();
        }
    }

    // Q32
    static class Test32 {
        int x = 10;
        static int y = 20;

        Test32(int i, int j) {
            x = i;
            y = j;
        }

        void printXY() {
            System.out.print(x + " " + y + " ");
        }
    }

    // Q38
    static class Box38 {
        int length;
        int width;
        int height;

        static {
            System.out.println("Box is loaded into memory");
        }
    }

    // Q39
    static class Box39 {
        int length;
        int width;
        int height;

        {
            System.out.println("A box object is created..");
        }
    }

    // Q40
    static class Cylinder40 {
        private double length;
        private double radius;

        public Cylinder40() {
            this.length = 1.0;
            this.radius = 1.0;
        }

        public Cylinder40(double length, double radius) {
            this.length = length;
            this.radius = radius;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getVolume() {
            return round(Math.PI * radius * radius * length);
        }

        public double getArea() {
            return round(2 * Math.PI * radius * (radius + length));
        }

        public double getLateralArea() {
            return round(2 * Math.PI * radius * length);
        }

        static double round(double value) {
            return Math.round(value * 100.0) / 100.0;
        }
    }

    // Q41
    static class Box41 {
        int length;
        int width;
        int height;

        static {
            System.out.println("Box is loaded into memory");
        }

        {
            System.out.println("A box object is created..");
        }
    }

    // Q43
    static class MyClass43 {
        int x = 10;
        static int y = 20;

        MyClass43() {
            System.out.print("3 ");
        }

        static {
            System.out.print("1 ");
        }

        {
            System.out.print("2 ");
        }

        static void mB() {
            System.out.print("4 ");
        }
    }

    // Q44
    static class MyPoint44 {
        void myMethod() {
            int x, y;
            x = 5;
            y = 3;
            System.out.print(" ( " + x + ", " + y + " ) ");
            switchCoords(x, y);
            System.out.print(" ( " + x + ", " + y + " ) ");
        }

        void switchCoords(int x, int y) {
            int temp;
            temp = x;
            x = y;
            y = temp;
            System.out.print(" ( " + x + ", " + y + " ) ");
        }
    }

    // Q47
    static class Cat47 {
        private String name;

        Cat47(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Q48
    static class Employee48 {
        private String firstName;
        private String lastName;
        private double monthlySalary;

        public Employee48(String firstName, String lastName, double monthlySalary) {
            this.firstName = firstName;
            this.lastName = lastName;
            setMonthlySalary(monthlySalary);
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getMonthlySalary() {
            return monthlySalary;
        }

        public void setMonthlySalary(double monthlySalary) {
            if (monthlySalary > 0) {
                this.monthlySalary = monthlySalary;
            } else {
                System.out.println("Invalid monthly salary " + monthlySalary
                        + " - the value is not set (it must be positive).");
            }
        }

        public double getYearlySalary() {
            return round(monthlySalary * 12);
        }

        public void raiseSalary(double percent) {
            monthlySalary = round(monthlySalary * (1 + percent / 100.0));
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        static double round(double value) {
            return Math.round(value * 100.0) / 100.0;
        }
    }

    // Q49
    static class Item49 {
        private int code;

        Item49(int code) {
            this.code = code;
        }

        void setCode(Item49 item) {
            this.code = item.code;
        }

        void printCode() {
            System.out.println("code : " + code);
        }
    }

    // Q51
    static class ValHold51 {
        public int i = 10;
    }

    // Q52
    static class MyClass52 {
        MyClass52() {
            System.out.println("MyClass()");
        }

        MyClass52(int i) {
            this(i, i);
            System.out.println("MyClass(int)");
        }

        MyClass52(int i, int j) {
            this();
            System.out.println("MyClass(int,int)");
        }
    }

    
    static class Date {
        public static final int YEAR = 1;
        public static final int MONTH = 2;
        public static final int DAY = 3;

        private int year = 1970;
        private int month = 1;
        private int day = 1;

        public Date() {
        }

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public Date(Date d) {
            this.year = d.year;
            this.month = d.month;
            this.day = d.day;
        }

        public static Date getDateInstance() {
            return new Date();
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public void set(int field, int value) {
            if (field == YEAR) {
                year = value;
            } else if (field == MONTH) {
                month = value;
            } else if (field == DAY) {
                day = value;
            } else {
                System.out.println("Invalid field " + field);
            }
        }

        public void set(Date d) {
            this.year = d.year;
            this.month = d.month;
            this.day = d.day;
        }

        public void printDate() {
            System.out.println(year + "-" + month + "-" + day);
        }
    }

    /* Q53 - the completed class Box */
    static class Box53 {
        private int length;
        private int width;
        private int height;

        public Box53() {
            this(0, 0, 0);
        }

        public Box53(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        public Box53(int side) {                 // a square cube
            this(side, side, side);
        }

        public Box53(Box53 b) {                  // copy constructor
            this(b.length, b.width, b.height);
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getVolume() {
            return length * width * height;
        }

        public void printVolume() {
            System.out.println("Volume : " + getVolume());
        }

        public void setDimension(int length, int width, int height) {
            setLength(length);
            setWidth(width);
            setHeight(height);
        }

        public void setDimension(int side) {     // a square cube
            setDimension(side, side, side);
        }

        public void setDimension(Box53 b) {      // copy the values
            setDimension(b.length, b.width, b.height);
        }

        public Box53 getCopy() {
            return new Box53(this);
        }
    }
}
