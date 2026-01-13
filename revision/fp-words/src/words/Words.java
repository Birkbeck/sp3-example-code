package words;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Words example: Java implementation with map/filter/reduce.
 */
public class Words {

    /**
     * Find all files in the filesystem subtree rooted at folder.
     * @param folder root of subtree, requires folder.isDirectory() == true
     * @return stream of all ordinary files (not folders) that have folder as
     *         their ancestor
     */
    public static Stream<File> allFilesIn(File folder) {
        File[] children = folder.listFiles();
        Stream<File> descendants = Arrays.stream(children)
                .filter(File::isDirectory)
                .flatMap(Words::allFilesIn);
        return Stream.concat(descendants,
                Arrays.stream(children).filter(File::isFile));
    }

    /**
     * Make a filename suffix testing predicate.
     * @param suffix string to test
     * @return a predicate that returns true iff the filename ends with suffix.
     */
    public static Predicate<File> endsWith(String suffix) {
        return f -> f.getPath().endsWith(suffix);
    }

    /**
     * Read in a file.
     * @param file file to read in
     * @return stream of lines in the file
     */
    public static Stream<String> readIn(File file) {
        try {
            return Files.readAllLines(file.toPath()).stream();
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    /**
     * Split a string into words.
     * @param str string to split
     * @return stream of non-word-character-separated words in str
     */
    public static Stream<String> splitIntoWords(String str) {
        return Arrays.stream(str.split("\\W+")).filter(s -> !s.isEmpty());
    }


}