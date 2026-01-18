package example.spec;

public interface Person {
    default void thing(){
        System.out.print("Prints something out\n");
    }
}
