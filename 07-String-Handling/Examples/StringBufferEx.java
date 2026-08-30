public class StringBufferEx {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Java");

        System.out.println("Original: " + sb);

        sb.append(" Programming");
        System.out.println("Append: " + sb);

        sb.insert(5, "Core ");
        System.out.println("Insert: " + sb);

        sb.replace(5, 10, "Advanced");
        System.out.println("Replace: " + sb);

        sb.reverse();
        System.out.println("Reverse: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}