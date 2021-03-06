package day4.validator;

import day4.model.Room;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomNameValidatorTest {
    @Test
    public void isValid() throws Exception {
        Room room = new Room("aaaaa-bbb-z-y-x", 0, "abxyz");
        Room room2 = new Room("a-b-c-d-e-f-g-h", 0, "abcde");
        Room room3 = new Room("not-a-real-room", 0, "oarel");
        Room room4 = new Room("totally-real-room", 0, "decoy");
        assertTrue(RoomNameValidator.isValid(room));
        assertTrue(RoomNameValidator.isValid(room2));
        assertTrue(RoomNameValidator.isValid(room3));
        assertFalse(RoomNameValidator.isValid(room4));
    }
}