package day7.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasNotPalindromeInsideBracket implements Function<String, Boolean> {
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile(".*\\[(\\w+)\\].*");
    private List<String> bracketsContent = new ArrayList<>();
    private Matcher matcher;

    @Override
    public Boolean apply(String s) {
        bracketsContent = new ArrayList<>();
        while (hasBrackets(s)) {
            String group = matcher.group(1);
            bracketsContent.add(group);
//            System.out.println("b " + s);
            s = s.replaceFirst("\\["+group+"\\]", "");
//            System.out.println("a " + s);
        }
        for (String content : bracketsContent) {
            for (int i = 0; i <= content.length() - 4; i++) {
                String subStr = content.substring(i, i + 4);
                if (PalindromeUtils.isPalindrome(subStr)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean hasBrackets(String s) {
        matcher = INSIDE_BRACKETS_TEXT.matcher(s);
        return matcher.find(0);
    }
}
