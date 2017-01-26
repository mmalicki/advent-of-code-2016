package day4.validator;

import day4.converter.StringUtils;
import day4.model.Room;
import java.util.Comparator;
import java.util.Map;
import static java.util.Map.*;
import java.util.TreeMap;
import java.util.function.Function;

public class RoomValidator {
    private static final int CHECKED_LETTERS_LIMIT = 5;
    private static final Comparator<Entry<Character, Integer>> BY_LETTER_OCCURENCES_DESCENDING = Comparator
            .<Entry<Character, Integer>, Integer>comparing(Entry::getValue).reversed();
    private static final Function<Entry<Character, Integer>, Character> BY_NAMES = Entry::getKey;

    public static boolean isValid(Room room) {
        Map<Character, Integer> nameLettersOccurrences = new TreeMap<>(StringUtils.getCharactersOccurrences(room.getEncryptedName()));
        return nameLettersOccurrences.entrySet().stream()

        .sorted(BY_LETTER_OCCURENCES_DESCENDING.thenComparing(BY_NAMES))
        .limit(CHECKED_LETTERS_LIMIT)

        .map(Entry::getKey)
        .collect(StringBuilder::new,  StringBuilder::append, StringBuilder::append).toString()

        .equals(room.getChecksum());
    }
}