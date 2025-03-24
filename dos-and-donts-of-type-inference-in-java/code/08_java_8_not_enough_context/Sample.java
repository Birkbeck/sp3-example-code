import java.util.*;

import static java.util.Comparator.*;

class Stock {
    public String ticker;
    public int price;

    public Stock(String theTicker, int thePrice) {
        ticker = theTicker;
        price = thePrice;
    }

    public int getPrice() {
        return price;
    }
}

public class Sample {
    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(new Stock("A", 1), new Stock("B", 2));

        stocks.stream()
                //.sorted(comparing(stock -> stock.price).reversed()); //ERROR

                //.sorted(comparing((Stock stock) -> stock.price).reversed()); //OK

                //.sorted(comparing(stock -> stock.getPrice()).reversed()); //ERROR

                .sorted(comparing((Stock stock) -> stock.getPrice()).reversed()); //OK

        //.sorted(comparing(Stock::getPrice).reversed()); //OK

        System.out.println("OK");
    }
}