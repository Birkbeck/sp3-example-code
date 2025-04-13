package map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {
    /**
     * Apply a function to every element of a list.
     *
     * @param f    function to apply
     * @param list list to iterate over
     * @return [f(list[0]), f(list[1]), ..., f(list[n-1])]
     */
    public static <T, R> List<R> map(Function<T, R> f, List<T> list) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
