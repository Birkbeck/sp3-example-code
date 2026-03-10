package swissarmyknife;

import lombok.Data;

@Data // Mutable DTO -> Data Transfer Objects
public class SearchRequest {
    private String query;
    private int page;
    // Generate -> Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor
}
