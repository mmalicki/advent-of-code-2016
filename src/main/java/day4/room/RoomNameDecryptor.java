package day4.room;

import day4.model.Room;
import scala.Char;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class RoomNameDecryptor implements DecryptorStrategy {

    private static final int ALPHABET_SIZE = 26;
    private static final char ALPHABET_BASE = 'a';
    private static final String NORTHPOLE_ROOM = "north pole";
    private static final Predicate<Room> STORES_NORTHPOLE_OBJECTS = room -> room.getEncryptedName().contains(NORTHPOLE_ROOM);

    @Override
    public Optional<Integer> decrypt(Stream<Room> roomStream) {
        return roomStream
                .map(room -> new Room(shiftRoomNameById(room), room.getId(), room.getChecksum()))
                .filter(STORES_NORTHPOLE_OBJECTS).findAny()
                .map(Room::getId);
    }

    private String shiftRoomNameById(Room room) {
        return room.getEncryptedName().chars()
             .map(letter -> letter == '-' ? ' ' : shiftRightBy(letter, room.getId()))
             .mapToObj(value -> Character.toLowerCase((char) value))
             .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    private int shiftRightBy(int letter, int shift) {
        int letterOffset = letter - ALPHABET_BASE;
        int shiftedOffset = (letterOffset + shift) % ALPHABET_SIZE;
        return  (ALPHABET_BASE + shiftedOffset);
    }
}