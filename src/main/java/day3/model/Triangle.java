package day3.model;

import java.util.List;

/**
 * @author mmalicki
 */
public class Triangle {
    public final long fst;
    public final long snd;
    public final long thrd;

    public Triangle(final long fst, final long snd, final long thrd) {
        this.fst = fst;
        this.snd = snd;
        this.thrd = thrd;
    }
    public static Triangle of(final long fst, final long snd, final long thrd) {
        return new Triangle(fst, snd, thrd);
    }

    public static Triangle of(List<Integer> lengths) {
        assert lengths.size() == 3;
        return Triangle.of(lengths.get(0), lengths.get(1), lengths.get(2));
    }
}
