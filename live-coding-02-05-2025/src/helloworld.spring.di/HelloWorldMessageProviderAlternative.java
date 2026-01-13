package helloworld.spring.di;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    @Override
    public String getMessage() {
        return "Goodbye cruel!";
    }
}
