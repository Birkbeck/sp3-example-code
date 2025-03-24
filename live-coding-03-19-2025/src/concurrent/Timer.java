// onjava/Timer.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package concurrent;

import static java.util.concurrent.TimeUnit.*;

public class Timer {
    private long start = System.nanoTime();

    public static long duration(Runnable test) {
        Timer timer = new Timer();
        test.run();
        return timer.duration();
    }

    public long duration() {
        return NANOSECONDS.toMillis(
                System.nanoTime() - start);
    }
}
