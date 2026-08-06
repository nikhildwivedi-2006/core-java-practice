class Student {

    String name;
    int age;

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

public class ClassObjectEx {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "Nikhil";
        student1.age = 20;

        Student student2 = new Student();
        student2.name = "Rahul";
        student2.age = 21;

        student1.display();

        System.out.println();

        student2.display();
    }
}