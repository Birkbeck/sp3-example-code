package anonymous;

public class AnonymousMain {
    public static void main(String[] args) {
        MyEventConsumer myEventConsumer = new MyEventConsumer() {
            private int eventCount = 0;

            public void consume(Object event) {
                System.out.println(event.toString() + " consumed " + this.eventCount++ + " times.");
            }
        };
    }
}
