package helloworld;

import java.io.FileInputStream;
import java.util.Properties;

public final class MessageSupportFactory {

    private static MessageSupportFactory instance = null;

    static {
        instance = new MessageSupportFactory();
    }

    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        Properties props = new Properties();

        try {
            try (var fis = new FileInputStream("bean.properties")) {
                props.load(fis);
            }

            // get the implementation classes
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass)
                    .getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
