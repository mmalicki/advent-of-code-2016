package day8.run.model;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Screen {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 6;

    private boolean screen[][] = new boolean[HEIGHT][WIDTH];

    public void turnOn(int width, int height) {
        int columns = width;
        int rows = height;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                screen[i][j] = true;
            }
        }
    }

    public void rotateRow(int row, int rotation) {
        rotate(WIDTH,
                index -> screen[row][getRotated(rotation, index, WIDTH)],
                rotated -> System.arraycopy(rotated, 0, screen[row], 0, rotated.length));
    }

    public void rotateColumn(int column, int rotation) {
        rotate(HEIGHT,
                index -> screen[getRotated(rotation, index, HEIGHT)][column],
                rotated -> {
                    for (int i = 0; i < rotated.length; i++) {
                        screen[i][column] = rotated[i];
                    }
                }
        );
    }

    private void rotate(int range, Function<Integer, Boolean> rotationFunction, Consumer<boolean[]> rotationApplier) {
        boolean rotated[] = new boolean[range];
        for (int i = 0; i < rotated.length; i++) {
            rotated[i] = rotationFunction.apply(i);
        }
        rotationApplier.accept(rotated);
    }

    private int getRotated(int rotation, int i, int range) {
        return (i - rotation) < 0 ?
                range - (rotation - i) :
                (i - rotation) % range;
    }

    boolean[][] getScreen() {
        return screen;
    }
}
