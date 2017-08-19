package day10.instruction;

import static org.junit.Assert.assertEquals;

public class InstructionTypeTest {

//    @Test
//    public void shouldBuildInstantInstruction() {
//        int id = 100;
//        int value = 10;
//        Matcher matcher = Pattern.compile("(\\d+) (\\d+)").matcher(value + " " + id);
//        matcher.find();
//
//        Instruction result = InstructionType.INSTANT.createInstruction(matcher);
//
//        assertEquals(new InstantInstruction(value, id), result);
//    }
//
//    @Test
//    public void shouldBuildConditionalInstruction() throws Exception {
//        Matcher matcher = Pattern.compile("bot (\\d+) gives low to (output|bot) (\\d+) and high to (output|bot) (\\d+)")
//                .matcher("bot 65 gives low to bot 135 and high to bot 82");
//        matcher.find();
//
//        Instruction result = InstructionType.CONDITIONAL.createInstruction(matcher);
//
//        assertEquals(
//                new ConditionalInstruction(65, true, 135, true, 82),
//                result);
//    }
}