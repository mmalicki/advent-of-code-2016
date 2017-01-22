package day4.room;

import day4.model.Room;

import java.util.stream.Stream;

@FunctionalInterface
public interface DecryptorStrategy {
    int decrypt(Stream<Room> roomStream);
}
