package java8.model;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/**
 * @author mmalicki
 */

public class Keypad {
    private static final KeypadKey ONE = new KeypadKey(Key.ONE, Key.FOUR, Key.ONE, Key.ONE, Key.TWO);
    private static final KeypadKey TWO = new KeypadKey(Key.TWO, Key.FIVE, Key.TWO, Key.ONE, Key.THREE);
    private static final KeypadKey THREE = new KeypadKey(Key.THREE, Key.SIX, Key.THREE, Key.TWO, Key.THREE);
    private static final KeypadKey FOUR = new KeypadKey(Key.FOUR, Key.SEVEN, Key.ONE, Key.FOUR, Key.FIVE);
    private static final KeypadKey FIVE = new KeypadKey(Key.FIVE, Key.EIGHT, Key.TWO, Key.FOUR, Key.SIX);
    private static final KeypadKey SIX = new KeypadKey(Key.SIX, Key.NINE, Key.THREE, Key.FIVE, Key.SIX);
    private static final KeypadKey SEVEN = new KeypadKey(Key.SEVEN, Key.SEVEN, Key.FOUR, Key.SEVEN, Key.EIGHT);
    private static final KeypadKey EIGHT = new KeypadKey(Key.EIGHT, Key.EIGHT, Key.FIVE, Key.SEVEN, Key.NINE);
    private static final KeypadKey NINE = new KeypadKey(Key.NINE, Key.NINE, Key.SIX, Key.EIGHT, Key.NINE);

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

    private KeypadKey currentKey;

    public Keypad() {
        this.currentKey = FIVE;
    }
    public Keypad(final KeypadKey currentKey) {
        this.currentKey = currentKey;
    }

    public void move(Direction direction) {
        switch (direction) {
            case DOWN:
                currentKey = KEYS.get(currentKey.nextDown);
                break;
            case LEFT:
                currentKey = KEYS.get(currentKey.nextLeft);
                break;
            case RIGHT:
                currentKey = KEYS.get(currentKey.nextRight);
                break;
            case UP:
                currentKey = KEYS.get(currentKey.nextUp);
                break;
        }
    }

    public Key getCurrentKey() {
        return currentKey.key;
    }
}



