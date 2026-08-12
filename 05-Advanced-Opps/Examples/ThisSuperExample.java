class Animal {

    String name = "Animal";

    Animal() {

        System.out.println("Parent constructor");
    }

    void sound() {

        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    String name = "Dog";

    Dog() {

        super();

        System.out.println("Child constructor");
    }

    void display() {

        System.out.println("Child name  : " + this.name);
        System.out.println("Parent name : " + super.name);

        this.sound();

        super.sound();
    }

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}

public class ThisSuperExample {

    public static void main(String[] args) {

        Dog dog = new Dog();

        System.out.println();

        dog.display();
    }
}