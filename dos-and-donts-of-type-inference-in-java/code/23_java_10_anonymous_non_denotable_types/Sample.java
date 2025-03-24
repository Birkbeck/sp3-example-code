import java.util.*;

import static java.util.stream.Collectors.*;

public class Sample {
    public static int getPrice(String ticker) {
        return (int) (Math.random() * 1000);
    }

    public static void main(String[] args) {
        var tickers = List.of("INTC", "MSFT", "ORCL", "GOOG", "AMZN", "AAPL");

        var tickersAndPrices =
                tickers.stream()
                        .sorted()
                        .map(theTicker -> new Object() {
                            String ticker = theTicker;
                            int price = getPrice(theTicker);
                        })
                        .collect(toList());

        tickersAndPrices.forEach(data -> System.out.printf("%s---%d\n", data.ticker, data.price));
    }
}