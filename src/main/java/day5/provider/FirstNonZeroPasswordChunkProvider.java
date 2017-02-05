package day5.provider;

/**
 * @author mmalicki
 */
public class FirstNonZeroPasswordChunkProvider implements PasswordChunkProvider {
    @Override
    public String getPasswordChunk(final String input) {
        return Character.toString(Character.toUpperCase((char) input.chars()
                .filter(value -> value != '0')
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find first non zero character"))));
    }
}
