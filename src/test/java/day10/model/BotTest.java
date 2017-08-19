package day10.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BotTest {

    @Test
    public void name() throws Exception {
        Bot bot = new Bot(1);
        bot.addChip(1);
        bot.addChip(2);

        System.out.println(bot.removeHigherValueChip());
    }
}