package day10.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class OutputBin extends ReceivingSubject {
    private int value;

    public OutputBin(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void addChip(int chipValue) {
        value = chipValue;
    }
}
