package day7.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasNotPalindromeInsideBracket implements Function<String, Boolean> {
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile("\\[(\\w+)\\]");
    private static final int PALINDROME_LENGTH = 4;

    @Override
    public Boolean apply(String s) {
        List<String> bracketsContent = PalindromeUtils.extractAllByPattern(s, INSIDE_BRACKETS_TEXT);
        return bracketsContent.stream()
                .noneMatch(content -> PalindromeUtils.containsPalindrome(content, PALINDROME_LENGTH));
    }
}
