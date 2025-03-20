package mf.qcon.talk.example11;

import java.util.function.*;

public class LoanPattern {

    public static void main(String... args) {

    }

    public static class Resource {

        private Resource() {
            System.out.println("Opening resource");
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
