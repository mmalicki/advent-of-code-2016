package day8;

import day8.model.Screen;

public class ScreenPrinter {
    public static void printScreen(Screen screen) {
        boolean[][] arr = screen.getScreen();
        for (boolean[] a : arr) {
            for (boolean b : a) {
                System.out.print(b ? 'x' : '_');
            }
            System.out.println();
        }
    }
}
