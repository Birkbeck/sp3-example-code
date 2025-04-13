package generics;

public class Driver {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        Storage<Object> st = new Storage<>();
        st.setValue(new Person());
        Storage<Person> sp = new Storage<>();
        //st = sp;

        Class it = Person.class;
        System.out.println(it);

        Class baCls = BankAccount.class;
        try {
            Object myAccount = baCls.newInstance();
            System.out.println(myAccount);
            st.setValue(myAccount);
            // Deposit
            //myAccount.deposit(15);
        } catch (InstantiationException e) {
            // ...
        } catch (IllegalAccessException e) {
            // ...
        }

    }
}

class Person {

}
