package lombokexamples.exceptions;

import java.net.MalformedURLException;
import java.net.URL;

public class UserService {

    public URL buildUsersApiUrl() {
        try {
            return new URL("https://apiserver.com/users");
        } catch (MalformedURLException ex) {
            // Malformed? Really?
            throw new RuntimeException(ex);
        }
    }
}