public class StringClassEx {

    public static void main(String[] args) {

        // String literals
        String s1 = "Java";
        String s2 = "Java";

        // Creating String using new
        String s3 = new String("Java");

        // Reference comparison
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false

        // Content comparison
        System.out.println(s1.equals(s3)); // true

        // Immutability
        String text = "Hello";

        text.concat(" Java");

        System.out.println(text); // Hello

        text = text.concat(" Java");

        System.out.println(text); // Hello Java

        // Common methods
        System.out.println(text.length());
        System.out.println(text.toUpperCase());
        System.out.println(text.contains("Java"));
        System.out.println(text.substring(0, 5));

        // intern()
        String s4 = new String("Java");
        String s5 = s4.intern();

        System.out.println(s5 == s1); // true
    }
}