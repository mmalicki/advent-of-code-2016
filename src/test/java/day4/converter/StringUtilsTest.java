package day4.converter;

import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringUtilsTest {

    //TODO: refaktor klasy z logika
    @Test
    public void convert() throws Exception {
        Map<Character, Integer> occurrences = StringUtils.getCharactersOccurrences("bbbb-a-qqqqqq");
        assertEquals(4, (long)occurrences.get('b')); //TODO: rzutowanie
        assertEquals(1, (long)occurrences.get('a')); //TODO: rzutowanie
        assertEquals(6, (long)occurrences.get('q')); //TODO: rzutowanie
        assertEquals(4, occurrences.size());
    }

}