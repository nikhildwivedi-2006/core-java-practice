
public class o2VariablesExample {

    // instance variable
    String name = "Nikhil";

    // static variable
    static String college = "IIT kanpur";

    public void display() {

        // local variable
        int age = 20;

        System.out.println("Name :" + name);
        System.out.println("Age :" + age);
        System.out.println("College :" + college);

    }

    public static void main(String[] args) {

        o2VariablesExample variable = new o2VariablesExample();

        variable.display();
    }

}
