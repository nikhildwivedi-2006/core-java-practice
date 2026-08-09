public class PassingArrayExample {

    static void modifyArray(int[] numbers) {

        numbers[0] = 100;
    }

    static void reassignArray(int[] numbers) {

        numbers = new int[] { 500, 600, 700 };
    }

    public static void main(String[] args) {

        int[] numbers = { 10, 20, 30 };

        modifyArray(numbers);

        System.out.println("After modification: " + numbers[0]);

        reassignArray(numbers);

        System.out.println("After reassignment: " + numbers[0]);
    }
}