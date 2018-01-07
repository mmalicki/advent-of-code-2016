package day12.instruction;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BasicProcessor {
    private static final Set<Register> SUPPORTED_REGISTERS = EnumSet.of(Register.REG_A, Register.REG_B, Register.REG_C, Register.REG_D);
    private int instructionPointer;
    private int registerA;
    private int registerB;
    private int registerC;
    private int registerD;
    private final Map<Register, Consumer<Integer>> registerBySetValue = Map.of(
            Register.REG_A, val -> registerA = val,
            Register.REG_B, val -> registerB = val,
            Register.REG_C, val -> registerC = val,
            Register.REG_D, val -> registerD = val
    );
    private final Map<Register, Supplier<Integer>> registerByGetValue = Map.of(
            Register.REG_A, () -> registerA,
            Register.REG_B, () -> registerB,
            Register.REG_C, () -> registerC,
            Register.REG_D, () -> registerD
    );

    public void copy(Register from, Register to) {
        validateRegisters(List.of(from, to));
        registerBySetValue.get(to).accept(registerByGetValue.get(from).get());
        instructionPointer++;
    }

    public void copy(int from, Register to) {
        validateRegisters(List.of(to));
        registerBySetValue.get(to).accept(from);
        instructionPointer++;
    }

    public void increment(Register register) {
        validateRegisters(List.of(register));
        registerBySetValue.get(register).accept(registerByGetValue.get(register).get() + 1);
        instructionPointer++;
    }

    public void decrement(Register register) {
        validateRegisters(List.of(register));
        registerBySetValue.get(register).accept(registerByGetValue.get(register).get() - 1);
        instructionPointer++;
    }

    public void jumpIfNotZero(Register condition, int jumpOffset) {
        if (registerByGetValue.get(condition).get() != 0) {
            instructionPointer += jumpOffset;
        } else {
            instructionPointer++;
        }
    }

    private void validateRegisters(List<Register> registers) {
        if (!SUPPORTED_REGISTERS.containsAll(registers)) {
            throw new IllegalArgumentException("Register not supoorted by this processor");
        }
    }
}
