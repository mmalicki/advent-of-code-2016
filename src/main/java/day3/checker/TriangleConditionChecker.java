package day3.checker;

import day3.model.Triangle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mmalicki
 */
public class TriangleConditionChecker {
    public boolean isTriangle(List<Integer> lengths) {
        final List<Integer> result = lengths.stream()
                .sorted()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
        System.out.println(result + " " + ((result.size() == 3) && ((result.get(0) + result.get(1)) > result.get(2))));
        return (result.size() == 3) && ((result.get(0) + result.get(1)) > result.get(2));
    }
    public boolean isTriangle(Triangle triangle) {
        return isTriangle(Arrays.asList((int)triangle.fst, (int)triangle.snd, (int)triangle.thrd));
    }
}
