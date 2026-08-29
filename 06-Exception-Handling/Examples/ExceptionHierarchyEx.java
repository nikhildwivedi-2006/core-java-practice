public class ExceptionHierarchyEx {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic Exception");

        } catch (RuntimeException e) {

            System.out.println("Runtime Exception");

        } catch (Exception e) {

            System.out.println("General Exception");
        }

        System.out.println("Program continues...");
    }
}