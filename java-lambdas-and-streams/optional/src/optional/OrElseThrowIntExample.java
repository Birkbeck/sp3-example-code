package optional;

import java.util.concurrent.ThreadLocalRandom;

public class OrElseThrowIntExample {
    public static void main(String[] args) {
        int result = ThreadLocalRandom.current().ints(5)
            .filter(i -> i % 10 == 0)
            .findAny()
            .orElseThrow();//alternative to getAsInt()
        System.out.println(result);
    }
}
