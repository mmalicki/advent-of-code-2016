package day10.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class ReceivingSubject {
    protected final int id;

    public ReceivingSubject(int id) {
        this.id = id;
    }

    public abstract void addChip(int chipValue);

    public abstract int getId();
}
