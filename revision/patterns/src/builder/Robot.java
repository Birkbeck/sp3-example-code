package builder;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class Robot {
    private String robotHead;
    private String robotTorso;
    private String robotArms;
    private String robotLegs;

}
