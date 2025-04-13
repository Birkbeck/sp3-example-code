public class Greeter {
    private final Personality personality;

    public Greeter(Personality personality) {
        this.personality = personality;
    }

    public String greet() {
        return this.personality.greet();
    }
}
