package demo.strategy;

class Demo {
    static void main(String... args) {
        // ...
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new BitcoinPayment());
        // ...
        cart.checkout(100);
    }
}