package day3.extractor;

import day3.model.Triangle;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author mmalicki
 */
public class HorizontalExtractor implements TriangleLengthsExtractor {
    private static final Pattern EXTRACT_LENGTHS_PATTERN = Pattern.compile("\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)");
    @Override
    public List<Triangle> extract(final List<String> inputLines) {
        return inputLines.stream().map(lengths -> Triangle.of(extract(lengths))).collect(Collectors.toList());
    }

    private List<Integer> extract(String lengthsAsString) {
        Matcher extractor = EXTRACT_LENGTHS_PATTERN.matcher(lengthsAsString);
        if (extractor.matches()) {
            return Arrays.asList(getGroup(extractor, 1), getGroup(extractor, 2), getGroup(extractor, 3));
        } else {
            throw new RuntimeException("Input string did not match lengths pattern: " + lengthsAsString);
        }
    }

    private int getGroup(final Matcher extractor, final int group) {
        return Integer.parseInt(extractor.group(group));
    }
}
