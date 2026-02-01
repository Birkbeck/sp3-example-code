package parallel.two;

import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

public class Demo {
    static void main() {
        List<String> words = generateLargeRandomListOfWords(5_000);
        for (int x = 0; x < 10; x++) {
            long startTime = System.nanoTime();

            long result = words.parallelStream()
                    .filter(s -> s.toLowerCase().contains("java"))
                    .map(String::toUpperCase)
                    .count();
            long duration = System.nanoTime() - startTime;
            System.out.printf("Count = %d Processed in: %d ms\n", result, duration);
        }
    }

    static List<String> generateLargeRandomListOfWords(long size) {
        System.out.printf("Generating Large Random List of Words of size %d\n", size);
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int MINLEN = 3;

        return LongStream.range(0, size)
                .parallel()
                .mapToObj(i -> {
                    int length = random.nextInt(alphabet.length() - MINLEN + 1) + MINLEN;
                    StringBuilder word = new StringBuilder();
                    for (int k = 0; k < alphabet.length(); k++) {
                        word.append(alphabet.charAt(random.nextInt(alphabet.length())));
                    }
                    return word.toString();
                })
                .toList(); // collect(Collectors.toList()
    }
}
