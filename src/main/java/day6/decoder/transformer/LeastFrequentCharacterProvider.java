package day6.decoder.transformer;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequentCharacterProvider implements Transformer {
    @Override
    public String provide(String input) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (Character character : input.toCharArray()) {
            occurrences.merge(character.toString(), 0, (count, old) -> count + 1);
        }
        return occurrences.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("Max occurrences not found"))
                .getKey();
    }
}
