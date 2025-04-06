package helloworld.spring.autoscan;

import org.springframework.stereotype.Component;

@Component("provider")
class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "From: " + this.getClass().getPackageName() + " Hello!";
    }
}

