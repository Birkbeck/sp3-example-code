package generics.dogs;

/**
 * An abstract dog which provides basic implementation for a dog.
 *
 * @author
 */
public abstract class AbstractDog implements Dog {
    //keep these private so no one can change these values.
    private String name;
    private String breed;

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final void setName(String name) {
        this.name = name;
    }

    @Override
    public final String getBreed() {
        return this.breed;
    }

    protected final void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public abstract void bark();

    @Override
    public final String toString() {
        return "Breed: " + this.breed + " Name: " + this.name;
    }
}
