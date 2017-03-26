package day6.decoder;

import day6.decoder.transformer.MostFrequentCharacterProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author mmalicki
 */
@RunWith(MockitoJUnitRunner.class)
public class BasicDecoderTest {

    private static final String LINE_SEP = System.lineSeparator();

    @Mock
    private MostFrequentCharacterProvider transformer;

    private BasicDecoder instance;

    @Before
    public void init() {
        instance = new BasicDecoder(transformer);
    }

    @Test
    public void test() throws Exception {
        Mockito.when(transformer.provide(Mockito.anyString()))
                .then(returnsFirstArg());
        String result = instance.decode("aaa"+ LINE_SEP +"bbb"+ LINE_SEP +"ccc"+ LINE_SEP +"ddd");
        Assert.assertEquals("aaabbbcccddd", result);

    }
}