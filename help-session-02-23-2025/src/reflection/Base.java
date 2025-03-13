package reflection;

public interface Base {
    default String print() {
        return ">>> " + this.getClass().getSimpleName();
    }
}
