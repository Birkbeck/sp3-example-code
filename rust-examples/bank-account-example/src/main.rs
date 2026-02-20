// ----- BANK ACCOUNT EXAMPLE -----

// We will create a bank account that multiple customers will try to withdraw money from

use std::thread;

fn main() {
    // Bank struct just contains current balance

    pub struct Bank {
        balance: f32,
    }

    // Allows multiple owners and blocks access when needed
    // A smart pointer Rc<RefCell<T>> allows multiple owners with mutable
    // access to the same data

    // Arc<T> provides shared ownership of a value
    // Mutex blocks threads waiting for lock to be available

    use std::sync::{Arc, Mutex};

    fn withdraw(the_bank: &Arc<Mutex<Bank>>, amt: f32) {
        let mut bank_ref = the_bank.lock().unwrap();

        if bank_ref.balance < 5.00 {
            println!(
                "Current Balance : {} Withdrawal a smaller amount",
                bank_ref.balance
            );
        } else {
            bank_ref.balance -= amt;
            println!(
                "Customer withdrew {} Current Balance {}",
                amt, bank_ref.balance
            );
        }
    }

    fn customer(the_bank: Arc<Mutex<Bank>>) {
        withdraw(&the_bank, 5.00);
    }

    let bank: Arc<Mutex<Bank>> = Arc::new(Mutex::new(Bank { balance: 20.00 }));

    // Creates 10 customer threads

    let handles = (0..10).map(|_| {
        // Clone duplicates an the bank object

        let bank_ref = bank.clone();
        thread::spawn(|| customer(bank_ref))
    });

    // Wait for all customers to finish

    for handle in handles {
        handle.join().unwrap();
    }

    println!("Total: {}", bank.lock().unwrap().balance);
}
