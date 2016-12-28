package java8.resolver;

import java.util.List;
import java8.converter.StringDirectionToDirectionConverter;

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

    public String resolveCode(List<String> instructions) {
        String code = "";
        for (String instruction : instructions) {
            keypadNavigator.navigateKeypad(directionConverter.getDirections(instruction));
            code += keypadNavigator.getCurrentKey();
        }
        return code;
    }
}
