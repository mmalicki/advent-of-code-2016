package day3.extractor;

import day3.model.Triangle;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class VerticalExtractorTest {
    private TriangleLengthsExtractor testObject = new VerticalExtractor();

    @Test
    public void extract() {
        List<Triangle> result = testObject.extract(Arrays.asList("101 301 501", "102 302 502", "103 303 503",
                "201 401 601", "202 402 602", "203 403 603"));

        assertThat(result,  equalTo(Arrays.asList(Triangle.of(101, 102, 103), Triangle.of(301, 302, 303),Triangle.of(501, 502, 503)
                ,Triangle.of(201, 202, 203),Triangle.of(401, 402, 403), Triangle.of(601, 602, 603))));
    }

}