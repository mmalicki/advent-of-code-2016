package day5.provider;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author mmalicki
 */
public class FirstNonZeroPasswordChunkProviderTest {

    private FirstNonZeroPasswordChunkProvider firstNonZeroPasswordChunkProvider = new FirstNonZeroPasswordChunkProvider();

    @Test
    public void test() throws Exception {
        String result = firstNonZeroPasswordChunkProvider.getPasswordChunk("00000R456");
        assertEquals("R", result);
    }
}