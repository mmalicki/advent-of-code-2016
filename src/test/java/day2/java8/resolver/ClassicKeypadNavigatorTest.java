package day2.java8.resolver;

import day2.java8.model.Direction;
import day2.java8.model.Key;
import day2.java8.model.keypad.ClassicKeypad;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ClassicKeypadNavigatorTest {

    private KeypadNavigator keypadNavigator;

    @Test
    public void navigateKeypad() throws Exception {
        //GIVEN
        ClassicKeypad classicKeypad = new ClassicKeypad();
        keypadNavigator = new KeypadNavigator(classicKeypad);
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
        ClassicKeypad classicKeypad = new ClassicKeypad();
        keypadNavigator = new KeypadNavigator(classicKeypad);
        List<Direction> directions = Arrays.asList(Direction.DOWN, Direction.LEFT, Direction.RIGHT);

        //WHEN
        keypadNavigator.navigateKeypad(directions);

        //THEN
        Key result = keypadNavigator.getCurrentKey();
        Assert.assertEquals(Key.EIGHT, result);
    }
}