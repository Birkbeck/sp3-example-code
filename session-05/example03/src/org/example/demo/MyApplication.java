package org.example.demo;

import com.google.inject.Inject;

public class MyApplication {
    private final MessageService service;

    // Constructor Injection
    @Inject
    public MyApplication(MessageService service) {
        this.service = service;
    }

    public void send(String msg) {
        service.sendMessage(msg);
    }
}
