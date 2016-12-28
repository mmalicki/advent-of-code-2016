package day2.java8.model.keypad;

import day2.java8.model.Direction;
import day2.java8.model.Key;
import day2.java8.model.KeypadKey;

public abstract class Keypad {
    protected KeypadKey currentKey;

    protected abstract KeypadKey getKeypadKey(Key key);

    public void move(Direction direction) {
        switch (direction) {
            case DOWN:
                currentKey = getKeypadKey(currentKey.nextDown);
                break;
            case LEFT:
                currentKey = getKeypadKey(currentKey.nextLeft);
                break;
            case RIGHT:
                currentKey = getKeypadKey(currentKey.nextRight);
                break;
            case UP:
                currentKey = getKeypadKey(currentKey.nextUp);
                break;
        }
    }

    public Key getCurrentKey() {
        return currentKey.key;
    }
}
