package day5.transformer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author mmalicki
 */
public class DoorIDMD5TransformerTest {

    private DoorIDTransformer doorIDTransformer = new DoorIDMD5Transformer();

    @Test
    public void test() {
        String result = doorIDTransformer.transform("abc3231929");
        assertEquals("00000155f8105dff7f56ee10fa9b9abd", result);
    }
}