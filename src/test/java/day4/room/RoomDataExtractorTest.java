package day4.room;

import day4.extractor.RoomDataExtractor;
import org.junit.Assert;
import org.junit.Test;

public class RoomDataExtractorTest {

    private RoomDataExtractor testObject = new RoomDataExtractor();

    @Test
    public void testExtractRoom() {
        String roomData = "jvyyvzpcl-jhukf-shivyhavyf-487[zhtsi]";
        String[] room = testObject.extractRoomData(roomData);
        Assert.assertEquals("jvyyvzpcl-jhukf-shivyhavyf", room[0]);
        Assert.assertEquals("487", room[1]);
        Assert.assertEquals("zhtsi", room[2]);
    }
}