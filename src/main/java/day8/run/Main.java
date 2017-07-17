package day8.run;

import day8.run.interpreter.InstructionInterpreter;
import day8.run.model.Screen;
import loader.PuzzleInputLoader;

public class Main {
    public static void main(String[] args) {
        String file = PuzzleInputLoader.loadInputPuzzle("8.txt");
        Screen screen = new Screen();
        InstructionInterpreter instructionInterpreter = new InstructionInterpreter(screen);
        for (String instruction : file.split(System.lineSeparator())) {
            instructionInterpreter.executeCommand(instruction);
        }
        System.out.println(screen.getTurnedOnPixels());
        ScreenReader.readScreen(screen);
    }
}
