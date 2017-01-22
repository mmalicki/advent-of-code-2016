package day4.converter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Interner;
import day4.model.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//TODO: ta klasa nie powinna przyjmować room, raczej po prostu string
//TODO: bo to sa juz dwie rzeczy i tworzy sie zaleznosc na room w testach + trzeba obsluzyc dodatkowo wyciaganie wartosci
public class RoomToRoomNameLetterOccurencesConverter {

    public static Map<String, Integer> convert(Room room) {
        String name = room.getEncryptedName();
        return mapToLettersOccurrences(name);
    }

    private static Map<String, Integer> mapToLettersOccurrences(String name) {
        Map<String, Integer> occurrences = new HashMap<>();
        name.chars()
                .filter(value -> value != '-') // TODO: to nie nalezy do obowiazkow tej klasy
                .forEach(
                letter ->{
                    String letterStr = Character.toString((char) letter);
                    occurrences.putIfAbsent(letterStr, 0);
                    occurrences.put(letterStr, occurrences.get(letterStr) + 1);
                });
        return occurrences;
    }
}
