class Animal {

    void eat() {

        System.out.println("Animal eats");
    }

    void sound() {

        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Dog barks");
    }

    @Override
    void sound() {

        System.out.println("Dog makes a sound");
    }
}

public class InheritanceEx {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat(); // Inherited method
        dog.bark(); // Child method
        dog.sound(); // Overridden method
    }
}