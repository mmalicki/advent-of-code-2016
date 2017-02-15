package day5.validator.transformation;

/**
 * @author mmalicki
 */
public class CharPosValidator implements TransformationValidator {
    @Override
    public boolean isValid(final String transformedInput) {
        return transformedInput.chars()
                .limit(5)
                .allMatch(c -> c == '0')
                && transformedInput.charAt(5) >= '0'
                && transformedInput.charAt(5) <= '7';

    }
}
