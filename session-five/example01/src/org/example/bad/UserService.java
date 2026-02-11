/// ## The Problem: Tightly Coupled Code
///
/// Imagine a `UserService` that sends a welcome email. 
/// If we hardcode the email service, we can't easily swap it for an SMS service or 
/// a "Mock" service for testing.
 
package org.example.bad;

import org.example.EmailService;

public class UserService {
    private EmailService emailService = new EmailService(); // Hardcoded!

    public void registerUser(String email) {
        // Logic...
        emailService.send("Welcome!", email);
    }
}
