import java.io.File;
import java.io.IOException;
import java.util.List;

import static words.Words.allFilesIn;
import static words.Words.getWords;
import static words.Words.onlyFilesWithSuffix;

public class Main {

    /**
     * Print the words in Java files in the project.
     *
     * @param args unused
     */
    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime();

        List<File> allFiles = allFilesIn(new File("."));
        List<File> javaFiles = onlyFilesWithSuffix(allFiles, ".java");
        List<String> words = getWords(javaFiles);
        for (String s : words) {
            System.out.println(s);
        }
        // Stop measuring execution time
        long endTime = System.nanoTime();
        // Calculate the execution time in milliseconds
        long executionTime = (endTime - startTime) / 1_000_000;

        System.out.println("Execution time " + executionTime + "ms");
    }
}