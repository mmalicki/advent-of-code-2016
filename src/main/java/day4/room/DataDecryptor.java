package day4.room;

import day4.model.Room;
import day4.validator.RoomNameValidator;

import java.util.List;
import java.util.Optional;

public class DataDecryptor {
    public static Optional<Integer> decrypt(List<String> inputData, DecryptorStrategy decryptorStrategy) {
        return decryptorStrategy.decrypt(inputData.stream()
                .map(RoomProvider::provide)
                .filter(RoomNameValidator::isValid));
    }

}
