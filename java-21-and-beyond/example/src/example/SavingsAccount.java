package example;

import example.BankAccount;

// Inheritance example
public class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(double rate) {
        interestRate = rate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}