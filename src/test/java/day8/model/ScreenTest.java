package day8.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScreenTest {

    Screen screen = new Screen();

    @Test
    public void rotateRow() throws Exception {
        screen.turnOn(48, 1);
        screen.rotateRow(0, 4);

        assertEquals(50, Screen.WIDTH);
        assertTrue(screen.getScreen()[0][1]);
        assertFalse(screen.getScreen()[0][2]);
        assertFalse(screen.getScreen()[0][3]);
        assertTrue(screen.getScreen()[0][4]);

    }

    @Test
    public void rotateColumn() throws Exception {
        screen.turnOn(1,4);
        screen.rotateColumn(0, 4);

        assertTrue(screen.getScreen()[1][0]);
        assertFalse(screen.getScreen()[2][0]);
        assertFalse(screen.getScreen()[3][0]);
        assertTrue(screen.getScreen()[4][0]);
    }

    @Test
    public void turnOn() throws Exception {
        screen.turnOn(3, 2);
        boolean[][] screenArr = screen.getScreen();
        assertTrue(screenArr[0][0] && screenArr[0][1] && screenArr[0][2]
                && screenArr[1][0] && screenArr[1][1] && screenArr[1][2]);
    }

}