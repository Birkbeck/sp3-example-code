package lombokexamples.exceptions;

import lombok.SneakyThrows;

import java.net.URL;

public class UserServiceLombok {
    @SneakyThrows
    public URL buildUsersApiUrl() {
        return new URL("https://apiserver.com/users");
    }
}