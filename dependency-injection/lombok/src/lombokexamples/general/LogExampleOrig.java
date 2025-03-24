package lombokexamples.general;

import java.util.logging.Logger;

public class LogExampleOrig {
    private static final Logger log = Logger.getLogger(LogExample.class.getName());

    public static void main(String... args) {
        log.severe("Something's wrong here");
    }
}