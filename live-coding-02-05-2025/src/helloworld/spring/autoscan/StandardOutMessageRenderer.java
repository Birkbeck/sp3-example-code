package helloworld.spring.autoscan;

import helloworld.common.MessageProvider;
import helloworld.common.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")   // This is the same as @Component(value="renderer")
class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired
    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class: " + this.getClass().getName());
        }

        System.out.println(messageProvider.getMessage());
    }
}