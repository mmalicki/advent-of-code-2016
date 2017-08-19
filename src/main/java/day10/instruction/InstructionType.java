package day10.instruction;

import java.util.regex.Matcher;

public enum InstructionType {
    INSTANT {
        @Override
        public Instruction build(Matcher matcher) {
            Integer value = Integer.parseInt(matcher.group(1));
            Integer botId = Integer.parseInt(matcher.group(2));
            return new InstantInstruction(value, botId);
        }
    },
    CONDITIONAL {
        @Override
        public Instruction build(Matcher matcher) {
            Integer donorId = Integer.parseInt(matcher.group(1));
            boolean isLowReceiverBot = BOT.equals(matcher.group(2));
            Integer lowReceiverId = Integer.parseInt(matcher.group(3));
            boolean isHighReceiverBot = BOT.equals(matcher.group(4));
            Integer highReceiverId = Integer.parseInt(matcher.group(5));
            return new ConditionalInstruction(donorId, isLowReceiverBot, lowReceiverId, isHighReceiverBot, highReceiverId);
        }
    };

    private static final String BOT = "bot";
    public abstract Instruction build(Matcher matcher);
}
