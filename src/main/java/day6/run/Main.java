package day6.run;

import day6.decoder.BasicDecoder;
import day6.decoder.Decoder;
import day6.decoder.transformer.MostFrequentCharacterProvider;
import day6.decoder.transformer.Transformer;
import loader.PuzzleInputLoader;

/**
 * @author mmalicki
 */
public class Main {
    public static void main(String[] args) {
        String input = PuzzleInputLoader.loadInputPuzzle("6.txt");
        Transformer transformer = new MostFrequentCharacterProvider();
        Decoder decoder = new BasicDecoder(transformer);
        String result = decoder.decode(input);
        System.out.println(result);
    }
}
