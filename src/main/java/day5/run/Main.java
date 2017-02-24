package day5.run;

import day5.generator.IncrementalPasswordGenerator;
import day5.generator.PasswordGenerator;
import day5.provider.FirstNonZeroPasswordChunkProvider;
import day5.provider.PasswordChunkProvider;
import day5.transformer.DoorIDMD5Transformer;
import day5.transformer.DoorIDTransformer;
import day5.validator.password.EightCharacterPasswordValidator;
import day5.validator.password.PasswordValidator;
import day5.validator.transformation.CharPosValidator;
import day5.validator.transformation.TransformationValidator;

/**
 * @author mmalicki
 */
public class Main {
    public static void main(String[] args) {
        String puzzleInput = "wtnhxymk";
        PasswordChunkProvider passwordChunkProvider = new FirstNonZeroPasswordChunkProvider();
        DoorIDTransformer doorIDTransformer = new DoorIDMD5Transformer();
        PasswordValidator passwordValidator = new EightCharacterPasswordValidator();
        TransformationValidator transformationValidator = new CharPosValidator();
        PasswordGenerator incrementalPasswordGenerator = new IncrementalPasswordGenerator(passwordChunkProvider, passwordValidator, doorIDTransformer, transformationValidator);

        System.out.println(incrementalPasswordGenerator.generate(puzzleInput));
    }
}

//wykonujemy pewna operacje na door id
//jesli wynik tej operacji spelnia pewien warunek
// to konstruujemy hasło wynikowe przeprowadzajac pewna operacje
// powtarzamy wszystkie czynnosci do chwili uzyskania pozadanego hasla ustalajac warunek spelnienia wymogu hasla