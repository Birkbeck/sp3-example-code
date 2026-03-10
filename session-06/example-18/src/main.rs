// ----- READING & WRITING TO FILES & ERROR HANDLING -----
// Rust doesn't have exceptions like other languages.
// It handles recoverable errors with Result and the panic! macro for
// unrecoverable errors

// When the panic! macro executes your program prints an error
// memory is cleaned up and the program quits

use std::fs::File;
use std::io::BufRead;
use std::io::BufReader;
use std::io::ErrorKind;
use std::io::Write;

fn main() {
    // panic!("Terrible Error");

    // Accessing an index that doesn't exist calls panic
    // let lil_arr = [1,2];
    // println!("{}", lil_arr[10]);

    // File to create

    let path = "lines.txt";

    // Result has 2 varients Ok and Err
    // enum Result<T, E> {
    // Ok(T),
    // Err(E), }
    // Where T represents the data typeof the value returns and E the type of error

    // Create file and handle errors with match

    let output = File::create(path);
    let mut output = match output {
        Ok(file) => file,
        Err(error) => {
            panic!("Problem creating file : {:?}", error);
        }
    };

    // Write to file and define the panic! error message with expect

    write!(output, "Just some\nRandom Words").expect("Failed to write to file");

    // Open the file and if everything is ok unwrap returns the file
    // and if not panic! triggers an error
    // (You could replace unwrap with ?)

    // Read file using buffering

    let input = File::open(path).unwrap();
    let buffered = BufReader::new(input);

    // Cycle through and print the lines

    for line in buffered.lines() {
        println!("{}", line.unwrap());
    }

    // You can also catch specific errors
    // Here we will try to open a file and trigger an error if the file
    // couldn't be created, or use a default

    let output2 = File::create("rand.txt");
    let _output3 = match output2 {
        Ok(file) => file,
        Err(error) => match error.kind() {
            ErrorKind::NotFound => match File::create("rand.txt") {
                Ok(fc) => fc,
                Err(e) => panic!("Can't create file: {:?}", e),
            },
            _other_error => panic!("Problem opening file : {:?}", error),
        },
    };
}
