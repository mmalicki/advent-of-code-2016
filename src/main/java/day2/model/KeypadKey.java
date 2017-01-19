package day2.model;

/**
 * @author mmalicki
 */
public class KeypadKey {
    public final Key key;
    public final Key nextDown;
    public final Key nextUp;
    public final Key nextLeft;
    public final Key nextRight;

    KeypadKey(final Key key, final Key nextDown, final Key nextUp, final Key nextLeft, final Key nextRight) {
        this.key = key;
        this.nextDown = nextDown;
        this.nextUp = nextUp;
        this.nextLeft = nextLeft;
        this.nextRight = nextRight;
    }

    public static KeypadKeyBuilder builder() {
        return new KeypadKeyBuilder();
    }

    public static final class KeypadKeyBuilder {
        public Key key;
        public Key nextDown;
        public Key nextUp;
        public Key nextLeft;
        public Key nextRight;

        private KeypadKeyBuilder() {
        }

        public KeypadKeyBuilder withKey(Key key) {
            this.key = key;
            return this;
        }

        public KeypadKeyBuilder withNextDown(Key nextDown) {
            this.nextDown = nextDown;
            return this;
        }

        public KeypadKeyBuilder withNextUp(Key nextUp) {
            this.nextUp = nextUp;
            return this;
        }

        public KeypadKeyBuilder withNextLeft(Key nextLeft) {
            this.nextLeft = nextLeft;
            return this;
        }

        public KeypadKeyBuilder withNextRight(Key nextRight) {
            this.nextRight = nextRight;
            return this;
        }

        public KeypadKey build() {
            return new KeypadKey(key, nextDown, nextUp, nextLeft, nextRight);
        }
    }
}
