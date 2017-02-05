package day5.validator.transformation;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author mmalicki
 */
public class FirstFiveZeroesValidatorTest {

    @Test
    public void test() throws Exception {
        FirstFiveZeroesValidator firstFiveZeroesValidator = new FirstFiveZeroesValidator();
        final boolean result = firstFiveZeroesValidator.isValid("00000ab414");
        assertTrue(result);
    }
}