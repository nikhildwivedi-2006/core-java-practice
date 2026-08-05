public class o3NestedIfEx {

    public static void main(String[] args) {

        // Example 1: Driving Eligibility
        int age = 20;
        boolean hasLicense = true;

        if (age >= 18) {

            if (hasLicense) {
                System.out.println("Eligible to Drive");
            }

        }

        System.out.println();

        // Example 2: Student Result
        int marks = 82;

        if (marks >= 35) {

            if (marks >= 75) {
                System.out.println("Passed with Distinction");
            }

        }

    }

}