<<<<<<< HEAD
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
||||||| (empty tree)
=======
package helloworld.decoupled.factory;

import helloworld.common.MessageProvider;
import helloworld.common.MessageRenderer;

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
>>>>>>> 5ce30b0 (Update changes)
