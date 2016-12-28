package java8.resolver;

import java.util.List;
import java8.model.Direction;
import java8.model.Key;
import java8.model.Keypad;

/**
 * @author mmalicki
 */
public class KeypadNavigator {
    private final Keypad keypad;

    public KeypadNavigator(final Keypad keypad) {
        this.keypad = keypad;
    }

    public void navigateKeypad(List<Direction> directions) {
        for (Direction direction : directions) {
            keypad.move(direction);
        }
    }
    public Key getCurrentKey() {
        return keypad.getCurrentKey();
    }
}
