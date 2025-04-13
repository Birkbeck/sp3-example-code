package lombokexamples.general;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogExampleCategoryOrig {
    private static final Log log = LogFactory.getLog("CounterLog");

    public static void main(String... args) {
        log.error("Calling the 'CounterLog' with a message");
    }
}