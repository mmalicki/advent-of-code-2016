package day10.instruction;

import day10.model.ConditionalInstruction;

public class ConditionalInstructionTest {
    private ConditionalInstruction testObject;

//    @Test
//    public void shouldCheckExecutionPossibilityForNoBots() throws Exception {
//        testObject = new ConditionalInstruction(0, false, 0, false, 0);
//
//        assertFalse(testObject.canExecute(ImmutableList.of()));
//    }
//
//    @Test
//    public void shouldCheckExecutionPossibilityForValidBot() throws Exception {
//        testObject = new ConditionalInstruction(0, false, 0, false, 0);
//        Bot bot = new Bot(0);
//        bot.getChips().addAll(ImmutableList.of(1, 2));
//        //we shouldn't have to know what makes bot "valid". It should be mocked.
//        //what if definition of valid changes? This test might fail, but should not.
//
//        boolean result = testObject.canExecute(ImmutableList.of(bot));
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void shouldCheckExecutionPossibilityForNotValidBot() throws Exception {
//        testObject = new ConditionalInstruction(0, false, 0, false, 0);
//
//        boolean result = testObject.canExecute(ImmutableList.of(new Bot(0)));
//
//        assertFalse(result);
//    }

}