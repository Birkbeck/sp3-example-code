// Some selection examples

use std::cmp::Ordering; // reference to this item within the std::cmp crate

fn main() {
    // ----- IF EXPRESSIONS -----

    let age = 8;

    if (age >= 1) && (age <= 18) {
        println!("Important Birthday");
    } else if (age == 21) || (age == 50) {
        println!("Important Birthday");
    } else if age >= 65 {
        println!("Important Birthday");
    } else {
        println!("Not an Important Birthday");
    }

    // ----- TERNARY OPERATOR -----

    let mut my_age = 47;
    let can_vote = if my_age >= 18 { true } else { false };
    println!("Can Vote : {}", can_vote);

    // ----- MATCH -----
    // Match runs different code depending on conditions
    // The pattern and the code to be executed is called an arm
    // A match must match all possible values!

    // You can do what we did with if

    let age2 = 8;
    match age2 {
        1..=18 => println!("Important Birthday"),  // 1 through 18
        21 | 50 => println!("Important Birthday"), // 21 or 50
        65..=i32::MAX => println!("Important Birthday"), // > 65
        _ => println!("Not an Important Birthday"), // Default
    };

    // Compares age to valid age and cmp returns an Ordering which
    // has either the value Less, Greater, or Equal

    my_age = 18;
    let voting_age = 18;
    match my_age.cmp(&voting_age) {
        Ordering::Less => println!("Can't Vote"),
        Ordering::Greater => println!("Can Vote"),
        Ordering::Equal => println!("You just gained the right to vote!"),
    };
}
