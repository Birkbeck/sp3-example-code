package strings;

public class StringStripExample {
    public static void main(String[] args) {
        String s = "  test string  ";
        System.out.printf("'%s'%n", s);
        String striped = s.strip();
        System.out.printf("strip():%n '%s'%n", striped);

        striped = s.stripLeading();
        System.out.printf("stripLeading():%n '%s'%n", striped);

        striped = s.stripTrailing();
        System.out.printf("stripTrailing():%n '%s'%n", striped);
    }
}
