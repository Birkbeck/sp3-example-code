package generics.dogs;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains the main function which simply tests chiuaua and germanshepherd
 *
 * @author
 */
public class Main {

    public static void main(String[] args) {
        Dog alice = new Chiuaua("Alice");
        Dog bob = new Chiuaua("Bob");
        Dog charlie = new Chiuaua("Charlie");
        Dog dave = new GermanShepherd("Dave");

        List<Dog> allDogs = new LinkedList<Dog>();
        allDogs.add(alice);
        allDogs.add(bob);
        allDogs.add(charlie);
        allDogs.add(dave);


        // Warning!  Some Java Generics traps below:

        // Chiuaua is a subtype of Dog, but List<Chiuaua> is not a subtype of List<Dog>
        List<Chiuaua> littleDogList = new LinkedList<>();
        littleDogList.add(new Chiuaua("Evan"));
        // List<Dog> moreDogs = littleDogList;

        // One may not create arrays of bound generic types
        // LinkedList<Chiuaua>[] manyDogs = new LinkedList<>[42];
    }
}
