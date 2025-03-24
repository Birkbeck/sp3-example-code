package capture;

import java.util.function.Function;

public interface MyEventProducer {
    <T, R> void listen(Function<T, R> o);
}
