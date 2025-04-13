package threads.and.blocking.tasks;

import lombok.experimental.UtilityClass;

import java.util.concurrent.CountDownLatch;

@UtilityClass
public class Latch {
    final static int MAX = 5;

    final static CountDownLatch latch = new CountDownLatch(MAX);
}