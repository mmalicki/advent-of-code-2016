package day2.resolver;

import java.util.List;
import day2.model.Direction;
import day2.model.Key;
import day2.model.keypad.Keypad;

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
