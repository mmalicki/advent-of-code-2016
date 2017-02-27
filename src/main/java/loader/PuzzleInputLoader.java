package loader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author mmalicki
 */
public class PuzzleInputLoader {
    public static String loadInputPuzzle(String file) {
        try {
            URL resource = Optional.ofNullable(PuzzleInputLoader.class.getClassLoader().getResource(file))
                    .orElseThrow(() -> new RuntimeException("Could not find file: " + file));
            byte[] fileContent = Files.readAllBytes(Paths.get(resource.toURI()));
            return new String(fileContent);
        } catch (IOException e) {
            throw new RuntimeException("Cannot extract file: " + file);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Cannot convert URL to URI: " + e.getMessage());
        }
    }
}
