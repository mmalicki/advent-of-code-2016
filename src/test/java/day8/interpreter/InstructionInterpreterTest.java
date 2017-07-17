package day8.interpreter;

import day8.model.Screen;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class InstructionInterpreterTest {

    @Mock
    private Screen screen;
    private InstructionInterpreter instructionInterpreter;

    @Before
    public void init() {
        instructionInterpreter = new InstructionInterpreter(screen);
    }

    @Test
    public void shouldExecuteTurnOn() throws Exception {
        String command = "rect 1x2";

        instructionInterpreter.executeCommand(command);

        Mockito.verify(screen).turnOn(1, 2);
    }

    @Test
    public void shouldExecuteRotateColumn() throws Exception {
        String command = "rotate column x=1 by 3";

        instructionInterpreter.executeCommand(command);

        Mockito.verify(screen).rotateColumn(1, 3);
    }

    @Test
    public void shouldRotateRow() throws Exception {
        String command = "rotate row y=0 by 10";

        instructionInterpreter.executeCommand(command);

        Mockito.verify(screen).rotateRow(0, 10);
    }
}