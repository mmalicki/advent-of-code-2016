package day7.predicate;

import org.junit.Test;

import static org.junit.Assert.*;

public class HasSSLSupportedBlockPredicateTest {
    @Test
    public void name() throws Exception {
        HasSSLSupportedBlockPredicate predicate = new HasSSLSupportedBlockPredicate();
        assertTrue(predicate.apply("aba[bab]xyz"));
        assertFalse(predicate.apply("xyx[xyx]xyx"));
        assertTrue(predicate.apply("aaa[kek]eke"));
         assertTrue(predicate.apply("zazbz[bzb]cdb"));
    }
}