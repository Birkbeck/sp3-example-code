package common;

import interfaces.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String message() {
        return "Hello World!";
    }

}