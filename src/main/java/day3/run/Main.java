package day3.run;

import day3.checker.TriangleConditionChecker;
import day3.extractor.TriangleLengthsExtractor;
import day3.extractor.VerticalExtractor;
import day3.model.Triangle;
import java.util.List;
import loader.PuzzleInputLoader;

/**
 * @author mmalicki
 */
public class Main {
    public static void main(String[] args) {
        PuzzleInputLoader puzzleInputLoader = new PuzzleInputLoader();
        TriangleLengthsExtractor trianglesLengthsExtractor = new VerticalExtractor();
        TriangleConditionChecker triangleConditionChecker = new TriangleConditionChecker();
        final List<String> puzzleInput = puzzleInputLoader.loadInputPuzzle("C:/advent/3.txt");
        List<Triangle> triangles = trianglesLengthsExtractor.extract(puzzleInput);

        long trianglesCount = triangles.stream()
                .filter(triangleConditionChecker::isTriangle)
                .count();
        System.out.println("Triangles count: " + trianglesCount);
    }
}
