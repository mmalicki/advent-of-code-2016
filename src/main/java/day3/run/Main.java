package day3.run;

import day3.checker.TriangleConditionChecker;
import day3.extractor.TriangleLengthsExtractor;
import day3.extractor.VerticalExtractor;
import day3.model.Triangle;

import java.util.Arrays;
import java.util.List;
import loader.PuzzleInputLoader;

/**
 * @author mmalicki
 */
public class Main {
    public static void main(String[] args) {
        TriangleLengthsExtractor trianglesLengthsExtractor = new VerticalExtractor();
        TriangleConditionChecker triangleConditionChecker = new TriangleConditionChecker();
        final List<String> puzzleInput = Arrays.asList(PuzzleInputLoader.loadInputPuzzle("3.txt")
                .split(System.lineSeparator()));
        List<Triangle> triangles = trianglesLengthsExtractor.extract(puzzleInput);

        long trianglesCount = triangles.stream()
                .filter(triangleConditionChecker::isTriangle)
                .count();
        System.out.println("Triangles count: " + trianglesCount);
    }
}
