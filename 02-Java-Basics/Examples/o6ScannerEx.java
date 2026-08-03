import java.util.Scanner;

public class o6ScannerEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = sc.nextLine();

        System.out.print("Enter your Age: ");
        int age = sc.nextInt();

        System.out.print("Enter your CGPA: ");
        double cgpa = sc.nextDouble();

        System.out.println("\n===== Student Details =====");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("CGPA : " + cgpa);

        sc.close();
    }
}
