package strings;

public class StringIsBlankExample {
    public static void main(String[] args) {
        String s = "  ";
        //old isEmpty() method
        boolean empty = s.isEmpty();
        System.out.println(empty);
        //new isBlank()
        boolean blank = s.isBlank();
        System.out.println(blank);
    }
}
