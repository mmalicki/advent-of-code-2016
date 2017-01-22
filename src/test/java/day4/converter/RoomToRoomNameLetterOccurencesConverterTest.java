package day4.converter;

import day4.model.Room;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class RoomToRoomNameLetterOccurencesConverterTest {

    //TODO: refaktor klasy z logika
    @Test
    public void convert() throws Exception {
        Room room = new Room("bbbb-a-qqqqqq", 0, "");
        Map<String, Integer> occurrences = RoomToRoomNameLetterOccurencesConverter.convert(room);
        assertEquals(4, (long)occurrences.get("b")); //TODO: rzutowanie
        assertEquals(1, (long)occurrences.get("a")); //TODO: rzutowanie
        assertEquals(6, (long)occurrences.get("q")); //TODO: rzutowanie
        assertEquals(3, occurrences.size());
    }

}