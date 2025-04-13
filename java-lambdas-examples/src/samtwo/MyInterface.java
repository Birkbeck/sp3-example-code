package samtwo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public interface MyInterface {

    static void printItToSystemOut(String text) {
        System.out.println(text);
    }

    void printIt(String text);

    default void printUtf8To(String text, OutputStream outputStream) {
        try {
            outputStream.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }
}