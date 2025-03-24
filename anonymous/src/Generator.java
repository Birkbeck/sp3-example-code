package anonymous;

public class Generator {
    public Sensor getSensor() {
        class MyNewSensor implements Sensor {

            @Override
            public void myMethod() {
                // TODO
            }
        }
        return new MyNewSensor();
    }
}
