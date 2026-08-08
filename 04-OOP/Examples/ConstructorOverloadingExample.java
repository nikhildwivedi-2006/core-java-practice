class Student {

    String name;
    int age;

    Student() {

        name = "Unknown";
        age = 0;
    }

    Student(String name) {

        this.name = name;
        age = 0;
    }

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    void display() {

        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

public class ConstructorOverloadingExample {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Nikhil");
        Student student3 = new Student("Nikhil", 20);

        student1.display();

        System.out.println();

        student2.display();

        System.out.println();

        student3.display();
    }
}