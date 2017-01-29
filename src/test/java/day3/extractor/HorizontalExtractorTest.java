package day3.extractor;

import day3.model.Triangle;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class HorizontalExtractorTest {

    private TriangleLengthsExtractor testObject = new HorizontalExtractor();

    @Test
    public void extract() throws Exception {
        List<Triangle> result = testObject.extract(Arrays.asList("101 301 501", "102 302 502", "103 303 503",
                "201 401 601", "202 402 602", "203 403 603"));

        assertThat(result, equalTo(Arrays.asList(Triangle.of(101, 301, 501), Triangle.of(102, 302, 502),
                Triangle.of(103, 303, 503), Triangle.of(201, 401, 601), Triangle.of(202, 402, 602), Triangle.of(203, 403, 603))));
    }

}