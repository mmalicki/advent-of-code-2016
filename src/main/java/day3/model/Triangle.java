package day3.model;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return fst == triangle.fst &&
                snd == triangle.snd &&
                thrd == triangle.thrd;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fst, snd, thrd);
    }
}
