package day9.decoder;

import com.google.common.base.Strings;
import day9.model.Marker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {
    private static final Pattern MARKER_PATTERN = Pattern.compile("\\((\\d+)x(\\d+)\\)");
    public String decode(String input) {
        Matcher matcher = MARKER_PATTERN.matcher(input);
        StringBuilder decodedText = new StringBuilder(input);
        int end = 0;
        while (matcher.find(end)) {
            Marker marker = new Marker(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            int nextElement = matcher.start() + marker.getMarkerLength();
            end = nextElement + marker.getCharCount();
            String repeat = Strings.repeat(decodedText.substring(nextElement, end), marker.getMultiplyValue());
            decodedText.replace(matcher.start(), end, repeat);
            end = decodedText.indexOf(repeat) + repeat.length();
            matcher = MARKER_PATTERN.matcher(decodedText);
        }
        return decodedText.toString();
    }
}