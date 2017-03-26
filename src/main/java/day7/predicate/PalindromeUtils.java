package day7.predicate;

import day4.converter.StringUtils;

public class PalindromeUtils {
    private static boolean atLeastTwoDifferentChars(String s) {
        return StringUtils.getCharactersOccurrences(s).entrySet().size() > 1;
    }

    private static String reverse(String s) {
        char[] input = s.toCharArray();
        String result = "";
        for (int i = input.length - 1; i >= 0; i--) {
            result += input[i];
        }
        return result;
    }

    static boolean isPalindrome(String s) {
        return reverse(s).equals(s) && atLeastTwoDifferentChars(s);
    }
}