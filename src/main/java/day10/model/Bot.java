package day10.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data public class Bot {
    private Integer id;
    private List<Integer> chips = new ArrayList<>();

    public boolean canProceed() {
        return chips.size() == 2;
    }

    public Bot(Integer id) {
        this.id = id;
    }
}
