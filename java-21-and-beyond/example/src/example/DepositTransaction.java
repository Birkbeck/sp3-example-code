package example;

public class DepositTransaction extends BankTransaction {
    public void execute(BankAccount account) {
        account.deposit(100);
    }
}
