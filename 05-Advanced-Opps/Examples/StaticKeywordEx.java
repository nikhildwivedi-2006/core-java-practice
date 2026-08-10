class Student {

    String name;
    static String college = "SIRT";

    static void displayCollege() {

        System.out.println("College : " + college);
    }

    void displayStudent() {

        System.out.println("Name    : " + name);
        System.out.println("College : " + college);
    }
}

public class StaticKeywordEx {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "Nikhil";

        Student student2 = new Student();
        student2.name = "Rahul";

        student1.displayStudent();
        System.out.println();

        student2.displayStudent();
        System.out.println();

        Student.displayCollege();
    }
}