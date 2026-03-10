package demo.one;

import demo.interfaces.DatabaseConfig;

import java.util.Optional;

public class DatabaseConfigImpl implements DatabaseConfig {
    private static final DatabaseConfig INSTANCE = new DatabaseConfigImpl();

    private DatabaseConfigImpl() {
        System.out.println("Loading Configuration...");
    }

    public static Optional<DatabaseConfig> getInstance() {
        return Optional.of(INSTANCE);
    }

}