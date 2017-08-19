package day10.run;

import day10.instruction.ElementsHolder;
import day10.instruction.Instruction;
import day10.instruction.InstructionExecutor;
import day10.instruction.InstructionInterpreter;
import loader.PuzzleInputLoader;

import javax.xml.ws.Holder;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InstructionInterpreter instructionInterpreter = new InstructionInterpreter();
        List<Instruction> instructions = instructionInterpreter.parseInstructions(
                PuzzleInputLoader.loadInputPuzzle("10.txt"));
        InstructionExecutor instructionExecutor = new InstructionExecutor();
        instructionExecutor.execute(instructions);
    }
}