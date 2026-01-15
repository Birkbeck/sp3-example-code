package mysealed;

public class MySealed {
    public sealed interface PaymentMethod
        permits CreditCard, BankTransfer, GiftCard {}

    public record CreditCard(String number, String expiry)
            implements PaymentMethod {}

    // public record Scam() implements PaymentMethod {}

    public sealed interface BankTransfer extends PaymentMethod
        permits WireTransfer {}

    public record WireTransfer(String swiftCode) implements BankTransfer {}

    public non-sealed class GiftCard implements PaymentMethod {}

    public static void main() {
        PaymentMethod myCard = new CreditCard("123456","12/25");
        System.out.println(myCard);

    }
}

class A {}
class B extends A{}