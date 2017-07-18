package day9.model;

public class Marker {
    private static final int MARKER_SYMBOLS = 3;
    private final int charCount;
    private final int multiplyValue;
    
    public Marker(int charCount, int multiplyValue) {
        this.charCount = charCount;
        this.multiplyValue = multiplyValue;
    }

    public int getCharCount() {
        return charCount;
    }

    public int getMultiplyValue() {
        return multiplyValue;
    }

    public int getMarkerLength() {
        return MARKER_SYMBOLS
                + String.valueOf(charCount).length()
                + String.valueOf(multiplyValue).length();
    }

    @Override
    public String toString() {
        return "(" + charCount + "x" + multiplyValue + ")";
    }
}
