                              ,import words.Words;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import static words.Words.endsWith;

public class Main {
    /**
     * Print the words in Java files in the project.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Stream<File> roots = Arrays.stream(new String[]{"."}).map(File::new);
        Stream<File> files = roots
                .flatMap(Words::allFilesIn)
                .filter(endsWith(".java"));
        Stream<String> lines = files.flatMap(Words::readIn);
        Stream<String> words = lines.flatMap(Words::splitIntoWords);
        words.forEach(System.out::println);
        // Stop measuring execution time
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
        long executionTime = (endTime - startTime) / 1_000_000;

        System.out.println("Execution time " + executionTime + "ms");

    }

//    static Predicate<File> endsWith(String suffix) {
//        return f -> f.getPath().endsWith(suffix);
//    }
}