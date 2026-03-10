package org.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("org.example.demo") // Tells Spring where to look for @Component
public class AppConfig {

    @Bean
    public MessageService emailService() {
        return new EmailServiceImpl();
    }
}