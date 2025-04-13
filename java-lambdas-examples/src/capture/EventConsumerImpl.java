package capture;

public class EventConsumerImpl {

    private final String name = "MyConsumer";

    public void attach(MyEventProducer eventProducer) {
        eventProducer.listen(e -> {
            System.out.println(this.name);
            return this.name;
        });
    }
}