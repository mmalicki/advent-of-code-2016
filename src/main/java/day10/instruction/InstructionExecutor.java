package day10.instruction;

import day10.model.Bot;
import day10.model.OutputBin;

import java.util.ArrayList;
import java.util.List;

public class InstructionExecutor {
    private List<Bot> bots = new ArrayList<>();
    private List<OutputBin> outputBins = new ArrayList<>();
    private List<Instruction> instructionQueue = new ArrayList<>();

    public List<Bot> getBots() {
        return bots;
    }

    public List<OutputBin> getOutputBins() {
        return outputBins;
    }

    public void execute(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            if (instruction.canExecute(bots)) {
                instruction.execute(bots, outputBins);
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
                    waitingInstruction.execute(bots, outputBins);
                    executed = true;
                    break;
                }
            }
        }
    }
}
