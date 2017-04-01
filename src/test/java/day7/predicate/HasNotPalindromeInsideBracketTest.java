package day7.predicate;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HasNotPalindromeInsideBracketTest {
    @Test
    public void test() throws Exception {
        HasNotPalindromeInsideBracket testObject = new HasNotPalindromeInsideBracket();
        assertFalse(testObject.apply("sdadda[aAbBBbAa]qwe"));
        assertTrue(testObject.apply("asd[AAAA]q"));
        assertTrue(testObject.apply("q[AAA]q"));
        assertTrue(testObject.apply("q[AbA]2"));
        assertFalse(testObject.apply("dd[AbbA]3"));
    }
    private static final Pattern INSIDE_BRACKETS_TEXT = Pattern.compile("\\[(\\w+)\\]");
    @Test
    public void name() throws Exception {
        String testBrackets = "aaaa[bbbb]cccc[dddd]eeee[ffff]gggg";
        Matcher matcher = INSIDE_BRACKETS_TEXT.matcher(testBrackets);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}