package day10.instruction;

import day10.model.Bot;

import java.util.List;

public class InstantInstruction extends Instruction {
    private final Integer value;
    private final Integer botId;

    public InstantInstruction(Integer value, Integer botId) {
        this.value = value;
        this.botId = botId;
    }

    @Override
    public void execute(List<Bot> bots) {
        Bot bot = getOrCreateBot(bots, botId);
        bot.getChips().add(value);
    }

    @Override
    public boolean canExecute(List<Bot> bots) {
        return true;
    }
}
