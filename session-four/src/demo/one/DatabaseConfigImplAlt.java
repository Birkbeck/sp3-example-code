package demo.one;

import demo.interfaces.DatabaseConfig;
import java.util.Optional;

// Probably? thread safe
public class DatabaseConfigImplAlt implements DatabaseConfig {

    private DatabaseConfigImplAlt() {
        System.out.println("Loading an alternate Configuration...");
    }

    public static Optional<DatabaseConfig> getInstance() {
        return Optional.of(Holder.INSTANCE);
    }

//    public static DatabaseConfig getInstance() {
//        return DatabaseConfigImplAlt.getInstance();
//    }

    private static class Holder {
        private static final DatabaseConfig INSTANCE = new DatabaseConfigImplAlt();

    }
}