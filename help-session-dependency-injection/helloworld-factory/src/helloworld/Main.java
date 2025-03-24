package helloworld;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //LOGGER.setLevel(Level.OFF);
        LOGGER.info("Hello World!");

        MessageSupportFactory mf = MessageSupportFactory.of();

        MessageRenderer mr = mf.renderer();
        MessageProvider mp = mf.provider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}