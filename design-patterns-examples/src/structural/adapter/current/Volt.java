package structural.adapter.current;

public class Volt {
    private int volts;

    public Volt(int v) {
        setVolts(v);
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}