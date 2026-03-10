package demo.strategy;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class BitcoinPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bitcoin");
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;

    public ShoppingCart() {
    }

    // DI - constructor
    public ShoppingCart(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // this is an example of dependency injection - mutator
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // write a general method that sets the PaymentStrategy
    // "method injection"

    public void checkout(int amount) {
/*
        Class cl = strategy.getClass();
        if ( cl.equals(CreditCardPayment.class)){

        } else if ( cl.equals(BitcoinPayment.class)){

        } else {
            throw ....
        }
*/
        strategy.pay(amount);
    }
}