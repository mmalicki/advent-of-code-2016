package day10.instruction;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import day10.exception.NotRecognizedInstructionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.lineSeparator;

public class InstructionInterpreter {
    private static final Map<InstructionType, Pattern> INSTRUCTION_TYPES = ImmutableMap.<InstructionType, Pattern>builder()
            .put(InstructionType.INSTANT, Pattern.compile("value (\\d+) goes to bot (\\d+)"))
            .put(InstructionType.CONDITIONAL, Pattern.compile("bot (\\d+) gives low to (output|bot) (\\d+) and high to (output|bot) (\\d+)"))
            .build();

    public List<Instruction> parseInstructions(String input) {
        ImmutableList.Builder<Instruction> instructions = ImmutableList.builder();
        for (String line : input.split(lineSeparator())) {
            instructions.add(parseInstruction(line));
        }
        return instructions.build();
    }

    private Instruction parseInstruction(String line) {
        for (Map.Entry<InstructionType, Pattern> instructionTypePattern : INSTRUCTION_TYPES.entrySet()) {
            Matcher matcher = instructionTypePattern.getValue().matcher(line);
            if (matcher.find()) {
                InstructionType instructionType = instructionTypePattern.getKey();
                return instructionType.build(matcher);
            }
        }
        throw new NotRecognizedInstructionException(line);
    }
}
