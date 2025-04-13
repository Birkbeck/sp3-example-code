package immutablecollection;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Configuration {
    private final List<String> settings;

    public Configuration(List<String> settings) {
        this.settings = Collections.unmodifiableList(settings);
    }

    @Override
    public int hashCode() {
        return getSettings().hashCode();
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Configuration that)) return false;

        return getSettings().equals(that.getSettings());
    }

    public List<String> getSettings() {
        return settings;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "settings=" + settings +
                '}';
    }
}
