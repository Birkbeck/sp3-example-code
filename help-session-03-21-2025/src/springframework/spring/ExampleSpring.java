package springframework.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

import java.io.FileInputStream;
import java.util.Properties;

import springframework.interfaces.Thing;

public class ExampleSpring {

    public static void main(String[] args) throws Exception {
        // get the bean factory
        var factory = new DefaultListableBeanFactory();

        // create a definition reader
        var rdr = new PropertiesBeanDefinitionReader(factory);

        // load the configuration options
        System.out.format("user.home = %s\n", System.getProperty("user.home"));
        var props = new Properties();
        try (var fis = new FileInputStream("mappings.properties")) {
            props.load(fis);
        }
        rdr.registerBeanDefinitions(props);

        Thing thingy = (Thing) factory.getBean("thingy");
        System.out.format("Adding thingy: %s\n", thingy);
    }
}