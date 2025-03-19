import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloActivator implements BundleActivator {
    private BundleContext context;

    @Override
    public void start(final BundleContext context) throws Exception {
        System.out.println("Starting: Hello World");
        this.context = context;
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        System.out.println("Stopping: Goodbye Cruel World");
        this.context = null;
    }
}
