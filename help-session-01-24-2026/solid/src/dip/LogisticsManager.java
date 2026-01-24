package dip;

import java.util.EmptyStackException;

public class LogisticsManager {
    private EmailService emailService = new EmailService();// concrete implementation

    public void completeOrder(){
        emailService.sendEmail("Fred", "Ouch!", "That hurt...");
    }
}

class EmailService {
    public void sendEmail(String to, String subject, String body) {}
}
