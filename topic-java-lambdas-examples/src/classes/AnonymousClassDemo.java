package classes;

import java.util.Random;

public class AnonymousClassDemo {
    private static final Random generator = new Random();

    public static IntSequence randomInts(int low, int high) {
        return new IntSequence() {
            public int next() {
                return low + generator.nextInt(high - low + 1);
            }

            public boolean hasNext() {
                return true;
            }
        };
    }

    public static void main(String[] args) {
        IntSequence dieTosses = randomInts(1, 6);
        for (int i = 0; i < 10; i++)
            System.out.println(dieTosses.next());
    }
}
