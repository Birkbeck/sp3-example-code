package mediator;

public class StockOffer {

    private final int stockShares;
    private final int colleagueCode;
    private String stockSymbol = "";

    public StockOffer(int numOfShares, String stock, int collCode) {

        stockShares = numOfShares;
        stockSymbol = stock;
        colleagueCode = collCode;

    }

    public int getstockShares() {
        return stockShares;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getCollCode() {
        return colleagueCode;
    }

}