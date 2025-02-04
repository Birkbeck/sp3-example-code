package helloworld.spring;

public class AnotherWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Some other message";
    }
}
