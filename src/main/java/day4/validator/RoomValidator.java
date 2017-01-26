package day4.validator;

import day4.converter.RoomToRoomNameLetterOccurencesConverter;
import day4.model.Room;
import java.util.Comparator;
import java.util.Map;
import static java.util.Map.*;
import java.util.TreeMap;

public class RoomValidator {
    private static final int CHECKED_LETTERS_LIMIT = 5;

    public static boolean isValid(Room room) {
        Map<String, Integer> nameLettersOccurrences = new TreeMap<>(RoomToRoomNameLetterOccurencesConverter.convert(room));
        return nameLettersOccurrences.entrySet().stream()
        .sorted(Comparator
                .<Entry<String, Integer>, Integer>comparing(Entry::getValue).reversed()
                .thenComparing(Entry::getKey))
        .map(Entry::getKey)
        .limit(CHECKED_LETTERS_LIMIT)
        .collect(StringBuilder::new,  StringBuilder::append, StringBuilder::append).toString()
        .equals(room.getChecksum());
    }
}