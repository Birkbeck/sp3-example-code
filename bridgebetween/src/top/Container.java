package top;

import lombok.Data;

@Data
public class Container {
    private final Thing things = Thing.of();
}
