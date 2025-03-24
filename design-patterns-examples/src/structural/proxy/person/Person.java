package structural.proxy.person;

public class Person implements PersonInterface {
    private final String mName;
    private final float mWeight;

    public Person(String name, float weight) {
        mName = name;
        mWeight = weight;
    }

    @Override
    public float getWeight() {
        // Assume we weigh ourselves here
        return mWeight;
    }

    @Override
    public String getName() {
        return mName;
    }
}
