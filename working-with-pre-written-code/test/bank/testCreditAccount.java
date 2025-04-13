package bank;

public class testCreditAccount {


    public static void main(String[] args) {

        // Instantiate 3 accounts
        // Using constructor with values
        Account A1 = new Account("Sanjay Gupta", 11556, 300);
        // Using default constructor
        Account A2 = new Account();
        Account A3 = new Account();

        // Instantiate 2 credit accounts
        // Using default constructor
        Account C1 = new CreditAccount();
        // Using constructor with values which will call constructor from super
        Account C2 = new CreditAccount("Another", 66778, 1000, 500);

        //Set values of Instances created using default constructor
        A2.setaccountname("He Xai");
        A2.setaccountnum(22338);
        A2.setbalance(500);

        A3.setaccountname("Ilya Mustafana");
        A3.setaccountnum(44559);
        A3.setbalance(1000);

        C1.setaccountname("A.N Other");
        C1.setaccountnum(88776);
        C1.setbalance(500);

        // Print accounts
        A1.print();
        A2.print();
        A3.print();
        C1.print();
        C2.print();
    }
}

