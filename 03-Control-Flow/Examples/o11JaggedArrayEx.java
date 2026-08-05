public class o11JaggedArrayEx {

    public static void main(String[] args) {

        int[][] numbers = new int[3][];

        numbers[0] = new int[] { 10, 20 };
        numbers[1] = new int[] { 30, 40, 50 };
        numbers[2] = new int[] { 60 };

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers[i].length; j++) {

                System.out.print(numbers[i][j] + " ");

            }

            System.out.println();
        }

    }

}