package day3.extractor;

import day3.model.Triangle;
import java.util.List;

/**
 * @author mmalicki
 */
public interface TriangleLengthsExtractor {
    List<Triangle> extract(List<String> inputLines);
}
