package helloworld.spring.autoscan;

public interface MessageRenderer {
    void render();

    default void setMessageProvider(MessageProvider provider) {
    }
}
