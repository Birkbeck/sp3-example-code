package factorymethod.logger;

public abstract class LoggerFactory {
    public static LoggerFactory getFactory(String f)
        throws Exception {
        return (LoggerFactory) Class.forName(f).getDeclaredConstructor().newInstance();
    }

    public abstract Logger getLogger();
}
