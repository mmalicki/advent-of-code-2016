package day6.decoder.transformer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mmalicki
 */
public class MostFrequentCharacterProviderTest {
    @Test
    public void test() throws Exception {
        MostFrequentCharacterProvider instance = new MostFrequentCharacterProvider();
        Assert.assertEquals("b", instance.provide("nfbgiorjthotrbgfnbfgbkaaaaaaaaaaakbvpobkgfbaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaqqq"));
    }
}