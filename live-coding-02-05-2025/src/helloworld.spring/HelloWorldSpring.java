package helloworld.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

import java.io.FileInputStream;
import java.util.Properties;

import interfaces.MessageProvider;
import interfaces.MessageRenderer;


public class HelloWorldSpring {

    public static void main(String[] args) throws Exception {
        // get the bean factory
        BeanFactory factory = getBeanFactory();

        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        MessageProvider mp = (MessageProvider) factory.getBean("provider");
        mr.setMessageProvider(mp);
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {
        // get the bean factory - understanding DefaultListableBeanFactory() not really important.
        //It is just an Factory class example from Spring.
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // create a definition reader
        PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(factory);

        // load the configuration options
        Properties props = new Properties();
        try (var fis = new FileInputStream("beans")) {
            props.load(fis);
        }
        rdr.registerBeanDefinitions(props);

        return factory;
    }
}