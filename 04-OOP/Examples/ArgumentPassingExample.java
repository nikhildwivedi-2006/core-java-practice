class Student {

    String name;
}

public class ArgumentPassingExample {

    static void changePrimitive(int number) {

        number = 100;
    }

    static void changeObject(Student student) {

        student.name = "Rahul";
    }

    static void reassignReference(Student student) {

        student = new Student();
        student.name = "Aman";
    }

    public static void main(String[] args) {

        // Primitive value
        int value = 50;

        changePrimitive(value);

        System.out.println("Primitive value : " + value);

        // Object
        Student student = new Student();
        student.name = "Nikhil";

        changeObject(student);

        System.out.println("Object value    : " + student.name);

        // Reference reassignment
        reassignReference(student);

        System.out.println("After reassignment : " + student.name);
    }
}