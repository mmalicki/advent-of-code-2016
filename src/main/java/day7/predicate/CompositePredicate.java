package day7.predicate;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class CompositePredicate {

    private List<Function<String, Boolean>> predicates = new LinkedList<>();

    @SafeVarargs
    private CompositePredicate(Function<String, Boolean>... predicate) {
        predicates = Arrays.asList(predicate);
    }

    @SafeVarargs
    public static CompositePredicate of(Function<String, Boolean>... predicate) {
        return new CompositePredicate(predicate);
    }

    public boolean applies(String input) {
        return predicates.stream().allMatch(predicate -> predicate.apply(input));
    }
}
