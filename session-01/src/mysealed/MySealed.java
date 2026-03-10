package mysealed;

public class MySealed {
    public sealed interface PaymentMethod
            // only the following card implement/inherit this interface
            permits CreditCard, BankTransfer, GiftCard {
    }

    public record CreditCard(String number, String expiry)
            implements PaymentMethod {
    }

    // Not allowed to implement the class
    // public record Scam() implements PaymentMethod {}

    public sealed interface BankTransfer extends PaymentMethod
            permits WireTransfer {
    }

    public record WireTransfer(String swiftCode) implements BankTransfer {
    }

    // reopens the inheritance hierarchy
    public non-sealed class GiftCard implements PaymentMethod {
    }

    public static void main() {
        PaymentMethod myCard = new CreditCard("123456", "12/25");
        System.out.println(myCard);
    }
}

class A {
}

class B extends A {
}