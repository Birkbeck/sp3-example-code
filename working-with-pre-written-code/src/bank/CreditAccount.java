package bank;

public class CreditAccount extends Account {

    int creditLimit;

    //default constructor for CreditAccount
    CreditAccount() {
        super();
        this.creditLimit = 100;
    }

    //overloaded constructor for CreditAccount
    CreditAccount(String name, int num, int amt, int credit) {
        super(name, num, amt);
        this.creditLimit = credit;

    }

    //modifier to set the account creditlimit
    public void setcreditlimit(int num) {
        creditLimit = num;
    }

    //accessor to get the account creditlimit
    public int getcreditlimit() {

        return creditLimit;
    }

    //print method
    public void print() {
        System.out.println(accountname + " " + accountnum + " " + balance + " " + creditLimit);
    }
}
