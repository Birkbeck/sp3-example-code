package org.example;

import java.lang.reflect.Field;

/// This class scans an object, finds fields marked `@Inject`,
/// and assigns an instance to them.

public class MiniContainer {
    public static void wire(Object client) throws Exception {
        for (Field field : client.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                // Simple logic: if it's MessageService, give it an EmailService
                if (field.getType() == MessageService.class) {
                    field.set(client, new EmailService());
                }
            }
        }
    }
}