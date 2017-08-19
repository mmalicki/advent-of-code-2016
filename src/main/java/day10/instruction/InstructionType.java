package day10.instruction;

import day10.exception.NotRecognizedInstructionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum InstructionType {
    INSTANT (Pattern.compile("value (\\d+) goes to bot (\\d+)")){
        @Override
        public Instruction createInstruction(String instructionContent) {
            Matcher validatedMatcher = getValidatedMatcher(instructionContent);
            return InstructionFactory.createInstantInstruction(validatedMatcher);
        }
    },
    CONDITIONAL (Pattern.compile("bot (\\d+) gives low to (output|bot) (\\d+) and high to (output|bot) (\\d+)")){
        @Override
        public Instruction createInstruction(String instructionContent) {
            Matcher validatedMatcher = getValidatedMatcher(instructionContent);
            return InstructionFactory.createConditionalInstruction(validatedMatcher);
        }
    };

    private final Pattern pattern;

    InstructionType(Pattern pattern) {
        this.pattern = pattern;
    }

    public abstract Instruction createInstruction(String instruction);

    protected Matcher getValidatedMatcher(String input) {
        Matcher matcher = this.pattern.matcher(input);
        if (!matcher.find()) {
            throw new NotRecognizedInstructionException(input);
        }
        return matcher;
    }

    public boolean matches(String input) {
        return input.matches(pattern.pattern());
    }
}
