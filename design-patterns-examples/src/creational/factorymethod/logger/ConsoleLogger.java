package creational.factorymethod.logger;

public class ConsoleLogger implements Logger {
    @Override
    public void error(String msg) {

        System.err.println("ERROR: " + msg);
    }

    @Override
    public void debug(String msg) {

        System.err.println("DEBUG: " + msg);
    }
}
