public class o7StringEx {
 
      public static void main(String[] args) {

        String name = "Nikhil";

        System.out.println("Original String : " + name);
        System.out.println("Length          : " + name.length());
        System.out.println("Upper Case      : " + name.toUpperCase());
        System.out.println("Lower Case      : " + name.toLowerCase());
        System.out.println("Character at 2  : " + name.charAt(2));
        System.out.println("Contains 'hi'   : " + name.contains("hi"));
        System.out.println("Substring       : " + name.substring(2));
        System.out.println("Replace         : " + name.replace("N", "V"));
    }
    
}
