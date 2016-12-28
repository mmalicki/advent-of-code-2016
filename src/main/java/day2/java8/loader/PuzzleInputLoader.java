package day2.java8.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author mmalicki
 */
public class PuzzleInputLoader {
    public List<String> loadInputPuzzle(String file) {
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException("Cannot load file: " + file);
        }
    }
}
