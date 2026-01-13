package helloworld.spring.annotations;

public interface MessageRenderer {
    void render();

    default void setMessageProvider(MessageProvider provider) {
    }
}
