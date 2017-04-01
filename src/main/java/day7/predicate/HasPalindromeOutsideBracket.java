package day7.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasPalindromeOutsideBracket implements Function<String, Boolean> {

    private static final Pattern PALINDROME_OUTSIDE_BRACKETS = Pattern.compile("(.*)\\[.*\\](.*)");
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile(".*\\[(.*)\\].*");
    private List<String> bracketsContent = new ArrayList<>();
    private Matcher matcher;
static int k = 0;
    @Override
    public Boolean apply(String s) {
        bracketsContent = new ArrayList<>();
        while (hasBrackets(s)) {
            bracketsContent.add(matcher.group(1));
            s = s.replaceFirst("\\["+matcher.group(1)+"\\]", "    ");
        }

        String[] split = s.split("    ");
        for (int i = 0; i < bracketsContent.size(); i++) {
            String bracket = bracketsContent.get(i);
            String left = split[i];
            String right = split[i + 1];
            if ((check(left) || check(right))) {
                return true;
            }
        }
return false;
//        if (check(s)) return true;
//        return false;
    }

    private boolean check(String s) {
        for (int i = 0; i <= s.length() - 4; i++) {
            String subStr = s.substring(i, i + 4);
            if (PalindromeUtils.isPalindrome(subStr)) {
                return true;
            }
        }
        return false;
    }

    private boolean old(String s) {
        Matcher matcher = PALINDROME_OUTSIDE_BRACKETS.matcher(s);
        if (matcher.find()) {
            String fstString = matcher.group(1);
            String sndString = matcher.group(2);
            return PalindromeUtils.isPalindrome(fstString) || PalindromeUtils.isPalindrome(sndString);
        }
        return false;
    }
    private boolean hasBrackets(String s) {
        matcher = INSIDE_BRACKETS_TEXT.matcher(s);
        return matcher.find();
    }
}
