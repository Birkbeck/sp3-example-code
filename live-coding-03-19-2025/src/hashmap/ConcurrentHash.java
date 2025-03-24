package hashmap;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentHash {
    public static void main(String[] args) {
        System.out.println("Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        testForEach();
        testSearch();
        testReduce();
    }

    private static void testReduce() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", "bar");
        map.putIfAbsent("han", "solo");
        map.putIfAbsent("r2", "d2");
        map.putIfAbsent("c3", "p0");

        String reduced = map.reduce(1, (key, value) -> key + "=" + value,
            (s1, s2) -> s1 + ", " + s2);

        System.out.println(reduced);
    }

    private static void testSearch() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", "bar");
        map.putIfAbsent("han", "solo");
        map.putIfAbsent("r2", "d2");
        map.putIfAbsent("c3", "p0");

        System.out.println("\nsearch()\n");


        Optional<String> result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if (key.equals("foo") && value.equals("bar")) {
                return Optional.of("foobar");
            }
            return Optional.empty();
        });

        System.out.println(result);

        System.out.println("\nsearchValues()\n");

        result = map.searchValues(1, (String value) -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return Optional.of(value);
            }
            return Optional.empty();
        });

        System.out.println(result);
    }

    private static void testForEach() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", "bar");
        map.putIfAbsent("han", "solo");
        map.putIfAbsent("r2", "d2");
        map.putIfAbsent("c3", "p0");

        map.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));
        //map.forEach(5, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));

        System.out.println(map.mappingCount());
    }
}
