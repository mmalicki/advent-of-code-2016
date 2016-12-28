package day2.java8.model.keypad;

import com.google.common.collect.ImmutableMap;
import day2.java8.model.Key;
import day2.java8.model.KeypadKey;

import java.util.Map;

/**
 * @author mmalicki
 */

public class ClassicKeypad extends Keypad {
    private static final KeypadKey ONE = KeypadKey.builder().withKey(Key.ONE).withNextDown(Key.FOUR)
            .withNextUp(Key.ONE).withNextLeft(Key.ONE).withNextRight(Key.TWO).build();

    private static final KeypadKey TWO = KeypadKey.builder().withKey(Key.TWO).withNextDown(Key.FIVE)
            .withNextUp(Key.TWO).withNextLeft(Key.ONE).withNextRight(Key.THREE).build();

    private static final KeypadKey THREE = KeypadKey.builder().withKey(Key.THREE).withNextDown(Key.SIX)
            .withNextUp(Key.THREE).withNextLeft(Key.TWO).withNextRight(Key.THREE).build();

    private static final KeypadKey FOUR = KeypadKey.builder().withKey(Key.FOUR).withNextDown(Key.SEVEN)
            .withNextUp(Key.ONE).withNextLeft(Key.FOUR).withNextRight(Key.FIVE).build();

    private static final KeypadKey FIVE = KeypadKey.builder().withKey(Key.FIVE).withNextDown(Key.EIGHT)
            .withNextUp(Key.TWO).withNextLeft(Key.FOUR).withNextRight(Key.THREE).build();

    private static final KeypadKey SIX = KeypadKey.builder().withKey(Key.SIX).withNextDown(Key.NINE)
            .withNextUp(Key.THREE).withNextLeft(Key.FIVE).withNextRight(Key.SIX).build();

    private static final KeypadKey SEVEN = KeypadKey.builder().withKey(Key.SEVEN).withNextDown(Key.SEVEN)
            .withNextUp(Key.FOUR).withNextLeft(Key.SEVEN).withNextRight(Key.EIGHT).build();

    private static final KeypadKey EIGHT = KeypadKey.builder().withKey(Key.EIGHT).withNextDown(Key.EIGHT)
            .withNextUp(Key.FIVE).withNextLeft(Key.SEVEN).withNextRight(Key.NINE).build();

    private static final KeypadKey NINE = KeypadKey.builder().withKey(Key.NINE).withNextDown(Key.NINE)
            .withNextUp(Key.FIVE).withNextLeft(Key.EIGHT).withNextRight(Key.NINE).build();


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
            .build();


    public ClassicKeypad() {
        this.currentKey = FIVE;
    }

    public ClassicKeypad(final KeypadKey currentKey) {
        this.currentKey = currentKey;
    }

    @Override
    protected KeypadKey getKeypadKey(Key key) {
        return KEYS.get(key);
    }
}



