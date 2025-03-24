package generics.dogs;

import java.util.LinkedList;
import java.util.List;

public class DogWalker<T extends Dog> {
    private final List<T> dogs;

    public DogWalker(List<T> dogs) {
        this.dogs = new LinkedList<T>(dogs);  // Defensive copy
    }

    public static void main(String[] args) {
        Chiuaua alice = new Chiuaua("Alice");
        Chiuaua bob = new Chiuaua("Bob");
        Chiuaua charlie = new Chiuaua("Charlie");
        //GermanShepherd dave = new GermanShepherd("Dave");

        List<Chiuaua> littleDogs = new LinkedList<Chiuaua>();
        littleDogs.add(alice);
        littleDogs.add(bob);
        littleDogs.add(charlie);
        //littleDogs.add(dave);

        DogWalker<Chiuaua> eve = new DogWalker<Chiuaua>(littleDogs);
        eve.walk();
    }

    public void walk() {
        for (T dog : dogs) {
            dog.bark();  // Dogs still bark when you walk them
        }
    }
}
