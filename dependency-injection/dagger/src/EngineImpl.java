/**
 * Engine of a {@link Car}.
 *
 * @author Donato Rimenti
 */
public class EngineImpl implements Engine {

    /**
     * Starts the engine.
     */
    @Override
    public void start() {
        System.out.println("Engine started");
    }

    /**
     * Stops the engine.
     */
    @Override
    public void stop() {
        System.out.println("Engine stopped");
    }
}