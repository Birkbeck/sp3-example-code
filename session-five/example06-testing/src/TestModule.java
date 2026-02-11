import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule {
    private final MockMessageService mockService = new MockMessageService();

    @Override
    protected void configure() {
        // Bind the interface to our specific mock instance
        bind(MessageService.class).toInstance(mockService);
    }

    // Helper to let the test check the results
    public MockMessageService getMock() {
        return mockService;
    }
}