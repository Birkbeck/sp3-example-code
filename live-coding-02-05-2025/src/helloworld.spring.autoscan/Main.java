package helloworld.spring.autoscan;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import interfaces.MessageRenderer;

public class Main {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans_autoscan.xml");
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }
}