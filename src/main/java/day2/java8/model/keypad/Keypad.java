package day2.java8.model.keypad;

import day2.java8.model.Direction;
import day2.java8.model.Key;
import day2.java8.model.KeypadKey;

public abstract class Keypad {
    protected KeypadKey currentKey;

    protected abstract KeypadKey getKeypadKey(Key key);

    public void move(Direction direction) {
        currentKey = getKeypadKey(direction.getNext(currentKey));
    }

    public Key getCurrentKey() {
        return currentKey.key;
    }
}
