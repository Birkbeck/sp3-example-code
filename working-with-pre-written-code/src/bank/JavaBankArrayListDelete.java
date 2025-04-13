package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class JavaBankArrayListDelete extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static JTextArea displayJTextArea;
    // Make these variables publicly available
    public String Name;
    public int Accountnum;
    public int Balance;
    //  array to store Account details and an Arraylist
    ArrayList<Account> Accounts = new ArrayList<Account>();
    // JPanel for user inputs
    private JPanel inputDetailJPanel;
    // JLabel and JTextField for account name
    private JLabel NameJLabel;
    private JTextField NameJTextField;
    // JLabel and JTextField for account number
    private JLabel AccountnumJLabel;
    private JTextField AccountnumJTextField;
    // JLabel and JTextField for balance
    private JLabel BalanceJLabel;
    private JTextField BalanceJTextField;
    // JLabel and JTextField for withdraw
    private JLabel DepositJLabel;
    private JTextField DepositJTextField;
    // JLabel and JTextField for Withdraw
    private JLabel WithdrawJLabel;
    private JTextField WithdrawJTextField;
    // JButton to create account
    private JButton CreateAccountJButton;
    // JButton to delete account
    private JButton DeleteAccountJButton;
    // JButton to make transaction
    private JButton TransactionJButton;
    // JButton to display account
    private JButton DisplayJButton;
    // JLabel and JTextArea to display account details
    private JLabel displayJLabel;


    //static int noAccounts = 0; 

    // constructor

    public JavaBankArrayListDelete() {
        //create the interface and start the application
        createUserInterface();
    }

    public static void main(String[] args) {
        // Populate arrays with the word EMPTY
        // so we can check to see if the values are empty later

        JavaBankArrayListDelete application = new JavaBankArrayListDelete();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up inputDetailJPanel
        inputDetailJPanel = new JPanel();
        inputDetailJPanel.setBounds(16, 16, 208, 250);
        inputDetailJPanel.setBorder(new TitledBorder("Input Details"));
        inputDetailJPanel.setLayout(null);
        contentPane.add(inputDetailJPanel);

        // set up NameJLabel
        NameJLabel = new JLabel();
        NameJLabel.setBounds(8, 32, 90, 23);
        NameJLabel.setText("Name:");
        inputDetailJPanel.add(NameJLabel);

        // set up NameJTextField
        NameJTextField = new JTextField();
        NameJTextField.setBounds(112, 32, 80, 21);
        NameJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(NameJTextField);

        // set up AccountnumJLabel
        AccountnumJLabel = new JLabel();
        AccountnumJLabel.setBounds(8, 56, 100, 23);
        AccountnumJLabel.setText("Account Number:");
        inputDetailJPanel.add(AccountnumJLabel);

        // set up AccountnumTextField
        AccountnumJTextField = new JTextField();
        AccountnumJTextField.setBounds(112, 56, 80, 21);
        AccountnumJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(AccountnumJTextField);

        // set up BalanceJLabel
        BalanceJLabel = new JLabel();
        BalanceJLabel.setBounds(8, 80, 60, 23);
        BalanceJLabel.setText("Balance:");
        inputDetailJPanel.add(BalanceJLabel);

        // set up BalanceTextField
        BalanceJTextField = new JTextField();
        BalanceJTextField.setBounds(112, 80, 80, 21);
        BalanceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(BalanceJTextField);

        // set up DepositJLabel
        DepositJLabel = new JLabel();
        DepositJLabel.setBounds(8, 104, 80, 23);
        DepositJLabel.setText("Deposit:");
        inputDetailJPanel.add(DepositJLabel);

        // set up DepositJTextField
        DepositJTextField = new JTextField();
        DepositJTextField.setBounds(112, 104, 80, 21);
        DepositJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(DepositJTextField);

        // set up WithdrawJLabel
        WithdrawJLabel = new JLabel();
        WithdrawJLabel.setBounds(8, 128, 60, 23);
        WithdrawJLabel.setText("Withdraw:");
        inputDetailJPanel.add(WithdrawJLabel);

        // set up WithdrawJTextField
        WithdrawJTextField = new JTextField();
        WithdrawJTextField.setBounds(112, 128, 80, 21);
        WithdrawJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(WithdrawJTextField);

        // set up CreateAccountButton
        CreateAccountJButton = new JButton();
        CreateAccountJButton.setBounds(112, 152, 80, 24);
        CreateAccountJButton.setText("Create");
        inputDetailJPanel.add(CreateAccountJButton);
        CreateAccountJButton.addActionListener(

                new ActionListener() {
                    // event handler called when CreateAccountJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        CreateAccountJButtonActionPerformed(event);
                    }

                }

        ); // end call to addActionListener

        // set up DeleteAccountButton
        DeleteAccountJButton = new JButton();
        DeleteAccountJButton.setBounds(16, 152, 80, 24);
        DeleteAccountJButton.setText("Delete");
        inputDetailJPanel.add(DeleteAccountJButton);
        DeleteAccountJButton.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // event handler called when DeleteAccountJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        DeleteAccountJButtonActionPerformed(event);

                    }

                }

        ); // end call to addActionListener

        // set up TransactionJButton
        TransactionJButton = new JButton();
        TransactionJButton.setBounds(16, 180, 176, 24);
        TransactionJButton.setText("Make Transaction");
        inputDetailJPanel.add(TransactionJButton);
        TransactionJButton.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // event handler called when TransactionJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        TransactionJButtonActionPerformed(event);
                    }

                } // end anonymous inner class

        ); // end call to addActionListener

        // set up DisplayJButton
        DisplayJButton = new JButton();
        DisplayJButton.setBounds(16, 208, 176, 24);
        DisplayJButton.setText("Display Accounts");
        inputDetailJPanel.add(DisplayJButton);
        DisplayJButton.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // event handler called when TransactionJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        DisplayJButtonActionPerformed(event);
                    }

                } // end anonymous inner class

        ); // end call to addActionListener


        // set up displayJLabel
        displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 150, 23);
        displayJLabel.setText("Account Details:");
        contentPane.add(displayJLabel);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayJTextArea);
        scrollPane.setBounds(240, 48, 402, 184);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
        displayJTextArea.setText("Welcome to Java Bank - There are currently no Accounts created");

        // clear other JTextFields for new data
        NameJTextField.setText("");
        AccountnumJTextField.setText("0");
        BalanceJTextField.setText("0");
        DepositJTextField.setText("0");
        WithdrawJTextField.setText("0");

        // set properties of application's window
        setTitle("Java Bank"); // set title bar string
        setSize(670, 308); // set window size
        setVisible(true); // display window


    } // end method createUserInterface

    private void CreateAccountJButtonActionPerformed(ActionEvent event) {
        // System.out.println("Create Account Button Clicked");

        displayJTextArea.setText("");


        Name = "";

        //Get Name from Text Field
        Name = NameJTextField.getText();

        //Get Accountnum from Text Field and convert to int unless blank then set to 0
        if (AccountnumJTextField.getText() == "0") {
            Accountnum = 0;
        } else {
            Accountnum = Integer.parseInt(AccountnumJTextField.getText());
        }


        //Get Balance from Text Field and convert to int unless blank then set to 0
        if (BalanceJTextField.getText() == "0") {
            Balance = 0;
        } else {
            Balance = Integer.parseInt(BalanceJTextField.getText());
        }


        if ((Name != "") & (Accountnum != 0)) {
            //add a new account to the list using the Account constructor
            Accounts.add(new Account(Name, Accountnum, Balance));
            //Set a temp Account for display purposes
            Account tempAccount = Accounts.get(Accounts.size() - 1);
            //Display tempAccount
            displayJTextArea.setText(Accounts.size() + " " + tempAccount.getaccountname() + " " + tempAccount.getaccountnum() + " " + tempAccount.getbalance());

        } else {
            displayJTextArea.setText("Both the Name field and Account Number must be completed");
        }

        // clear other JTextFields for new data
        NameJTextField.setText("");
        AccountnumJTextField.setText("0");
        BalanceJTextField.setText("0");
        DepositJTextField.setText("0");
        WithdrawJTextField.setText("0");

    }

    private void DeleteAccountJButtonActionPerformed(ActionEvent event) {

        if (Accounts.size() == 0) {
            displayJTextArea.setText("No Accounts currently created");
        } else {

            // get user input
            int Accountnum = Integer.parseInt(AccountnumJTextField.getText());

            for (int i = 0; i < Accounts.size(); i++) {
                // get the element
                Account tempAccount = Accounts.get(i);
                if ((tempAccount.accountnum == Accountnum)) {
                    Accounts.remove(i);
                    //break;
                }

            }
        }
        NameJTextField.setText("");
        AccountnumJTextField.setText("0");
        BalanceJTextField.setText("0");
        DepositJTextField.setText("0");
        WithdrawJTextField.setText("0");

    }

    private void TransactionJButtonActionPerformed(ActionEvent event) {


        displayJTextArea.setText("");

        if (Accounts.size() == 0) {
            displayJTextArea.setText("No Accounts currently created");
        } else {

            // get user input
            int Accountnum = Integer.parseInt(AccountnumJTextField.getText());
            int Deposit = Integer.parseInt(DepositJTextField.getText());
            int Withdraw = Integer.parseInt(WithdrawJTextField.getText());


            for (int i = 0; i < Accounts.size(); i++) {
                // get the element and set to TempAccount
                Account tempAccount = Accounts.get(i);
                // if account number matches and deposit field has entry then deposit in account
                if ((tempAccount.accountnum == Accountnum) && (Deposit > 0)) {
                    tempAccount.setbalance(tempAccount.getbalance() + Deposit);
                    Accounts.set(i, tempAccount);
                    displayJTextArea.setText(tempAccount.getaccountname() + " " + tempAccount.getaccountnum() + " " + tempAccount.getbalance());

                }
                // if account number matches and withdrawal field has entry then withdraw from account
                if ((tempAccount.accountnum == Accountnum) && (Withdraw > 0)) {
                    tempAccount.setbalance(tempAccount.getbalance() - Withdraw);
                    Accounts.set(i, tempAccount);
                    displayJTextArea.setText(tempAccount.getaccountname() + " " + tempAccount.getaccountnum() + " " + tempAccount.getbalance());

                }
            }
        }

        // clear other JTextFields for new data
        NameJTextField.setText("");
        AccountnumJTextField.setText("0");
        BalanceJTextField.setText("0");
        DepositJTextField.setText("0");
        WithdrawJTextField.setText("0");


    }

    private void DisplayJButtonActionPerformed(ActionEvent event) {

        Name = NameJTextField.getText();
        displayJTextArea.setText("");

        if (Accounts.isEmpty()) {
            displayJTextArea.setText("No Accounts currently created");
        } else {
            for (int i = 0; i < Accounts.size(); i++) {
                Account tempAccount = Accounts.get(i);
                displayJTextArea.append(tempAccount.getaccountname() + " " + tempAccount.getaccountnum() + " " + tempAccount.getbalance() + "\n");


            }
        }
        // clear other JTextFields for new data
        NameJTextField.setText("");
        AccountnumJTextField.setText("0");
        BalanceJTextField.setText("0");
        DepositJTextField.setText("0");
        WithdrawJTextField.setText("0");


    }

}