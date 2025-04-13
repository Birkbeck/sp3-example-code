package misc;// generics/misc.BankTeller.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A very simple bank teller simulation
import java.util.*;

class Customer {
  private static long counter = 1;
  private final long id = counter++;
  @Override public String toString() {
    return "misc.Customer " + id;
  }
}

class Teller {
  private static long counter = 1;
  private final long id = counter++;
  @Override public String toString() {
    return "misc.Teller " + id;
  }
}

class Bank {
  private List<BankTeller> tellers =
    new ArrayList<>();
  public void put(BankTeller bt) {
    tellers.add(bt);
  }
}

public class BankTeller {
  public static void serve(Teller t, Customer c) {
    System.out.println(t + " serves " + c);
  }
  public static void main(String[] args) {
    // Demonstrate create():
    RandomList<Teller> tellers =
      Suppliers.create(
        RandomList::new, Teller::new, 4);
    // Demonstrate fill():
    List<Customer> customers = Suppliers.fill(
      new ArrayList<>(), Customer::new, 12);
    customers.forEach(c ->
      serve(tellers.select(), c));
    // Demonstrate assisted latent typing:
    Bank bank = Suppliers.fill(
      new Bank(), Bank::put, BankTeller::new, 3);
    // Can also use second version of fill():
    List<Customer> customers2 = Suppliers.fill(
      new ArrayList<>(),
      List::add, Customer::new, 12);
  }
}
/* Output:
misc.Teller 3 serves misc.Customer 1
misc.Teller 2 serves misc.Customer 2
misc.Teller 3 serves misc.Customer 3
misc.Teller 1 serves misc.Customer 4
misc.Teller 1 serves misc.Customer 5
misc.Teller 3 serves misc.Customer 6
misc.Teller 1 serves misc.Customer 7
misc.Teller 2 serves misc.Customer 8
misc.Teller 3 serves misc.Customer 9
misc.Teller 3 serves misc.Customer 10
misc.Teller 2 serves misc.Customer 11
misc.Teller 4 serves misc.Customer 12
*/
