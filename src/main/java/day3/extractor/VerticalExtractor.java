package day3.extractor;

import day3.model.Triangle;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mmalicki
 */
public class VerticalExtractor implements TriangleLengthsExtractor {
    private static final Pattern EXTRACT_LENGTHS_PATTERN = Pattern.compile("\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)");

    @Override
    public List<Triangle> extract(final List<String> inputLines) {
        List<Triangle> possibleTriangles = new LinkedList<>();
        for (int i = 2; i < inputLines.size(); i += 3) {
            String threeRows = inputLines.get(i) + inputLines.get(i - 1) + inputLines.get(i - 2);
            possibleTriangles.addAll(extract(threeRows));
        }
        return possibleTriangles;
    }

    private List<Triangle> extract(String lengthsAsString) {
        Matcher extractor = EXTRACT_LENGTHS_PATTERN.matcher(lengthsAsString);
        if (extractor.matches()) {
            return Arrays.asList(getTriangle(extractor, 1), getTriangle(extractor, 2), getTriangle(extractor, 3));
        } else {
            throw new RuntimeException("Input string did not match lengths pattern: " + lengthsAsString);
        }
    }//n = 1, 2, 3
    // 1 2 3
    // 4 5 6
    // 7 8 9
    private Triangle getTriangle(Matcher extractor, int n) {
        return Triangle.of(getGroup(extractor, n), getGroup(extractor, n + 3), getGroup(extractor, n + 6));
    }

    private int getGroup(final Matcher extractor, final int group) {
        return Integer.parseInt(extractor.group(group));
    }
}
