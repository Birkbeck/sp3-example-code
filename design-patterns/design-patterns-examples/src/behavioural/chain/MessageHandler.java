package behavioural.chain;

public abstract class MessageHandler {
    private final MessageHandler next;

    public MessageHandler(MessageHandler next) {
        this.next = next;
    }

    public void handle(Message message) {
        if (next != null) {
            next.handle(message);
        }
    }
}