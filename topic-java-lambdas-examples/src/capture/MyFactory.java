package capture;

@FunctionalInterface
public interface MyFactory {
    String create(char[] chars);
}