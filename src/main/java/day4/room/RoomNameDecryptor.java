package day4.room;

import day4.model.Room;
import java.util.stream.Stream;

public class RoomNameDecryptor implements DecryptorStrategy {
    @Override
    public int decrypt(Stream<Room> roomStream) {
        return roomStream.map(room -> {
            final String result = room.getEncryptedName().chars()
                    .map(letter -> {
                        if (letter == '-') {
                            return ' ';
                        } else {
                            return 'a' + ((letter - 'a' + room.getId()) % 26);
                        }
                    })
                    .mapToObj(Character::toLowerCase)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
            return new Room(result, room.getId(), room.getChecksum());
            //baza + wynik % liczbaLiterWAlf
        }).filter(room -> room.getEncryptedName().contains("northpole"))
            .findAny().get().getId();
    }
}
