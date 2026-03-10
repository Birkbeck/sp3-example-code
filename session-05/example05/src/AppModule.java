import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {}

    @Provides
    @Named("dbUrl")
    public String provideDbUrl() {
        return "jdbc:mysql://localhost:3306/prod";
    }

    @Provides
    @Named("apiKey")
    public String provideApiKey() {
        return "SECRET_12345";
    }
}