package day5.generator;

import day5.provider.PasswordChunkProvider;
import day5.transformer.DoorIDTransformer;
import day5.validator.password.PasswordValidator;
import day5.validator.transformation.TransformationValidator;

/**
 * @author mmalicki
 */
public class IncrementalPasswordGenerator implements PasswordGenerator{
    private final PasswordChunkProvider passwordChunkProvider;
    private final PasswordValidator passwordValidator;
    private final DoorIDTransformer doorIDTransformer;
    private final TransformationValidator transformationValidator;

    public IncrementalPasswordGenerator(final PasswordChunkProvider passwordChunkProvider, final PasswordValidator passwordValidator,
            final DoorIDTransformer doorIDTransformer, final TransformationValidator transformationValidator) {
        this.passwordChunkProvider = passwordChunkProvider;
        this.passwordValidator = passwordValidator;
        this.doorIDTransformer = doorIDTransformer;
        this.transformationValidator = transformationValidator;
    }

    public String generate(String puzzleInput) {
        int counter = 0;
        StringBuilder password = new StringBuilder();
        while(!passwordValidator.isValid(password.toString())) {
            String input = puzzleInput + counter++;
            String transformedInput = doorIDTransformer.transform(input);
            if (transformationValidator.isValid(transformedInput)) {
                password.append(passwordChunkProvider.getPasswordChunk(transformedInput));
            }
            if (counter == (Integer.MAX_VALUE - 1)) {
                throw new RuntimeException("Could not generate password");
            }
        }
        return password.toString();
    }


}