package day2.resolver;

import day2.converter.StringDirectionToDirectionConverter;
import day2.model.Direction;
import day2.model.Key;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CodeResolverTest {

    @Mock
    private KeypadNavigator keypadNavigator;

    @Mock
    private StringDirectionToDirectionConverter directionConverter;

    @InjectMocks
    private CodeResolver codeResolver;

    @Test
    public void resolveCode() {
        List<Direction> directions = Arrays.asList(Direction.LEFT, Direction.LEFT);
        List<Direction> directions2 = Arrays.asList(Direction.DOWN, Direction.RIGHT);
        when(directionConverter.getDirections("LL")).thenReturn(directions);
        when(directionConverter.getDirections("DR")).thenReturn(directions2);
        when(keypadNavigator.getCurrentKey())
                .thenReturn(Key.FOUR)
                .thenReturn(Key.EIGHT);

        String result = codeResolver.resolve(Arrays.asList("LL", "DR"));

        assertEquals("48", result);
    }
}