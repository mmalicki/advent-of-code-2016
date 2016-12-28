package day2.java8.model;

/**
 * @author mmalicki
 */
public enum Direction {
    LEFT {
        @Override
        public Key getNext(KeypadKey keypadKey) {
            return keypadKey.nextLeft;
        }
    }, RIGHT {
        @Override
        public Key getNext(KeypadKey key) {
            return key.nextRight;
        }
    }, UP {
        @Override
        public Key getNext(KeypadKey key) {
            return key.nextUp;
        }
    }, DOWN {
        @Override
        public Key getNext(KeypadKey key) {
            return key.nextDown;
        }
    };

    public abstract Key getNext(KeypadKey key);
}
