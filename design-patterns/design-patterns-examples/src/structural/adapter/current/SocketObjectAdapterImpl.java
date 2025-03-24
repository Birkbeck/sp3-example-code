package adapter.current;

public class SocketObjectAdapterImpl implements SocketAdapter {

    //Using Composition for adapter pattern
    private final Socket sock = new Socket();

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(sock.getVolt(), 20);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(sock.getVolt(), 80);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}