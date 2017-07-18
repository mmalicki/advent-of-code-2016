package day9.run;

import com.google.common.base.Strings;
import day9.decoder.Decoder;
import day9.model.Marker;
import loader.PuzzleInputLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String puzzleInput = PuzzleInputLoader.loadInputPuzzle("9.txt");

        Decoder decoder = new Decoder();
        String decoded = decoder.decode(puzzleInput);
        System.out.println(decoded.length());
    }
}
