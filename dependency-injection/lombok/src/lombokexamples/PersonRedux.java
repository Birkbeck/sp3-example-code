package lombokexamples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
/*
 * Another example class for use with reflection
 */

@Log
@Data
@AllArgsConstructor
public class PersonRedux {
    private String name;
    private String userid;

    public PersonRedux() {
        this("Fred", "xyz123");
    }
}