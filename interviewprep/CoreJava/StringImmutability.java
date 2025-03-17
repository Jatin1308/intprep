public class StringImmutability {

    public static void main(String[] args) {

        String s1 = "hello";  // -> created in string pool

        String s2 = s1.concat(" World");  // created directly in heap memory

        String s3 = s1.concat(" World").intern(); // creates a new object in string pool

        String s4 = "hello World"; // already exist in the string pool

        String s5 = new String("hello World"); // -> create a new anyway its already present in heap
    }
}
