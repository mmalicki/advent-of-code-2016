package day7.predicate;

import day4.converter.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HasPalindromeOutsideBracketTest {

    @Test
    public void test() throws Exception {
        HasPalindromeOutsideBracket testObject = new HasPalindromeOutsideBracket();
        assertTrue(testObject.apply("AaaA[qwq]2"));
        assertFalse(testObject.apply("AaA[qwq]2"));
        assertFalse(testObject.apply("AAA[qwq]2"));
        assertFalse(testObject.apply("AAAA[qwq]2"));
        assertFalse(testObject.apply("a[qwq]AAAA"));
        assertFalse(testObject.apply("a[qwq]AaA"));
        assertTrue(testObject.apply("a[qwq]AaaA"));
        assertFalse(testObject.apply("a[qwq]Aa"));
        assertFalse(testObject.apply("a[qwq]aa"));

    }
}