package creational.factorymethod.logger;

public class ConsoleLoggerFactory extends LoggerFactory {
    @Override
    public Logger getLogger() {
        return new ConsoleLogger();
    }
}