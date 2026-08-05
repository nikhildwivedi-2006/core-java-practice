public class o2IfElseEx {

    public static void main(String[] args) {

        // Example 1: Voting Eligibility
        int age = 20;

        if (age >= 18) {
            System.out.println("Eligible to Vote");
        } else {
            System.out.println("Not Eligible to Vote");
        }

        System.out.println();

        // Example 2: Pass or Fail
        int marks = 32;

        if (marks >= 35) {
            System.out.println("Student Passed");
        } else {
            System.out.println("Student Failed");
        }

        System.out.println();

        // Example 3: Positive or Negative
        int number = -5;

        if (number >= 0) {
            System.out.println("Positive Number");
        } else {
            System.out.println("Negative Number");
        }

    }

}