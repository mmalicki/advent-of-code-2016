package day7.predicate;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static day7.predicate.PalindromeUtils.extractAllByPattern;

public class HasSSLSupportedBlockPredicate implements Function<String, Boolean> {
    private static final Pattern PALINDROME_OUTSIDE_BRACKETS = Pattern.compile("(?:\\]|^)(\\w+)(?:\\[|$)");
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile("\\[(\\w+)\\]");

    @Override
    public Boolean apply(String s) {
        List<String> outsideBracketsContent = extractAllByPattern(s, PALINDROME_OUTSIDE_BRACKETS);
        List<String> insideBracketsContent = extractAllByPattern(s, INSIDE_BRACKETS_TEXT);
        List<String> outsidePalindromes = getAllPalindromes(outsideBracketsContent);
        List<String> insidePalindromes = getAllPalindromes(insideBracketsContent);
        return outsidePalindromes.stream().anyMatch(palindrome -> insidePalindromes.contains(reverse(palindrome)));
    }

    private String reverse(String s) {
        return String.valueOf(s.charAt(1)) + String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1));
    }

    private List<String> getAllPalindromes(List<String> words) {
        return words.stream()
                .map(w -> PalindromeUtils.getPalindromes(w, 3))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
