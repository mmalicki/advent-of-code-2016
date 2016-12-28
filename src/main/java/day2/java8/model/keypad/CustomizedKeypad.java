package day2.java8.model.keypad;

import com.google.common.collect.ImmutableMap;
import day2.java8.model.Key;
import day2.java8.model.KeypadKey;

import java.util.Map;

public class CustomizedKeypad extends Keypad{
    private static final KeypadKey ONE = new KeypadKey(Key.ONE, Key.THREE, Key.ONE, Key.ONE, Key.ONE);
    private static final KeypadKey TWO = new KeypadKey(Key.TWO, Key.SIX, Key.TWO, Key.TWO, Key.THREE);
    private static final KeypadKey THREE = new KeypadKey(Key.THREE, Key.SEVEN, Key.ONE, Key.TWO, Key.FOUR);
    private static final KeypadKey FOUR = new KeypadKey(Key.FOUR, Key.EIGHT, Key.FOUR, Key.THREE, Key.FOUR);
    private static final KeypadKey FIVE = new KeypadKey(Key.FIVE, Key.FIVE, Key.FIVE, Key.FIVE, Key.SIX);
    private static final KeypadKey SIX = new KeypadKey(Key.SIX, Key.A, Key.TWO, Key.FIVE, Key.SEVEN);
    private static final KeypadKey SEVEN = new KeypadKey(Key.SEVEN, Key.B, Key.THREE, Key.SIX, Key.EIGHT);
    private static final KeypadKey EIGHT = new KeypadKey(Key.EIGHT, Key.C, Key.FOUR, Key.SEVEN, Key.NINE);
    private static final KeypadKey NINE = new KeypadKey(Key.NINE, Key.NINE, Key.NINE, Key.EIGHT, Key.NINE);
    private static final KeypadKey A = new KeypadKey(Key.A, Key.A, Key.SIX, Key.A, Key.B);
    private static final KeypadKey B = new KeypadKey(Key.B, Key.D, Key.SEVEN, Key.A, Key.C);
    private static final KeypadKey C = new KeypadKey(Key.C, Key.C, Key.EIGHT, Key.B, Key.C);
    private static final KeypadKey D = new KeypadKey(Key.D, Key.D, Key.B, Key.D, Key.D);

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
