package day10.instruction;

import day10.exception.BotNotExistingException;
import day10.model.Bot;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ConditionalInstruction extends Instruction {
    private final Integer donorId;
    private final Integer lowReceiverId;
    private final Integer highReceiverId;
    private final boolean isLowReceiverBot;
    private final boolean isHighReceiverBot;

    public ConditionalInstruction(Integer donorId, boolean isLowReceiverBot, Integer lowReceiverId, boolean isHighReceiverBot, Integer highReceiverId) {
        this.donorId = donorId;
        this.lowReceiverId = lowReceiverId;
        this.highReceiverId = highReceiverId;
        this.isLowReceiverBot = isLowReceiverBot;
        this.isHighReceiverBot = isHighReceiverBot;
    }

    @Override
    public void execute(List<Bot> bots) {
        Bot donorBot = bots.stream()
                .filter(b -> b.getId().intValue() == donorId)
                .findAny()
                .orElseThrow(() -> new BotNotExistingException(donorId.toString()));

        List<Integer> chips = donorBot.getChips();

        if (chips.contains(61) && chips.contains(17)) {
            System.out.println(donorId);
        }

        if (isLowReceiverBot) {
            Bot lowReceiverBot = getOrCreateBot(bots, lowReceiverId);
            distributeChip(lowReceiverBot, chips, BinaryOperator.minBy(Integer::compareTo));
        }
        if (isHighReceiverBot) {
            Bot highReceiverBot = getOrCreateBot(bots, highReceiverId);
            distributeChip(highReceiverBot, chips, BinaryOperator.maxBy(Integer::compareTo));
        }
        chips.clear();
    }

    private void distributeChip(Bot receiver, List<Integer> chips, BinaryOperator<Integer> reducer) {
        receiver.getChips().add(chips.stream().reduce(reducer).get());
    }

    @Override
    public boolean canExecute(List<Bot> bots) {
        Optional<Bot> bot = bots.stream()
                .filter(b -> b.getId().intValue() == donorId)
                .findAny();

        return bot
                .map(Bot::canProceed)
                .orElse(false);//bot.isPresent() && bot.get().canProceed();
    }
}
