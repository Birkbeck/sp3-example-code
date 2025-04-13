package lambdas;

import java.util.Currency;
import java.util.Locale;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        displayCurrencyCode(() -> Currency.getInstance(Locale.CHINA)
            .getCurrencyCode());

    }

    public static void displayCurrencyCode(Supplier<String> currencyCodeSupplier) {
        System.out.println(currencyCodeSupplier.get());
    }
}
