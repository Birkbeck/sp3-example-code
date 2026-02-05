package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SecretAgent {
    private String codeName = "Double-O-Seven";
}

public class SpyGlass {
    public static void main(String... args) throws Exception {
        SecretAgent agent = new SecretAgent();

        // Get the field named 'codeName'
        Field field = agent.getClass().getDeclaredField("codeName");

        // Force access to the private field
        field.setAccessible(true);

        // Read the value
        String value = (String) field.get(agent);
        System.out.println("Discovered code name: " + value); // Outputs: Double-O-Seven

        // Modify the value!
        field.set(agent, "Austin Powers");
        System.out.println("New code name: " + (String) field.get(agent));
    }
}