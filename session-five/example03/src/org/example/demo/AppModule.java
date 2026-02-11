package org.example.demo;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        // This is the core "Binding" logic
        bind(MessageService.class).to(EmailServiceImpl.class);
    }
}