package day9.decoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecoderTest {

    private Decoder decoder = new Decoder();

    @Test
    public void shouldDecodeBasicMarker() throws Exception {
        String input = "(3x3)XYZ";

        String result = decoder.decode(input);

        assertEquals("XYZXYZXYZ", result);
    }

    @Test
    public void shouldDecodeMultipleMarkers() throws Exception {
        String input = "A(2x2)BCD(2x2)EFG";

        String result = decoder.decode(input);

        assertEquals("ABCBCDEFEFG", result);
    }

    @Test
    public void shouldIgnoreFalseMarker() throws Exception {
        String input = "(6x1)(1x3)A";

        String result = decoder.decode(input);

        assertEquals("(1x3)A", result);
    }

    @Test
    public void anotherFalseMarker() throws Exception {
        String input = "X(8x2)(3x3)ABCY";

        String result = decoder.decode(input);

        assertEquals("X(3x3)ABC(3x3)ABCY", result);
    }
}