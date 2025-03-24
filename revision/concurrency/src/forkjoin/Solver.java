package forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class Solver extends RecursiveAction {
    private int[] list;
    private long result;

    private static Logger logger = Logger.getAnonymousLogger();

    public Solver(int[] array) {
        this.list = array;
    }

    @Override
    protected void compute() {
        if (list.length == 1) {
            result = list[0];
        } else {
            int midpoint = list.length / 2;
            int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solver s1 = new Solver(l1);
            Solver s2 = new Solver(l2);
            ForkJoinTask.invokeAll(s1, s2);
            result = s1.result + s2.result;
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Solver solver)) return false;

        return result == solver.result && Arrays.equals(list, solver.list);
    }

    @Override
    public int hashCode() {
        int result1 = Arrays.hashCode(list);
        result1 = 31 * result1 + Long.hashCode(result);
        return result1;
    }

    @Override
    public String toString() {
        return "Solver{" + "list=" + Arrays.toString(list) + ", result=" + result + '}';
    }

    public int[] getList() {
        return list;
    }

    public long getResult() {
        return result;
    }
}