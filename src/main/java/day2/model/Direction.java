package day2.model;

import java.util.Arrays;

/**
 * @author mmalicki
 */
public enum Direction {
    LEFT {
        @Override
        public Key getNext(KeypadKey keypadKey) {
            return keypadKey.nextLeft;
        }
        @Override
        public String toString() {
            return "L";
        }
    }, RIGHT {
        @Override
        public Key getNext(KeypadKey key) {
            return key.nextRight;
        }
        @Override
        public String toString() {
            return "R";
        }
    }, UP {
        @Override
        public Key getNext(KeypadKey key) {
            return key.nextUp;
        }
        @Override
        public String toString() {
            return "U";
        }
    }, DOWN {
        @Override
        public Key getNext(KeypadKey key) {
            return key.nextDown;
        }
        @Override
        public String toString() {
            return "D";
        }
    };

    public abstract Key getNext(KeypadKey key);

    public static Direction getDirection(String value) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.toString().equals(value))
                .findAny().orElseThrow(
                        () -> new RuntimeException("No existing direction with given key: " + value)
                );
    }
}
