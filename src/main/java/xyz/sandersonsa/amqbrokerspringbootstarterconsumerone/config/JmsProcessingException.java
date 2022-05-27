package xyz.sandersonsa.amqbrokerspringbootstarterconsumerone.config;

public class JmsProcessingException extends RuntimeException {

    public JmsProcessingException(String message) {
        super(message);
    }
}