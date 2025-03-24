import java.util.*;
import java.util.function.*;

interface Source<T> {
    void generate(Supplier<T> supplier);
}

class Generator<T> {
    public static <T> Generator<T> create(Source<T> source) {
        return null;
    }
}

public class Sample {
    public static void main(String[] args) {
        Generator.<Integer>create(supplier -> generate(supplier));

        System.out.println("OK");
    }

    public static void generate(Supplier<Integer> supplier) {
    }
}