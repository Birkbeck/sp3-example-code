import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyApplicationTest {
    private TestModule testModule;
    private MyApplication app;

    @BeforeEach
    void setUp() {
        testModule = new TestModule();
        // Create the injector using the TEST module
        Injector injector = Guice.createInjector(testModule);
        app = injector.getInstance(MyApplication.class);
    }

    @Test
    void testAppSendsMessageCorrectly() {
        // Act
        app.send("Test Message");

        // Assert
        MockMessageService mock = testModule.getMock();
        assertEquals(1, mock.sentMessages.size());
        assertEquals("Test Message", mock.sentMessages.get(0));
    }
}