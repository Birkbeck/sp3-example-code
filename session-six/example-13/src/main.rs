// if we leave this out we will receive a compiler warning as we don't use Tuesday, etc.
#![allow(unused)] 

fn main() {
// ----- ENUMS -----
    // Enumerated types allow for the definition of custom data types

    // Create an Enum for days of week

    enum Day {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday,
    }

    // Define function for Day enum
    // Note that this implementation "accompanies" the definition of the enumerated type.
    // More on this later when we consider functions in more detail.
    // Remember that Rust is NOT an object-oriented programming language.

    impl Day {
        fn is_weekend(&self) -> bool {
            match self {
                Day::Saturday | Day::Sunday => true,
                _ => false,
            }
        }
    }

    // Use enum to store todays day

    let today: Day = Day::Monday;

    // Perform different actions based on day

    match today {
        Day::Monday => println!("Everyone hates Monday"),
        Day::Tuesday => println!("Donut day"),
        Day::Wednesday => println!("Hump day"),
        Day::Thursday => println!("Pay day"),
        Day::Friday => println!("Almost Weekend"),
        Day::Saturday => println!("Weekend!!!"),
        Day::Sunday => println!("Weekend!!!"),
    }

    // Check if today is a weekend

    println!("Is today the weekend {}", today.is_weekend()); // similar calling regime as for Python
}
