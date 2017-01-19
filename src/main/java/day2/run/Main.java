package day2.run;


import day2.converter.StringDirectionToDirectionConverter;
import day2.model.keypad.CustomizedKeypad;
import day2.resolver.CodeResolver;
import day2.resolver.KeypadNavigator;
import loader.PuzzleInputLoader;
import day2.model.keypad.ClassicKeypad;
import day2.model.keypad.Keypad;

/**
 * @author mmalicki
 */
public class Main {
    private static final String INPUT_PATH = "C:/advent/2.txt";

    public static void main(String[] args) {
        Keypad classicKeypad = new ClassicKeypad();
        Keypad customKeypad = new CustomizedKeypad();
        KeypadNavigator keypadNavigator = new KeypadNavigator(customKeypad);
        CodeResolver codeResolver = new CodeResolver(keypadNavigator,
                new StringDirectionToDirectionConverter());
        PuzzleInputLoader puzzleInputLoader = new PuzzleInputLoader();
        String result = codeResolver.resolveCode(puzzleInputLoader.loadInputPuzzle(INPUT_PATH));
        System.out.println(result);
    }
}
