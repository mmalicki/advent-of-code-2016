package day6.decoder.transformer;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author mmalicki
 */
public class MostFrequentCharacterProvider implements Transformer {
    private SortedMap<String, Integer> occurrences = new TreeMap<>();

    @Override
    public String provide(final String input) {
        for (Character character : input.toCharArray()) {
            occurrences.put(character.toString(), occurrences.getOrDefault(character.toString(), 0) + 1);
        }
        return occurrences.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("Max occurences not found"))
                .getKey();
    }
}
