package helloworld;

import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.InvocationTargetException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


@Data(staticConstructor = "of")
@Accessors(fluent = true)
public final class MessageSupportFactory {
    static MessageSupportFactory instance = null;

    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        try {
            // load the configuration
            ResourceBundle res = ResourceBundle.getBundle("beans_en_GB");
            // get the implementation classes
            String rendererClass = res.getString("renderer");
            Main.LOGGER.info("Renderer class: " + rendererClass);
            String providerClass = res.getString("provider");
            Main.LOGGER.info("Provider class: " + providerClass);

            renderer = (MessageRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass)
                    .getDeclaredConstructor().newInstance();
        } catch (MissingResourceException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | ClassNotFoundException e) {
            Main.LOGGER.severe("Incorrect resource file or error in creation");
        }
    }
}