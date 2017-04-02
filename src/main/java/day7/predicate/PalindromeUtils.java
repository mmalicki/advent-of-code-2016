package day7.predicate;

import day4.converter.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean containsPalindrome(String s, int wordLength) {
        for (int i = 0; i <= s.length() - wordLength; i++) {
            String subStr = s.substring(i, i + wordLength);
            if (isPalindrome(subStr)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> extractAllByPattern(String s, Pattern pattern) {
        List<String> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

    public static List<String> getPalindromes(String s, int wordLength) {
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i <= s.length() - wordLength; i++) {
            String subStr = s.substring(i, i + wordLength);
            if (isPalindrome(subStr)) {
                palindromes.add(subStr);
            }
        }
        return palindromes;
    }
}