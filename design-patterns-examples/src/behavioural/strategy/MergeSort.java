package behavioural.strategy;

public class MergeSort implements Sorter {


    /**
     * This function is called recursively
     * to sort its input array.  It is not space
     * efficient (that's left as an exercise in the notes).
     * OOP course: Why is it private and static?
     */
    private static int[] doMergeSort(int[] array, int l, int r) {

        if (l == r) {
            //  Only one element, so it's sorted!
            int[] res = new int[1];
            res[0] = array[l];
            return res;
        }

        // Find the split point
        final int c = (int) Math.ceil((r - l + 1) / 2.0);

        // Recursively sort the two halves
        final int[] a1 = doMergeSort(array, l, l + c - 1);
        final int[] a2 = doMergeSort(array, l + c, r);

        // Merge the results together
        return doMerge(a1, a2);
    }

    /**
     * This function merges two sorted arrays into one
     * big sorted array (which it creates)
     *
     * @param a1 first input array (sorted)
     * @param a2 second input array (sorted)
     * @return merged array (sorted)
     */
    private static int[] doMerge(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];

        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < a1.length + a2.length; i++) {
            if (i1 == a1.length) result[i] = a2[i2++];
            else if (i2 == a2.length) result[i] = a1[i1++];
            else if (a1[i1] < a2[i2]) {
                result[i] = a1[i1++];
            } else {
                result[i] = a2[i2++];
            }
        }

        return result;
    }

    @Override
    public void sort(int[] array) {
        final int[] r = doMergeSort(array, 0, array.length - 1);

        System.arraycopy(r, 0, array, 0, r.length);
    }


}
