public class o10TwoDimensionalArrayEx {

    public static void main(String[] args) {

        int[][] marks = {
                { 80, 75, 90 },
                { 65, 70, 85 },
                { 95, 88, 91 }
        };

        for (int i = 0; i < marks.length; i++) {

            for (int j = 0; j < marks[i].length; j++) {

                System.out.print(marks[i][j] + " ");

            }

            System.out.println();
        }

    }

}