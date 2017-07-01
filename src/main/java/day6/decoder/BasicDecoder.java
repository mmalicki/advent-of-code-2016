package day6.decoder;

import day6.ColumnIterator;
import day6.decoder.transformer.Transformer;

import java.util.Iterator;

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
        StringBuilder decoded = new StringBuilder();
        Iterator<String> iterator = ColumnIterator.of(input);
        while (iterator.hasNext()) {
            decoded.append(transformer.provide(iterator.next()));
        }
        return decoded.toString();
    }
}
