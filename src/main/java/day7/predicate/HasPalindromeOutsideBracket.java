package day7.predicate;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasPalindromeOutsideBracket implements Function<String, Boolean> {

    private static final Pattern PALINDROME_OUTSIDE_BRACKETS = Pattern.compile("(?:\\]|^)(\\w+)(?:\\[|$)");
    private static final int OUTSIDE_BRACKETS_CONTENT_GROUP = 1;
    private static final int PALINDROME_LENGTH = 4;

    @Override
    public Boolean apply(String s) {
        List<String> bracketsContent = extractOutsideBracketsContent(s);
        for (String content : bracketsContent) {
            if (PalindromeUtils.containsPalindrome(content, PALINDROME_LENGTH)) {
                return true;
            }
        }
        return false;
    }

    private List<String> extractOutsideBracketsContent(String s) {
        Matcher matcher = PALINDROME_OUTSIDE_BRACKETS.matcher(s);
        List<String> content = new ArrayList<>();
        while (matcher.find()) {
            content.add(matcher.group(OUTSIDE_BRACKETS_CONTENT_GROUP));
        }
        return content;
    }
}
