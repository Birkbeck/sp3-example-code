package helloworld.spring.di.xml;

public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider provider);
}
