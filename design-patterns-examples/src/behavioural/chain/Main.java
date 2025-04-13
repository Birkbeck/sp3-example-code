package behavioural.chain;

public class Main {
    public static void main(String[] args) {
        var handler = new SpamHandler(new DefaultHandler(null));
        handler.handle(new Standard());
        handler.handle(new Spam());
    }
}
