package day4.room;

import day4.model.Room;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class RoomNameDecryptorTest {

    private RoomNameDecryptor testObject = new RoomNameDecryptor();

    @Test
    public void test() {
        int result = testObject.decrypt(Stream.of(new Room("abc", 3, ""),
                new Room("abc-def", 2, ""),
                new Room("mnqsg-onkd", 1, "")));
        assertEquals(1, result);
    }
}