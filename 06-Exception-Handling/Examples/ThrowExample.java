
public class ThrowExample {

    public static void main(String[] args) {

        int age = 16;

        try {

            if (age < 18) {

                throw new IllegalArgumentException(
                        "Age must be 18 or above");
            }

            System.out.println("Eligible to vote");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Program continues...");
    }
}