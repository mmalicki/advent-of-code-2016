package day10.instruction;

import com.google.common.collect.ImmutableList;
import day10.model.ConditionalInstruction;
import day10.model.InstantInstruction;
import day10.model.InstructionReceiverLevel;
import day10.model.Bot;
import day10.model.ReceivingLevel;

import java.util.regex.Matcher;

public class InstructionFactory {
    private static final String BOT = "bot";

    public static ConditionalInstruction createConditionalInstruction(Matcher instructionMatcher) {
        ElementsHolder holder = ElementsHolder.getInstance();
        Bot donorBot = holder.getOrCreateBot(Integer.parseInt(instructionMatcher.group(1)));

        boolean isLowReceiverBot = BOT.equals(instructionMatcher.group(2));
        Integer lowReceiverId = Integer.parseInt(instructionMatcher.group(3));
        InstructionReceiverLevel lowerReceivingSubject = new InstructionReceiverLevel(isLowReceiverBot
                ? holder.getOrCreateBot(lowReceiverId)
                : holder.getOrCreateOutputBin(lowReceiverId),
                ReceivingLevel.LOWER);

        boolean isHighReceiverBot = BOT.equals(instructionMatcher.group(4));
        Integer highReceiverId = Integer.parseInt(instructionMatcher.group(5));
        InstructionReceiverLevel higherReceivingSubject = new InstructionReceiverLevel(isHighReceiverBot
                ? holder.getOrCreateBot(highReceiverId)
                : holder.getOrCreateOutputBin(highReceiverId),
                ReceivingLevel.HIGHER);

        return new ConditionalInstruction(donorBot, ImmutableList.of(lowerReceivingSubject, higherReceivingSubject));
    }

    public static InstantInstruction createInstantInstruction(Matcher instructionMatcher) {
        ElementsHolder holder = ElementsHolder.getInstance();
        Integer value = Integer.parseInt(instructionMatcher.group(1));
        Integer botId = Integer.parseInt(instructionMatcher.group(2));
        Bot donorBot = holder.getOrCreateBot(botId);

        return new InstantInstruction(donorBot, value);
    }
}
