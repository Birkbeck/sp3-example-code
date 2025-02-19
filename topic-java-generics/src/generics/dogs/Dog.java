package generics.dogs;

/**
 * An interface which details methods for a generic dog.
 *
 * @author
 */
public interface Dog {

    /**
     * Returns the name of the dog
     *
     * @return String The name of the dog
     */
    String getName();

    /**
     * Sets the name of the dog.
     *
     * @param name the new name
     */
    void setName(String name);

    /**
     * returns the breed of the dog.
     *
     * @return String the breed of the dog.
     */
    String getBreed();

    /**
     * The prints out the dog's bark to console.
     */
    void bark();

    /**
     * returns a string which contains the name and the breed as follows
     * <p>
     * Breed: __ Name: __
     *
     * @return
     */
    @Override
    String toString();

}
