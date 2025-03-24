package creational.singletonalt;

public class MySingleton {
    private static final MySingleton instance = new MySingleton();

    private MySingleton() {
    } // no client can do: new MySingleton()

    public static MySingleton getInstance() {
        return instance;
    }

    public void doX() {
    }

    public void doY() {
    }

    public String getA() {
        return "";
    }

    public int getB() {
        return 0;
    }
}