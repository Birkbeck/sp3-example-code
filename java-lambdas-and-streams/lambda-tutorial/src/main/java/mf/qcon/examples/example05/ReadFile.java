package mf.qcon.examples.example05;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadFile {

    public static void main(String[] args) {
        long uniqueWords = calculateUniqueWords("src/main/resources/data.txt");
        System.out.println("Unique words in file: " + uniqueWords);
    }

    private static long calculateUniqueWords(String fileName) {
        try {
            return Files.lines(Paths.get(fileName))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}