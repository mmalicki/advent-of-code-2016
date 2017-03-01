package day6.decoder.transformer;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequentCharacterProvider implements Transformer {
    @Override
    public String provide(String input) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (Character character : input.toCharArray()) {
            occurrences.put(character.toString(), occurrences.getOrDefault(character.toString(), 0) + 1);
        }
        return occurrences.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("Max occurrences not found"))
                .getKey();
    }
}
