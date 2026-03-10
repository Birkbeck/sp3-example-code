package builder;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    static void main() {
        Tweet post = Tweet.builder()
                .author("Frank")
                .content("Boring")
                .hashtags(List.of("Lombok looks interesting", "Java is verbose"))
                .timestamp(LocalDateTime.now())
                .build();
        System.out.println(post);

    }
}
