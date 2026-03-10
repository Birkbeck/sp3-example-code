import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DatabaseService {
    private final String url;

    @Inject
    public DatabaseService(@Named("dbUrl") String url) {
        this.url = url;
    }
}