package strings;

public class StringLinesExample {
    public static void main(String[] args) {
        String s = "jujube\nsatsuma\nguava";
        s.lines()
                .forEach(System.out::println);
    }
}
