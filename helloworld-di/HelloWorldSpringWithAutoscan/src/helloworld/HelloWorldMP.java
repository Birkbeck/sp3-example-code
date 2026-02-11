package helloworld;

import org.springframework.stereotype.Component;

//@Component("provider")
public class HelloWorldMP implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World! --- with Autoscan! How does that work?";
    }

}