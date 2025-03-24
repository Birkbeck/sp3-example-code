package creational.factorymethod.logger;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger implements Logger {
    private final PrintStream out;

    private FileLogger(String file) throws IOException {
        this.out = new PrintStream(Files.newOutputStream(Paths.get(file)));
    }

    @Override
    public void error(String msg) {
        out.println("ERROR: " + msg);
    }

    @Override
    public void debug(String msg) {
        out.println("DEBUG: " + msg);
    }
}
