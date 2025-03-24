package lambdas;

import java.math.BigDecimal;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        displayCurrencyCode(currency -> getCurrencyRateForCurrencyCode(currency));
    }

    private static void displayCurrencyCode(Function<String, BigDecimal> currencyRateFunction) {
        BigDecimal rate = currencyRateFunction.apply("USD");
        System.out.println("Currency rate for USD : " + rate);
    }

    private static BigDecimal getCurrencyRateForCurrencyCode(String currency) {
        System.out.println("getting rate for the currency: " + currency);
        //just a test, in real situation, we might be getting the currency rate
        // for the provided currency from a cache
        return new BigDecimal(Math.round(Math.random() * 100));
    }
}
