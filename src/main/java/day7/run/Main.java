package day7.run;

import day7.predicate.HasNotPalindromeInsideBracket;
import loader.PuzzleInputLoader;

public class Main {
    public static void main(String[] args) {
        String input = PuzzleInputLoader.loadInputPuzzle("7.txt");
        String lines[] = input.split(System.lineSeparator());
        new HasNotPalindromeInsideBracket().apply("ad[13drge]feergt");
    }
}
