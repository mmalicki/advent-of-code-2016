package java8.model;

/**
 * @author mmalicki
 */
public enum Key {
    ONE(1), TWO(2), THREE(3),
    FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9);

    private final int number;

    Key(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}