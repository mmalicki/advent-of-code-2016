package day4.extractor;

import day4.model.Room;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomDataExtractor {
    private static final Pattern ROOM_PATTERN = Pattern.compile("(.+)-(\\d+)\\[(\\w+)\\]");
    public static String[] extractRoomData(String data) {
        Matcher roomMatcher = ROOM_PATTERN.matcher(data);
        if (roomMatcher.find()) {
            String encryptedName = roomMatcher.group(1);
            String id = roomMatcher.group(2);
            String checksum = roomMatcher.group(3);
            return new String[]{encryptedName, id, checksum};
        } else {
            throw new RuntimeException("Incorrect room data: " + data);
        }
    }
}
