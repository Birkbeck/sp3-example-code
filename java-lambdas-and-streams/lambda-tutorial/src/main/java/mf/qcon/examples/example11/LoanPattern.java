package mf.qcon.examples.example11;

import java.util.function.*;

public class LoanPattern {

    public static void main(String... args) {
        Resource.withResource(r -> r.operate());
    }

    public static class Resource {

        private Resource() {
            System.out.println("Opening resource");
        }

        public static void withResource(Consumer<Resource> consumer) {
            Resource r = new Resource();
            try {
                consumer.accept(r);
            } finally {
                r.dispose();
            }
        }

        public void operate() {
            System.out.println("Operating on resource");
            throw new RuntimeException();
        }

        public void dispose() {
            System.out.println("Disposing resource");
        }
    }
}
