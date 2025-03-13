package helloworld.spring;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "From: " + this.getClass().getPackageName() + " Hello World!";
    }

}