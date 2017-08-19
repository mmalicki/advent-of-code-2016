package day10.model;

public class InstructionReceiverLevel {
    private final ReceivingSubject receivingSubject;
    private final ReceivingLevel receivingLevel;

    public InstructionReceiverLevel(ReceivingSubject receivingSubject, ReceivingLevel receivingLevel) {
        this.receivingSubject = receivingSubject;
        this.receivingLevel = receivingLevel;
    }

    public ReceivingSubject getReceivingSubject() {
        return receivingSubject;
    }

    public ReceivingLevel getReceivingLevel() {
        return receivingLevel;
    }
}
