class Student {

    String name;
    int age;

    void setData(String name, int age) {

        this.name = name;
        this.age = age;

    }

    void display() {

        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);

    }
}

public class ObjectInitializationExample {

    public static void main(String[] args) {

        Student student = new Student();

        student.setData("Nikhil", 20);

        student.display();

    }
}