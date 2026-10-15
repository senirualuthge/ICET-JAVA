package Polymorphism;

abstract class Animal {
    public abstract void sound();
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Poly1 {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        // Dynamic dispatch: method call is resolved at runtime
        a1.sound();
        a2.sound();
    }
}
