package day6;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mmalicki
 */
public class ColumnIteratorTest {
    @Test
    public void testIterator() throws Exception {
        String input = "abcd" + System.lineSeparator() + "efgh" + System.lineSeparator() + "ijkl" + System.lineSeparator() + "mnop";
        ColumnIterator iterator = ColumnIterator.of(input);
        StringBuilder result = new StringBuilder();

        while(iterator.hasNext()) {
            result.append(iterator.next());
        }
        Assert.assertEquals("aeimbfjncgkodhlp", result.toString());

    }
}