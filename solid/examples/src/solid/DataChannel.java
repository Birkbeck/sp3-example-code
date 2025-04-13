package solid;

public interface DataChannel {
    void send(char c);

    char receive();
}