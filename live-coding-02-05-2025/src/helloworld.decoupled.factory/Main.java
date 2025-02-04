package helloworld.decoupled.factory;

import java.util.logging.Logger;

public class Main {
    static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        MessageSupportFactory mf = MessageSupportFactory.of();
        MessageRenderer mr = mf.renderer();
        MessageProvider mp = mf.provider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}