package day2.java8.model;

/**
 * @author mmalicki
 */
public enum Direction {
    LEFT {
        @Override
        public Key move(KeypadKey keypadKey) {
            return keypadKey.nextLeft;
        }
    }, RIGHT {
        @Override
        public Key move(KeypadKey key) {
            return key.nextRight;
        }
    }, UP {
        @Override
        public Key move(KeypadKey key) {
            return key.nextUp;
        }
    }, DOWN {
        @Override
        public Key move(KeypadKey key) {
            return key.nextDown;
        }
    };

    public abstract Key move(KeypadKey key);
}
