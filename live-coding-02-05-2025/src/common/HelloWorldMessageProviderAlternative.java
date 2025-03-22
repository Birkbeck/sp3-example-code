package common;

import interfaces.MessageProvider;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    public String message() {
        return "Goodbye cruel!";
    }
}
