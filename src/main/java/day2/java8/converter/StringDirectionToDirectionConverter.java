package day2.java8.converter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import day2.java8.model.Direction;

/**
 * @author mmalicki
 */
public class StringDirectionToDirectionConverter {
    private static final Map<String, Direction> DIRECTIONS = ImmutableMap.of(
            "L", Direction.LEFT,
            "R", Direction.RIGHT,
            "U", Direction.UP,
            "D", Direction.DOWN
    );

    public List<Direction> getDirections(String directions) {
        ImmutableList.Builder<Direction> result = ImmutableList.builder();
        for (Character direction : directions.toCharArray()) {
            result.add(DIRECTIONS.get(direction.toString()));
        }
        return result.build();
    }
}
