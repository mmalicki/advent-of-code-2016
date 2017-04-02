package day7.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasNotPalindromeInsideBracket implements Function<String, Boolean> {
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile("\\[(\\w+)\\]");
    private static final int BRACKETS_CONTENT_MATCHING_GROUP = 1;
    private static final int PALINDROME_LENGTH = 4;

    @Override
    public Boolean apply(String s) {
        List<String> bracketsContent = extractBracketsContent(s);
        return bracketsContent.stream()
                .noneMatch(content -> PalindromeUtils.containsPalindrome(content, PALINDROME_LENGTH));
    }

    private List<String> extractBracketsContent(String s) {
        List<String> bracketsContent = new ArrayList<>();
        Matcher matcher = INSIDE_BRACKETS_TEXT.matcher(s);
        while (matcher.find()) {
            bracketsContent.add(matcher.group(BRACKETS_CONTENT_MATCHING_GROUP));
        }
        return bracketsContent;
    }
}
