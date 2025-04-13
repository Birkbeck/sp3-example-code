package creational.builder.pc;

public class ExampleStringBuilder {
    public static void main(String[] args) {
        String s = "The " +
            " strange " +
            " string"; // equivalent of "build"
        System.out.println(s);

        // return "a" + "b" + "c" + "d";
        // "a" + "b" -> "ab"
        // "ab" + "c" -> "abc"
        // "abc" + "d" -> "abcd"
    }
}
