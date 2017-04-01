package day7.run;

import com.google.common.base.Predicates;
import day7.predicate.CompositePredicate;
import day7.predicate.HasNotPalindromeInsideBracket;
import day7.predicate.HasPalindromeOutsideBracket;
import loader.PuzzleInputLoader;

public class Main {
    public static void main(String[] args) {
        String input = PuzzleInputLoader.loadInputPuzzle("7.txt");
        String lines[] = input.split(System.lineSeparator());
        CompositePredicate compositePredicate = CompositePredicate.of(new HasNotPalindromeInsideBracket(), new HasPalindromeOutsideBracket());
        int count = 0;
        System.out.println(compositePredicate.applies("ioxxoj[asdfgh]zxcvbn"));
        for (String line : lines) {
            if (compositePredicate.applies(line)) {
                System.out.println(++count);
            }
        }

    }
}
