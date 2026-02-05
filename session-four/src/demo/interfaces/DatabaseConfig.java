package demo.interfaces;

import java.util.Optional;

public interface DatabaseConfig {
    public static Optional<DatabaseConfig> getInstance() {
        return Optional.empty();
    }
}