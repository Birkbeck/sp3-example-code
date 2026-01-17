package methods;

import java.util.Arrays;

public class Demo {
    static void main() {
        Integer[] intArray = {1,2,3,4,5};
        System.out.printf("Array: %s\n", Arrays.toString(intArray));
        arrayIterPrint(intArray);
        swap(intArray,0,1);
        System.out.printf("Array: %s\n", Arrays.toString(intArray));
        arrayIterPrint(intArray);
    }

    public static <T> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static <T> void arrayIterPrint(T[] array){
        for (T item: array) {
            System.out.printf("array item %s\n", item);
        }
    }
}
