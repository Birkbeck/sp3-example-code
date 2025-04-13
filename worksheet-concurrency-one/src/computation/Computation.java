package computation;

import java.util.Random;

/**
 * A class that performs a costly computation
 */
public class Computation implements Runnable {
    /**
     * The result of the computation.
     */
    private double result = 0;

    /**
     * True when the computation result is ready, false otherwise.
     */
    private boolean resultReady = false;

    /**
     * The number to perform the computation with
     */
    private double[] numbers = null;

    /**
     * A new computation.
     *
     * @param data an array of doubles to perform the computation
     */
    public Computation(double[] data) {
        this.numbers = data;
    }

    /**
     * Runs the computation.
     */
    @Override
    public void run() {
        synchronized (this) {
            double result = 0.0;

            // A new Random is created here because Math.random() is
            // synchronised, which leads to no improvement being seen
            Random r = new Random(-1);
            for (int i = 0; i < numbers.length; i++) {
                result += Math.sqrt(numbers[i]);
                result += Math.sqrt(r.nextDouble() * result);
                result += Math.sqrt(r.nextDouble() * result);
                result += Math.sqrt(r.nextDouble() * result);
            }
            this.result = result;
            this.resultReady = true;
            notifyAll();
        }
    }

    /**
     * Returns the result of the computation if it is ready.
     * If it is not, it blocks until it is.
     *
     * @return the result of the computation.
     */
    public synchronized double getResult() {
        while (!resultReady) {
            try {
                wait();
            } catch (InterruptedException ex) {
                // Nothing to do, just sleep less
            }
        }
        resultReady = false;
        return result;
    }
}