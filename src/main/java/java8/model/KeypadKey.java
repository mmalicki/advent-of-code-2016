package java8.model;

/**
 * @author mmalicki
 */
public class KeypadKey {
    public final Key key;
    public final Key nextDown;
    public final Key nextUp;
    public final Key nextLeft;
    public final Key nextRight;

    public KeypadKey(final Key key, final Key nextDown, final Key nextUp, final Key nextLeft, final Key nextRight) {
        this.key = key;
        this.nextDown = nextDown;
        this.nextUp = nextUp;
        this.nextLeft = nextLeft;
        this.nextRight = nextRight;
    }
}
