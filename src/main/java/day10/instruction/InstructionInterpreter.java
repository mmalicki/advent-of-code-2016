package day10.instruction;

import com.google.common.collect.ImmutableList;
import day10.exception.NotRecognizedInstructionException;

import java.util.List;

import static java.lang.System.lineSeparator;

public class InstructionInterpreter {
    public List<Instruction> parseInstructions(String input) {
        ImmutableList.Builder<Instruction> instructions = ImmutableList.builder();
        for (String line : input.split(lineSeparator())) {
            instructions.add(parseInstruction(line));
        }
        return instructions.build();
    }

    private Instruction parseInstruction(String line) {
        for (InstructionType instructionType : InstructionType.values()) {
            if (instructionType.matches(line)) {
                return instructionType.createInstruction(line);
            }
        }
        throw new NotRecognizedInstructionException(line);
    }
}
