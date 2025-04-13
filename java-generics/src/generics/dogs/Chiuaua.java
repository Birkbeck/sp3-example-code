package generics.dogs;

/**
 * A Chiuaua specific implementation of AbstractDog
 *
 * @author
 */
public class Chiuaua extends AbstractDog {
    /**
     * A constructor used to make a Chiuaua.
     * this.name = name;
     */
    public Chiuaua(String name) {
        this.setName(name);
        this.setBreed("Chiuaua");
    }

    @Override
    public void bark() {
        System.out.println("arf! arf!");
    }
}
