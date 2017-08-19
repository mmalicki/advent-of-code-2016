package day10.instruction;

import day10.model.Bot;
import day10.model.OutputBin;
import day10.model.ReceivingSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ElementsHolder {
    private static ElementsHolder INSTANCE = new ElementsHolder();

    private List<Bot> bots = new ArrayList<>();
    private List<OutputBin> outputBins = new ArrayList<>();

    private ElementsHolder() {
    }

    public static ElementsHolder getInstance() {
        return INSTANCE;
    }

    public Bot getOrCreateBot(int id) {
        return getOrCreate(bots, id, Bot::new);
    }

    public OutputBin getOrCreateOutputBin(int id) {
        return getOrCreate(outputBins, id, OutputBin::new);
    }

    private <T extends ReceivingSubject> T getOrCreate(List<T> elements, int id, Function<Integer, T> subjectCreator) {
        Optional<T> element = elements.stream()
                .filter(b -> b.getId() == id)
                .findAny();
        if (element.isPresent()) {
            return element.get();
        } else {
            T newEl = subjectCreator.apply(id);
            elements.add(newEl);
            return newEl;
        }
    }
}
