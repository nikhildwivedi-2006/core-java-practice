public class o9ArrayEx {

    public static void main(String[] args) {

        int[] marks = { 80, 75, 90, 88, 92 };

        System.out.println("First Element : " + marks[0]);
        System.out.println("Array Length  : " + marks.length);

        System.out.println("\nUsing For Loop:");

        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }

        System.out.println("\nUsing Enhanced For Loop:");

        for (int mark : marks) {
            System.out.println(mark);
        }

    }

}