package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * In the main() method an instance of Consumer<Integer> is defined(named consumer) using a lambda expression
 * which takes input as an object of type Integer and contains logic to print the value of that Integer.
 * Next the main() method defines a new list of integers and passes it to the printList() method along with
 * the consumer object defined earlier which contains the printing logic.
 * The printList() method iterates through the list of integers and invokes the accept() method of the consumer
 * object for every integer in the list.
 * The accept() method which works as per the lambda definition assigned to the consumer interface,
 * i.e. i-> System.out.print(" "+i) , prints out the value of each integer with a single space character
 * prepended to it. Thus giving the output 1 10 200 101 -10 0.
 */
public class ConsumerFunctionExample {
    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> System.out.print(" " + i);
        List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);
        printList(integerList, consumer);
    }

    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
        for (Integer integer : listOfIntegers) {
            consumer.accept(integer);
        }
    }
}