package day10.model;

import day10.instruction.Instruction;
import day10.model.Bot;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class InstantInstruction implements Instruction {
    private final Bot receiver;
    private final int chipValue;

    public InstantInstruction(Bot receiver, int chipValue) {
        this.receiver = receiver;
        this.chipValue = chipValue;
    }

    @Override
    public void execute() {
        receiver.addChip(chipValue);
    }

    @Override
    public boolean canExecute() {
        return true;
    }
}
