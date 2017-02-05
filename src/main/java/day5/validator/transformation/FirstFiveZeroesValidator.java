package day5.validator.transformation;

/**
 * @author mmalicki
 */
public class FirstFiveZeroesValidator implements TransformationValidator {
    @Override
    public boolean isValid(final String transformedInput) {
        return transformedInput.chars()
                .limit(5)
                .allMatch(value -> value == '0');
    }
}
