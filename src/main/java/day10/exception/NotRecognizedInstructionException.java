package day10.exception;

public class NotRecognizedInstructionException extends RuntimeException {
    public NotRecognizedInstructionException(String message) {
        super(message);
    }
}
