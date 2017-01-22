package day4.room;

import day4.model.Room;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoomNameDecryptor implements DecryptorStrategy {
    @Override
    public int decrypt(Stream<Room> roomStream) {
        return roomStream.map(room -> {
            String result = room.getEncryptedName().chars()
                    .map(letter ->{ if(letter == '-'){ return ' ';} else {return  'a' +  ((letter - 'a' + room.getId()) % 26);}})
                    .mapToObj(c -> Character.toString((char)c))
                    .reduce((s1, s2) -> s1 + s2).orElse("not found");
            return new Room(result, room.getId(), room.getChecksum());
            //baza + wynik % liczbaLiterWAlf
        }).filter(room -> room.getEncryptedName().contains("northpole"))
            .findAny().get().getId();
    }
}
