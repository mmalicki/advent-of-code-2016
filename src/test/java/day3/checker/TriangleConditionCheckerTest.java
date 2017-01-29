package day3.checker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TriangleConditionCheckerTest {

    private TriangleConditionChecker testObject = new TriangleConditionChecker();

    @Test
    public void isTriangle() throws Exception {
        Assert.assertFalse(testObject.isTriangle(Arrays.asList(4, 4, 0)));
        Assert.assertFalse(testObject.isTriangle(Arrays.asList(4, 4, -1)));
        Assert.assertTrue(testObject.isTriangle(Arrays.asList(5, 4, 3)));
    }
}