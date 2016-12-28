package day2.java8.model;

/**
 * @author mmalicki
 */
public enum Key {
    ONE(1), TWO(2), THREE(3),
    FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9),
    A("A"), B("B"), C("C"), D("D");

    private String character;

    Key(final int number) {
        this.character = String.valueOf(number);
    }

    Key(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }
}