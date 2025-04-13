package generics;

public class BankAccount {
    private float balance;

    public BankAccount() {
        balance = 100;
    }

    public void deposit(float amount) {
        this.balance += amount;
    }

    public float showBalance() {
        return this.balance;
    }
}
