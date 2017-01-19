package day2.converter;

import java.util.Arrays;
import java.util.List;
import day2.model.Direction;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author mmalicki
 */
public class StringDirectionToDirectionConverterTest {

    private StringDirectionToDirectionConverter testObject = new StringDirectionToDirectionConverter();

    @Test
    public void getDirections() {
        String instructions = "LLUDR";
        final List<Direction> result = testObject.getDirections(instructions);
        Assert.assertEquals(Arrays.asList(Direction.LEFT, Direction.LEFT,
                Direction.UP, Direction.DOWN, Direction.RIGHT), result);
    }

}