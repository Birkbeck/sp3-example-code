package mf.qcon.talk.example05;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadFile {

    public static void main(String[] args) {
        long uniqueWords = calculateUniqueWords("src/main/resources/data.txt");
        System.out.println("Unique words in file: " + uniqueWords);
    }

    private static long calculateUniqueWords(String fileName) {
        return 0;
    }
}