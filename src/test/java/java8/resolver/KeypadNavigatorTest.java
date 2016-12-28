package java8.resolver;

import java8.model.Direction;
import java8.model.Key;
import java8.model.Keypad;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KeypadNavigatorTest {

    private KeypadNavigator keypadNavigator;

    @Test
    public void navigateKeypad() throws Exception {
        //GIVEN
        Keypad keypad = new Keypad();
        keypadNavigator = new KeypadNavigator(keypad);
        List<Direction> directions = Arrays.asList(Direction.UP, Direction.RIGHT, Direction.RIGHT, Direction.UP);

        //WHEN
        keypadNavigator.navigateKeypad(directions);

        //THEN
        Key result = keypadNavigator.getCurrentKey();
        Assert.assertEquals(Key.THREE, result);
    }

    @Test
    public void navigateKeypad_NoBoundaries() throws Exception {
        //GIVEN
        Keypad keypad = new Keypad();
        keypadNavigator = new KeypadNavigator(keypad);
        List<Direction> directions = Arrays.asList(Direction.DOWN, Direction.LEFT, Direction.RIGHT);

        //WHEN
        keypadNavigator.navigateKeypad(directions);

        //THEN
        Key result = keypadNavigator.getCurrentKey();
        Assert.assertEquals(Key.EIGHT, result);
    }
}