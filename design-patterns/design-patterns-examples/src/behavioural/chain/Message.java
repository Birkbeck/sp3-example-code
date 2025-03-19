package behavioural.chain;

public interface Message {
    String toString();
}

class Spam implements Message {
    @Override
    public String toString() {
        return getClass().toString();
    }
}

class Standard implements Message {
    @Override
    public String toString() {
        return getClass().toString();
    }
}

