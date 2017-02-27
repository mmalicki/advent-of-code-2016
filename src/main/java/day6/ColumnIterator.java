package day6;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/**
 * @author mmalicki
 */
public class ColumnIterator implements Iterator<String>{
    private final String input;
    private final int rowLength;
    private final int rowCount;
    private int index;

    private ColumnIterator(String input, int rowLength, final int rowCount) {
        this.input = input;
        this.rowLength = rowLength;
        this.rowCount = rowCount;
    }

    public static ColumnIterator of(String input) {
        Preconditions.checkArgument(input.contains(System.lineSeparator()));
        int rowLength = input.indexOf(System.lineSeparator());
        String strippedOfNewLines = input.replace(System.lineSeparator(), "");
        int rowCount = strippedOfNewLines.length() / rowLength  + strippedOfNewLines.length() % rowLength;
        return new ColumnIterator(strippedOfNewLines, rowLength, rowCount);
    }

    @Override
    public boolean hasNext() {
        return index < rowLength;
    }

    @Override
    public String next() {
        String nextElement = "";
        for (int row = 0; row < rowCount; row++) {
            nextElement += input.charAt(index + row * rowLength);
        }
        index++;
        return nextElement;
    }
}
