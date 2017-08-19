package day10.instruction;

import day10.model.Bot;

import java.util.List;
import java.util.Optional;

public abstract class Instruction {
    abstract void execute(List<Bot> bots);

    Bot getOrCreateBot(List<Bot> bots, int id) {
        Optional<Bot> bot = bots.stream()
                .filter(b -> b.getId() == id)
                .findAny();
//                .orElse(new Bot(id));
        if (bot.isPresent()) {
            return bot.get();
        } else {
            Bot newBot = new Bot(id);
            bots.add(newBot);
            return newBot;
        }
    }

    abstract boolean canExecute(List<Bot> bots);
}
