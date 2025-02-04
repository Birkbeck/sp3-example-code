package helloworld.decoupled.factory;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);
}
