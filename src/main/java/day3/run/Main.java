package day3.run;

import day3.checker.TriangleConditionChecker;
import day3.extractor.HorizontalExtractorLoader;
import java.util.List;
import loader.PuzzleInputLoader;

/**
 * @author mmalicki
 */
public class Main {
    public static void main(String[] args) {
        PuzzleInputLoader puzzleInputLoader = new PuzzleInputLoader();
        HorizontalExtractorLoader horizontalExtractorLoader = new HorizontalExtractorLoader();
        TriangleConditionChecker triangleConditionChecker = new TriangleConditionChecker();
        final List<String> puzzleInput = puzzleInputLoader.loadInputPuzzle("C:/advent/3.txt");
        long trianglesCount = puzzleInput.stream()
                .filter(lengths -> triangleConditionChecker.isTriangle(horizontalExtractorLoader.extract(lengths)))
                .count();
        System.out.println("Triangles count: " + trianglesCount);
    }
}
