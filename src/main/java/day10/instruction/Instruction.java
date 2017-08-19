package day10.instruction;

import day10.model.Bot;
import day10.model.OutputBin;
import day10.model.ReceivingSubject;

import java.util.List;
import java.util.Optional;

public interface Instruction {
    void execute();
    boolean canExecute();
}
