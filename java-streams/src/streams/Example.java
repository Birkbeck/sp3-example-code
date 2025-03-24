package streams;

public class Example {
    public static void main(String[] args) {
        Box b = new BoxImplAnother(); // tight binding
    }
}


interface Box {}

class BoxImpl implements Box {}

class BoxImplAnother implements Box {}