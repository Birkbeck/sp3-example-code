package behavioural.chain;

public class DefaultHandler extends MessageHandler {
    public DefaultHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public void handle(Message message) {
        if (isSpam(message)) {
            // handle spam
        } else {
            super.handle(message);
        }
    }

    private boolean isSpam(Message m) {
        System.out.println(m);
        return true;
    }

    // ...
}