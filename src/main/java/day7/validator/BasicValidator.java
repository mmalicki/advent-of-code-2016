package day7.validator;

import day7.predicate.CompositePredicate;
import day7.predicate.HasNotPalindromeInsideBracket;
import day7.predicate.HasPalindromeOutsideBracket;

public class BasicValidator {
    private CompositePredicate compositePredicate;

    public BasicValidator() {
        compositePredicate = CompositePredicate.of(new HasNotPalindromeInsideBracket(), new HasPalindromeOutsideBracket());
    }


}
