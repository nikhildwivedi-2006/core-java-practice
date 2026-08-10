class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}

public class GarbageCollectionEx {

    public static void main(String[] args) {

        Student student = new Student("Nikhil");

        System.out.println("student name : " + student.name);

        // The reference is removed.
        student = null;

        // Request the JVM to perform GC.
        System.gc();

        System.out.println("Program continues...");
    }
}