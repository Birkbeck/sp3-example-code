package helloworld.spring.di.cons;

import interfaces.MessageProvider;

public record ConfigurableMessageProvider(String message) implements MessageProvider {

}