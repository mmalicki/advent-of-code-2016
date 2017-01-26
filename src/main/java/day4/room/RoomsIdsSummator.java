package day4.room;

import day4.model.Room;

import java.util.Optional;
import java.util.stream.Stream;

public class RoomsIdsSummator implements DecryptorStrategy {
    @Override
    public Optional<Integer> decrypt(Stream<Room> roomStream) {
        return Optional.of(roomStream
                .mapToInt(Room::getId)
                .sum());
    }
}
