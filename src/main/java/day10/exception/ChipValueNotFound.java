package day10.exception;

public class ChipValueNotFound extends RuntimeException {
    public ChipValueNotFound(String message) {
        super(message);
    }
}
