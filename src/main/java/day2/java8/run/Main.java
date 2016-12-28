package day2.java8.run;


import day2.java8.converter.StringDirectionToDirectionConverter;
import day2.java8.loader.PuzzleInputLoader;
import day2.java8.model.keypad.ClassicKeypad;
import day2.java8.model.keypad.CustomizedKeypad;
import day2.java8.model.keypad.Keypad;
import day2.java8.resolver.CodeResolver;
import day2.java8.resolver.KeypadNavigator;

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
