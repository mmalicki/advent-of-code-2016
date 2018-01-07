package day12.instruction;

import javax.annotation.processing.Processor;

public enum Instruction {
    CPY,
    INC,
    DEC,
    JNZ;

    public abstract void execute(Processor processor, );
}