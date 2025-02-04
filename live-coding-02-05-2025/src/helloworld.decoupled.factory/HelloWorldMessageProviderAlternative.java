package helloworld.decoupled.factory;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    @Override
    public String getMessage() {
        return "Welcome to my world!";
    }

}