package day10.model;

import day10.instruction.Instruction;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
public class ConditionalInstruction implements Instruction {
    private final Bot donorBot;
    private final List<InstructionReceiverLevel> receivingSubjects;

    public ConditionalInstruction(Bot donorBot, List<InstructionReceiverLevel> receivers) {
        this.donorBot = donorBot;
        this.receivingSubjects = receivers;
    }

    @Override
    public void execute() {
        for (InstructionReceiverLevel receiver : receivingSubjects) {
            int chipValue = receiver.getReceivingLevel().removeChipFrom(donorBot);
            receiver.getReceivingSubject().addChip(chipValue);
        }
    }

    @Override
    public boolean canExecute() {
        return donorBot.canProceedWithAction();
    }
}
