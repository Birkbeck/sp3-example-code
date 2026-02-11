package org.example;

import org.example.better.UserService;

/// In manual DI, your `Main` class acts as the *Inversion of Control (IoC) Container*.

public class App {
    public static void main(String... args){
        // We wire the graph manually
        MessageService service = new EmailService();
        UserService userService = new UserService(service);
        
        userService.register("Alice");
    }
}