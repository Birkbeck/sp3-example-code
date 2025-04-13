package strings;

public class StringStripVsTrimExample {
    public static void main(String[] args) {
        String s = "test string\u205F";
        String striped = s.strip();
        System.out.printf("'%s'%n", striped);

        String trimmed = s.trim();
        System.out.printf("'%s'%n", trimmed);
    }
}
