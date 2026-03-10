import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        // Simple bindings still go here
        bind(MessageService.class).to(EmailServiceImpl.class);
    }

    // Guice sees @Provides and knows this method creates a dependency
    @Provides
    public DatabaseConnection provideConnection() {
        DatabaseConnection conn = new DatabaseConnectionImpl();
        conn.setUrl("jdbc:mysql://localhost:3306/mydb");
        conn.setTimeout(5000);
        return conn;
    }
}