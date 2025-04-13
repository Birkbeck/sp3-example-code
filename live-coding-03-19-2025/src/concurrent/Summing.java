package concurrent;// concurrent/Summing.java

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.*;

public class Summing {

    public static final int SZ = 1_000_000_000;
    public static final long CHECK =
            (long) SZ * ((long) SZ + 1) / 2; // Gauss's formula

    public static void main(String[] args) {
        System.out.println(CHECK);
        timeTest("Sum Stream", CHECK, () -> rangeClosed(0, SZ).sum());
        timeTest("Sum Stream Parallel", CHECK, () -> rangeClosed(0, SZ).parallel().sum());
        timeTest("Sum Iterated", CHECK, () -> iterate(0, i -> i + 1).limit(SZ + 1).sum());

        // Slower & runs out of memory above 1_000_000:
        // timeTest("Sum Iterated Parallel", CHECK, () ->
        //   LongStream.iterate(0, i -> i + 1)
        //     .parallel()
        //     .limit(SZ+1).sum());
    }

    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + ": ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue)
            System.out.println(timer.duration() + "ms");
        else
            System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
    }
}
/* Output:
5000000050000000
Sum Stream: 841ms
Sum Stream Parallel: 179ms
Sum Iterated: 4051ms
*/
