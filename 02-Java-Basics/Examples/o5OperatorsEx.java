public class o5OperatorsEx {

    public static void main(String[] args) {

        int a = 20;
        int b = 10;

        // Arithmetic Operators
        System.out.println("===== Arithmetic Operators =====");
        System.out.println("Addition       : " + (a + b));
        System.out.println("Subtraction    : " + (a - b));
        System.out.println("Multiplication : " + (a * b));
        System.out.println("Division       : " + (a / b));
        System.out.println("Modulus        : " + (a % b));

        // Unary Operators
        System.out.println("\n===== Unary Operators =====");
        int x = 5;
        System.out.println("Original Value : " + x);
        System.out.println("Pre Increment  : " + (++x));
        System.out.println("Post Increment : " + (x++));
        System.out.println("Current Value  : " + x);
        System.out.println("Pre Decrement  : " + (--x));
        System.out.println("Post Decrement : " + (x--));
        System.out.println("Current Value  : " + x);

        // Assignment Operators
        System.out.println("\n===== Assignment Operators =====");
        int c = 10;

        c += 5;
        System.out.println("c += 5 : " + c);

        c -= 2;
        System.out.println("c -= 2 : " + c);

        c *= 3;
        System.out.println("c *= 3 : " + c);

        c /= 2;
        System.out.println("c /= 2 : " + c);

        c %= 4;
        System.out.println("c %= 4 : " + c);

        // Relational Operators
        System.out.println("\n===== Relational Operators =====");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));

        // Logical Operators
        System.out.println("\n===== Logical Operators =====");

        boolean condition1 = true;
        boolean condition2 = false;

        System.out.println("AND : " + (condition1 && condition2));
        System.out.println("OR  : " + (condition1 || condition2));
        System.out.println("NOT : " + (!condition1));

        // Bitwise Operators
        System.out.println("\n===== Bitwise Operators =====");

        int m = 5;
        int n = 3;

        System.out.println("m & n : " + (m & n));
        System.out.println("m | n : " + (m | n));
        System.out.println("m ^ n : " + (m ^ n));
        System.out.println("~m    : " + (~m));

        // Shift Operators
        System.out.println("\n===== Shift Operators =====");

        int value = 8;

        System.out.println("Left Shift  : " + (value << 1));
        System.out.println("Right Shift : " + (value >> 1));

        // Ternary Operator
        System.out.println("\n===== Ternary Operator =====");

        int age = 20;

        String result = (age >= 18) ? "Eligible to Vote" : "Not Eligible";

        System.out.println(result);

        // instanceof Operator
        System.out.println("\n===== instanceof Operator =====");

        String name = "Java";

        System.out.println(name instanceof String);

    }

}