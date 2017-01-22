package day4.room;

import day4.model.Room;
import day4.validator.RoomValidator;

import java.util.List;

public class DataDecryptor {
    public static int decrypt(List<String> inputData, DecryptorStrategy decryptorStrategy) {
        return decryptorStrategy.decrypt(inputData.stream()
                .map(RoomProvider::provide)
                .filter(RoomValidator::isValid));
    }

}
