package day10.model;

import day10.exception.ChipValueNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Bot extends ReceivingSubject {
    private List<Integer> chips = new ArrayList<>();

    public Bot(Integer id) {
        super(id);
    }

    public int getId() {
        return id;
    }

    @Override
    public void addChip(int chipValue) {
        chips.add(chipValue);
    }


    public int removeHigherValueChip() {
        return removeChip(Integer::max);
    }

    public int removeLowerValueChip() {
        return removeChip(Integer::min);
    }

    private int removeChip(BinaryOperator<Integer> aggregateFunction) {
        Integer chip = chips.stream()
                .reduce(aggregateFunction)
                .orElseThrow(() -> new ChipValueNotFound("Could not find chip value for given requirement: " + aggregateFunction));
        chips.remove(chip);
        return chip;
    }

    public boolean canProceedWithAction() {
        return chips.size() == 2;
    }
}
