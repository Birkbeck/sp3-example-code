package behavioural.strategy;

public class BubbleSort implements Sorter {

    @Override
    public void sort(int[] array) {
        boolean madeswap = false;

        do {
            madeswap = false;
            for (int k = 0; k < array.length - 1; k++) {
                if (array[k] > array[k + 1]) {
                    int tmp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = tmp;
                    madeswap = true;
                }
            }
        } while (madeswap);
    }

    public String getId() {
        return "Bubble";
    }
}
