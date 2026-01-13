package helloworld.spring.di;

import java.util.ResourceBundle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public final class Main {
    /**
     * To illustrate the creation of the factory and the dependency injection
     * provided by the Spring Framework.
     *
     * @param args — unused command line arguments
     * @throws Exception — as there is little (no?) handling of errors
     */
    public static void main(final String... args) throws Exception {
        // get the bean factory
        var factory = new DefaultListableBeanFactory();
        // create a definition reader
        var rdr = new PropertiesBeanDefinitionReader(factory);

        // load the configuration bundle
        ResourceBundle res = ResourceBundle.getBundle("beansdi_en_GB");
        rdr.registerBeanDefinitions(res);

        var mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }
}
