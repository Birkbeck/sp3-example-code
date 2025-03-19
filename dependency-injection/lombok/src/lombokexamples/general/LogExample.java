package lombokexamples.general;

import lombok.extern.java.Log;

@Log
public class LogExample {
    public static void main(String... args) {
        log.severe("Something's wrong here");
    }
}