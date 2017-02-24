package day6.decoder;

import day6.decoder.transformer.Transformer;

/**
 * @author mmalicki
 */
public class BasicDecoder implements Decoder {

    private final Transformer transformer;

    public BasicDecoder(final Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String decode(final String input) {
        String decoded = "";
        for(String line : input.split(System.lineSeparator())) {
            decoded += transformer.provide(line);
        }
        return decoded;
    }
}
