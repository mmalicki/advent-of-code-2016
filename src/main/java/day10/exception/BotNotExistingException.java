package day10.exception;

public class BotNotExistingException extends RuntimeException {
    public BotNotExistingException(String message) {
        super(message);
    }
}
