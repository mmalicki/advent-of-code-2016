package day3.model;

/**
 * @author mmalicki
 */
public class Triangle {
    private final long fst;
    private final long snd;
    private final long thrd;

    public Triangle(final long fst, final long snd, final long thrd) {
        this.fst = fst;
        this.snd = snd;
        this.thrd = thrd;
    }
    public static Triangle of(final long fst, final long snd, final long thrd) {
        return new Triangle(fst, snd, thrd);
    }
}
