package org.example.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Injector with our module
        Injector injector = Guice.createInjector(new AppModule());

        // 2. Ask the injector for an instance of the application
        // Guice will automatically see that MyApplication needs MessageService
        // and look at AppModule to find the implementation.
        MyApplication app = injector.getInstance(MyApplication.class);

        app.send("Hello from Google Guice!");
    }
}