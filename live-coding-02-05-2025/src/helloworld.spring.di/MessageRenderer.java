package helloworld.spring.di;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);
}
