package immutable;

public final class ImmutableData {
    private final int value;

    public ImmutableData(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImmutableData that)) return false;

        return getValue() == that.getValue();
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ImmutableData{" +
                "value=" + value +
                '}';
    }
}
