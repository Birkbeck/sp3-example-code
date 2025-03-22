package helloworld.spring.di;

import java.io.FileInputStream;
import java.util.Properties;

import interfaces.MessageRenderer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public final class HelloWorldSpringWithDI {

    private HelloWorldSpringWithDI() {
    }

    /**
     * To illustrate the creation of the factory and the dependency injection
     * provided by the Spring Framework.
     *
     * @param args — unused command line arguments
     * @throws Exception — as there is little (no?) handling of errors
     */
    public static void main(final String[] args) throws Exception {
        // get the bean factory
        var factory = getBeanFactory();

        var mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {
        // get the bean factory
        var factory = new DefaultListableBeanFactory();
        // create a definition reader
        var rdr = new PropertiesBeanDefinitionReader(factory);

        // load the configuration options
        var props = new Properties();
        try (var fis = new FileInputStream("beans.prop")) {
            props.load(fis);
        }

        rdr.registerBeanDefinitions(props);
        return factory;
    }
}
