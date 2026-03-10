// Define that you want to use the input/output library
use std::io;

fn main() {
    // You can tell println is a macro because of the ! and not a function

    println!("What is your name?");

    // Define an mutable variable (Value can changed)
    // String::new : A function that returns an empty string

    let mut name = String::new(); // Reminder — the "mut" means "mutable"

    /*
    By default variables are immutable (Value can't Change) but it is possible to use mutable variables.
    It is recommended to use immutable variables because then you don't have to track down how values change.
    */

    // This string is immutable
    // Define it is a string with double quotes

    let greeting = "Nice to meet you";

    /*
    Receive input from the user with read_line 
    name is passed as an argument to read_line
    & defines that this variable is a reference to the variable 
    this allows read_line to save values directly to name

    You use mut to define that name is a mutable variable
    */

    /*
    read_line returns io::Result which is an enum
    Enums have a fixed number of specific values (Ok or Err)
    If Err is returned the operation failed and Err can tell you why
    Result has an expect function that returns any error that occurred

    (We should handle this error, but we'll cover that later)
    */

    io::stdin()
        .read_line(&mut name)
        .expect("Didn't Receive Input");

    // Were you have {} your variable values will be placed
    // To remove the newline after name use trim_end

    println!("Hello {}! {}", name.trim_end(), greeting);
}