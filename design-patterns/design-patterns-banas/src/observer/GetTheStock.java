package observer;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {

    // Could be used to set how many seconds to wait
    // in Thread.sleep() below

    // private int startTime;
    private final String stock;
    private final Subject stockGrabber;

    // Will hold reference to the StockGrabber object
    private double price;

    public GetTheStock(Subject stockgrabber, int newstarttime, String newstock, double newprice) {

        // Store the reference to the stockGrabber object so
        // I can make calls to its methods

        this.stockGrabber = stockgrabber;

        // startTime = newstarttime;  Not used to have variable sleep time
        stock = newstock;
        price = newprice;
    }

    @Override
    public void run() {
        // Formats decimals to 2 places

        final DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 1; i <= 20; i++) {

            try {
                // Sleep for 2 seconds
                Thread.sleep(2000);

                // Use Thread.sleep(startTime * 1000); to
                // make sleep time variable
            } catch (InterruptedException e) {
            }

            // Generates a random number between -.03 and .03

            final double randNum = (Math.random() * (.06)) - .03;

            // Change the price and then convert it back into a double

            price = Double.valueOf(df.format((price + randNum)));

            switch (stock) {
                case "IBM":
                    ((StockGrabber) stockGrabber).setIBMPrice(price);
                    break;
                case "AAPL":
                    ((StockGrabber) stockGrabber).setAAPLPrice(price);
                    break;
                case "GOOG":
                    ((StockGrabber) stockGrabber).setGOOGPrice(price);
                    break;
            }

            System.out.println(stock + ": " + df.format((price + randNum))
                + " " + df.format(randNum));
            System.out.println();
        }
    }
}