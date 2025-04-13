import java.util.*;

class Resource implements AutoCloseable {
    public void close() {
        System.out.println("called...");
    }
}

public class Sample {
    public static void main(String[] args) {
        //try(Resource resource = new Resource()) {
        //
        //}

        try (var resource = new Resource()) {

        }
    }
}