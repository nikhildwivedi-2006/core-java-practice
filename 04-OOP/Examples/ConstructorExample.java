class Student {

    String name;
    int age;

    // No-argument constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

public class ConstructorExample {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Nikhil", 20);

        student1.display();

        System.out.println();

        student2.display();
    }
}