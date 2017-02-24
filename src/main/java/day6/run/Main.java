package day6.run;

import day6.decoder.BasicDecoder;
import day6.decoder.Decoder;
import day6.decoder.transformer.MostFrequentCharacterProvider;
import day6.decoder.transformer.Transformer;
import java.util.List;
import java.util.StringJoiner;
import loader.PuzzleInputLoader;

/**
 * @author mmalicki
 */
public class Main {
    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        List<String> input = PuzzleInputLoader.loadInputPuzzle("C://advent//6.txt");
        input.forEach(joiner::add);
//                .stream()
//                .reduce(String::concat)
//                .orElseThrow(() -> new RuntimeException("could not load input data"));
        Transformer transformer = new MostFrequentCharacterProvider();
        Decoder decoder = new BasicDecoder(transformer);
        String result = decoder.decode(joiner.toString());
        System.out.println(result);
    }
}
