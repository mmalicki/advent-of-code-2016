package day3.extractor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mmalicki
 */
public class HorizontalExtractorLoader {
    private static final Pattern EXTRACT_LENGTHS_PATTERN = Pattern.compile("\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)");

    public List<Integer> extract(String lengthsAsString) {
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
