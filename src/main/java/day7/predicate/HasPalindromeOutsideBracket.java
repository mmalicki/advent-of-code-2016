package day7.predicate;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class HasPalindromeOutsideBracket implements Function<String, Boolean> {
    private static final Pattern PALINDROME_OUTSIDE_BRACKETS = Pattern.compile("(?:\\]|^)(\\w+)(?:\\[|$)");
    private static final int PALINDROME_LENGTH = 4;

    @Override
    public Boolean apply(String s) {
        List<String> bracketsContent = PalindromeUtils.extractAllByPattern(s, PALINDROME_OUTSIDE_BRACKETS);
        return bracketsContent.stream()
                .anyMatch(content -> PalindromeUtils.containsPalindrome(content, PALINDROME_LENGTH));
    }
}
