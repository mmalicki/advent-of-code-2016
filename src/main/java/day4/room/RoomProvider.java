package day4.room;

import day4.extractor.RoomDataExtractor;
import day4.model.Room;

public class RoomProvider {
    public static Room provide(String data) {
        String[] roomData = RoomDataExtractor.extractRoomData(data);
        String name = roomData[0];
        int id = Integer.parseInt(roomData[1]);
        String checksum = roomData[2];
        return new Room(name, id, checksum);
    }
}
