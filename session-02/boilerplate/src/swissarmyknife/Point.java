package swissarmyknife;

import lombok.Value;

@Value // immutable objects
public class Point {
    int x;
    int y;
}
// Generates Final fields, Getters, No Setters, ToString, EqualsAndHashCode, AllArgsConstructor
