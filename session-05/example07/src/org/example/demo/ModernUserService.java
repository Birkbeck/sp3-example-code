package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModernUserService {
    private final MessageService messageService;

    // Spring finds the implementation in the Context and injects it here
    @Autowired
    public ModernUserService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void register(String name) {
        System.out.println("Registering: " + name);
        messageService.sendMessage("Welcome " + name);
    }
}