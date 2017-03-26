package day7.predicate;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasNotPalindromeInsideBracket implements Function<String, Boolean> {
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile(".*\\[(.*)\\].*");

    @Override
    public Boolean apply(String s) {
        Matcher matcher = INSIDE_BRACKETS_TEXT.matcher(s);
        if (matcher.find()) {
            String insideBrackets = matcher.group(1);
            return PalindromeUtils.isPalindrome(insideBrackets);
        }
        return false;
    }
}
