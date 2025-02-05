package helloworld.spring.di.xml;

import helloworld.common.MessageRenderer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String... args) throws Exception {
        // get the bean factory
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans_spring.xml");
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }
}