package day2.resolver;

import java.util.List;
import day2.converter.StringDirectionToDirectionConverter;

/**
 * @author mmalicki
 */
public class CodeResolver {
    private final KeypadNavigator keypadNavigator;
    private final StringDirectionToDirectionConverter directionConverter;

    public CodeResolver(final KeypadNavigator keypadNavigator, final StringDirectionToDirectionConverter directionConverter) {
        this.keypadNavigator = keypadNavigator;
        this.directionConverter = directionConverter;
    }

    public String resolve(List<String> instructions) {
        StringBuilder code = new StringBuilder();
        for (String instruction : instructions) {
            keypadNavigator.navigateKeypad(directionConverter.getDirections(instruction));
            code.append(keypadNavigator.getCurrentKey());
        }
        return code.toString();
    }
}
