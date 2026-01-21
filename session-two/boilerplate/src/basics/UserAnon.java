package basics;


import lombok.*;

@Getter
@Setter
@ToString(exclude = "password")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class UserAnon {
    private final Long id;
    private final String name;
    private String password;

    //public String toString(UserAnon ua){....}
    //public String toString(Object o)
}
