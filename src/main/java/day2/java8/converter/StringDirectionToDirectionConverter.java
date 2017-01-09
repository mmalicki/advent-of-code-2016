package day2.java8.converter;

import com.google.common.collect.ImmutableList;
import day2.java8.model.Direction;
import java.util.List;

/**
 * @author mmalicki
 */
public class StringDirectionToDirectionConverter {
    public List<Direction> getDirections(String directions) {
        ImmutableList.Builder<Direction> result = ImmutableList.builder();
        for (Character direction : directions.toCharArray()) {
            result.add(Direction.getDirection(direction.toString()));
        }
        return result.build();
    }
}
