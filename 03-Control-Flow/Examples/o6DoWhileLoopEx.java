public class o6DoWhileLoopEx {

    public static void main(String[] args) {

        // Example 1: Print 1 to 5
        int i = 1;

        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        System.out.println();

        // Example 2: Executes at least once
        int number = 10;

        do {
            System.out.println(number);
        } while (number < 5);

    }

}