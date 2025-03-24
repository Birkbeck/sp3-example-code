package lombokexamples;/*
 * Another example class for use with reflection
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRedux implements Person {
    private String name;
    private String userid;
}
