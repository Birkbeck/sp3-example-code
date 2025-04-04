package optional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    private User user;

    private final Logger logger = LogManager.getLogManager().getLogger("optional.OptionalTest");

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        Optional<User> opt = Optional.of(user);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("John", opt.get());
    }

    @Test
    public void whenCheckIsPresent_thenOk() {
        user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        assertTrue(opt.isPresent());

        assertEquals(user.getEmail(), opt.get().getEmail());
    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        assertTrue(opt.isPresent());

        opt.ifPresent(u -> assertEquals(user.getEmail(), u.getEmail()));
    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals("anna@gmail.com", result.getEmail());
    }

    @Test
    public void whenValueNotNull_thenIgnoreDefault() {
        User user = new User("john@gmail.com", "1234");
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals("john@gmail.com", result.getEmail());
    }

    @Test
    public void whenSetDefaultOrElseGet_thenOk() {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElseGet(() -> user2);

        assertEquals("anna@gmail.com", result.getEmail());
    }

    @Test
    public void givenPresentValue_whenCompare_thenOk() {
        User user = new User("john@gmail.com", "1234");
        logger.info("Using orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        logger.info("Using orElseGet");
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private User createNewUser() {
        logger.info("Creating New User");
        return new User("extra@gmail.com", "1234");
    }

    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        User user = null;
        logger.info("Using orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        logger.info("Using orElseGet");
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThrowException_thenOk() {
        User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user).map(u -> u.getEmail()).orElse("default@gmail.com");
        assertEquals(email, user.getEmail());

    }

    @Test
    public void whenFlatMap_thenOk() {
        user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        String position = Optional.ofNullable(user).flatMap(u -> u.getPosition()).orElse("default");
        assertEquals(position, user.getPosition().get());

    }

    @Test
    public void whenFilter_thenOk() {
        user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user).filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        assertTrue(result.isPresent());
    }

    @Test
    public void whenStream_thenOk() {
        List<User> users = new ArrayList<>();
        User user = users.stream().findFirst().orElse(new User("default", "1234"));
        assertEquals(user.getEmail(), "default");
    }

}