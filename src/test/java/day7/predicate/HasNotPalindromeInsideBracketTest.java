package day7.predicate;

import org.junit.Test;

import static org.junit.Assert.*;

public class HasNotPalindromeInsideBracketTest {
    @Test
    public void test() throws Exception {
        HasNotPalindromeInsideBracket testObject = new HasNotPalindromeInsideBracket();
        assertTrue(testObject.apply("sdadda[aAbBBbAa]qwe"));
        assertFalse(testObject.apply("asd[AAAA]q"));
        assertFalse(testObject.apply("q[AAA]q"));
        assertTrue(testObject.apply("q[AbA]2"));
        assertTrue(testObject.apply("dd[AbbA]3"));

    }
}