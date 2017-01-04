package day3.extractor;

import day3.model.Triangle;
import java.util.List;

/**
 * @author mmalicki
 */
public class HorizontalExtractor implements TriangleLengthsExtractor {
    @Override
    public List<Triangle> extract(final List<String> inputLines) {
        return inputLines;
    }
}
