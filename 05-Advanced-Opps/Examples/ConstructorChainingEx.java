class Person {

    String name;

    Person(String name) {

        this.name = name;

        System.out.println("Person constructor");
    }
}

class Student extends Person {

    int rollNo;

    Student(String name, int rollNo) {

        super(name);

        this.rollNo = rollNo;

        System.out.println("Student constructor");
    }
}

public class ConstructorChainingEx {

    public static void main(String[] args) {

        Student student = new Student("Nikhil", 101);

        System.out.println("Name: " + student.name);
        System.out.println("Roll No: " + student.rollNo);
    }
}