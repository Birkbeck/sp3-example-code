package structural.decorator.decoratoralt;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteCounterOutputStream extends FilterOutputStream {
    private int counter;

    public ByteCounterOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b);
        this.counter++;
    }

    public int getCounter() {
        return this.counter;
    }
}
