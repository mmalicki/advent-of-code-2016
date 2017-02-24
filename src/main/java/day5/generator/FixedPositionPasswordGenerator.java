package day5.generator;

import day5.provider.PasswordChunkProvider;
import day5.transformer.DoorIDTransformer;
import day5.validator.password.PasswordValidator;
import day5.validator.transformation.TransformationValidator;
import java.util.Arrays;

/**
 * @author mmalicki
 */
public class FixedPositionPasswordGenerator implements PasswordGenerator {
    private final PasswordChunkProvider passwordChunkProvider;
    private final PasswordValidator passwordValidator;
    private final DoorIDTransformer doorIDTransformer;
    private final TransformationValidator transformationValidator;

    public FixedPositionPasswordGenerator(final PasswordChunkProvider passwordChunkProvider,
            final PasswordValidator passwordValidator, final DoorIDTransformer doorIDTransformer,
            final TransformationValidator transformationValidator) {
        this.passwordChunkProvider = passwordChunkProvider;
        this.passwordValidator = passwordValidator;
        this.doorIDTransformer = doorIDTransformer;
        this.transformationValidator = transformationValidator;
    }

    @Override
    public String generate(String puzzleInput) {
        int counter = 0, cc = 0;
        String input;
        Character password[] = new Character[8];
        while(cc < 8) {
            input = puzzleInput + counter++;
            String transformedInput = doorIDTransformer.transform(input);
            if (transformationValidator.isValid(transformedInput)) {
                int position = Integer.parseInt(String.valueOf(transformedInput.charAt(5)));
                char character = transformedInput.charAt(6);
                if (password[position] == null) {
                    password[position] = character;
                    cc++;
                }
            }
        }
        return Arrays.toString(password);
    }
}
