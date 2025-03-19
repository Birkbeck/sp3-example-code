/**
 * Brand of a {@link Car}.
 *
 * @author Donato Rimenti
 */
public class BrandImpl implements Brand {

    /**
     * The name of the brand.
     */
    private String name;

    /**
     * Instantiates a new Brand.
     *
     * @param name the {@link #name}
     */
    public BrandImpl(String name) {
        this.name = name;
    }

    /**
     * Gets the {@link #name}.
     *
     * @return the {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the {@link #name}.
     *
     * @param name the new {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

}