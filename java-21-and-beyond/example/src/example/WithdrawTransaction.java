package example;

public class WithdrawTransaction extends BankTransaction {
    public void execute(BankAccount account) {
        account.withdraw(100);
    }
}
