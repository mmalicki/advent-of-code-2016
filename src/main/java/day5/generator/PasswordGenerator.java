package day5.generator;

import day5.provider.PasswordChunkProvider;
import day5.transformer.DoorIDTransformer;
import day5.validator.password.PasswordValidator;
import day5.validator.transformation.TransformationValidator;

/**
 * @author mmalicki
 */
public class PasswordGenerator {
    private final PasswordChunkProvider passwordChunkProvider;
    private final PasswordValidator passwordValidator;
    private final DoorIDTransformer doorIDTransformer;
    private final TransformationValidator transformationValidator;

    public PasswordGenerator(final PasswordChunkProvider passwordChunkProvider, final PasswordValidator passwordValidator, final DoorIDTransformer doorIDTransformer, final TransformationValidator transformationValidator) {
        this.passwordChunkProvider = passwordChunkProvider;
        this.passwordValidator = passwordValidator;
        this.doorIDTransformer = doorIDTransformer;
        this.transformationValidator = transformationValidator;
    }

    public String generate(String puzzleInput) {
        int counter = 0;
        String password = "";
        String input;
        while(!passwordValidator.isValid(password)) {
            input = puzzleInput + counter++;
            String transformedInput = doorIDTransformer.transform(input);
            if (transformationValidator.isValid(transformedInput)) {
                password += passwordChunkProvider.getPasswordChunk(transformedInput);
            }
            if (counter == (Integer.MAX_VALUE - 1)) {
                throw new RuntimeException("Could not generate password");
            }
        }
        return password;
    }
}