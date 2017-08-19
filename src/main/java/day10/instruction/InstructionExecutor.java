package day10.instruction;

import day10.model.Bot;
import day10.model.OutputBin;

import java.util.ArrayList;
import java.util.List;

public class InstructionExecutor {
    private List<Instruction> instructionQueue = new ArrayList<>();

    public void execute(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            if (instruction.canExecute()) {
                instruction.execute();
                runWaitingInstructionsCheck();
            } else {
                instructionQueue.add(instruction);
            }
        }
    }

    private void runWaitingInstructionsCheck() {
        for (Instruction waitingInstruction : instructionQueue) {
            if (waitingInstruction.canExecute()) {
                instructionQueue.remove(waitingInstruction);
                waitingInstruction.execute();
                runWaitingInstructionsCheck();
                return;
            }
        }
    }
}
