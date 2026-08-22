class Parent {

    int value = 10;

    void show() {

        System.out.println("Parent instance method");
    }

    static void display() {

        System.out.println("Parent static method");
    }
}

class Child extends Parent {

    int value = 20;

    @Override
    void show() {

        System.out.println("Child instance method");
    }

    static void display() {

        System.out.println("Child static method");
    }
}

public class PolymorphismEx {

    public static void main(String[] args) {

        Parent obj = new Child();

        // Runtime polymorphism
        obj.show();

        // Static method hiding
        Parent.display();

        // Fields are accessed using reference type
        System.out.println("Value: " + obj.value);
    }
}