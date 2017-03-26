package day7.predicate;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasPalindromeOutsideBracket implements Function<String, Boolean> {

    private static final Pattern PALINDROME_OUTSIDE_BRACKETS = Pattern.compile("(.*)\\[.*\\](.*)");

    @Override
    public Boolean apply(String s) {
        Matcher matcher = PALINDROME_OUTSIDE_BRACKETS.matcher(s);
        if (matcher.find()) {
            String fstString = matcher.group(1);
            String sndString = matcher.group(2);
            return PalindromeUtils.isPalindrome(fstString) || PalindromeUtils.isPalindrome(sndString);
        }
        return false;
    }
}
