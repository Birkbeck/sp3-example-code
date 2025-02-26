package helloworld.spring;

public interface MessageRenderer {
    void render();

    default void setMessageProvider(MessageProvider provider) {
    }
}
