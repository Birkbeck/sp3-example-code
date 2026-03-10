package org.example;

public class EmailService implements MessageService {
    public void send(String msg, String rec) { 
        System.out.println("Email: " + msg);
    }

    public void register(String email) {
        System.out.println( "Registering: " + email);
    }
}
