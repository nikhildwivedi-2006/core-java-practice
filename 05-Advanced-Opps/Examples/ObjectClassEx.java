import java.util.Objects;

class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return "Student{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return age == other.age &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

public class ObjectClassEx {

    public static void main(String[] args) {

        Student student1 = new Student("Nikhil", 20);
        Student student2 = new Student("Nikhil", 20);

        System.out.println("toString(): " + student1);

        System.out.println("== : " + (student1 == student2));

        System.out.println("equals(): " + student1.equals(student2));

        System.out.println("HashCode 1: " + student1.hashCode());
        System.out.println("HashCode 2: " + student2.hashCode());

        System.out.println("Class: " + student1.getClass().getName());
    }
}