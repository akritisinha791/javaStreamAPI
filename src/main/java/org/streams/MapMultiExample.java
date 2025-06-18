package org.streams;

import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

public class MapMultiExample {
    public static void main(String[] args) {
        List<String> sentences = List.of("Hello world", "Java streams are powerful", "mapMulti is useful");

        Stream<String> words = sentences.stream()
                .mapMulti((sentence, consumer) -> {
                    Arrays.stream(sentence.split(" "))
                            .forEach(consumer);
                });

        words.forEach(System.out::println);
    }
}