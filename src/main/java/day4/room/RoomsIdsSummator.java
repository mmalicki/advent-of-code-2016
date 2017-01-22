package day4.room;

import day4.model.Room;

import java.util.stream.Stream;

public class RoomsIdsSummator implements DecryptorStrategy {
    @Override
    public int decrypt(Stream<Room> roomStream) {
        return roomStream
                .mapToInt(Room::getId)
                .sum();
    }
}
