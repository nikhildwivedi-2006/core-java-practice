public class FinallyBlockEx {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        } finally {

            System.out.println("Finally block always executes");
        }

        System.out.println("Program continues...");
    }
}