package day4.converter;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
    public static Map<Character, Integer> getCharactersOccurrences(String word) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (Character character: word.toCharArray()) {
            occurrences.compute(character, (s, occur) -> (occur == null) ? 1 : occur + 1);
        }
        return occurrences;
    }
}
