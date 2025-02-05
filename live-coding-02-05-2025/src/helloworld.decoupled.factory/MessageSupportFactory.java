<<<<<<< HEAD
package helloworld.decoupled.factory;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;


@Data(staticConstructor = "of")
@Accessors(fluent = true)
public final class MessageSupportFactory {

    private static MessageSupportFactory instance = null;

    static {
        instance = new MessageSupportFactory();
    }

    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {

        var res = ResourceBundle.getBundle("beans_en_GB");

        try {
            // get the implementation classes
            String rendererClass = res.getString("renderer");
            String providerClass = res.getString("provider");
            renderer = (MessageRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass)
                    .getDeclaredConstructor().newInstance();
        } catch (MissingResourceException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | ClassNotFoundException e) {
            Main.LOGGER.severe("Incorrect resource file or error in creation");
            e.printStackTrace();
        }
    }
}
||||||| (empty tree)
=======
package helloworld.decoupled.factory;

import helloworld.common.MessageProvider;
import helloworld.common.MessageRenderer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.InvocationTargetException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


@Data(staticConstructor = "of")
@Accessors(fluent = true)
public final class MessageSupportFactory {

    private static MessageSupportFactory instance = null;

    static {
        instance = new MessageSupportFactory();
    }

    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {

        ResourceBundle res = ResourceBundle.getBundle("beans_en_GB");

        try {
            // get the implementation classes
            String rendererClass = res.getString("renderer");
            String providerClass = res.getString("provider");
            renderer = (MessageRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass)
                    .getDeclaredConstructor().newInstance();
        } catch (MissingResourceException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | ClassNotFoundException e) {
            Main.LOGGER.severe("Incorrect resource file or error in creation");
            e.printStackTrace();
        }
    }
}
>>>>>>> 5ce30b0 (Update changes)
