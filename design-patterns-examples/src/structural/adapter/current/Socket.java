package structural.adapter.current;

public class Socket {
    public Volt getVolt() {
        return new Volt(240);
    }
}