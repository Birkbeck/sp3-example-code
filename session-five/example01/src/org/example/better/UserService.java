package org.example.better;

import org.example.MessageService;


public class UserService {
    private final MessageService messageService;

    // Dependency is injected here
    public UserService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void register(String user) {
        messageService.send("Hello " + user, "user@example.com");
    }
}