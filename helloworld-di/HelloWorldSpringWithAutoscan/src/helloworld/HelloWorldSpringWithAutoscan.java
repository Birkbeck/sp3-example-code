package helloworld;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class HelloWorldSpringWithAutoscan {

    private HelloWorldSpringWithAutoscan() {
    }

    public static void main(final String[] args) throws Exception {
        // get the bean factory
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
        var mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }
}
