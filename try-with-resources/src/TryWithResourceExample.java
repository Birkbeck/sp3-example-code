package trywithresources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResourceExample {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = getInputStream();

        try (inputStream) {
            String s = new String(inputStream.readAllBytes());
            System.out.println(s);
        }

        System.out.println("after try-with-resource block");
    }

    public static InputStream getInputStream() {
        return new ByteArrayInputStream("test string".getBytes()) {
            @Override
            public void close() throws IOException {
                System.out.println("closing");
                super.close();
            }
        };
    }
}
