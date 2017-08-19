package day10.instruction;

import day10.model.Bot;

import java.util.ArrayList;
import java.util.List;

public class InstructionExecutor {
    private List<Bot> bots = new ArrayList<>();
    private List<Instruction> instructionQueue = new ArrayList<>();

    public List<Bot> getBots() {
        return bots;
    }

    public void execute(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            if (instruction.canExecute(bots)) {
                instruction.execute(bots);
                runWaitingInstructionsCheck();

            } else {
                instructionQueue.add(instruction);
            }
        }
    }

    private void runWaitingInstructionsCheck() {
        boolean executed = true;
        while (executed) {
            executed = false;
            for (Instruction waitingInstruction : instructionQueue) {
                if (waitingInstruction.canExecute(bots)) {
                    instructionQueue.remove(waitingInstruction);
                    waitingInstruction.execute(bots);
                    executed = true;
                    break;
                }
            }
        }
    }
}
