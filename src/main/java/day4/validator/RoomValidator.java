package day4.validator;

import day4.converter.RoomToRoomNameLetterOccurencesConverter;
import day4.model.Room;

import java.util.*;

public class RoomValidator {
    private static final int CHECKED_LETTERS_LIMIT = 5;
    private static final Comparator<Map.Entry<String, Integer>> COMPARE_BY_OCCURRENCES_AND_ALPHABETIZATION = (o1, o2) -> {
        return o1.getValue().equals(o2.getValue()) ?
                o1.getKey().compareTo(o2.getKey()) :
                o2.getValue().compareTo(o1.getValue()); // TODO: CZYTELNOŚĆ !!!!
    };

    public static boolean isValid(Room room) {
        Map<String, Integer> nameLettersOccurrences = new TreeMap<>(RoomToRoomNameLetterOccurencesConverter.convert(room));
        String validChecksum = nameLettersOccurrences.entrySet().stream()
        .sorted(COMPARE_BY_OCCURRENCES_AND_ALPHABETIZATION)
        .map(Map.Entry::getKey)
        .limit(CHECKED_LETTERS_LIMIT)
        .reduce(String::concat).orElse(""); // TODO: nieciekawe to

        return room.getChecksum().equals(validChecksum);
    }
}