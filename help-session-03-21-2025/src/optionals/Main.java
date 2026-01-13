package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        var item = new X<Integer>();
        var returnValue = item.myMethod();
        System.out.format("Value = %s%n", returnValue.isPresent() ? returnValue.get() : "Oops!");
    }
}

class X<T> {
    Optional<T> myMethod() {
        return Optional.empty();
    }
}
