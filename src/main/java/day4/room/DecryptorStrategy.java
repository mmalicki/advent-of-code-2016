package day4.room;

import day4.model.Room;

import java.util.Optional;
import java.util.stream.Stream;

@FunctionalInterface
public interface DecryptorStrategy {
    Optional<Integer> decrypt(Stream<Room> roomStream);
}
