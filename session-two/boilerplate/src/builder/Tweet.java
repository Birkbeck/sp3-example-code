package builder;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@ToString
public class Tweet {
    private String author;
    private String content;
    private LocalDateTime timestamp;
    private List<String> hashtags;
}
