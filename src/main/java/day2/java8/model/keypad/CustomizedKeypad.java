package day2.java8.model.keypad;

import com.google.common.collect.ImmutableMap;
import day2.java8.model.Key;
import day2.java8.model.KeypadKey;

import java.util.Map;

public class CustomizedKeypad extends Keypad {
    private static final KeypadKey ONE = KeypadKey.builder().withKey(Key.ONE).withNextDown(Key.THREE).withNextUp(Key.ONE)
            .withNextLeft(Key.ONE).withNextRight(Key.ONE).build();

    private static final KeypadKey TWO = KeypadKey.builder().withKey(Key.TWO).withNextDown(Key.SIX).withNextUp(Key.TWO)
            .withNextLeft(Key.TWO).withNextRight(Key.THREE).build();

    private static final KeypadKey THREE = KeypadKey.builder().withKey(Key.THREE).withNextDown(Key.SEVEN).withNextUp(Key.ONE)
            .withNextLeft(Key.TWO).withNextRight(Key.FOUR).build();

    private static final KeypadKey FOUR = KeypadKey.builder().withKey(Key.FOUR).withNextDown(Key.EIGHT).withNextUp(Key.FOUR)
            .withNextLeft(Key.THREE).withNextRight(Key.FOUR).build();

    private static final KeypadKey FIVE = KeypadKey.builder().withKey(Key.FIVE).withNextDown(Key.FIVE).withNextUp(Key.FIVE)
            .withNextLeft(Key.FIVE).withNextRight(Key.SIX).build();

    private static final KeypadKey SIX = KeypadKey.builder().withKey(Key.SIX).withNextDown(Key.A).withNextUp(Key.TWO)
            .withNextLeft(Key.FIVE).withNextRight(Key.SEVEN).build();

    private static final KeypadKey SEVEN = KeypadKey.builder().withKey(Key.SEVEN).withNextDown(Key.B).withNextUp(Key.THREE)
            .withNextLeft(Key.SIX).withNextRight(Key.EIGHT).build();

    private static final KeypadKey EIGHT = KeypadKey.builder().withKey(Key.EIGHT).withNextDown(Key.C).withNextUp(Key.FOUR)
            .withNextLeft(Key.SEVEN).withNextRight(Key.NINE).build();

    private static final KeypadKey NINE = KeypadKey.builder().withKey(Key.NINE).withNextDown(Key.NINE).withNextUp(Key.NINE)
            .withNextLeft(Key.EIGHT).withNextRight(Key.NINE).build();

    private static final KeypadKey A = KeypadKey.builder().withKey(Key.A).withNextDown(Key.A).withNextUp(Key.SIX)
            .withNextLeft(Key.A).withNextRight(Key.B).build();

    private static final KeypadKey B = KeypadKey.builder().withKey(Key.B).withNextDown(Key.D).withNextUp(Key.SEVEN)
            .withNextLeft(Key.A).withNextRight(Key.C).build();

    private static final KeypadKey C = KeypadKey.builder().withKey(Key.C).withNextDown(Key.C).withNextUp(Key.EIGHT)
            .withNextLeft(Key.B).withNextRight(Key.C).build();

    private static final KeypadKey D = KeypadKey.builder().withKey(Key.D).withNextDown(Key.D).withNextUp(Key.B)
            .withNextLeft(Key.D).withNextRight(Key.D).build();

    private static final Map<Key, KeypadKey> KEYS = ImmutableMap.<Key, KeypadKey>builder()
            .put(Key.ONE, ONE)
            .put(Key.TWO, TWO)
            .put(Key.THREE, THREE)
            .put(Key.FOUR, FOUR)
            .put(Key.FIVE, FIVE)
            .put(Key.SIX, SIX)
            .put(Key.SEVEN, SEVEN)
            .put(Key.EIGHT, EIGHT)
            .put(Key.NINE, NINE)
            .put(Key.A, A)
            .put(Key.B, B)
            .put(Key.C, C)
            .put(Key.D, D)
            .build();

    public CustomizedKeypad() {
        this.currentKey = FIVE;
    }

    public CustomizedKeypad(final KeypadKey currentKey) {
        this.currentKey = currentKey;
    }

    @Override
    protected KeypadKey getKeypadKey(Key key) {
        return KEYS.get(key);
    }
}
