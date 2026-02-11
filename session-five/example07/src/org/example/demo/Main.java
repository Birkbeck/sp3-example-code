package org.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Spring Context using our Config class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Retrieve the bean from the container
        ModernUserService service = context.getBean(ModernUserService.class);

        // 3. Use the service
        service.register("Bob");

        // 4. Close the context to trigger destruction lifecycle
        context.close();
    }
}