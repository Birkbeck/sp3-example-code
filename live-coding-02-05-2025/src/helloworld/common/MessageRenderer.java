package helloworld.common;

public interface MessageRenderer {
    void render();

    default void setMessageProvider(MessageProvider provider) {}
}
