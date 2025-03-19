package generics.dogs;

/**
 * A German Shepherd specific implementation of AbstractDog
 *
 * @author
 */
public class GermanShepherd extends AbstractDog {

    /**
     * A constructor used to make a german shepherd.
     */
    public GermanShepherd(String name) {
        this.setName(name);
        this.setBreed("GermanShepherd");
    }

    @Override
    public void bark() {
        System.out.println("BARK! BARK!");
    }

    /**
     * Plays fetch with the dog
     */
    public void play() {
        System.out.println(this.getName() + " fetched the ball!");
    }
}
