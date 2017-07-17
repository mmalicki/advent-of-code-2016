package day8.run;

import day8.run.model.Screen;

public class ScreenReader {
    public static void readScreen(Screen screen) {
        boolean[][] arr = screen.getScreen();
        for (boolean[] a : arr) {
            for (boolean b : a) {
                System.out.print(b ? 'x' : '_');
            }
            System.out.println();
        }
    }
}
