package common;

import interfaces.MessageProvider;

public class AnotherWorldMessageProvider implements MessageProvider {
    public String message() {
        return "Some other message";
    }
}
