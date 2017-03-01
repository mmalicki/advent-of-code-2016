package day4.run;

import day4.room.DataDecryptor;
import day4.room.RoomNameDecryptor;
import day4.room.RoomsIdsSummator;
import loader.PuzzleInputLoader;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(PuzzleInputLoader.loadInputPuzzle("4.txt")
                .split(System.lineSeparator()));
        int sectorsSum = DataDecryptor.decrypt(input, new RoomNameDecryptor())
                .orElseThrow(() -> new RuntimeException("No data matching decrypting criteria"));
        System.out.println(sectorsSum);
    }
}
