package defmethod;

import org.w3c.dom.ls.LSOutput;

public class Demo {
    // an interface is a strict contract
    // add new methods to the interface you will need to add them to all
    // implementing classes.

    // default methods - allow you to provide an interface with a pre-written body.
    static void main() {
        Logger consoleLogger = msg -> System.err.println("Console: " + msg);
        consoleLogger.log("message");
        consoleLogger.logError("Something went wrong");
    }
}

@FunctionalInterface
interface Logger {
    void log(String msg);

    default void logError(String message){
        System.out.println("ERROR: " + message);
    }
}
