package mf.qcon.talk.example09;

import java.util.concurrent.*;
import java.util.function.*;

public class ParallelStreamsHarness {

    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) {
        System.out.println("SideEffect sum done in: " + measurePerf(ParallelStreamsWithSideEffect::sideEffectSum, 10_000_000L) + " msecs");
        //System.out.println("SideEffect prallel sum done in: " + measurePerf(ParallelStreamsWithSideEffect::sideEffectParallelSum, 10_000_000L) + " msecs" );
    }

    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
